package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class JdkFutureAdapters$ListenableFutureAdapter<V>
  extends ForwardingFuture<V>
  implements ListenableFuture<V>
{
  private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
  private static final Executor defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
  private final Executor adapterExecutor;
  private final ExecutionList executionList = new ExecutionList();
  private final AtomicBoolean hasListeners = new AtomicBoolean(false);
  private final Future<V> delegate;
  
  JdkFutureAdapters$ListenableFutureAdapter(Future<V> delegate)
  {
    this(delegate, defaultAdapterExecutor);
  }
  
  JdkFutureAdapters$ListenableFutureAdapter(Future<V> delegate, Executor adapterExecutor)
  {
    this.delegate = ((Future)Preconditions.checkNotNull(delegate));
    this.adapterExecutor = ((Executor)Preconditions.checkNotNull(adapterExecutor));
  }
  
  protected Future<V> delegate()
  {
    return delegate;
  }
  
  public void addListener(Runnable listener, Executor exec)
  {
    executionList.add(listener, exec);
    if (hasListeners.compareAndSet(false, true))
    {
      if (delegate.isDone())
      {
        executionList.execute();
        return;
      }
      adapterExecutor.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            Uninterruptibles.getUninterruptibly(delegate);
          }
          catch (Error e)
          {
            throw e;
          }
          catch (Throwable e) {}
          executionList.execute();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */