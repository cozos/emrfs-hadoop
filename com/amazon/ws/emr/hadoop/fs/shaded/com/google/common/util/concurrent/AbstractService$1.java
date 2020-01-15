package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class AbstractService$1
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$1(String x0)
  {
    super(x0);
  }
  
  void call(Service.Listener listener)
  {
    listener.starting();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */