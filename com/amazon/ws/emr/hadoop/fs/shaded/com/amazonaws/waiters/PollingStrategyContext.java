package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public class PollingStrategyContext
{
  private final AmazonWebServiceRequest originalRequest;
  private final int retriesAttempted;
  
  PollingStrategyContext(AmazonWebServiceRequest originalRequest, int retriesAttempted)
  {
    this.originalRequest = originalRequest;
    this.retriesAttempted = retriesAttempted;
  }
  
  public AmazonWebServiceRequest getOriginalRequest()
  {
    return originalRequest;
  }
  
  public int getRetriesAttempted()
  {
    return retriesAttempted;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategyContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */