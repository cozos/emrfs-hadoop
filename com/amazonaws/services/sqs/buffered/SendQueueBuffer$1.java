package com.amazonaws.services.sqs.buffered;

import java.util.concurrent.Semaphore;

class SendQueueBuffer$1
  implements SendQueueBuffer.Listener<SendQueueBuffer.OutboundBatchTask<R, Result>>
{
  SendQueueBuffer$1(SendQueueBuffer this$0, Semaphore paramSemaphore) {}
  
  public void invoke(SendQueueBuffer.OutboundBatchTask<R, Result> task)
  {
    val$inflightOperationBatches.release();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */