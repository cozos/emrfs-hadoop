package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.util.concurrent.Future;

public abstract interface Waiter<Input extends AmazonWebServiceRequest>
{
  public abstract void run(WaiterParameters<Input> paramWaiterParameters)
    throws AmazonServiceException, WaiterTimedOutException, WaiterUnrecoverableException;
  
  public abstract Future<Void> runAsync(WaiterParameters<Input> paramWaiterParameters, WaiterHandler paramWaiterHandler)
    throws AmazonServiceException, WaiterTimedOutException, WaiterUnrecoverableException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */