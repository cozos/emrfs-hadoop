package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;

public abstract interface HttpExecutionAware
{
  public abstract boolean isAborted();
  
  public abstract void setCancellable(Cancellable paramCancellable);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */