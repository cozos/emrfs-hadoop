package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import java.util.concurrent.ThreadFactory;

final class SDKProgressPublisher$LazyHolder$1
  implements ThreadFactory
{
  public Thread newThread(Runnable r)
  {
    Thread t = new Thread(r);
    t.setName("java-sdk-progress-listener-callback-thread");
    t.setDaemon(true);
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher.LazyHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */