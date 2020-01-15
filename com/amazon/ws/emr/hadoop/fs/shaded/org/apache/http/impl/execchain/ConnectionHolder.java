package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionReleaseTrigger;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Contract(threading=ThreadingBehavior.SAFE)
class ConnectionHolder
  implements ConnectionReleaseTrigger, Cancellable, Closeable
{
  private final Log log;
  private final HttpClientConnectionManager manager;
  private final HttpClientConnection managedConn;
  private final AtomicBoolean released;
  private volatile boolean reusable;
  private volatile Object state;
  private volatile long validDuration;
  private volatile TimeUnit tunit;
  
  public ConnectionHolder(Log log, HttpClientConnectionManager manager, HttpClientConnection managedConn)
  {
    this.log = log;
    this.manager = manager;
    this.managedConn = managedConn;
    released = new AtomicBoolean(false);
  }
  
  public boolean isReusable()
  {
    return reusable;
  }
  
  public void markReusable()
  {
    reusable = true;
  }
  
  public void markNonReusable()
  {
    reusable = false;
  }
  
  public void setState(Object state)
  {
    this.state = state;
  }
  
  public void setValidFor(long duration, TimeUnit tunit)
  {
    synchronized (managedConn)
    {
      validDuration = duration;
      this.tunit = tunit;
    }
  }
  
  private void releaseConnection(boolean reusable)
  {
    if (released.compareAndSet(false, true)) {
      synchronized (managedConn)
      {
        if (reusable) {
          manager.releaseConnection(managedConn, state, validDuration, tunit);
        } else {
          try
          {
            managedConn.close();
            log.debug("Connection discarded");
          }
          catch (IOException ex)
          {
            if (log.isDebugEnabled()) {
              log.debug(ex.getMessage(), ex);
            }
          }
          finally
          {
            manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
          }
        }
      }
    }
  }
  
  public void releaseConnection()
  {
    releaseConnection(reusable);
  }
  
  public void abortConnection()
  {
    if (released.compareAndSet(false, true)) {
      synchronized (managedConn)
      {
        try
        {
          managedConn.shutdown();
          log.debug("Connection discarded");
        }
        catch (IOException ex)
        {
          if (log.isDebugEnabled()) {
            log.debug(ex.getMessage(), ex);
          }
        }
        finally
        {
          manager.releaseConnection(managedConn, null, 0L, TimeUnit.MILLISECONDS);
        }
      }
    }
  }
  
  public boolean cancel()
  {
    boolean alreadyReleased = released.get();
    log.debug("Cancelling request execution");
    abortConnection();
    return !alreadyReleased;
  }
  
  public boolean isReleased()
  {
    return released.get();
  }
  
  public void close()
    throws IOException
  {
    releaseConnection(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.ConnectionHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */