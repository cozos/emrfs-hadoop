package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.CloneUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionReleaseTrigger;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.AbstractHttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.HeaderGroup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractExecutionAwareRequest
  extends AbstractHttpMessage
  implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest
{
  private final AtomicBoolean aborted;
  private final AtomicReference<Cancellable> cancellableRef;
  
  protected AbstractExecutionAwareRequest()
  {
    aborted = new AtomicBoolean(false);
    cancellableRef = new AtomicReference(null);
  }
  
  @Deprecated
  public void setConnectionRequest(final ClientConnectionRequest connRequest)
  {
    setCancellable(new Cancellable()
    {
      public boolean cancel()
      {
        connRequest.abortRequest();
        return true;
      }
    });
  }
  
  @Deprecated
  public void setReleaseTrigger(final ConnectionReleaseTrigger releaseTrigger)
  {
    setCancellable(new Cancellable()
    {
      public boolean cancel()
      {
        try
        {
          releaseTrigger.abortConnection();
          return true;
        }
        catch (IOException ex) {}
        return false;
      }
    });
  }
  
  public void abort()
  {
    if (aborted.compareAndSet(false, true))
    {
      Cancellable cancellable = (Cancellable)cancellableRef.getAndSet(null);
      if (cancellable != null) {
        cancellable.cancel();
      }
    }
  }
  
  public boolean isAborted()
  {
    return aborted.get();
  }
  
  public void setCancellable(Cancellable cancellable)
  {
    if (!aborted.get()) {
      cancellableRef.set(cancellable);
    }
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    AbstractExecutionAwareRequest clone = (AbstractExecutionAwareRequest)super.clone();
    headergroup = ((HeaderGroup)CloneUtils.cloneObject(headergroup));
    params = ((HttpParams)CloneUtils.cloneObject(params));
    return clone;
  }
  
  public void completed()
  {
    cancellableRef.set(null);
  }
  
  public void reset()
  {
    Cancellable cancellable = (Cancellable)cancellableRef.getAndSet(null);
    if (cancellable != null) {
      cancellable.cancel();
    }
    aborted.set(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.AbstractExecutionAwareRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */