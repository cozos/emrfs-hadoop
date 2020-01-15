package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import javax.annotation.Nullable;

public final class SettableFuture<V>
  extends AbstractFuture<V>
{
  public static <V> SettableFuture<V> create()
  {
    return new SettableFuture();
  }
  
  public boolean set(@Nullable V value)
  {
    return super.set(value);
  }
  
  public boolean setException(Throwable throwable)
  {
    return super.setException(throwable);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SettableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */