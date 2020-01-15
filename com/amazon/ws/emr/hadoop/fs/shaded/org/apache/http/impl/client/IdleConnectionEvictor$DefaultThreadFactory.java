package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import java.util.concurrent.ThreadFactory;

class IdleConnectionEvictor$DefaultThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable r)
  {
    Thread t = new Thread(r, "Connection evictor");
    t.setDaemon(true);
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.IdleConnectionEvictor.DefaultThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */