package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.slf4j.Logger;

class MultipartUploadOutputStream$MultipartUploadFutureCallBack
  implements FutureCallback<PartETag>
{
  private final ListenableFuture<PartETag> future;
  private final int partNum;
  
  public MultipartUploadOutputStream$MultipartUploadFutureCallBack(ListenableFuture<PartETag> arg1, int future)
  {
    this.future = future;
    this.partNum = partNum;
  }
  
  public void onFailure(Throwable arg0)
  {
    if (future.isCancelled())
    {
      MultipartUploadOutputStream.LOG.debug("Multipart Upload for part: " + partNum + " cancelled");
    }
    else
    {
      MultipartUploadOutputStream.access$000(this$0).remove(Integer.valueOf(partNum));
      MultipartUploadOutputStream.LOG.debug("Removed " + partNum + " from incomplete partNum set because it failed");
      
      MultipartUploadOutputStream.MultiPartUploadFuture multiPartUploadFuture = new MultipartUploadOutputStream.MultiPartUploadFuture(this$0, 0L, future, null);
      List<MultipartUploadOutputStream.MultiPartUploadFuture> newMultipartUploadFutures = new ArrayList();
      
      newMultipartUploadFutures.add(multiPartUploadFuture);
      MultipartUploadOutputStream.access$100(this$0).put(Integer.valueOf(partNum), newMultipartUploadFutures);
      MultipartUploadOutputStream.LOG.debug("Added just the failed future to the list of futures for partNum: " + partNum);
    }
  }
  
  public void onSuccess(PartETag arg0)
  {
    DateTime endTime = DateTime.now();
    synchronized (MultipartUploadOutputStream.access$200(this$0))
    {
      try
      {
        while (MultipartUploadOutputStream.access$100(this$0).get(Integer.valueOf(partNum)) == null) {
          MultipartUploadOutputStream.access$200(this$0).wait();
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException("Thread interrupted in multipart upload future callback's onSuccess", e);
      }
    }
    List<MultipartUploadOutputStream.MultiPartUploadFuture> multiPartUploadFutures = (List)MultipartUploadOutputStream.access$100(this$0).get(Integer.valueOf(partNum));
    MultipartUploadOutputStream.LOG.debug("Total spawned multipart upload futures for partNum: " + partNum + " are: " + multiPartUploadFutures
      .size());
    List<MultipartUploadOutputStream.MultiPartUploadFuture> newMultipartUploadFutures = null;
    for (MultipartUploadOutputStream.MultiPartUploadFuture multiPartUploadFuture : multiPartUploadFutures) {
      if (multiPartUploadFuture.getFuture().isDone())
      {
        multiPartUploadFuture.setEndTime(endTime);
        newMultipartUploadFutures = new ArrayList();
        newMultipartUploadFutures.add(multiPartUploadFuture);
      }
      else
      {
        MultipartUploadOutputStream.LOG.debug("Cancelling future for partNum: " + partNum + " running for: " + 
          (endTime.getMillis() - multiPartUploadFuture.getStartTime().getMillis()) / 1000L + " s");
        multiPartUploadFuture.getFuture().cancel(true);
        
        multiPartUploadFuture.getMultiPartUploadCallable().setShouldCallAbortOnCompletion(true);
      }
    }
    if (newMultipartUploadFutures != null) {
      MultipartUploadOutputStream.access$100(this$0).put(Integer.valueOf(partNum), newMultipartUploadFutures);
    }
    MultipartUploadOutputStream.LOG.debug("Going to remove " + partNum + " from the incomplete part num set");
    MultipartUploadOutputStream.access$000(this$0).remove(Integer.valueOf(partNum));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.MultipartUploadOutputStream.MultipartUploadFutureCallBack
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */