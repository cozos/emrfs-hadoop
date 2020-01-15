package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MoreExecutors$DirectExecutorService
  extends AbstractListeningExecutorService
{
  private final Lock lock = new ReentrantLock();
  private final Condition termination = lock.newCondition();
  private int runningTasks = 0;
  private boolean shutdown = false;
  
  public void execute(Runnable command)
  {
    startTask();
    try
    {
      command.run();
    }
    finally
    {
      endTask();
    }
  }
  
  public boolean isShutdown()
  {
    lock.lock();
    try
    {
      return shutdown;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  public void shutdown()
  {
    lock.lock();
    try
    {
      shutdown = true;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  public List<Runnable> shutdownNow()
  {
    shutdown();
    return Collections.emptyList();
  }
  
  public boolean isTerminated()
  {
    lock.lock();
    try
    {
      return (shutdown) && (runningTasks == 0);
    }
    finally
    {
      lock.unlock();
    }
  }
  
  /* Error */
  public boolean awaitTermination(long timeout, java.util.concurrent.TimeUnit unit)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 85	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore 4
    //   7: aload_0
    //   8: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
    //   11: invokeinterface 62 1 0
    //   16: aload_0
    //   17: invokevirtual 87	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:isTerminated	()Z
    //   20: ifeq +18 -> 38
    //   23: iconst_1
    //   24: istore 6
    //   26: aload_0
    //   27: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
    //   30: invokeinterface 65 1 0
    //   35: iload 6
    //   37: ireturn
    //   38: lload 4
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +18 -> 60
    //   45: iconst_0
    //   46: istore 6
    //   48: aload_0
    //   49: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 65 1 0
    //   57: iload 6
    //   59: ireturn
    //   60: aload_0
    //   61: getfield 35	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:termination	Ljava/util/concurrent/locks/Condition;
    //   64: lload 4
    //   66: invokeinterface 92 3 0
    //   71: lstore 4
    //   73: goto -57 -> 16
    //   76: astore 7
    //   78: aload_0
    //   79: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/MoreExecutors$DirectExecutorService:lock	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 65 1 0
    //   87: aload 7
    //   89: athrow
    // Line number table:
    //   Java source line #345	-> byte code offset #0
    //   Java source line #346	-> byte code offset #7
    //   Java source line #349	-> byte code offset #16
    //   Java source line #350	-> byte code offset #23
    //   Java source line #358	-> byte code offset #26
    //   Java source line #351	-> byte code offset #38
    //   Java source line #352	-> byte code offset #45
    //   Java source line #358	-> byte code offset #48
    //   Java source line #354	-> byte code offset #60
    //   Java source line #358	-> byte code offset #76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	DirectExecutorService
    //   0	90	1	timeout	long
    //   0	90	3	unit	java.util.concurrent.TimeUnit
    //   5	67	4	nanos	long
    //   24	34	6	bool	boolean
    //   76	12	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	26	76	finally
    //   38	48	76	finally
    //   60	78	76	finally
  }
  
  private void startTask()
  {
    lock.lock();
    try
    {
      if (isShutdown()) {
        throw new RejectedExecutionException("Executor already shutdown");
      }
      runningTasks += 1;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  private void endTask()
  {
    lock.lock();
    try
    {
      runningTasks -= 1;
      if (isTerminated()) {
        termination.signalAll();
      }
    }
    finally
    {
      lock.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors.DirectExecutorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */