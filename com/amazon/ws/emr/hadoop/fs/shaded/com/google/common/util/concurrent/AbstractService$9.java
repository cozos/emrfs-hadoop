package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class AbstractService$9
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$9(AbstractService paramAbstractService, String x0, Service.State paramState, Throwable paramThrowable)
  {
    super(x0);
  }
  
  void call(Service.Listener listener)
  {
    listener.failed(val$from, val$cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */