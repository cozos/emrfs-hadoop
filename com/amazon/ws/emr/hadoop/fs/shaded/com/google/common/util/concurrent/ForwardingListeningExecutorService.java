package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public abstract class ForwardingListeningExecutorService
  extends ForwardingExecutorService
  implements ListeningExecutorService
{
  protected abstract ListeningExecutorService delegate();
  
  public <T> ListenableFuture<T> submit(Callable<T> task)
  {
    return delegate().submit(task);
  }
  
  public ListenableFuture<?> submit(Runnable task)
  {
    return delegate().submit(task);
  }
  
  public <T> ListenableFuture<T> submit(Runnable task, T result)
  {
    return delegate().submit(task, result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingListeningExecutorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */