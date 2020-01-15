package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public class HttpFailureStatusAcceptor<Output>
  extends WaiterAcceptor<Output>
{
  private final int expectedStatusCode;
  private final WaiterState waiterState;
  
  public HttpFailureStatusAcceptor(int expectedStatusCode, WaiterState waiterState)
  {
    this.expectedStatusCode = expectedStatusCode;
    this.waiterState = waiterState;
  }
  
  public boolean matches(AmazonServiceException ase)
  {
    return expectedStatusCode == ase.getStatusCode();
  }
  
  public WaiterState getState()
  {
    return waiterState;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpFailureStatusAcceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */