package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmrFSFutureCallback<T>
  implements FutureCallback<T>
{
  private static final Logger LOG = LoggerFactory.getLogger(EmrFSFutureCallback.class);
  private List<ListenableFuture<T>> listenableFutures;
  private boolean cancelFuturesOnFailure;
  private AtomicBoolean cancelled;
  
  public EmrFSFutureCallback(boolean cancelFuturesOnFailure)
  {
    cancelled = new AtomicBoolean(false);
    this.cancelFuturesOnFailure = cancelFuturesOnFailure;
    listenableFutures = Collections.synchronizedList(new ArrayList());
  }
  
  public boolean isCancelled()
  {
    return cancelled.get();
  }
  
  public void registerFuture(ListenableFuture<T> future)
  {
    if (isCancelled()) {
      future.cancel(true);
    }
    listenableFutures.add(future);
    Futures.addCallback(future, this);
  }
  
  public void ensureFuturesComplete()
    throws RuntimeException
  {
    getResults();
  }
  
  public List<T> getResults()
    throws RuntimeException
  {
    RuntimeException re = null;
    List<T> results = new ArrayList(listenableFutures.size());
    for (ListenableFuture<T> listenableFuture : listenableFutures) {
      try
      {
        T r = listenableFuture.get();
        results.add(r);
      }
      catch (InterruptedException|ExecutionException|CancellationException exception)
      {
        if ((exception instanceof InterruptedException | exception.getCause() instanceof InterruptedException)) {
          throw new RuntimeException(exception);
        }
        if (re == null) {
          re = new RuntimeException(exception);
        }
      }
    }
    if (re != null) {
      throw re;
    }
    return results;
  }
  
  public void onSuccess(T obj) {}
  
  public synchronized void onFailure(Throwable t)
  {
    if (((cancelFuturesOnFailure) || ((t instanceof InterruptedException))) && (cancelled.compareAndSet(false, true)))
    {
      LOG.debug("Cancel all futures");
      cancelFutures();
    }
  }
  
  private void cancelFutures()
  {
    for (ListenableFuture<T> listenableFuture : listenableFutures) {
      listenableFuture.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFSFutureCallback
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */