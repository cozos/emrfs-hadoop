package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.Callable;

final class Callables$2
  implements Callable<T>
{
  Callables$2(Supplier paramSupplier, Callable paramCallable) {}
  
  public T call()
    throws Exception
  {
    Thread currentThread = Thread.currentThread();
    String oldName = currentThread.getName();
    boolean restoreName = Callables.access$000((String)val$nameSupplier.get(), currentThread);
    try
    {
      return (T)val$callable.call();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Callables.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */