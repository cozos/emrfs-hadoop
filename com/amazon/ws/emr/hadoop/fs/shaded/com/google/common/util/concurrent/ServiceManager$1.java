package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class ServiceManager$1
  extends ListenerCallQueue.Callback<ServiceManager.Listener>
{
  ServiceManager$1(String x0)
  {
    super(x0);
  }
  
  void call(ServiceManager.Listener listener)
  {
    listener.healthy();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */