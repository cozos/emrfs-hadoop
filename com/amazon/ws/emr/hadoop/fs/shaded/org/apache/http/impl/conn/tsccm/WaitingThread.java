package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class WaitingThread
{
  private final Condition cond;
  private final RouteSpecificPool pool;
  private Thread waiter;
  private boolean aborted;
  
  public WaitingThread(Condition cond, RouteSpecificPool pool)
  {
    Args.notNull(cond, "Condition");
    
    this.cond = cond;
    this.pool = pool;
  }
  
  public final Condition getCondition()
  {
    return cond;
  }
  
  public final RouteSpecificPool getPool()
  {
    return pool;
  }
  
  public final Thread getThread()
  {
    return waiter;
  }
  
  public boolean await(Date deadline)
    throws InterruptedException
  {
    if (waiter != null) {
      throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + waiter);
    }
    if (aborted) {
      throw new InterruptedException("Operation interrupted");
    }
    waiter = Thread.currentThread();
    
    boolean success = false;
    try
    {
      if (deadline != null)
      {
        success = cond.awaitUntil(deadline);
      }
      else
      {
        cond.await();
        success = true;
      }
      if (aborted) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      waiter = null;
    }
    return success;
  }
  
  public void wakeup()
  {
    if (waiter == null) {
      throw new IllegalStateException("Nobody waiting on this object.");
    }
    cond.signalAll();
  }
  
  public void interrupt()
  {
    aborted = true;
    cond.signalAll();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.WaitingThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */