package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;

final class MoreExecutors$1
  implements Runnable
{
  MoreExecutors$1(BlockingQueue paramBlockingQueue, ListenableFuture paramListenableFuture) {}
  
  public void run()
  {
    val$queue.add(val$future);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */