package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public abstract interface FutureFallback<V>
{
  public abstract ListenableFuture<V> create(Throwable paramThrowable)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureFallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */