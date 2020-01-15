package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers;

import java.util.concurrent.ThreadFactory;

final class TimeoutThreadPoolBuilder$1
  implements ThreadFactory
{
  private int threadCount = 1;
  
  TimeoutThreadPoolBuilder$1(String paramString) {}
  
  public Thread newThread(Runnable r)
  {
    Thread thread = new Thread(r);
    if (val$name != null) {
      thread.setName(val$name + "-" + threadCount++);
    }
    thread.setPriority(10);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.TimeoutThreadPoolBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */