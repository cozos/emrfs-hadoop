package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public class NoOpWaiterHandler
  extends WaiterHandler<AmazonWebServiceRequest>
{
  public void onWaitSuccess(AmazonWebServiceRequest request) {}
  
  public void onWaitFailure(Exception e) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.NoOpWaiterHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */