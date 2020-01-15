package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class WrappingExecutorService
  implements ExecutorService
{
  private final ExecutorService delegate;
  
  protected WrappingExecutorService(ExecutorService delegate)
  {
    this.delegate = ((ExecutorService)Preconditions.checkNotNull(delegate));
  }
  
  protected abstract <T> Callable<T> wrapTask(Callable<T> paramCallable);
  
  protected Runnable wrapTask(Runnable command)
  {
    final Callable<Object> wrapped = wrapTask(Executors.callable(command, null));
    
    new Runnable()
    {
      public void run()
      {
        try
        {
          wrapped.call();
        }
        catch (Exception e)
        {
          Throwables.propagate(e);
        }
      }
    };
  }
  
  private final <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> tasks)
  {
    ImmutableList.Builder<Callable<T>> builder = ImmutableList.builder();
    for (Callable<T> task : tasks) {
      builder.add(wrapTask(task));
    }
    return builder.build();
  }
  
  public final void execute(Runnable command)
  {
    delegate.execute(wrapTask(command));
  }
  
  public final <T> Future<T> submit(Callable<T> task)
  {
    return delegate.submit(wrapTask((Callable)Preconditions.checkNotNull(task)));
  }
  
  public final Future<?> submit(Runnable task)
  {
    return delegate.submit(wrapTask(task));
  }
  
  public final <T> Future<T> submit(Runnable task, T result)
  {
    return delegate.submit(wrapTask(task), result);
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
    throws InterruptedException
  {
    return delegate.invokeAll(wrapTasks(tasks));
  }
  
  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate.invokeAll(wrapTasks(tasks), timeout, unit);
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> tasks)
    throws InterruptedException, ExecutionException
  {
    return (T)delegate.invokeAny(wrapTasks(tasks));
  }
  
  public final <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)delegate.invokeAny(wrapTasks(tasks), timeout, unit);
  }
  
  public final void shutdown()
  {
    delegate.shutdown();
  }
  
  public final List<Runnable> shutdownNow()
  {
    return delegate.shutdownNow();
  }
  
  public final boolean isShutdown()
  {
    return delegate.isShutdown();
  }
  
  public final boolean isTerminated()
  {
    return delegate.isTerminated();
  }
  
  public final boolean awaitTermination(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate.awaitTermination(timeout, unit);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.WrappingExecutorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */