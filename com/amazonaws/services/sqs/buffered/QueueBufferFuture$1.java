package com.amazonaws.services.sqs.buffered;

import java.util.concurrent.Callable;

class QueueBufferFuture$1
  implements Callable<Void>
{
  QueueBufferFuture$1(QueueBufferFuture this$0) {}
  
  public Void call()
    throws Exception
  {
    QueueBufferFuture.access$100(this$0).onSuccess(QueueBufferFuture.access$000(this$0));
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBufferFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */