package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CompleteMultipartCopy
  implements Callable<CopyResult>
{
  private final String uploadId;
  private final AmazonS3 s3;
  private final CopyObjectRequest origReq;
  private final List<Future<PartETag>> futures;
  private final CopyMonitor monitor;
  private final ProgressListenerChain listener;
  
  public CompleteMultipartCopy(String uploadId, AmazonS3 s3, CopyObjectRequest copyObjectRequest, List<Future<PartETag>> futures, ProgressListenerChain progressListenerChain, CopyMonitor monitor)
  {
    this.uploadId = uploadId;
    this.s3 = s3;
    origReq = copyObjectRequest;
    this.futures = futures;
    listener = progressListenerChain;
    this.monitor = monitor;
  }
  
  public CopyResult call()
    throws Exception
  {
    try
    {
      CompleteMultipartUploadRequest req = (CompleteMultipartUploadRequest)new CompleteMultipartUploadRequest(origReq.getDestinationBucketName(), origReq.getDestinationKey(), uploadId, collectPartETags()).withRequesterPays(origReq.isRequesterPays()).withGeneralProgressListener(origReq.getGeneralProgressListener()).withRequestMetricCollector(origReq.getRequestMetricCollector());
      
      res = s3.completeMultipartUpload(req);
    }
    catch (Exception e)
    {
      CompleteMultipartUploadResult res;
      monitor.reportFailure();
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      throw e;
    }
    CompleteMultipartUploadResult res;
    CopyResult copyResult = new CopyResult();
    copyResult.setSourceBucketName(origReq.getSourceBucketName());
    copyResult.setSourceKey(origReq.getSourceKey());
    copyResult.setDestinationBucketName(res
      .getBucketName());
    copyResult.setDestinationKey(res.getKey());
    copyResult.setETag(res.getETag());
    copyResult.setVersionId(res.getVersionId());
    
    monitor.copyComplete();
    
    return copyResult;
  }
  
  private List<PartETag> collectPartETags()
  {
    List<PartETag> partETags = new ArrayList();
    for (Future<PartETag> future : futures) {
      try
      {
        partETags.add(future.get());
      }
      catch (Exception e)
      {
        throw new SdkClientException("Unable to copy part: " + e.getCause().getMessage(), e.getCause());
      }
    }
    return partETags;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CompleteMultipartCopy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */