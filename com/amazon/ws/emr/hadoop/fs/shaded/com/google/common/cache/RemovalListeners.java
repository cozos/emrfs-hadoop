package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@Beta
public final class RemovalListeners
{
  public static <K, V> RemovalListener<K, V> asynchronous(final RemovalListener<K, V> listener, Executor executor)
  {
    Preconditions.checkNotNull(listener);
    Preconditions.checkNotNull(executor);
    new RemovalListener()
    {
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
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.RemovalListeners
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */