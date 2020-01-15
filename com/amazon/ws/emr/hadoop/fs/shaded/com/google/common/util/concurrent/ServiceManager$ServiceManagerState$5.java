package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class ServiceManager$ServiceManagerState$5
  extends ListenerCallQueue.Callback<ServiceManager.Listener>
{
  ServiceManager$ServiceManagerState$5(ServiceManager.ServiceManagerState paramServiceManagerState, String x0, Service paramService)
  {
    super(x0);
  }
  
  void call(ServiceManager.Listener listener)
  {
    listener.failure(val$service);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.ServiceManagerState.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */