package com.amazonaws.services.sqs.buffered;

class ReceiveQueueBuffer$2
  implements ReceiveQueueBuffer.Predicate<ReceiveQueueBuffer.ReceiveMessageBatchTask>
{
  ReceiveQueueBuffer$2(ReceiveQueueBuffer this$0) {}
  
  public boolean test(ReceiveQueueBuffer.ReceiveMessageBatchTask t)
  {
    return (t.isEmpty()) && (t.getException() == null);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */