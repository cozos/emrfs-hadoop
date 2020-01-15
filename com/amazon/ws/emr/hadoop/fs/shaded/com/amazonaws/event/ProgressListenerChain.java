package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgressListenerChain
  implements ProgressListener, DeliveryMode
{
  private static final Log log = LogFactory.getLog(ProgressListenerChain.class);
  private final List<ProgressListener> listeners = new CopyOnWriteArrayList();
  private final ProgressEventFilter progressEventFilter;
  private volatile boolean syncCallSafe = true;
  
  public ProgressListenerChain(ProgressListener... listeners)
  {
    this(null, listeners);
  }
  
  public ProgressListenerChain(ProgressEventFilter progressEventFilter, ProgressListener... listeners)
  {
    if (listeners == null) {
      throw new IllegalArgumentException("Progress Listeners cannot be null.");
    }
    for (ProgressListener listener : listeners) {
      addProgressListener(listener);
    }
    this.progressEventFilter = progressEventFilter;
  }
  
  public synchronized void addProgressListener(ProgressListener listener)
  {
    if (listener == null) {
      return;
    }
    if (syncCallSafe) {
      syncCallSafe = DeliveryMode.Check.isSyncCallSafe(listener);
    }
    listeners.add(listener);
  }
  
  public synchronized void removeProgressListener(ProgressListener listener)
  {
    if (listener == null) {
      return;
    }
    listeners.remove(listener);
  }
  
  protected List<ProgressListener> getListeners()
  {
    return listeners;
  }
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    ProgressEvent filteredEvent = progressEvent;
    if (progressEventFilter != null)
    {
      filteredEvent = progressEventFilter.filter(progressEvent);
      if (filteredEvent == null) {
        return;
      }
    }
    for (ProgressListener listener : listeners) {
      try
      {
        listener.progressChanged(filteredEvent);
      }
      catch (RuntimeException e)
      {
        log.warn("Couldn't update progress listener", e);
      }
    }
  }
  
  public boolean isSyncCallSafe()
  {
    return syncCallSafe;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */