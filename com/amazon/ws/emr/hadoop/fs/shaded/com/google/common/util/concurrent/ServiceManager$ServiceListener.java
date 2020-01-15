package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ServiceManager$ServiceListener
  extends Service.Listener
{
  final Service service;
  final WeakReference<ServiceManager.ServiceManagerState> state;
  
  ServiceManager$ServiceListener(Service service, WeakReference<ServiceManager.ServiceManagerState> state)
  {
    this.service = service;
    this.state = state;
  }
  
  public void starting()
  {
    ServiceManager.ServiceManagerState state = (ServiceManager.ServiceManagerState)this.state.get();
    if (state != null)
    {
      state.transitionService(service, Service.State.NEW, Service.State.STARTING);
      if (!(service instanceof ServiceManager.NoOpService)) {
        ServiceManager.access$200().log(Level.FINE, "Starting {0}.", service);
      }
    }
  }
  
  public void running()
  {
    ServiceManager.ServiceManagerState state = (ServiceManager.ServiceManagerState)this.state.get();
    if (state != null) {
      state.transitionService(service, Service.State.STARTING, Service.State.RUNNING);
    }
  }
  
  public void stopping(Service.State from)
  {
    ServiceManager.ServiceManagerState state = (ServiceManager.ServiceManagerState)this.state.get();
    if (state != null) {
      state.transitionService(service, from, Service.State.STOPPING);
    }
  }
  
  public void terminated(Service.State from)
  {
    ServiceManager.ServiceManagerState state = (ServiceManager.ServiceManagerState)this.state.get();
    if (state != null)
    {
      if (!(service instanceof ServiceManager.NoOpService)) {
        ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { service, from });
      }
      state.transitionService(service, from, Service.State.TERMINATED);
    }
  }
  
  public void failed(Service.State from, Throwable failure)
  {
    ServiceManager.ServiceManagerState state = (ServiceManager.ServiceManagerState)this.state.get();
    if (state != null)
    {
      if (!(service instanceof ServiceManager.NoOpService))
      {
        String str1 = String.valueOf(String.valueOf(service));String str2 = String.valueOf(String.valueOf(from));ServiceManager.access$200().log(Level.SEVERE, 34 + str1.length() + str2.length() + "Service " + str1 + " has failed in the " + str2 + " state.", failure);
      }
      state.transitionService(service, from, Service.State.FAILED);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.ServiceListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */