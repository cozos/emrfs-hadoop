package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.concurrent.Future;

class MultipartUploadOutputStream$MultiPartUploadFuture
{
  private final long partSize;
  private DateTime startTime;
  private DateTime endTime;
  private Future<PartETag> future;
  private MultipartUploadOutputStream.MultipartUploadCallable multipartUploadCallable;
  
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
  
  public Future<PartETag> getFuture()
  {
    return future;
  }
  
  public MultipartUploadOutputStream$MultiPartUploadFuture(long arg1, Future<PartETag> arg3, MultipartUploadOutputStream.MultipartUploadCallable future)
  {
    this.partSize = partSize;
    this.future = future;
    multipartUploadCallable = multiPartUploadCallable;
  }
  
  public MultipartUploadOutputStream.MultipartUploadCallable getMultiPartUploadCallable()
  {
    return multipartUploadCallable;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.MultipartUploadOutputStream.MultiPartUploadFuture
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */