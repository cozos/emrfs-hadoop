package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public final class WaiterParameters<Input extends AmazonWebServiceRequest>
{
  private final Input request;
  private final PollingStrategy pollingStrategy;
  
  public WaiterParameters()
  {
    request = null;
    pollingStrategy = null;
  }
  
  public WaiterParameters(Input request)
  {
    this.request = request;
    pollingStrategy = null;
  }
  
  private WaiterParameters(Input request, PollingStrategy pollingStrategy)
  {
    this.request = request;
    this.pollingStrategy = pollingStrategy;
  }
  
  public WaiterParameters<Input> withRequest(Input request)
  {
    return new WaiterParameters(request, pollingStrategy);
  }
  
  public WaiterParameters<Input> withPollingStrategy(PollingStrategy pollingStrategy)
  {
    return new WaiterParameters(request, pollingStrategy);
  }
  
  public Input getRequest()
  {
    return request;
  }
  
  public PollingStrategy getPollingStrategy()
  {
    return pollingStrategy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */