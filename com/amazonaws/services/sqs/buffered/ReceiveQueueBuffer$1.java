package com.amazonaws.services.sqs.buffered;

class ReceiveQueueBuffer$1
  implements ReceiveQueueBuffer.Predicate<ReceiveQueueBuffer.ReceiveMessageBatchTask>
{
  ReceiveQueueBuffer$1(ReceiveQueueBuffer this$0) {}
  
  public boolean test(ReceiveQueueBuffer.ReceiveMessageBatchTask t)
  {
    return (t.isExpired()) && (t.getException() == null);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */