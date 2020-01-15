package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@SdkProtectedApi
public class WaiterImpl<Input extends AmazonWebServiceRequest, Output>
  implements Waiter<Input>
{
  private final SdkFunction<Input, Output> sdkFunction;
  private final List<WaiterAcceptor<Output>> acceptors;
  private final PollingStrategy defaultPollingStrategy;
  private final ExecutorService executorService;
  
  @SdkProtectedApi
  public WaiterImpl(WaiterBuilder<Input, Output> waiterBuilder)
  {
    sdkFunction = ((SdkFunction)ValidationUtils.assertNotNull(waiterBuilder.getSdkFunction(), "sdkFunction"));
    acceptors = ((List)ValidationUtils.assertNotNull(waiterBuilder.getAcceptor(), "acceptors"));
    defaultPollingStrategy = ((PollingStrategy)ValidationUtils.assertNotNull(waiterBuilder.getDefaultPollingStrategy(), "defaultPollingStrategy"));
    executorService = ((ExecutorService)ValidationUtils.assertNotNull(waiterBuilder.getExecutorService(), "executorService"));
  }
  
  public void run(WaiterParameters<Input> waiterParameters)
    throws AmazonServiceException, WaiterTimedOutException, WaiterUnrecoverableException
  {
    ValidationUtils.assertNotNull(waiterParameters, "waiterParameters");
    
    Input request = ((AmazonWebServiceRequest)ValidationUtils.assertNotNull(waiterParameters.getRequest(), "request")).clone();
    request.getRequestClientOptions().appendUserAgent("waiter-request");
    
    WaiterExecution<Input, Output> waiterExecution = new WaiterExecutionBuilder().withRequest(request).withPollingStrategy(waiterParameters.getPollingStrategy() != null ? waiterParameters.getPollingStrategy() : defaultPollingStrategy).withAcceptors(acceptors).withSdkFunction(sdkFunction).build();
    
    waiterExecution.pollResource();
  }
  
  public Future<Void> runAsync(final WaiterParameters<Input> waiterParameters, final WaiterHandler callback)
    throws AmazonServiceException, WaiterTimedOutException, WaiterUnrecoverableException
  {
    executorService.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        try
        {
          run(waiterParameters);
          callback.onWaitSuccess(waiterParameters.getRequest());
        }
        catch (Exception ex)
        {
          callback.onWaitFailure(ex);
          
          throw ex;
        }
        return null;
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */