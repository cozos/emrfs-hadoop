package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public class HttpSuccessStatusAcceptor<Output>
  extends WaiterAcceptor<Output>
{
  private final WaiterState waiterState;
  
  public HttpSuccessStatusAcceptor(WaiterState waiterState)
  {
    this.waiterState = waiterState;
  }
  
  public boolean matches(Output output)
  {
    return true;
  }
  
  public WaiterState getState()
  {
    return waiterState;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpSuccessStatusAcceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */