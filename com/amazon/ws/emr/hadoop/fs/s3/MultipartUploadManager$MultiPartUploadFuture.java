package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.concurrent.Future;

@VisibleForTesting
class MultipartUploadManager$MultiPartUploadFuture
{
  private long partSize;
  private DateTime startTime;
  private DateTime endTime;
  private Future<UploadPartResult> future;
  private MultipartUploadManager.MultipartUploadCallable multipartUploadCallable;
  
  public long getPartSize()
  {
    return partSize;
  }
  
  public DateTime getStartTime()
  {
    return startTime;
  }
  
  public void setStartTime(DateTime startTime)
  {
    this.startTime = startTime;
  }
  
  public DateTime getEndTime()
  {
    return endTime;
  }
  
  public void setEndTime(DateTime endTime)
  {
    this.endTime = endTime;
  }
  
  public Future<UploadPartResult> getFuture()
  {
    return future;
  }
  
  public MultipartUploadManager$MultiPartUploadFuture(long this$0, Future<UploadPartResult> arg3, MultipartUploadManager.MultipartUploadCallable future)
  {
    this.partSize = partSize;
    this.future = future;
    multipartUploadCallable = multiPartUploadCallable;
  }
  
  public MultipartUploadManager.MultipartUploadCallable getMultiPartUploadCallable()
  {
    return multipartUploadCallable;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartUploadManager.MultiPartUploadFuture
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */