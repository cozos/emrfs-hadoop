package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CopyCallable
  implements Callable<CopyResult>
{
  private final AmazonS3 s3;
  private final ExecutorService threadPool;
  private final CopyObjectRequest copyObjectRequest;
  private String multipartUploadId;
  private final ObjectMetadata metadata;
  private final CopyImpl copy;
  private static final Log log = LogFactory.getLog(CopyCallable.class);
  private final TransferManagerConfiguration configuration;
  private final List<Future<PartETag>> futures = new ArrayList();
  private final ProgressListenerChain listenerChain;
  
  public CopyCallable(TransferManager transferManager, ExecutorService threadPool, CopyImpl copy, CopyObjectRequest copyObjectRequest, ObjectMetadata metadata, ProgressListenerChain progressListenerChain)
  {
    s3 = transferManager.getAmazonS3Client();
    configuration = transferManager.getConfiguration();
    this.threadPool = threadPool;
    this.copyObjectRequest = copyObjectRequest;
    this.metadata = metadata;
    listenerChain = progressListenerChain;
    this.copy = copy;
  }
  
  List<Future<PartETag>> getFutures()
  {
    return futures;
  }
  
  String getMultipartUploadId()
  {
    return multipartUploadId;
  }
  
  public boolean isMultipartCopy()
  {
    return metadata.getContentLength() > configuration.getMultipartCopyThreshold();
  }
  
  public CopyResult call()
    throws Exception
  {
    copy.setState(Transfer.TransferState.InProgress);
    if (isMultipartCopy())
    {
      SDKProgressPublisher.publishProgress(listenerChain, ProgressEventType.TRANSFER_STARTED_EVENT);
      copyInParts();
      return null;
    }
    return copyInOneChunk();
  }
  
  private CopyResult copyInOneChunk()
  {
    CopyObjectResult copyObjectResult = s3.copyObject(copyObjectRequest);
    
    CopyResult copyResult = new CopyResult();
    copyResult.setSourceBucketName(copyObjectRequest.getSourceBucketName());
    copyResult.setSourceKey(copyObjectRequest.getSourceKey());
    copyResult.setDestinationBucketName(copyObjectRequest
      .getDestinationBucketName());
    copyResult.setDestinationKey(copyObjectRequest.getDestinationKey());
    copyResult.setETag(copyObjectResult.getETag());
    copyResult.setVersionId(copyObjectResult.getVersionId());
    return copyResult;
  }
  
  private void copyInParts()
    throws Exception
  {
    multipartUploadId = initiateMultipartUpload(copyObjectRequest);
    
    long optimalPartSize = getOptimalPartSize(metadata.getContentLength());
    try
    {
      CopyPartRequestFactory requestFactory = new CopyPartRequestFactory(copyObjectRequest, multipartUploadId, optimalPartSize, metadata.getContentLength());
      copyPartsInParallel(requestFactory);
    }
    catch (Exception e)
    {
      SDKProgressPublisher.publishProgress(listenerChain, ProgressEventType.TRANSFER_FAILED_EVENT);
      abortMultipartCopy();
      throw new RuntimeException("Unable to perform multipart copy", e);
    }
  }
  
  private long getOptimalPartSize(long contentLengthOfSource)
  {
    long optimalPartSize = TransferManagerUtils.calculateOptimalPartSizeForCopy(copyObjectRequest, configuration, contentLengthOfSource);
    
    log.debug("Calculated optimal part size: " + optimalPartSize);
    return optimalPartSize;
  }
  
  private void copyPartsInParallel(CopyPartRequestFactory requestFactory)
  {
    while (requestFactory.hasMoreRequests())
    {
      if (threadPool.isShutdown()) {
        throw new CancellationException("TransferManager has been shutdown");
      }
      CopyPartRequest request = requestFactory.getNextCopyPartRequest();
      futures.add(threadPool.submit(new CopyPartCallable(s3, request)));
    }
  }
  
  private String initiateMultipartUpload(CopyObjectRequest origReq)
  {
    EncryptedInitiateMultipartUploadRequest req = (EncryptedInitiateMultipartUploadRequest)new EncryptedInitiateMultipartUploadRequest(origReq.getDestinationBucketName(), origReq.getDestinationKey()).withCannedACL(origReq.getCannedAccessControlList()).withRequesterPays(origReq.isRequesterPays()).withAccessControlList(origReq.getAccessControlList()).withStorageClass(origReq.getStorageClass()).withSSECustomerKey(origReq.getDestinationSSECustomerKey()).withSSEAwsKeyManagementParams(origReq.getSSEAwsKeyManagementParams()).withGeneralProgressListener(origReq.getGeneralProgressListener()).withRequestMetricCollector(origReq.getRequestMetricCollector());
    
    req.setCreateEncryptionMaterial(false);
    
    ObjectMetadata newObjectMetadata = origReq.getNewObjectMetadata();
    if (newObjectMetadata == null) {
      newObjectMetadata = new ObjectMetadata();
    }
    if (newObjectMetadata.getContentType() == null) {
      newObjectMetadata.setContentType(metadata.getContentType());
    }
    req.setObjectMetadata(newObjectMetadata);
    
    populateMetadataWithEncryptionParams(metadata, newObjectMetadata);
    
    req.setTagging(origReq.getNewObjectTagging());
    
    req.withObjectLockMode(origReq.getObjectLockMode())
      .withObjectLockLegalHoldStatus(origReq.getObjectLockLegalHoldStatus())
      .withObjectLockRetainUntilDate(origReq.getObjectLockRetainUntilDate());
    
    String uploadId = s3.initiateMultipartUpload(req).getUploadId();
    log.debug("Initiated new multipart upload: " + uploadId);
    
    return uploadId;
  }
  
  private void populateMetadataWithEncryptionParams(ObjectMetadata source, ObjectMetadata destination)
  {
    Map<String, String> userMetadataSource = source.getUserMetadata();
    Map<String, String> userMetadataDestination = destination.getUserMetadata();
    
    String[] headersToCopy = { "x-amz-cek-alg", "x-amz-iv", "x-amz-key", "x-amz-key-v2", "x-amz-wrap-alg", "x-amz-tag-len", "x-amz-matdesc", "x-amz-unencrypted-content-length", "x-amz-unencrypted-content-md5" };
    if (userMetadataSource != null)
    {
      if (userMetadataDestination == null)
      {
        userMetadataDestination = new HashMap();
        destination.setUserMetadata(userMetadataDestination);
      }
      for (String header : headersToCopy)
      {
        String headerValue = (String)userMetadataSource.get(header);
        if (headerValue != null) {
          userMetadataDestination.put(header, headerValue);
        }
      }
    }
  }
  
  private void abortMultipartCopy()
  {
    try
    {
      AbortMultipartUploadRequest abortRequest = new AbortMultipartUploadRequest(copyObjectRequest.getDestinationBucketName(), copyObjectRequest.getDestinationKey(), multipartUploadId).withRequesterPays(copyObjectRequest.isRequesterPays());
      s3.abortMultipartUpload(abortRequest);
    }
    catch (Exception e)
    {
      log.info("Unable to abort multipart upload, you may need to manually remove uploaded parts: " + e
      
        .getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */