package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecutorServiceFactory;
import java.util.concurrent.ExecutorService;

public class AmazonDynamoDBWaiters
{
  private final AmazonDynamoDB client;
  private final ExecutorService executorService = WaiterExecutorServiceFactory.buildExecutorServiceForWaiter("AmazonDynamoDBWaiters");
  
  @SdkInternalApi
  public AmazonDynamoDBWaiters(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public Waiter<DescribeTableRequest> tableExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeTableFunction(client)).withAcceptors(new WaiterAcceptor[] { new TableExists.IsACTIVEMatcher(), new TableExists.IsResourceNotFoundExceptionMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(25), new FixedDelayStrategy(20))).withExecutorService(executorService).build();
  }
  
  public Waiter<DescribeTableRequest> tableNotExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeTableFunction(client)).withAcceptors(new WaiterAcceptor[] { new TableNotExists.IsResourceNotFoundExceptionMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(25), new FixedDelayStrategy(20))).withExecutorService(executorService).build();
  }
  
  public void shutdown()
  {
    executorService.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.AmazonDynamoDBWaiters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */