package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public enum WaiterState
{
  SUCCESS,  RETRY,  FAILURE;
  
  private WaiterState() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */