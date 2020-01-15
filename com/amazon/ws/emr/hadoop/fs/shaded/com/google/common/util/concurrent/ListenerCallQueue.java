package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Queues;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class ListenerCallQueue<L>
  implements Runnable
{
  private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
  private final L listener;
  private final Executor executor;
  
  static abstract class Callback<L>
  {
    private final String methodCall;
    
    Callback(String methodCall)
    {
      this.methodCall = methodCall;
    }
    
    abstract void call(L paramL);
    
    void enqueueOn(Iterable<ListenerCallQueue<L>> queues)
    {
      for (ListenerCallQueue<L> queue : queues) {
        queue.add(this);
      }
    }
  }
  
  @GuardedBy("this")
  private final Queue<Callback<L>> waitQueue = Queues.newArrayDeque();
  @GuardedBy("this")
  private boolean isThreadScheduled;
  
  ListenerCallQueue(L listener, Executor executor)
  {
    this.listener = Preconditions.checkNotNull(listener);
    this.executor = ((Executor)Preconditions.checkNotNull(executor));
  }
  
  synchronized void add(Callback<L> callback)
  {
    waitQueue.add(callback);
  }
  
  void execute()
  {
    boolean scheduleTaskRunner = false;
    synchronized (this)
    {
      if (!isThreadScheduled)
      {
        isThreadScheduled = true;
        scheduleTaskRunner = true;
      }
    }
    if (scheduleTaskRunner) {
      try
      {
        executor.execute(this);
      }
      catch (RuntimeException e)
      {
        synchronized (this)
        {
          isThreadScheduled = false;
        }
        ??? = String.valueOf(String.valueOf(listener));String str = String.valueOf(String.valueOf(executor));logger.log(Level.SEVERE, 42 + ((String)???).length() + str.length() + "Exception while running callbacks for " + (String)??? + " on " + str, e);
        
        throw e;
      }
    }
  }
  
  public void run()
  {
    boolean stillRunning = true;
    try
    {
      for (;;)
      {
        Callback<L> nextToRun;
        synchronized (this)
        {
          Preconditions.checkState(isThreadScheduled);
          nextToRun = (Callback)waitQueue.poll();
          if (nextToRun == null)
          {
            isThreadScheduled = false;
            stillRunning = false;
            break;
          }
        }
        try
        {
          nextToRun.call(listener);
        }
        catch (RuntimeException e)
        {
          String str1 = String.valueOf(String.valueOf(listener));String str2 = String.valueOf(String.valueOf(methodCall));logger.log(Level.SEVERE, 37 + str1.length() + str2.length() + "Exception while executing callback: " + str1 + "." + str2, e);
        }
      }
    }
    finally
    {
      if (stillRunning) {
        synchronized (this)
        {
          isThreadScheduled = false;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenerCallQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */