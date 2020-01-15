package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ForwardingFuture<V>
  extends ForwardingObject
  implements Future<V>
{
  protected abstract Future<V> delegate();
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    return delegate().cancel(mayInterruptIfRunning);
  }
  
  public boolean isCancelled()
  {
    return delegate().isCancelled();
  }
  
  public boolean isDone()
  {
    return delegate().isDone();
  }
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    return (V)delegate().get();
  }
  
  public V get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (V)delegate().get(timeout, unit);
  }
  
  public static abstract class SimpleForwardingFuture<V>
    extends ForwardingFuture<V>
  {
    private final Future<V> delegate;
    
    protected SimpleForwardingFuture(Future<V> delegate)
    {
      this.delegate = ((Future)Preconditions.checkNotNull(delegate));
    }
    
    protected final Future<V> delegate()
    {
      return delegate;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */