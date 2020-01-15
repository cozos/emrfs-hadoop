package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class Futures$CombinedFuture$1
  implements Runnable
{
  Futures$CombinedFuture$1(Futures.CombinedFuture paramCombinedFuture) {}
  
  public void run()
  {
    if (this$0.isCancelled()) {
      for (ListenableFuture<?> future : this$0.futures) {
        future.cancel(this$0.wasInterrupted());
      }
    }
    this$0.futures = null;
    
    this$0.values = null;
    
    this$0.combiner = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.CombinedFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */