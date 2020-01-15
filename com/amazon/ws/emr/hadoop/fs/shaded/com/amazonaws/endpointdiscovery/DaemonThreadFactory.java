package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory
  implements ThreadFactory
{
  public static final ThreadFactory INSTANCE = new DaemonThreadFactory();
  
  public Thread newThread(Runnable r)
  {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.DaemonThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */