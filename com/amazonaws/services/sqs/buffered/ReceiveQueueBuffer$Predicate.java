package com.amazonaws.services.sqs.buffered;

abstract interface ReceiveQueueBuffer$Predicate<T>
{
  public abstract boolean test(T paramT);
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.Predicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */