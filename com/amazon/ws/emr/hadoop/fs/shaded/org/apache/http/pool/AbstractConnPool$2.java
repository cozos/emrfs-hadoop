package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.FutureCallback;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class AbstractConnPool$2
  implements Future<E>
{
  private final AtomicBoolean cancelled = new AtomicBoolean(false);
  private final AtomicBoolean done = new AtomicBoolean(false);
  private final AtomicReference<E> entryRef = new AtomicReference(null);
  
  AbstractConnPool$2(AbstractConnPool paramAbstractConnPool, FutureCallback paramFutureCallback, Object paramObject1, Object paramObject2) {}
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    if (cancelled.compareAndSet(false, true))
    {
      done.set(true);
      AbstractConnPool.access$000(this$0).lock();
      try
      {
        AbstractConnPool.access$100(this$0).signalAll();
      }
      finally
      {
        AbstractConnPool.access$000(this$0).unlock();
      }
      if (val$callback != null) {
        val$callback.cancelled();
      }
      return true;
    }
    return false;
  }
  
  public boolean isCancelled()
  {
    return cancelled.get();
  }
  
  public boolean isDone()
  {
    return done.get();
  }
  
  public E get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      return get(0L, TimeUnit.MILLISECONDS);
    }
    catch (TimeoutException ex)
    {
      throw new ExecutionException(ex);
    }
  }
  
  public E get(long timeout, TimeUnit tunit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    E entry = (PoolEntry)entryRef.get();
    if (entry != null) {
      return entry;
    }
    synchronized (this)
    {
      try
      {
        E leasedEntry;
        for (;;)
        {
          leasedEntry = AbstractConnPool.access$200(this$0, val$route, val$state, timeout, tunit, this);
          if ((AbstractConnPool.access$300(this$0) <= 0) || 
            (leasedEntry.getUpdated() + AbstractConnPool.access$300(this$0) > System.currentTimeMillis()) || 
            (this$0.validate(leasedEntry))) {
            break;
          }
          leasedEntry.close();
          this$0.release(leasedEntry, false);
        }
        entryRef.set(leasedEntry);
        done.set(true);
        this$0.onLease(leasedEntry);
        if (val$callback != null) {
          val$callback.completed(leasedEntry);
        }
        return leasedEntry;
      }
      catch (IOException ex)
      {
        done.set(true);
        if (val$callback != null) {
          val$callback.failed(ex);
        }
        throw new ExecutionException(ex);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.AbstractConnPool.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */