package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class SDKProgressPublisher$LazyHolder
{
  private static final ExecutorService executor = ;
  
  private static ExecutorService createNewExecutorService()
  {
    Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public Thread newThread(Runnable r)
      {
        Thread t = new Thread(r);
        t.setName("java-sdk-progress-listener-callback-thread");
        t.setDaemon(true);
        return t;
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher.LazyHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */