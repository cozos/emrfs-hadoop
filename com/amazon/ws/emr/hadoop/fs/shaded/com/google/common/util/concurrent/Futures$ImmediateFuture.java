package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Futures$ImmediateFuture<V>
  implements ListenableFuture<V>
{
  private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
  
  public void addListener(Runnable listener, Executor executor)
  {
    Preconditions.checkNotNull(listener, "Runnable was null.");
    Preconditions.checkNotNull(executor, "Executor was null.");
    try
    {
      executor.execute(listener);
    }
    catch (RuntimeException e)
    {
      String str1 = String.valueOf(String.valueOf(listener));String str2 = String.valueOf(String.valueOf(executor));log.log(Level.SEVERE, 57 + str1.length() + str2.length() + "RuntimeException while executing runnable " + str1 + " with executor " + str2, e);
    }
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    return false;
  }
  
  public abstract V get()
    throws ExecutionException;
  
  public V get(long timeout, TimeUnit unit)
    throws ExecutionException
  {
    Preconditions.checkNotNull(unit);
    return (V)get();
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.ImmediateFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */