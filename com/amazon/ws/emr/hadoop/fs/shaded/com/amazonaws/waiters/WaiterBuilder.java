package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SdkProtectedApi
public class WaiterBuilder<Input extends AmazonWebServiceRequest, Output>
{
  private SdkFunction<Input, Output> sdkFunction;
  private List<WaiterAcceptor<Output>> acceptors = new ArrayList();
  private PollingStrategy defaultPollingStrategy;
  private ExecutorService executorService;
  
  public WaiterBuilder<Input, Output> withSdkFunction(SdkFunction<Input, Output> sdkFunction)
  {
    this.sdkFunction = sdkFunction;
    return this;
  }
  
  public WaiterBuilder<Input, Output> withAcceptors(WaiterAcceptor<Output>... acceptors)
  {
    Collections.addAll(this.acceptors, acceptors);
    return this;
  }
  
  public WaiterBuilder<Input, Output> withDefaultPollingStrategy(PollingStrategy pollingStrategy)
  {
    defaultPollingStrategy = pollingStrategy;
    return this;
  }
  
  public WaiterBuilder<Input, Output> withExecutorService(ExecutorService executorService)
  {
    this.executorService = executorService;
    return this;
  }
  
  public List<WaiterAcceptor<Output>> getAcceptor()
  {
    return acceptors;
  }
  
  public SdkFunction<Input, Output> getSdkFunction()
  {
    return sdkFunction;
  }
  
  PollingStrategy getDefaultPollingStrategy()
  {
    return defaultPollingStrategy;
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Waiter<Input> build()
  {
    return new WaiterImpl(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */