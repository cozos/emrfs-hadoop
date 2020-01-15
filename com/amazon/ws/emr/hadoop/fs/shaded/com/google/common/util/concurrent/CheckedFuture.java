package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract interface CheckedFuture<V, X extends Exception>
  extends ListenableFuture<V>
{
  public abstract V checkedGet()
    throws Exception;
  
  public abstract V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */