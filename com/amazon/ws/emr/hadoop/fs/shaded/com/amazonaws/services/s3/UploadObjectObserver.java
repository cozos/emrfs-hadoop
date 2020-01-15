package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UploadObjectObserver
{
  private final List<Future<UploadPartResult>> futures = new ArrayList();
  private UploadObjectRequest req;
  private String uploadId;
  private S3DirectSpi s3direct;
  private AmazonS3 s3;
  private ExecutorService es;
  
  public UploadObjectObserver init(UploadObjectRequest req, S3DirectSpi s3direct, AmazonS3 s3, ExecutorService es)
  {
    this.req = req;
    this.s3direct = s3direct;
    this.s3 = s3;
    this.es = es;
    return this;
  }
  
  protected InitiateMultipartUploadRequest newInitiateMultipartUploadRequest(UploadObjectRequest req)
  {
    return 
    
      (InitiateMultipartUploadRequest)new EncryptedInitiateMultipartUploadRequest(req.getBucketName(), req.getKey(), req.getMetadata()).withMaterialsDescription(req.getMaterialsDescription()).withRedirectLocation(req.getRedirectLocation()).withSSEAwsKeyManagementParams(req.getSSEAwsKeyManagementParams()).withSSECustomerKey(req.getSSECustomerKey()).withStorageClass(req.getStorageClass()).withAccessControlList(req.getAccessControlList()).withCannedACL(req.getCannedAcl()).withGeneralProgressListener(req.getGeneralProgressListener()).withRequestMetricCollector(req.getRequestMetricCollector()).withRequestCredentialsProvider(req.getRequestCredentialsProvider());
  }
  
  public String onUploadInitiation(UploadObjectRequest req)
  {
    InitiateMultipartUploadResult res = s3.initiateMultipartUpload(newInitiateMultipartUploadRequest(req));
    return uploadId = res.getUploadId();
  }
  
  public void onPartCreate(PartCreationEvent event)
  {
    final File part = event.getPart();
    
    final UploadPartRequest reqUploadPart = newUploadPartRequest(event, part);
    final OnFileDelete fileDeleteObserver = event.getFileDeleteObserver();
    appendUserAgent(reqUploadPart, AmazonS3EncryptionClient.USER_AGENT);
    futures.add(es.submit(new Callable()
    {
      public UploadPartResult call()
      {
        try
        {
          return uploadPart(reqUploadPart);
        }
        finally
        {
          if (!part.delete()) {
            LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + part + " which has already been uploaded");
          } else if (fileDeleteObserver != null) {
            fileDeleteObserver.onFileDelete(null);
          }
        }
      }
    }));
  }
  
  public CompleteMultipartUploadResult onCompletion(List<PartETag> partETags)
  {
    return s3.completeMultipartUpload(
    
      (CompleteMultipartUploadRequest)new CompleteMultipartUploadRequest(req.getBucketName(), req.getKey(), uploadId, partETags).withRequestCredentialsProvider(req.getRequestCredentialsProvider()));
  }
  
  public void onAbort()
  {
    for (Future<?> future : getFutures()) {
      future.cancel(true);
    }
    if (uploadId != null) {
      try
      {
        s3.abortMultipartUpload(new AbortMultipartUploadRequest(req
          .getBucketName(), req.getKey(), uploadId));
      }
      catch (Exception e)
      {
        LogFactory.getLog(getClass()).debug("Failed to abort multi-part upload: " + uploadId, e);
      }
    }
  }
  
  protected UploadPartRequest newUploadPartRequest(PartCreationEvent event, File part)
  {
    UploadPartRequest reqUploadPart = (UploadPartRequest)new UploadPartRequest().withBucketName(req.getBucketName()).withFile(part).withKey(req.getKey()).withPartNumber(event.getPartNumber()).withPartSize(part.length()).withLastPart(event.isLastPart()).withUploadId(uploadId).withObjectMetadata(req.getUploadPartMetadata()).withRequestCredentialsProvider(req.getRequestCredentialsProvider());
    
    return reqUploadPart;
  }
  
  protected UploadPartResult uploadPart(UploadPartRequest reqUploadPart)
  {
    return s3direct.uploadPart(reqUploadPart);
  }
  
  protected <X extends AmazonWebServiceRequest> X appendUserAgent(X request, String userAgent)
  {
    request.getRequestClientOptions().appendUserAgent(userAgent);
    return request;
  }
  
  public List<Future<UploadPartResult>> getFutures()
  {
    return futures;
  }
  
  protected UploadObjectRequest getRequest()
  {
    return req;
  }
  
  protected String getUploadId()
  {
    return uploadId;
  }
  
  protected S3DirectSpi getS3DirectSpi()
  {
    return s3direct;
  }
  
  protected AmazonS3 getAmazonS3()
  {
    return s3;
  }
  
  protected ExecutorService getExecutorService()
  {
    return es;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.UploadObjectObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */