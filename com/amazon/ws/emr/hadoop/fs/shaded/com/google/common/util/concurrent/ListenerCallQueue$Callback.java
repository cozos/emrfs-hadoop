package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

abstract class ListenerCallQueue$Callback<L>
{
  private final String methodCall;
  
  ListenerCallQueue$Callback(String methodCall)
  {
    this.methodCall = methodCall;
  }
  
  abstract void call(L paramL);
  
  void enqueueOn(Iterable<ListenerCallQueue<L>> queues)
  {
    for (ListenerCallQueue<L> queue : queues) {
      queue.add(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenerCallQueue.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */