package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract class ForwardingCheckedFuture<V, X extends Exception>
  extends ForwardingListenableFuture<V>
  implements CheckedFuture<V, X>
{
  public V checkedGet()
    throws Exception
  {
    return (V)delegate().checkedGet();
  }
  
  public V checkedGet(long timeout, TimeUnit unit)
    throws TimeoutException, Exception
  {
    return (V)delegate().checkedGet(timeout, unit);
  }
  
  protected abstract CheckedFuture<V, X> delegate();
  
  @Beta
  public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception>
    extends ForwardingCheckedFuture<V, X>
  {
    private final CheckedFuture<V, X> delegate;
    
    protected SimpleForwardingCheckedFuture(CheckedFuture<V, X> delegate)
    {
      this.delegate = ((CheckedFuture)Preconditions.checkNotNull(delegate));
    }
    
    protected final CheckedFuture<V, X> delegate()
    {
      return delegate;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingCheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */