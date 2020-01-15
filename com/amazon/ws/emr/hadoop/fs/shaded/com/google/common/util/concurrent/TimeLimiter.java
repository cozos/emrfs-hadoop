package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public abstract interface TimeLimiter
{
  public abstract <T> T newProxy(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.TimeLimiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */