package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class SendQueueBuffer$OutboundBatchTask<R extends AmazonWebServiceRequest, Result>
  implements Runnable
{
  protected final List<R> requests;
  protected final ArrayList<QueueBufferFuture<R, Result>> futures;
  private boolean closed;
  private volatile SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> onCompleted;
  
  public SendQueueBuffer$OutboundBatchTask(SendQueueBuffer paramSendQueueBuffer)
  {
    requests = new ArrayList(SendQueueBuffer.access$300(paramSendQueueBuffer).getMaxBatchSize());
    futures = new ArrayList(SendQueueBuffer.access$300(paramSendQueueBuffer).getMaxBatchSize());
  }
  
  public void setOnCompleted(SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> value)
  {
    onCompleted = value;
  }
  
  public synchronized QueueBufferFuture<R, Result> addRequest(R request, QueueBufferCallback<R, Result> callback)
  {
    if (closed) {
      return null;
    }
    QueueBufferFuture<R, Result> theFuture = addIfAllowed(request, callback);
    if ((null == theFuture) || (isFull()))
    {
      closed = true;
      notify();
    }
    return theFuture;
  }
  
  private QueueBufferFuture<R, Result> addIfAllowed(R request, QueueBufferCallback<R, Result> callback)
  {
    if (isOkToAdd(request))
    {
      requests.add(request);
      
      QueueBufferFuture<R, Result> theFuture = new QueueBufferFuture(callback);
      
      futures.add(theFuture);
      onRequestAdded(request);
      return theFuture;
    }
    return null;
  }
  
  protected boolean isOkToAdd(R request)
  {
    return requests.size() < SendQueueBuffer.access$300(this$0).getMaxBatchSize();
  }
  
  protected void onRequestAdded(R request) {}
  
  protected boolean isFull()
  {
    return requests.size() >= SendQueueBuffer.access$300(this$0).getMaxBatchSize();
  }
  
  protected abstract void process(List<R> paramList, List<QueueBufferFuture<R, Result>> paramList1);
  
  public final void run()
  {
    try
    {
      long deadlineMs = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS) + SendQueueBuffer.access$300(this$0).getMaxBatchOpenMs() + 1L;
      long t = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
      List<QueueBufferFuture<R, Result>> futures;
      synchronized (this)
      {
        while ((!closed) && (t < deadlineMs))
        {
          t = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
          
          long toWait = Math.max(1L, deadlineMs - t);
          wait(toWait);
        }
        closed = true;
        
        List<R> requests = new ArrayList(this.requests);
        futures = new ArrayList(this.futures);
      }
      List<QueueBufferFuture<R, Result>> futures;
      List<R> requests;
      process(requests, futures);
    }
    catch (InterruptedException e)
    {
      SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
      failAll(e);
    }
    catch (AmazonClientException e)
    {
      SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
      failAll(e);
    }
    catch (RuntimeException e)
    {
      SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
      failAll(e);
      throw e;
    }
    catch (Error e)
    {
      failAll(new AmazonClientException("Error encountered", e));
      throw e;
    }
    finally
    {
      SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener = onCompleted;
      if (listener != null) {
        listener.invoke(this);
      }
    }
  }
  
  private void failAll(Exception e)
  {
    for (QueueBufferFuture<R, Result> f : futures) {
      f.setFailure(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.OutboundBatchTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */