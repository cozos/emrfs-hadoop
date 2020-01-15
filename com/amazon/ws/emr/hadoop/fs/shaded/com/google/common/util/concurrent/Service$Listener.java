package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public abstract class Service$Listener
{
  public void starting() {}
  
  public void running() {}
  
  public void stopping(Service.State from) {}
  
  public void terminated(Service.State from) {}
  
  public void failed(Service.State from, Throwable failure) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Service.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */