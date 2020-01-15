package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class DaemonThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable runnable)
  {
    Thread thread = Executors.defaultThreadFactory().newThread(runnable);
    thread.setDaemon(true);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DaemonThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */