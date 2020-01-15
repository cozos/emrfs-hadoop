package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class SimpleTimeLimiter$1
  implements InvocationHandler
{
  SimpleTimeLimiter$1(SimpleTimeLimiter paramSimpleTimeLimiter, Object paramObject, long paramLong, TimeUnit paramTimeUnit, Set paramSet) {}
  
  public Object invoke(Object obj, final Method method, final Object[] args)
    throws Throwable
  {
    Callable<Object> callable = new Callable()
    {
      public Object call()
        throws Exception
      {
        try
        {
          return method.invoke(val$target, args);
        }
        catch (InvocationTargetException e)
        {
          SimpleTimeLimiter.access$000(e, false);
          throw new AssertionError("can't get here");
        }
      }
    };
    return this$0.callWithTimeout(callable, val$timeoutDuration, val$timeoutUnit, val$interruptibleMethods.contains(method));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SimpleTimeLimiter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */