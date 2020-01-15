package com.amazonaws.services.sqs.buffered;

import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ReceiveQueueBuffer$ReceiveMessageFuture
  extends QueueBufferFuture<ReceiveMessageRequest, ReceiveMessageResult>
{
  private int requestedSize;
  private final long waitTimeDeadlineNano;
  private volatile Future<?> timeoutFuture;
  
  ReceiveQueueBuffer$ReceiveMessageFuture(QueueBufferCallback<ReceiveMessageRequest, ReceiveMessageResult> arg1, int cb, long paramSize)
  {
    super(cb);
    requestedSize = paramSize;
    waitTimeDeadlineNano = (System.nanoTime() + TimeUnit.NANOSECONDS.convert(waitTimeMs, TimeUnit.MILLISECONDS));
  }
  
  public void startWaitTimer()
  {
    if ((isDone()) || (timeoutFuture != null)) {
      return;
    }
    long remaining = waitTimeDeadlineNano - System.nanoTime();
    if (remaining <= 0L)
    {
      timeout();
    }
    else
    {
      Runnable timeoutRunnable = new Runnable()
      {
        public void run()
        {
          timeout();
        }
      };
      timeoutFuture = ReceiveQueueBuffer.access$000(this$0).schedule(timeoutRunnable, remaining, TimeUnit.NANOSECONDS);
    }
  }
  
  public boolean isExpired()
  {
    return System.nanoTime() > waitTimeDeadlineNano;
  }
  
  public synchronized void setSuccess(ReceiveMessageResult result)
  {
    cancelTimeout();
    super.setSuccess(result);
  }
  
  public synchronized void setFailure(Exception exception)
  {
    cancelTimeout();
    super.setFailure(exception);
  }
  
  public void timeout()
  {
    synchronized (ReceiveQueueBuffer.access$100(this$0))
    {
      synchronized (this)
      {
        if (!isDone())
        {
          setSuccess(new ReceiveMessageResult());
          ReceiveQueueBuffer.access$100(this$0).remove(this);
        }
      }
    }
  }
  
  public int getRequestedSize()
  {
    return requestedSize;
  }
  
  private synchronized void cancelTimeout()
  {
    if (timeoutFuture != null) {
      timeoutFuture.cancel(false);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.ReceiveMessageFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */