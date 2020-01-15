package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;

final class Callables$3
  implements Runnable
{
  Callables$3(Supplier paramSupplier, Runnable paramRunnable) {}
  
  public void run()
  {
    Thread currentThread = Thread.currentThread();
    String oldName = currentThread.getName();
    boolean restoreName = Callables.access$000((String)val$nameSupplier.get(), currentThread);
    try
    {
      val$task.run();
    }
    finally
    {
      if (restoreName) {
        Callables.access$000(oldName, currentThread);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Callables.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */