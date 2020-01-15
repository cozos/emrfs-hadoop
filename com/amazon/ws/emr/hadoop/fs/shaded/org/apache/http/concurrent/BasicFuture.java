package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicFuture<T>
  implements Future<T>, Cancellable
{
  private final FutureCallback<T> callback;
  private volatile boolean completed;
  private volatile boolean cancelled;
  private volatile T result;
  private volatile Exception ex;
  
  public BasicFuture(FutureCallback<T> callback)
  {
    this.callback = callback;
  }
  
  public boolean isCancelled()
  {
    return cancelled;
  }
  
  public boolean isDone()
  {
    return completed;
  }
  
  private T getResult()
    throws ExecutionException
  {
    if (ex != null) {
      throw new ExecutionException(ex);
    }
    if (cancelled) {
      throw new CancellationException();
    }
    return (T)result;
  }
  
  public synchronized T get()
    throws InterruptedException, ExecutionException
  {
    while (!completed) {
      wait();
    }
    return (T)getResult();
  }
  
  public synchronized T get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    Args.notNull(unit, "Time unit");
    long msecs = unit.toMillis(timeout);
    long startTime = msecs <= 0L ? 0L : System.currentTimeMillis();
    long waitTime = msecs;
    if (completed) {
      return (T)getResult();
    }
    if (waitTime <= 0L) {
      throw new TimeoutException();
    }
    do
    {
      wait(waitTime);
      if (completed) {
        return (T)getResult();
      }
      waitTime = msecs - (System.currentTimeMillis() - startTime);
    } while (waitTime > 0L);
    throw new TimeoutException();
  }
  
  public boolean completed(T result)
  {
    synchronized (this)
    {
      if (completed) {
        return false;
      }
      completed = true;
      this.result = result;
      notifyAll();
    }
    if (callback != null) {
      callback.completed(result);
    }
    return true;
  }
  
  public boolean failed(Exception exception)
  {
    synchronized (this)
    {
      if (completed) {
        return false;
      }
      completed = true;
      ex = exception;
      notifyAll();
    }
    if (callback != null) {
      callback.failed(exception);
    }
    return true;
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    synchronized (this)
    {
      if (completed) {
        return false;
      }
      completed = true;
      cancelled = true;
      notifyAll();
    }
    if (callback != null) {
      callback.cancelled();
    }
    return true;
  }
  
  public boolean cancel()
  {
    return cancel(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.BasicFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */