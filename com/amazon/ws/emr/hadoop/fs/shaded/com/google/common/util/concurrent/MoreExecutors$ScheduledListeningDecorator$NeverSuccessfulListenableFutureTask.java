package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;

final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask
  extends AbstractFuture<Void>
  implements Runnable
{
  private final Runnable delegate;
  
  public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(Runnable delegate)
  {
    this.delegate = ((Runnable)Preconditions.checkNotNull(delegate));
  }
  
  public void run()
  {
    try
    {
      delegate.run();
    }
    catch (Throwable t)
    {
      setException(t);
      throw Throwables.propagate(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */