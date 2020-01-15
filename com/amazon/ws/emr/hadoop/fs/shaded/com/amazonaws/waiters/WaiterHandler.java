package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public abstract class WaiterHandler<Input extends AmazonWebServiceRequest>
{
  public abstract void onWaitSuccess(Input paramInput);
  
  public abstract void onWaitFailure(Exception paramException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */