package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
public class TimeoutThreadPoolBuilder
{
  public static ScheduledThreadPoolExecutor buildDefaultTimeoutThreadPool(String name)
  {
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5, getThreadFactory(name));
    safeSetRemoveOnCancel(executor);
    executor.setKeepAliveTime(5L, TimeUnit.SECONDS);
    executor.allowCoreThreadTimeOut(true);
    
    return executor;
  }
  
  private static ThreadFactory getThreadFactory(String name)
  {
    new ThreadFactory()
    {
      private int threadCount = 1;
      
      public Thread newThread(Runnable r)
      {
        Thread thread = new Thread(r);
        if (val$name != null) {
          thread.setName(val$name + "-" + threadCount++);
        }
        thread.setPriority(10);
        return thread;
      }
    };
  }
  
  private static void safeSetRemoveOnCancel(ScheduledThreadPoolExecutor executor)
  {
    try
    {
      executor.getClass().getMethod("setRemoveOnCancelPolicy", new Class[] { Boolean.TYPE }).invoke(executor, new Object[] { Boolean.TRUE });
    }
    catch (IllegalAccessException e)
    {
      throwSetRemoveOnCancelException(e);
    }
    catch (IllegalArgumentException e)
    {
      throwSetRemoveOnCancelException(e);
    }
    catch (InvocationTargetException e)
    {
      throwSetRemoveOnCancelException(e.getCause());
    }
    catch (NoSuchMethodException e)
    {
      throw new SdkClientException("The request timeout feature is only available for Java 1.7 and above.");
    }
    catch (SecurityException e)
    {
      throw new SdkClientException("The request timeout feature needs additional permissions to function.", e);
    }
  }
  
  private static void throwSetRemoveOnCancelException(Throwable cause)
  {
    throw new SdkClientException("Unable to setRemoveOnCancelPolicy for request timeout thread pool", cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.TimeoutThreadPoolBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */