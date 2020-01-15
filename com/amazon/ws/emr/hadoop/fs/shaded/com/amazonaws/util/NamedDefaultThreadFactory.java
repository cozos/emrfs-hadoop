package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@SdkInternalApi
public class NamedDefaultThreadFactory
  implements ThreadFactory
{
  private static final Map<String, AtomicInteger> poolNumberMap = new ConcurrentHashMap();
  private final ThreadGroup group;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  private final String namePrefix;
  
  public static NamedDefaultThreadFactory of(String name)
  {
    return new NamedDefaultThreadFactory(name);
  }
  
  private NamedDefaultThreadFactory(String name)
  {
    AtomicInteger poolNumber = getPoolNumberForName(name);
    SecurityManager s = System.getSecurityManager();
    group = (s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup());
    namePrefix = ("pool-" + name + "-" + poolNumber.getAndIncrement() + "-thread-");
  }
  
  public Thread newThread(Runnable r)
  {
    Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0L);
    if (t.isDaemon()) {
      t.setDaemon(false);
    }
    if (t.getPriority() != 5) {
      t.setPriority(5);
    }
    return t;
  }
  
  private static AtomicInteger getPoolNumberForName(String name)
  {
    AtomicInteger poolNumber = (AtomicInteger)poolNumberMap.get(name);
    if (poolNumber == null) {
      synchronized (NamedDefaultThreadFactory.class)
      {
        poolNumber = (AtomicInteger)poolNumberMap.get(name);
        if (poolNumber == null)
        {
          poolNumber = new AtomicInteger(1);
          poolNumberMap.put(name, poolNumber);
        }
      }
    }
    return poolNumber;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NamedDefaultThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */