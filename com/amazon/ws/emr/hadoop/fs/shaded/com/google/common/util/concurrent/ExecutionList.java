package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class ExecutionList
{
  @VisibleForTesting
  static final Logger log = Logger.getLogger(ExecutionList.class.getName());
  @GuardedBy("this")
  private RunnableExecutorPair runnables;
  @GuardedBy("this")
  private boolean executed;
  
  public void add(Runnable runnable, Executor executor)
  {
    Preconditions.checkNotNull(runnable, "Runnable was null.");
    Preconditions.checkNotNull(executor, "Executor was null.");
    synchronized (this)
    {
      if (!executed)
      {
        runnables = new RunnableExecutorPair(runnable, executor, runnables);
        return;
      }
    }
    executeListener(runnable, executor);
  }
  
  public void execute()
  {
    RunnableExecutorPair list;
    synchronized (this)
    {
      if (executed) {
        return;
      }
      executed = true;
      list = runnables;
      runnables = null;
    }
    RunnableExecutorPair reversedList = null;
    while (list != null)
    {
      RunnableExecutorPair tmp = list;
      list = next;
      next = reversedList;
      reversedList = tmp;
    }
    while (reversedList != null)
    {
      executeListener(runnable, executor);
      reversedList = next;
    }
  }
  
  private static void executeListener(Runnable runnable, Executor executor)
  {
    try
    {
      executor.execute(runnable);
    }
    catch (RuntimeException e)
    {
      String str1 = String.valueOf(String.valueOf(runnable));String str2 = String.valueOf(String.valueOf(executor));log.log(Level.SEVERE, 57 + str1.length() + str2.length() + "RuntimeException while executing runnable " + str1 + " with executor " + str2, e);
    }
  }
  
  private static final class RunnableExecutorPair
  {
    final Runnable runnable;
    final Executor executor;
    @Nullable
    RunnableExecutorPair next;
    
    RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair next)
    {
      this.runnable = runnable;
      this.executor = executor;
      this.next = next;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ExecutionList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */