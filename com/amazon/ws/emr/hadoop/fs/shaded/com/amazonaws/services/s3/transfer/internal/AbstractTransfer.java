package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.LegacyS3ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class AbstractTransfer
  implements Transfer
{
  protected volatile Transfer.TransferState state = Transfer.TransferState.Waiting;
  protected TransferMonitor monitor;
  private final TransferProgress transferProgress;
  private final String description;
  protected final ProgressListenerChain listenerChain;
  protected final Collection<TransferStateChangeListener> stateChangeListeners = new LinkedList();
  
  AbstractTransfer(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain)
  {
    this(description, transferProgress, progressListenerChain, null);
  }
  
  AbstractTransfer(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, TransferStateChangeListener stateChangeListener)
  {
    this.description = description;
    listenerChain = progressListenerChain;
    this.transferProgress = transferProgress;
    addStateChangeListener(stateChangeListener);
  }
  
  public final synchronized boolean isDone()
  {
    return (state == Transfer.TransferState.Failed) || (state == Transfer.TransferState.Completed) || (state == Transfer.TransferState.Canceled);
  }
  
  public void waitForCompletion()
    throws AmazonClientException, AmazonServiceException, InterruptedException
  {
    try
    {
      Object result = null;
      while ((!monitor.isDone()) || (result == null))
      {
        Future<?> f = monitor.getFuture();
        result = f.get();
      }
    }
    catch (ExecutionException e)
    {
      rethrowExecutionException(e);
    }
  }
  
  public AmazonClientException waitForException()
    throws InterruptedException
  {
    try
    {
      while (!monitor.isDone()) {
        monitor.getFuture().get();
      }
      monitor.getFuture().get();
      return null;
    }
    catch (ExecutionException e)
    {
      return unwrapExecutionException(e);
    }
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public synchronized Transfer.TransferState getState()
  {
    return state;
  }
  
  public void setState(Transfer.TransferState state)
  {
    synchronized (this)
    {
      this.state = state;
    }
    for (??? = stateChangeListeners.iterator(); ((Iterator)???).hasNext();)
    {
      TransferStateChangeListener listener = (TransferStateChangeListener)((Iterator)???).next();
      listener.transferStateChanged(this, state);
    }
  }
  
  public void notifyStateChangeListeners(Transfer.TransferState state)
  {
    for (TransferStateChangeListener listener : stateChangeListeners) {
      listener.transferStateChanged(this, state);
    }
  }
  
  public synchronized void addProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener listener)
  {
    listenerChain.addProgressListener(listener);
  }
  
  public synchronized void removeProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener listener)
  {
    listenerChain.removeProgressListener(listener);
  }
  
  @Deprecated
  public synchronized void addProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ProgressListener listener)
  {
    listenerChain.addProgressListener(new LegacyS3ProgressListener(listener));
  }
  
  @Deprecated
  public synchronized void removeProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ProgressListener listener)
  {
    listenerChain.removeProgressListener(new LegacyS3ProgressListener(listener));
  }
  
  public synchronized void addStateChangeListener(TransferStateChangeListener listener)
  {
    if (listener != null) {
      stateChangeListeners.add(listener);
    }
  }
  
  public synchronized void removeStateChangeListener(TransferStateChangeListener listener)
  {
    if (listener != null) {
      stateChangeListeners.remove(listener);
    }
  }
  
  public TransferProgress getProgress()
  {
    return transferProgress;
  }
  
  public void setMonitor(TransferMonitor monitor)
  {
    this.monitor = monitor;
  }
  
  public TransferMonitor getMonitor()
  {
    return monitor;
  }
  
  protected void fireProgressEvent(ProgressEventType eventType)
  {
    SDKProgressPublisher.publishProgress(listenerChain, eventType);
  }
  
  protected void rethrowExecutionException(ExecutionException e)
  {
    throw unwrapExecutionException(e);
  }
  
  protected AmazonClientException unwrapExecutionException(ExecutionException e)
  {
    Throwable t = e;
    while ((t.getCause() != null) && ((t instanceof ExecutionException))) {
      t = t.getCause();
    }
    if ((t instanceof AmazonClientException)) {
      return (AmazonClientException)t;
    }
    return new AmazonClientException("Unable to complete transfer: " + t.getMessage(), t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.AbstractTransfer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */