package com.amazonaws.services.sqs.buffered;

class ReceiveQueueBuffer$ReceiveMessageFuture$1
  implements Runnable
{
  ReceiveQueueBuffer$ReceiveMessageFuture$1(ReceiveQueueBuffer.ReceiveMessageFuture this$1) {}
  
  public void run()
  {
    this$1.timeout();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.ReceiveMessageFuture.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */