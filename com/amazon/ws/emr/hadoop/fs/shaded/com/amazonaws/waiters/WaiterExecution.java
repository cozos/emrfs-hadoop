package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.List;

@SdkProtectedApi
public class WaiterExecution<Input extends AmazonWebServiceRequest, Output>
{
  private final SdkFunction<Input, Output> sdkFunction;
  private final Input request;
  private final CompositeAcceptor<Output> acceptor;
  private final PollingStrategy pollingStrategy;
  
  public WaiterExecution(WaiterExecutionBuilder<Input, Output> waiterExecutionBuilder)
  {
    sdkFunction = ((SdkFunction)ValidationUtils.assertNotNull(waiterExecutionBuilder.getSdkFunction(), "sdkFunction"));
    request = ((AmazonWebServiceRequest)ValidationUtils.assertNotNull(waiterExecutionBuilder.getRequest(), "request"));
    acceptor = new CompositeAcceptor((List)ValidationUtils.assertNotNull(waiterExecutionBuilder.getAcceptorsList(), "acceptors"));
    pollingStrategy = ((PollingStrategy)ValidationUtils.assertNotNull(waiterExecutionBuilder.getPollingStrategy(), "pollingStrategy"));
  }
  
  public boolean pollResource()
    throws AmazonServiceException, WaiterTimedOutException, WaiterUnrecoverableException
  {
    int retriesAttempted = 0;
    for (;;)
    {
      switch (getCurrentState())
      {
      case SUCCESS: 
        return true;
      case FAILURE: 
        throw new WaiterUnrecoverableException("Resource never entered the desired state as it failed.");
      case RETRY: 
        PollingStrategyContext pollingStrategyContext = new PollingStrategyContext(request, retriesAttempted);
        if (pollingStrategy.getRetryStrategy().shouldRetry(pollingStrategyContext))
        {
          safeCustomDelay(pollingStrategyContext);
          retriesAttempted++;
        }
        else
        {
          throw new WaiterTimedOutException("Reached maximum attempts without transitioning to the desired state");
        }
        break;
      }
    }
  }
  
  private WaiterState getCurrentState()
    throws AmazonServiceException
  {
    try
    {
      return acceptor.accepts(sdkFunction.apply(request));
    }
    catch (AmazonServiceException amazonServiceException)
    {
      return acceptor.accepts(amazonServiceException);
    }
  }
  
  private void safeCustomDelay(PollingStrategyContext pollingStrategyContext)
  {
    try
    {
      pollingStrategy.getDelayStrategy().delayBeforeNextRetry(pollingStrategyContext);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */