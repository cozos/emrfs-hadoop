package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpFailureStatusAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpSuccessStatusAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AmazonS3Waiters
{
  private final AmazonS3 client;
  private final ExecutorService executorService = Executors.newFixedThreadPool(50);
  
  @SdkInternalApi
  public AmazonS3Waiters(AmazonS3 client)
  {
    this.client = client;
  }
  
  public Waiter<HeadBucketRequest> bucketNotExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new HeadBucketFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpFailureStatusAcceptor(404, WaiterState.SUCCESS) }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(5))).withExecutorService(executorService).build();
  }
  
  public Waiter<HeadBucketRequest> bucketExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new HeadBucketFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new HttpFailureStatusAcceptor(301, WaiterState.SUCCESS), new HttpFailureStatusAcceptor(403, WaiterState.SUCCESS), new HttpFailureStatusAcceptor(404, WaiterState.RETRY) }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(5))).withExecutorService(executorService).build();
  }
  
  public Waiter<GetObjectMetadataRequest> objectExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new HeadObjectFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new HttpFailureStatusAcceptor(404, WaiterState.RETRY) }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(5))).withExecutorService(executorService).build();
  }
  
  public Waiter<GetObjectMetadataRequest> objectNotExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new HeadObjectFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpFailureStatusAcceptor(404, WaiterState.SUCCESS) }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(5))).withExecutorService(executorService).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters.AmazonS3Waiters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */