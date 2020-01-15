package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonDynamoDBStreamsAsyncClient
  extends AmazonDynamoDBStreamsClient
  implements AmazonDynamoDBStreamsAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonDynamoDBStreamsAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonDynamoDBStreamsAsyncClientBuilder asyncBuilder()
  {
    return AmazonDynamoDBStreamsAsyncClientBuilder.standard();
  }
  
  AmazonDynamoDBStreamsAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest request)
  {
    return describeStreamAsync(request, null);
  }
  
  public Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest request, final AsyncHandler<DescribeStreamRequest, DescribeStreamResult> asyncHandler)
  {
    final DescribeStreamRequest finalRequest = (DescribeStreamRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeStreamResult call()
        throws Exception
      {
        DescribeStreamResult result = null;
        try
        {
          result = executeDescribeStream(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest request)
  {
    return getRecordsAsync(request, null);
  }
  
  public Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest request, final AsyncHandler<GetRecordsRequest, GetRecordsResult> asyncHandler)
  {
    final GetRecordsRequest finalRequest = (GetRecordsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetRecordsResult call()
        throws Exception
      {
        GetRecordsResult result = null;
        try
        {
          result = executeGetRecords(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest request)
  {
    return getShardIteratorAsync(request, null);
  }
  
  public Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest request, final AsyncHandler<GetShardIteratorRequest, GetShardIteratorResult> asyncHandler)
  {
    final GetShardIteratorRequest finalRequest = (GetShardIteratorRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetShardIteratorResult call()
        throws Exception
      {
        GetShardIteratorResult result = null;
        try
        {
          result = executeGetShardIterator(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest request)
  {
    return listStreamsAsync(request, null);
  }
  
  public Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest request, final AsyncHandler<ListStreamsRequest, ListStreamsResult> asyncHandler)
  {
    final ListStreamsRequest finalRequest = (ListStreamsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListStreamsResult call()
        throws Exception
      {
        ListStreamsResult result = null;
        try
        {
          result = executeListStreams(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */