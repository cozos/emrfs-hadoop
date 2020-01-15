package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Future;

public abstract class ForwardingFuture$SimpleForwardingFuture<V>
  extends ForwardingFuture<V>
{
  private final Future<V> delegate;
  
  protected ForwardingFuture$SimpleForwardingFuture(Future<V> delegate)
  {
    this.delegate = ((Future)Preconditions.checkNotNull(delegate));
  }
  
  protected final Future<V> delegate()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingFuture.SimpleForwardingFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */