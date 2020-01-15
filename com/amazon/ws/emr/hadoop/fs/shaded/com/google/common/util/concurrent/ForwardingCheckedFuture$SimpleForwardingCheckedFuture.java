package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@Beta
public abstract class ForwardingCheckedFuture$SimpleForwardingCheckedFuture<V, X extends Exception>
  extends ForwardingCheckedFuture<V, X>
{
  private final CheckedFuture<V, X> delegate;
  
  protected ForwardingCheckedFuture$SimpleForwardingCheckedFuture(CheckedFuture<V, X> delegate)
  {
    this.delegate = ((CheckedFuture)Preconditions.checkNotNull(delegate));
  }
  
  protected final CheckedFuture<V, X> delegate()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingCheckedFuture.SimpleForwardingCheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */