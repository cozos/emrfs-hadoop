package com.amazonaws.services.sqs.buffered;

abstract interface SendQueueBuffer$Listener<T>
{
  public abstract void invoke(T paramT);
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */