package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class MoreExecutors$ListeningDecorator
  extends AbstractListeningExecutorService
{
  private final ExecutorService delegate;
  
  MoreExecutors$ListeningDecorator(ExecutorService delegate)
  {
    this.delegate = ((ExecutorService)Preconditions.checkNotNull(delegate));
  }
  
  public boolean awaitTermination(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate.awaitTermination(timeout, unit);
  }
  
  public boolean isShutdown()
  {
    return delegate.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return delegate.isTerminated();
  }
  
  public void shutdown()
  {
    delegate.shutdown();
  }
  
  public List<Runnable> shutdownNow()
  {
    return delegate.shutdownNow();
  }
  
  public void execute(Runnable command)
  {
    delegate.execute(command);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.ListeningDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */