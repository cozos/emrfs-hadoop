package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class CallableBackgroundInitializer<T>
  extends BackgroundInitializer<T>
{
  private final Callable<T> callable;
  
  public CallableBackgroundInitializer(Callable<T> call)
  {
    checkCallable(call);
    callable = call;
  }
  
  public CallableBackgroundInitializer(Callable<T> call, ExecutorService exec)
  {
    super(exec);
    checkCallable(call);
    callable = call;
  }
  
  protected T initialize()
    throws Exception
  {
    return (T)callable.call();
  }
  
  private void checkCallable(Callable<T> call)
  {
    if (call == null) {
      throw new IllegalArgumentException("Callable must not be null!");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.CallableBackgroundInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */