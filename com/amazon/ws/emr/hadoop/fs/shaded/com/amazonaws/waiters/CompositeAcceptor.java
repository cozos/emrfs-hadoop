package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.List;

@SdkInternalApi
class CompositeAcceptor<Output>
{
  private List<WaiterAcceptor<Output>> acceptors = new ArrayList();
  
  public CompositeAcceptor(List<WaiterAcceptor<Output>> acceptors)
  {
    this.acceptors = ((List)ValidationUtils.assertNotEmpty(acceptors, "acceptors"));
  }
  
  public List<WaiterAcceptor<Output>> getAcceptors()
  {
    return acceptors;
  }
  
  public WaiterState accepts(Output response)
  {
    for (WaiterAcceptor<Output> acceptor : acceptors) {
      if (acceptor.matches(response)) {
        return acceptor.getState();
      }
    }
    return WaiterState.RETRY;
  }
  
  public WaiterState accepts(AmazonServiceException exception)
    throws AmazonServiceException
  {
    for (WaiterAcceptor<Output> acceptor : acceptors) {
      if (acceptor.matches(exception)) {
        return acceptor.getState();
      }
    }
    throw exception;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.CompositeAcceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */