package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

final class Futures$1
  implements Runnable
{
  Futures$1(Executor paramExecutor, Runnable paramRunnable, AbstractFuture paramAbstractFuture) {}
  
  public void run()
  {
    final AtomicBoolean thrownFromDelegate = new AtomicBoolean(true);
    try
    {
      val$delegateExecutor.execute(new Runnable()
      {
        public void run()
        {
          thrownFromDelegate.set(false);
          val$delegateTask.run();
        }
      });
    }
    catch (RejectedExecutionException e)
    {
      if (thrownFromDelegate.get()) {
        val$outputFuture.setException(e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */