package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecutorServiceFactory;
import java.util.concurrent.ExecutorService;

public class AmazonCloudWatchWaiters
{
  private final AmazonCloudWatch client;
  private final ExecutorService executorService = WaiterExecutorServiceFactory.buildExecutorServiceForWaiter("AmazonCloudWatchWaiters");
  
  @SdkInternalApi
  public AmazonCloudWatchWaiters(AmazonCloudWatch client)
  {
    this.client = client;
  }
  
  public Waiter<DescribeAlarmsRequest> alarmExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeAlarmsFunction(client)).withAcceptors(new WaiterAcceptor[] { new AlarmExists.IsTrueMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(40), new FixedDelayStrategy(5))).withExecutorService(executorService).build();
  }
  
  public void shutdown()
  {
    executorService.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters.AmazonCloudWatchWaiters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */