package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public final class FakeTimeLimiter
  implements TimeLimiter
{
  public <T> T newProxy(T target, Class<T> interfaceType, long timeoutDuration, TimeUnit timeoutUnit)
  {
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(interfaceType);
    Preconditions.checkNotNull(timeoutUnit);
    return target;
  }
  
  public <T> T callWithTimeout(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit, boolean amInterruptible)
    throws Exception
  {
    Preconditions.checkNotNull(timeoutUnit);
    return (T)callable.call();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FakeTimeLimiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */