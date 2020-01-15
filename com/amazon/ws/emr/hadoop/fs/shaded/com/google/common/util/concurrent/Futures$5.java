package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

final class Futures$5
  implements Runnable
{
  Futures$5(ConcurrentLinkedQueue paramConcurrentLinkedQueue, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    ((AsyncSettableFuture)val$delegates.remove()).setFuture(val$future);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */