package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multiset;

class ServiceManager$ServiceManagerState$3
  extends Monitor.Guard
{
  ServiceManager$ServiceManagerState$3(ServiceManager.ServiceManagerState paramServiceManagerState, Monitor x0)
  {
    super(x0);
  }
  
  public boolean isSatisfied()
  {
    return this$0.states.count(Service.State.TERMINATED) + this$0.states.count(Service.State.FAILED) == this$0.numberOfServices;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.ServiceManagerState.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */