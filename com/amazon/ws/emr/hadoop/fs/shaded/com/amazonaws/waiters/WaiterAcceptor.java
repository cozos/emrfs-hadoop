package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract class WaiterAcceptor<Output>
{
  public boolean matches(Output output)
  {
    return false;
  }
  
  public boolean matches(AmazonServiceException output)
  {
    return false;
  }
  
  public abstract WaiterState getState();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */