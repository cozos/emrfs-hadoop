package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecutorServiceFactory;
import java.util.concurrent.ExecutorService;

public class AmazonElasticMapReduceWaiters
{
  private final AmazonElasticMapReduce client;
  private final ExecutorService executorService = WaiterExecutorServiceFactory.buildExecutorServiceForWaiter("AmazonElasticMapReduceWaiters");
  
  @SdkInternalApi
  public AmazonElasticMapReduceWaiters(AmazonElasticMapReduce client)
  {
    this.client = client;
  }
  
  public Waiter<DescribeClusterRequest> clusterRunning()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeClusterFunction(client)).withAcceptors(new WaiterAcceptor[] { new ClusterRunning.IsRUNNINGMatcher(), new ClusterRunning.IsWAITINGMatcher(), new ClusterRunning.IsTERMINATINGMatcher(), new ClusterRunning.IsTERMINATEDMatcher(), new ClusterRunning.IsTERMINATED_WITH_ERRORSMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(60), new FixedDelayStrategy(30))).withExecutorService(executorService).build();
  }
  
  public Waiter<DescribeStepRequest> stepComplete()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeStepFunction(client)).withAcceptors(new WaiterAcceptor[] { new StepComplete.IsCOMPLETEDMatcher(), new StepComplete.IsFAILEDMatcher(), new StepComplete.IsCANCELLEDMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(60), new FixedDelayStrategy(30))).withExecutorService(executorService).build();
  }
  
  public Waiter<DescribeClusterRequest> clusterTerminated()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new DescribeClusterFunction(client)).withAcceptors(new WaiterAcceptor[] { new ClusterTerminated.IsTERMINATEDMatcher(), new ClusterTerminated.IsTERMINATED_WITH_ERRORSMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(60), new FixedDelayStrategy(30))).withExecutorService(executorService).build();
  }
  
  public void shutdown()
  {
    executorService.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.AmazonElasticMapReduceWaiters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */