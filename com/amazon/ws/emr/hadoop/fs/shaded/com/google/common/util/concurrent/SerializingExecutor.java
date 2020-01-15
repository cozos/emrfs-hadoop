package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class SerializingExecutor
  implements Executor
{
  private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
  private final Executor executor;
  @GuardedBy("internalLock")
  private final Queue<Runnable> waitQueue = new ArrayDeque();
  @GuardedBy("internalLock")
  private boolean isThreadScheduled = false;
  private final TaskRunner taskRunner = new TaskRunner(null);
  
  public SerializingExecutor(Executor executor)
  {
    Preconditions.checkNotNull(executor, "'executor' must not be null.");
    this.executor = executor;
  }
  
  private final Object internalLock = new Object()
  {
    /* Error */
    public String toString()
    {
      // Byte code:
      //   0: ldc 22
      //   2: aload_0
      //   3: invokespecial 24	java/lang/Object:toString	()Ljava/lang/String;
      //   6: invokestatic 30	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   9: dup
      //   10: invokevirtual 34	java/lang/String:length	()I
      //   13: ifeq +9 -> 22
      //   16: invokevirtual 38	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   19: goto +12 -> 31
      //   22: pop
      //   23: new 26	java/lang/String
      //   26: dup_x1
      //   27: swap
      //   28: invokespecial 41	java/lang/String:<init>	(Ljava/lang/String;)V
      //   31: areturn
      // Line number table:
      //   Java source line #83	-> byte code offset #0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	1
    }
  };
  
  public void execute(Runnable r)
  {
    Preconditions.checkNotNull(r, "'r' must not be null.");
    boolean scheduleTaskRunner = false;
    synchronized (internalLock)
    {
      waitQueue.add(r);
      if (!isThreadScheduled)
      {
        isThreadScheduled = true;
        scheduleTaskRunner = true;
      }
    }
    if (scheduleTaskRunner)
    {
      boolean threw = true;
      try
      {
        executor.execute(taskRunner);
        threw = false;
      }
      finally
      {
        if (threw) {
          synchronized (internalLock)
          {
            isThreadScheduled = false;
          }
        }
      }
    }
  }
  
  private class TaskRunner
    implements Runnable
  {
    private TaskRunner() {}
    
    public void run()
    {
      boolean stillRunning = true;
      try
      {
        for (;;)
        {
          Preconditions.checkState(isThreadScheduled);
          Runnable nextToRun;
          synchronized (internalLock)
          {
            nextToRun = (Runnable)waitQueue.poll();
            if (nextToRun == null)
            {
              isThreadScheduled = false;
              stillRunning = false;
              break;
            }
          }
          try
          {
            nextToRun.run();
          }
          catch (RuntimeException e)
          {
            String str = String.valueOf(String.valueOf(nextToRun));SerializingExecutor.log.log(Level.SEVERE, 35 + str.length() + "Exception while executing runnable " + str, e);
          }
        }
      }
      finally
      {
        if (stillRunning) {
          synchronized (internalLock)
          {
            isThreadScheduled = false;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SerializingExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */