package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CompleteMultipartUpload
  implements Callable<UploadResult>
{
  private final String uploadId;
  private final AmazonS3 s3;
  private final PutObjectRequest origReq;
  private final List<Future<PartETag>> futures;
  private final List<PartETag> eTagsBeforeResume;
  private final UploadMonitor monitor;
  private final ProgressListenerChain listener;
  
  public CompleteMultipartUpload(String uploadId, AmazonS3 s3, PutObjectRequest putObjectRequest, List<Future<PartETag>> futures, List<PartETag> eTagsBeforeResume, ProgressListenerChain progressListenerChain, UploadMonitor monitor)
  {
    this.uploadId = uploadId;
    this.s3 = s3;
    origReq = putObjectRequest;
    this.futures = futures;
    this.eTagsBeforeResume = eTagsBeforeResume;
    listener = progressListenerChain;
    this.monitor = monitor;
  }
  
  public UploadResult call()
    throws Exception
  {
    try
    {
      CompleteMultipartUploadRequest req = (CompleteMultipartUploadRequest)new CompleteMultipartUploadRequest(origReq.getBucketName(), origReq.getKey(), uploadId, collectPartETags()).withRequesterPays(origReq.isRequesterPays()).withGeneralProgressListener(origReq.getGeneralProgressListener()).withRequestMetricCollector(origReq.getRequestMetricCollector());
      
      res = s3.completeMultipartUpload(req);
    }
    catch (Exception e)
    {
      CompleteMultipartUploadResult res;
      monitor.uploadFailure();
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      throw e;
    }
    CompleteMultipartUploadResult res;
    UploadResult uploadResult = new UploadResult();
    uploadResult.setBucketName(origReq
      .getBucketName());
    uploadResult.setKey(origReq.getKey());
    uploadResult.setETag(res.getETag());
    uploadResult.setVersionId(res.getVersionId());
    
    monitor.uploadComplete();
    
    return uploadResult;
  }
  
  private List<PartETag> collectPartETags()
  {
    List<PartETag> partETags = new ArrayList();
    partETags.addAll(eTagsBeforeResume);
    for (Future<PartETag> future : futures) {
      try
      {
        partETags.add(future.get());
      }
      catch (Exception e)
      {
        throw new SdkClientException("Unable to complete multi-part upload. Individual part upload failed : " + e.getCause().getMessage(), e.getCause());
      }
    }
    return partETags;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CompleteMultipartUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */