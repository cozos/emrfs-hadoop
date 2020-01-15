package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture<V>
  extends ForwardingFuture<V>
  implements ListenableFuture<V>
{
  protected abstract ListenableFuture<V> delegate();
  
  public void addListener(Runnable listener, Executor exec)
  {
    delegate().addListener(listener, exec);
  }
  
  public static abstract class SimpleForwardingListenableFuture<V>
    extends ForwardingListenableFuture<V>
  {
    private final ListenableFuture<V> delegate;
    
    protected SimpleForwardingListenableFuture(ListenableFuture<V> delegate)
    {
      this.delegate = ((ListenableFuture)Preconditions.checkNotNull(delegate));
    }
    
    protected final ListenableFuture<V> delegate()
    {
      return delegate;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingListenableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */