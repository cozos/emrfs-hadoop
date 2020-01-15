package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class BackgroundInitializer$InitializationTask
  implements Callable<T>
{
  private final ExecutorService execFinally;
  
  public BackgroundInitializer$InitializationTask(BackgroundInitializer paramBackgroundInitializer, ExecutorService exec)
  {
    execFinally = exec;
  }
  
  public T call()
    throws Exception
  {
    try
    {
      return (T)this$0.initialize();
    }
    finally
    {
      if (execFinally != null) {
        execFinally.shutdown();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.BackgroundInitializer.InitializationTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */