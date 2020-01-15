package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.concurrent.Executor;

final class RemovalListeners$1
  implements RemovalListener<K, V>
{
  RemovalListeners$1(Executor paramExecutor, RemovalListener paramRemovalListener) {}
  
  public void onRemoval(final RemovalNotification<K, V> notification)
  {
    val$executor.execute(new Runnable()
    {
      public void run()
      {
        val$listener.onRemoval(notification);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.RemovalListeners.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */