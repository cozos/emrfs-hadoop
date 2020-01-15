package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class AbstractService$2
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$2(String x0)
  {
    super(x0);
  }
  
  void call(Service.Listener listener)
  {
    listener.running();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */