package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class QueueBufferFuture<Req extends AmazonWebServiceRequest, Res>
  implements Future<Res>
{
  private Res result = null;
  private Exception e = null;
  private boolean done = false;
  private final QueueBufferCallback<Req, Res> callback;
  private QueueBuffer issuingBuffer = null;
  
  public QueueBufferFuture()
  {
    this(null);
  }
  
  public QueueBufferFuture(QueueBufferCallback<Req, Res> cb)
  {
    callback = cb;
  }
  
  public synchronized void setSuccess(Res paramResult)
  {
    if (done) {
      return;
    }
    result = paramResult;
    done = true;
    notifyAll();
    if (callback != null) {
      QueueBuffer.executor.submit(new Callable()
      {
        public Void call()
          throws Exception
        {
          callback.onSuccess(result);
          return null;
        }
      });
    }
  }
  
  public synchronized void setFailure(Exception paramE)
  {
    if (done) {
      return;
    }
    e = paramE;
    done = true;
    notifyAll();
    if (callback != null) {
      QueueBuffer.executor.submit(new Callable()
      {
        public Void call()
          throws Exception
        {
          callback.onError(e);
          return null;
        }
      });
    }
  }
  
  public boolean cancel(boolean arg0)
  {
    return false;
  }
  
  public synchronized void setBuffer(QueueBuffer paramBuffer)
  {
    issuingBuffer = paramBuffer;
  }
  
  public Res get()
    throws InterruptedException, ExecutionException
  {
    for (;;)
    {
      try
      {
        return (Res)get(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
      }
      catch (TimeoutException localTimeoutException) {}
    }
  }
  
  public synchronized Res get(long timeout, TimeUnit tu)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    long waitStartMs = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    long timeoutMs = TimeUnit.MILLISECONDS.convert(timeout, tu);
    long timeToWaitMs = timeoutMs;
    while (!done)
    {
      if (timeToWaitMs <= 0L) {
        throw new TimeoutException("Timed out waiting for results after " + timeout + " " + tu);
      }
      wait(timeToWaitMs);
      
      long nowMs = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
      timeToWaitMs = timeoutMs - (nowMs - waitStartMs);
    }
    if (e != null) {
      throw new ExecutionException(e);
    }
    return (Res)result;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public synchronized boolean isDone()
  {
    return done;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBufferFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */