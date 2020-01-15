package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedPutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UploadCallable
  implements Callable<UploadResult>
{
  private final AmazonS3 s3;
  private final ExecutorService threadPool;
  private final PutObjectRequest origReq;
  private String multipartUploadId;
  private final UploadImpl upload;
  private static final Log log = LogFactory.getLog(UploadCallable.class);
  private final TransferManagerConfiguration configuration;
  private final List<Future<PartETag>> futures = new ArrayList();
  private final ProgressListenerChain listener;
  private final TransferProgress transferProgress;
  private final List<PartETag> eTagsToSkip = new ArrayList();
  private PersistableUpload persistableUpload;
  
  public UploadCallable(TransferManager transferManager, ExecutorService threadPool, UploadImpl upload, PutObjectRequest origReq, ProgressListenerChain progressListenerChain, String uploadId, TransferProgress transferProgress)
  {
    s3 = transferManager.getAmazonS3Client();
    configuration = transferManager.getConfiguration();
    
    this.threadPool = threadPool;
    this.origReq = origReq;
    listener = progressListenerChain;
    this.upload = upload;
    multipartUploadId = uploadId;
    this.transferProgress = transferProgress;
  }
  
  List<Future<PartETag>> getFutures()
  {
    return futures;
  }
  
  List<PartETag> getETags()
  {
    return eTagsToSkip;
  }
  
  String getMultipartUploadId()
  {
    return multipartUploadId;
  }
  
  public boolean isMultipartUpload()
  {
    return TransferManagerUtils.shouldUseMultipartUpload(origReq, configuration);
  }
  
  public UploadResult call()
    throws Exception
  {
    upload.setState(Transfer.TransferState.InProgress);
    if (isMultipartUpload())
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_STARTED_EVENT);
      return uploadInParts();
    }
    return uploadInOneChunk();
  }
  
  private UploadResult uploadInOneChunk()
  {
    PutObjectResult putObjectResult = s3.putObject(origReq);
    
    UploadResult uploadResult = new UploadResult();
    uploadResult.setBucketName(origReq.getBucketName());
    uploadResult.setKey(origReq.getKey());
    uploadResult.setETag(putObjectResult.getETag());
    uploadResult.setVersionId(putObjectResult.getVersionId());
    return uploadResult;
  }
  
  private void captureUploadStateIfPossible()
  {
    if (origReq.getSSECustomerKey() == null)
    {
      persistableUpload = new PersistableUpload(origReq.getBucketName(), origReq.getKey(), origReq.getFile().getAbsolutePath(), multipartUploadId, configuration.getMinimumUploadPartSize(), configuration.getMultipartUploadThreshold());
      notifyPersistableTransferAvailability();
    }
  }
  
  public PersistableUpload getPersistableUpload()
  {
    return persistableUpload;
  }
  
  private void notifyPersistableTransferAvailability()
  {
    S3ProgressPublisher.publishTransferPersistable(listener, persistableUpload);
  }
  
  private UploadResult uploadInParts()
    throws Exception
  {
    boolean isUsingEncryption = s3 instanceof AmazonS3Encryption;
    long optimalPartSize = getOptimalPartSize(isUsingEncryption);
    try
    {
      if (multipartUploadId == null) {
        multipartUploadId = initiateMultipartUpload(origReq, isUsingEncryption);
      }
      UploadPartRequestFactory requestFactory = new UploadPartRequestFactory(origReq, multipartUploadId, optimalPartSize);
      UploadResult localUploadResult;
      if (TransferManagerUtils.isUploadParallelizable(origReq, isUsingEncryption))
      {
        captureUploadStateIfPossible();
        uploadPartsInParallel(requestFactory, multipartUploadId);
        return null;
      }
      return uploadPartsInSeries(requestFactory);
    }
    catch (Exception e)
    {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      performAbortMultipartUpload();
      throw e;
    }
    finally
    {
      if (origReq.getInputStream() != null) {
        try
        {
          origReq.getInputStream().close();
        }
        catch (Exception e)
        {
          log.warn("Unable to cleanly close input stream: " + e.getMessage(), e);
        }
      }
    }
  }
  
  void performAbortMultipartUpload()
  {
    if (multipartUploadId == null) {
      return;
    }
    try
    {
      AbortMultipartUploadRequest abortRequest = new AbortMultipartUploadRequest(origReq.getBucketName(), origReq.getKey(), multipartUploadId).withRequesterPays(origReq.isRequesterPays());
      s3.abortMultipartUpload(abortRequest);
    }
    catch (Exception e2)
    {
      log.info("Unable to abort multipart upload, you may need to manually remove uploaded parts: " + e2
      
        .getMessage(), e2);
    }
  }
  
  private long getOptimalPartSize(boolean isUsingEncryption)
  {
    long optimalPartSize = TransferManagerUtils.calculateOptimalPartSize(origReq, configuration);
    if ((isUsingEncryption) && (optimalPartSize % 32L > 0L)) {
      optimalPartSize = optimalPartSize - optimalPartSize % 32L + 32L;
    }
    log.debug("Calculated optimal part size: " + optimalPartSize);
    return optimalPartSize;
  }
  
  private UploadResult uploadPartsInSeries(UploadPartRequestFactory requestFactory)
  {
    List<PartETag> partETags = new ArrayList();
    while (requestFactory.hasMoreRequests())
    {
      if (threadPool.isShutdown()) {
        throw new CancellationException("TransferManager has been shutdown");
      }
      UploadPartRequest uploadPartRequest = requestFactory.getNextUploadPartRequest();
      
      InputStream inputStream = uploadPartRequest.getInputStream();
      if ((inputStream != null) && (inputStream.markSupported())) {
        if (uploadPartRequest.getPartSize() >= 2147483647L) {
          inputStream.mark(Integer.MAX_VALUE);
        } else {
          inputStream.mark((int)uploadPartRequest.getPartSize());
        }
      }
      partETags.add(s3.uploadPart(uploadPartRequest).getPartETag());
    }
    CompleteMultipartUploadRequest req = (CompleteMultipartUploadRequest)new CompleteMultipartUploadRequest(origReq.getBucketName(), origReq.getKey(), multipartUploadId, partETags).withRequesterPays(origReq.isRequesterPays()).withGeneralProgressListener(origReq.getGeneralProgressListener()).withRequestMetricCollector(origReq.getRequestMetricCollector());
    
    CompleteMultipartUploadResult res = s3.completeMultipartUpload(req);
    
    UploadResult uploadResult = new UploadResult();
    uploadResult.setBucketName(res.getBucketName());
    uploadResult.setKey(res.getKey());
    uploadResult.setETag(res.getETag());
    uploadResult.setVersionId(res.getVersionId());
    return uploadResult;
  }
  
  private void uploadPartsInParallel(UploadPartRequestFactory requestFactory, String uploadId)
  {
    Map<Integer, PartSummary> partNumbers = identifyExistingPartsForResume(uploadId);
    while (requestFactory.hasMoreRequests())
    {
      if (threadPool.isShutdown()) {
        throw new CancellationException("TransferManager has been shutdown");
      }
      UploadPartRequest request = requestFactory.getNextUploadPartRequest();
      if (partNumbers.containsKey(Integer.valueOf(request.getPartNumber())))
      {
        PartSummary summary = (PartSummary)partNumbers.get(Integer.valueOf(request.getPartNumber()));
        eTagsToSkip.add(new PartETag(request.getPartNumber(), summary
          .getETag()));
        transferProgress.updateProgress(summary.getSize());
      }
      else
      {
        futures.add(threadPool.submit(new UploadPartCallable(s3, request, shouldCalculatePartMd5())));
      }
    }
  }
  
  private Map<Integer, PartSummary> identifyExistingPartsForResume(String uploadId)
  {
    Map<Integer, PartSummary> partNumbers = new HashMap();
    if (uploadId == null) {
      return partNumbers;
    }
    int partNumber = 0;
    for (;;)
    {
      PartListing parts = s3.listParts(new ListPartsRequest(origReq
        .getBucketName(), origReq
        .getKey(), uploadId)
        .withPartNumberMarker(Integer.valueOf(partNumber))
        .withRequesterPays(origReq.isRequesterPays()));
      for (PartSummary partSummary : parts.getParts()) {
        partNumbers.put(Integer.valueOf(partSummary.getPartNumber()), partSummary);
      }
      if (!parts.isTruncated()) {
        return partNumbers;
      }
      partNumber = parts.getNextPartNumberMarker().intValue();
    }
  }
  
  private String initiateMultipartUpload(PutObjectRequest origReq, boolean isUsingEncryption)
  {
    InitiateMultipartUploadRequest req = null;
    if ((isUsingEncryption) && ((origReq instanceof EncryptedPutObjectRequest)))
    {
      req = new EncryptedInitiateMultipartUploadRequest(origReq.getBucketName(), origReq.getKey()).withCannedACL(origReq.getCannedAcl()).withObjectMetadata(origReq.getMetadata());
      ((EncryptedInitiateMultipartUploadRequest)req)
        .setMaterialsDescription(((EncryptedPutObjectRequest)origReq).getMaterialsDescription());
    }
    else
    {
      req = new InitiateMultipartUploadRequest(origReq.getBucketName(), origReq.getKey()).withCannedACL(origReq.getCannedAcl()).withObjectMetadata(origReq.getMetadata());
    }
    req.withTagging(origReq.getTagging());
    
    TransferManager.appendMultipartUserAgent(req);
    
    req.withAccessControlList(origReq.getAccessControlList())
      .withRequesterPays(origReq.isRequesterPays())
      .withStorageClass(origReq.getStorageClass())
      .withRedirectLocation(origReq.getRedirectLocation())
      .withSSECustomerKey(origReq.getSSECustomerKey())
      .withSSEAwsKeyManagementParams(origReq.getSSEAwsKeyManagementParams())
      .withGeneralProgressListener(origReq.getGeneralProgressListener())
      .withRequestMetricCollector(origReq.getRequestMetricCollector());
    
    req.withObjectLockMode(origReq.getObjectLockMode())
      .withObjectLockRetainUntilDate(origReq.getObjectLockRetainUntilDate())
      .withObjectLockLegalHoldStatus(origReq.getObjectLockLegalHoldStatus());
    
    String uploadId = s3.initiateMultipartUpload(req).getUploadId();
    log.debug("Initiated new multipart upload: " + uploadId);
    
    return uploadId;
  }
  
  private boolean shouldCalculatePartMd5()
  {
    return (origReq.getObjectLockMode() != null) || 
      (origReq.getObjectLockRetainUntilDate() != null) || 
      (origReq.getObjectLockLegalHoldStatus() != null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */