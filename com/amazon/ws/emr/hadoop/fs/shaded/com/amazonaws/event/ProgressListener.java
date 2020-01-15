package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public abstract interface ProgressListener
{
  public static final ProgressListener NOOP = new NoOpProgressListener();
  
  public abstract void progressChanged(ProgressEvent paramProgressEvent);
  
  public static class NoOpProgressListener
    implements ProgressListener, DeliveryMode
  {
    public boolean isSyncCallSafe()
    {
      return true;
    }
    
    public void progressChanged(ProgressEvent progressEvent) {}
  }
  
  public static class ExceptionReporter
    implements ProgressListener, DeliveryMode
  {
    private final ProgressListener listener;
    private final boolean syncCallSafe;
    private volatile Throwable cause;
    
    public ExceptionReporter(ProgressListener listener)
    {
      if (listener == null) {
        throw new IllegalArgumentException();
      }
      this.listener = listener;
      if ((listener instanceof DeliveryMode))
      {
        DeliveryMode cs = (DeliveryMode)listener;
        syncCallSafe = cs.isSyncCallSafe();
      }
      else
      {
        syncCallSafe = false;
      }
    }
    
    public void progressChanged(ProgressEvent progressEvent)
    {
      if (cause != null) {
        return;
      }
      try
      {
        listener.progressChanged(progressEvent);
      }
      catch (Throwable t)
      {
        cause = t;
      }
    }
    
    public void throwExceptionIfAny()
    {
      if (cause != null) {
        throw new SdkClientException(cause);
      }
    }
    
    public Throwable getCause()
    {
      return cause;
    }
    
    public static ExceptionReporter wrap(ProgressListener listener)
    {
      return new ExceptionReporter(listener);
    }
    
    public boolean isSyncCallSafe()
    {
      return syncCallSafe;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */