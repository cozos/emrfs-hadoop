package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.slf4j.Logger;

class MultipartUploadManager$MultipartUploadFutureCallBack
  implements FutureCallback<UploadPartResult>
{
  private ListenableFuture<UploadPartResult> future;
  private int partNum;
  
  public MultipartUploadManager$MultipartUploadFutureCallBack(ListenableFuture<UploadPartResult> arg1, int future)
  {
    this.future = future;
    this.partNum = partNum;
  }
  
  public void onFailure(Throwable arg0)
  {
    if (future.isCancelled())
    {
      MultipartUploadManager.access$1500().debug("Multipart Upload for part: {} cancelled", Integer.valueOf(partNum));
    }
    else
    {
      MultipartUploadManager.access$1600(this$0).remove(Integer.valueOf(partNum));
      MultipartUploadManager.access$1500().debug("Removed {} from incomplete partNum set because it failed", Integer.valueOf(partNum));
      
      MultipartUploadManager.MultiPartUploadFuture multiPartUploadFuture = new MultipartUploadManager.MultiPartUploadFuture(this$0, 0L, future, null);
      List<MultipartUploadManager.MultiPartUploadFuture> newMultipartUploadFutures = new ArrayList();
      newMultipartUploadFutures.add(multiPartUploadFuture);
      MultipartUploadManager.access$1700(this$0).put(Integer.valueOf(partNum), newMultipartUploadFutures);
      MultipartUploadManager.access$1500().debug("Added just the failed future to the list of futures for partNum: {}", 
        Integer.valueOf(partNum));
    }
  }
  
  public void onSuccess(UploadPartResult arg0)
  {
    DateTime endTime = DateTime.now();
    synchronized (MultipartUploadManager.access$1800(this$0))
    {
      try
      {
        while (MultipartUploadManager.access$1700(this$0).get(Integer.valueOf(partNum)) == null)
        {
          MultipartUploadManager.access$1500().debug("Waiting update from addPartAsynchronously for part uploading, but this should be rarely happened");
          
          MultipartUploadManager.access$1800(this$0).wait();
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException("Thread interrupted in multipart upload future callback's onSuccess", e);
      }
    }
    List<MultipartUploadManager.MultiPartUploadFuture> multiPartUploadFutures = (List)MultipartUploadManager.access$1700(this$0).get(Integer.valueOf(partNum));
    MultipartUploadManager.access$1500().debug("Total spawned multipart upload futures for partNum: {} are: {}", 
      Integer.valueOf(partNum), Integer.valueOf(multiPartUploadFutures.size()));
    List<MultipartUploadManager.MultiPartUploadFuture> newMultipartUploadFutures = null;
    for (MultipartUploadManager.MultiPartUploadFuture multiPartUploadFuture : multiPartUploadFutures) {
      if (multiPartUploadFuture.getFuture().isDone())
      {
        multiPartUploadFuture.setEndTime(endTime);
        newMultipartUploadFutures = new ArrayList();
        newMultipartUploadFutures.add(multiPartUploadFuture);
      }
      else
      {
        long startTime = multiPartUploadFuture.getStartTime() == null ? endTime.getMillis() : multiPartUploadFuture.getStartTime().getMillis();
        MultipartUploadManager.access$1500().debug("Cancelling future for partNum: {} running for: {} s", 
          Integer.valueOf(partNum), Long.valueOf((endTime.getMillis() - startTime) / 1000L));
        multiPartUploadFuture.getFuture().cancel(true);
        
        multiPartUploadFuture.getMultiPartUploadCallable().setShouldCallAbortOnCompletion(true);
      }
    }
    if (newMultipartUploadFutures != null) {
      MultipartUploadManager.access$1700(this$0).put(Integer.valueOf(partNum), newMultipartUploadFutures);
    }
    MultipartUploadManager.access$1500().debug("Going to remove {} from the incomplete part num set", Integer.valueOf(partNum));
    MultipartUploadManager.access$1600(this$0).remove(Integer.valueOf(partNum));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartUploadManager.MultipartUploadFutureCallBack
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */