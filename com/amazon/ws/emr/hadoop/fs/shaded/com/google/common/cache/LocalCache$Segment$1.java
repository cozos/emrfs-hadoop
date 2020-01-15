package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache$Segment$1
  implements Runnable
{
  LocalCache$Segment$1(LocalCache.Segment paramSegment, Object paramObject, int paramInt, LocalCache.LoadingValueReference paramLoadingValueReference, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    try
    {
      newValue = this$0.getAndRecordStats(val$key, val$hash, val$loadingValueReference, val$loadingFuture);
    }
    catch (Throwable t)
    {
      V newValue;
      LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", t);
      val$loadingValueReference.setException(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Segment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */