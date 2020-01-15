package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public abstract class ServiceManager$Listener
{
  public void healthy() {}
  
  public void stopped() {}
  
  public void failure(Service service) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */