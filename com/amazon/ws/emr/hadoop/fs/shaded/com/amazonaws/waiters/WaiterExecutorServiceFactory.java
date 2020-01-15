package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NamedDefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SdkProtectedApi
public class WaiterExecutorServiceFactory
{
  public static ExecutorService buildExecutorServiceForWaiter(String name)
  {
    return Executors.newCachedThreadPool(NamedDefaultThreadFactory.of(name));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecutorServiceFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */