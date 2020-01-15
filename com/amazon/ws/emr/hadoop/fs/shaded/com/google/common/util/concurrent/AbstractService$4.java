package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class AbstractService$4
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$4(String x0, Service.State paramState)
  {
    super(x0);
  }
  
  void call(Service.Listener listener)
  {
    listener.stopping(val$from);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */