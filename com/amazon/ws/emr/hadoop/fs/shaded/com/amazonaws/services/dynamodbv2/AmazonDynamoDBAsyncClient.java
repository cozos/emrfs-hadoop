package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonDynamoDBAsyncClient
  extends AmazonDynamoDBClient
  implements AmazonDynamoDBAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonDynamoDBAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonDynamoDBAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonDynamoDBAsyncClientBuilder asyncBuilder()
  {
    return AmazonDynamoDBAsyncClientBuilder.standard();
  }
  
  AmazonDynamoDBAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest request)
  {
    return batchGetItemAsync(request, null);
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest request, final AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler)
  {
    final BatchGetItemRequest finalRequest = (BatchGetItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public BatchGetItemResult call()
        throws Exception
      {
        BatchGetItemResult result = null;
        try
        {
          result = executeBatchGetItem(finalRequest);
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
  
  public Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity)
  {
    return batchGetItemAsync(new BatchGetItemRequest().withRequestItems(requestItems).withReturnConsumedCapacity(returnConsumedCapacity));
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler)
  {
    return batchGetItemAsync(new BatchGetItemRequest().withRequestItems(requestItems).withReturnConsumedCapacity(returnConsumedCapacity), asyncHandler);
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> requestItems)
  {
    return batchGetItemAsync(new BatchGetItemRequest().withRequestItems(requestItems));
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> requestItems, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler)
  {
    return batchGetItemAsync(new BatchGetItemRequest().withRequestItems(requestItems), asyncHandler);
  }
  
  public Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest request)
  {
    return batchWriteItemAsync(request, null);
  }
  
  public Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest request, final AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler)
  {
    final BatchWriteItemRequest finalRequest = (BatchWriteItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public BatchWriteItemResult call()
        throws Exception
      {
        BatchWriteItemResult result = null;
        try
        {
          result = executeBatchWriteItem(finalRequest);
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
  
  public Future<BatchWriteItemResult> batchWriteItemAsync(Map<String, List<WriteRequest>> requestItems)
  {
    return batchWriteItemAsync(new BatchWriteItemRequest().withRequestItems(requestItems));
  }
  
  public Future<BatchWriteItemResult> batchWriteItemAsync(Map<String, List<WriteRequest>> requestItems, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler)
  {
    return batchWriteItemAsync(new BatchWriteItemRequest().withRequestItems(requestItems), asyncHandler);
  }
  
  public Future<CreateBackupResult> createBackupAsync(CreateBackupRequest request)
  {
    return createBackupAsync(request, null);
  }
  
  public Future<CreateBackupResult> createBackupAsync(CreateBackupRequest request, final AsyncHandler<CreateBackupRequest, CreateBackupResult> asyncHandler)
  {
    final CreateBackupRequest finalRequest = (CreateBackupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateBackupResult call()
        throws Exception
      {
        CreateBackupResult result = null;
        try
        {
          result = executeCreateBackup(finalRequest);
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
  
  public Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest request)
  {
    return createGlobalTableAsync(request, null);
  }
  
  public Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest request, final AsyncHandler<CreateGlobalTableRequest, CreateGlobalTableResult> asyncHandler)
  {
    final CreateGlobalTableRequest finalRequest = (CreateGlobalTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateGlobalTableResult call()
        throws Exception
      {
        CreateGlobalTableResult result = null;
        try
        {
          result = executeCreateGlobalTable(finalRequest);
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
  
  public Future<CreateTableResult> createTableAsync(CreateTableRequest request)
  {
    return createTableAsync(request, null);
  }
  
  public Future<CreateTableResult> createTableAsync(CreateTableRequest request, final AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler)
  {
    final CreateTableRequest finalRequest = (CreateTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateTableResult call()
        throws Exception
      {
        CreateTableResult result = null;
        try
        {
          result = executeCreateTable(finalRequest);
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
  
  public Future<CreateTableResult> createTableAsync(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput)
  {
    return createTableAsync(new CreateTableRequest().withAttributeDefinitions(attributeDefinitions).withTableName(tableName).withKeySchema(keySchema)
      .withProvisionedThroughput(provisionedThroughput));
  }
  
  public Future<CreateTableResult> createTableAsync(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput, AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler)
  {
    return createTableAsync(new CreateTableRequest().withAttributeDefinitions(attributeDefinitions).withTableName(tableName).withKeySchema(keySchema)
      .withProvisionedThroughput(provisionedThroughput), asyncHandler);
  }
  
  public Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest request)
  {
    return deleteBackupAsync(request, null);
  }
  
  public Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest request, final AsyncHandler<DeleteBackupRequest, DeleteBackupResult> asyncHandler)
  {
    final DeleteBackupRequest finalRequest = (DeleteBackupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteBackupResult call()
        throws Exception
      {
        DeleteBackupResult result = null;
        try
        {
          result = executeDeleteBackup(finalRequest);
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
  
  public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest request)
  {
    return deleteItemAsync(request, null);
  }
  
  public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest request, final AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler)
  {
    final DeleteItemRequest finalRequest = (DeleteItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteItemResult call()
        throws Exception
      {
        DeleteItemResult result = null;
        try
        {
          result = executeDeleteItem(finalRequest);
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
  
  public Future<DeleteItemResult> deleteItemAsync(String tableName, Map<String, AttributeValue> key)
  {
    return deleteItemAsync(new DeleteItemRequest().withTableName(tableName).withKey(key));
  }
  
  public Future<DeleteItemResult> deleteItemAsync(String tableName, Map<String, AttributeValue> key, AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler)
  {
    return deleteItemAsync(new DeleteItemRequest().withTableName(tableName).withKey(key), asyncHandler);
  }
  
  public Future<DeleteItemResult> deleteItemAsync(String tableName, Map<String, AttributeValue> key, String returnValues)
  {
    return deleteItemAsync(new DeleteItemRequest().withTableName(tableName).withKey(key).withReturnValues(returnValues));
  }
  
  public Future<DeleteItemResult> deleteItemAsync(String tableName, Map<String, AttributeValue> key, String returnValues, AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler)
  {
    return deleteItemAsync(new DeleteItemRequest().withTableName(tableName).withKey(key).withReturnValues(returnValues), asyncHandler);
  }
  
  public Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest request)
  {
    return deleteTableAsync(request, null);
  }
  
  public Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest request, final AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler)
  {
    final DeleteTableRequest finalRequest = (DeleteTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteTableResult call()
        throws Exception
      {
        DeleteTableResult result = null;
        try
        {
          result = executeDeleteTable(finalRequest);
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
  
  public Future<DeleteTableResult> deleteTableAsync(String tableName)
  {
    return deleteTableAsync(new DeleteTableRequest().withTableName(tableName));
  }
  
  public Future<DeleteTableResult> deleteTableAsync(String tableName, AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler)
  {
    return deleteTableAsync(new DeleteTableRequest().withTableName(tableName), asyncHandler);
  }
  
  public Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest request)
  {
    return describeBackupAsync(request, null);
  }
  
  public Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest request, final AsyncHandler<DescribeBackupRequest, DescribeBackupResult> asyncHandler)
  {
    final DescribeBackupRequest finalRequest = (DescribeBackupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeBackupResult call()
        throws Exception
      {
        DescribeBackupResult result = null;
        try
        {
          result = executeDescribeBackup(finalRequest);
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
  
  public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest request)
  {
    return describeContinuousBackupsAsync(request, null);
  }
  
  public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest request, final AsyncHandler<DescribeContinuousBackupsRequest, DescribeContinuousBackupsResult> asyncHandler)
  {
    final DescribeContinuousBackupsRequest finalRequest = (DescribeContinuousBackupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeContinuousBackupsResult call()
        throws Exception
      {
        DescribeContinuousBackupsResult result = null;
        try
        {
          result = executeDescribeContinuousBackups(finalRequest);
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
  
  public Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest request)
  {
    return describeEndpointsAsync(request, null);
  }
  
  public Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest request, final AsyncHandler<DescribeEndpointsRequest, DescribeEndpointsResult> asyncHandler)
  {
    final DescribeEndpointsRequest finalRequest = (DescribeEndpointsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeEndpointsResult call()
        throws Exception
      {
        DescribeEndpointsResult result = null;
        try
        {
          result = executeDescribeEndpoints(finalRequest);
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
  
  public Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest request)
  {
    return describeGlobalTableAsync(request, null);
  }
  
  public Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest request, final AsyncHandler<DescribeGlobalTableRequest, DescribeGlobalTableResult> asyncHandler)
  {
    final DescribeGlobalTableRequest finalRequest = (DescribeGlobalTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeGlobalTableResult call()
        throws Exception
      {
        DescribeGlobalTableResult result = null;
        try
        {
          result = executeDescribeGlobalTable(finalRequest);
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
  
  public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest request)
  {
    return describeGlobalTableSettingsAsync(request, null);
  }
  
  public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest request, final AsyncHandler<DescribeGlobalTableSettingsRequest, DescribeGlobalTableSettingsResult> asyncHandler)
  {
    final DescribeGlobalTableSettingsRequest finalRequest = (DescribeGlobalTableSettingsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeGlobalTableSettingsResult call()
        throws Exception
      {
        DescribeGlobalTableSettingsResult result = null;
        try
        {
          result = executeDescribeGlobalTableSettings(finalRequest);
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
  
  public Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest request)
  {
    return describeLimitsAsync(request, null);
  }
  
  public Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest request, final AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> asyncHandler)
  {
    final DescribeLimitsRequest finalRequest = (DescribeLimitsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeLimitsResult call()
        throws Exception
      {
        DescribeLimitsResult result = null;
        try
        {
          result = executeDescribeLimits(finalRequest);
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
  
  public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest request)
  {
    return describeTableAsync(request, null);
  }
  
  public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest request, final AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler)
  {
    final DescribeTableRequest finalRequest = (DescribeTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeTableResult call()
        throws Exception
      {
        DescribeTableResult result = null;
        try
        {
          result = executeDescribeTable(finalRequest);
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
  
  public Future<DescribeTableResult> describeTableAsync(String tableName)
  {
    return describeTableAsync(new DescribeTableRequest().withTableName(tableName));
  }
  
  public Future<DescribeTableResult> describeTableAsync(String tableName, AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler)
  {
    return describeTableAsync(new DescribeTableRequest().withTableName(tableName), asyncHandler);
  }
  
  public Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest request)
  {
    return describeTimeToLiveAsync(request, null);
  }
  
  public Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest request, final AsyncHandler<DescribeTimeToLiveRequest, DescribeTimeToLiveResult> asyncHandler)
  {
    final DescribeTimeToLiveRequest finalRequest = (DescribeTimeToLiveRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeTimeToLiveResult call()
        throws Exception
      {
        DescribeTimeToLiveResult result = null;
        try
        {
          result = executeDescribeTimeToLive(finalRequest);
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
  
  public Future<GetItemResult> getItemAsync(GetItemRequest request)
  {
    return getItemAsync(request, null);
  }
  
  public Future<GetItemResult> getItemAsync(GetItemRequest request, final AsyncHandler<GetItemRequest, GetItemResult> asyncHandler)
  {
    final GetItemRequest finalRequest = (GetItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetItemResult call()
        throws Exception
      {
        GetItemResult result = null;
        try
        {
          result = executeGetItem(finalRequest);
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
  
  public Future<GetItemResult> getItemAsync(String tableName, Map<String, AttributeValue> key)
  {
    return getItemAsync(new GetItemRequest().withTableName(tableName).withKey(key));
  }
  
  public Future<GetItemResult> getItemAsync(String tableName, Map<String, AttributeValue> key, AsyncHandler<GetItemRequest, GetItemResult> asyncHandler)
  {
    return getItemAsync(new GetItemRequest().withTableName(tableName).withKey(key), asyncHandler);
  }
  
  public Future<GetItemResult> getItemAsync(String tableName, Map<String, AttributeValue> key, Boolean consistentRead)
  {
    return getItemAsync(new GetItemRequest().withTableName(tableName).withKey(key).withConsistentRead(consistentRead));
  }
  
  public Future<GetItemResult> getItemAsync(String tableName, Map<String, AttributeValue> key, Boolean consistentRead, AsyncHandler<GetItemRequest, GetItemResult> asyncHandler)
  {
    return getItemAsync(new GetItemRequest().withTableName(tableName).withKey(key).withConsistentRead(consistentRead), asyncHandler);
  }
  
  public Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest request)
  {
    return listBackupsAsync(request, null);
  }
  
  public Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest request, final AsyncHandler<ListBackupsRequest, ListBackupsResult> asyncHandler)
  {
    final ListBackupsRequest finalRequest = (ListBackupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListBackupsResult call()
        throws Exception
      {
        ListBackupsResult result = null;
        try
        {
          result = executeListBackups(finalRequest);
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
  
  public Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest request)
  {
    return listGlobalTablesAsync(request, null);
  }
  
  public Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest request, final AsyncHandler<ListGlobalTablesRequest, ListGlobalTablesResult> asyncHandler)
  {
    final ListGlobalTablesRequest finalRequest = (ListGlobalTablesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListGlobalTablesResult call()
        throws Exception
      {
        ListGlobalTablesResult result = null;
        try
        {
          result = executeListGlobalTables(finalRequest);
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
  
  public Future<ListTablesResult> listTablesAsync(ListTablesRequest request)
  {
    return listTablesAsync(request, null);
  }
  
  public Future<ListTablesResult> listTablesAsync(ListTablesRequest request, final AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    final ListTablesRequest finalRequest = (ListTablesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListTablesResult call()
        throws Exception
      {
        ListTablesResult result = null;
        try
        {
          result = executeListTables(finalRequest);
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
  
  public Future<ListTablesResult> listTablesAsync()
  {
    return listTablesAsync(new ListTablesRequest());
  }
  
  public Future<ListTablesResult> listTablesAsync(AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    return listTablesAsync(new ListTablesRequest(), asyncHandler);
  }
  
  public Future<ListTablesResult> listTablesAsync(String exclusiveStartTableName)
  {
    return listTablesAsync(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName));
  }
  
  public Future<ListTablesResult> listTablesAsync(String exclusiveStartTableName, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    return listTablesAsync(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName), asyncHandler);
  }
  
  public Future<ListTablesResult> listTablesAsync(String exclusiveStartTableName, Integer limit)
  {
    return listTablesAsync(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName).withLimit(limit));
  }
  
  public Future<ListTablesResult> listTablesAsync(String exclusiveStartTableName, Integer limit, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    return listTablesAsync(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName).withLimit(limit), asyncHandler);
  }
  
  public Future<ListTablesResult> listTablesAsync(Integer limit)
  {
    return listTablesAsync(new ListTablesRequest().withLimit(limit));
  }
  
  public Future<ListTablesResult> listTablesAsync(Integer limit, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    return listTablesAsync(new ListTablesRequest().withLimit(limit), asyncHandler);
  }
  
  public Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest request)
  {
    return listTagsOfResourceAsync(request, null);
  }
  
  public Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest request, final AsyncHandler<ListTagsOfResourceRequest, ListTagsOfResourceResult> asyncHandler)
  {
    final ListTagsOfResourceRequest finalRequest = (ListTagsOfResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListTagsOfResourceResult call()
        throws Exception
      {
        ListTagsOfResourceResult result = null;
        try
        {
          result = executeListTagsOfResource(finalRequest);
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
  
  public Future<PutItemResult> putItemAsync(PutItemRequest request)
  {
    return putItemAsync(request, null);
  }
  
  public Future<PutItemResult> putItemAsync(PutItemRequest request, final AsyncHandler<PutItemRequest, PutItemResult> asyncHandler)
  {
    final PutItemRequest finalRequest = (PutItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutItemResult call()
        throws Exception
      {
        PutItemResult result = null;
        try
        {
          result = executePutItem(finalRequest);
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
  
  public Future<PutItemResult> putItemAsync(String tableName, Map<String, AttributeValue> item)
  {
    return putItemAsync(new PutItemRequest().withTableName(tableName).withItem(item));
  }
  
  public Future<PutItemResult> putItemAsync(String tableName, Map<String, AttributeValue> item, AsyncHandler<PutItemRequest, PutItemResult> asyncHandler)
  {
    return putItemAsync(new PutItemRequest().withTableName(tableName).withItem(item), asyncHandler);
  }
  
  public Future<PutItemResult> putItemAsync(String tableName, Map<String, AttributeValue> item, String returnValues)
  {
    return putItemAsync(new PutItemRequest().withTableName(tableName).withItem(item).withReturnValues(returnValues));
  }
  
  public Future<PutItemResult> putItemAsync(String tableName, Map<String, AttributeValue> item, String returnValues, AsyncHandler<PutItemRequest, PutItemResult> asyncHandler)
  {
    return putItemAsync(new PutItemRequest().withTableName(tableName).withItem(item).withReturnValues(returnValues), asyncHandler);
  }
  
  public Future<QueryResult> queryAsync(QueryRequest request)
  {
    return queryAsync(request, null);
  }
  
  public Future<QueryResult> queryAsync(QueryRequest request, final AsyncHandler<QueryRequest, QueryResult> asyncHandler)
  {
    final QueryRequest finalRequest = (QueryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public QueryResult call()
        throws Exception
      {
        QueryResult result = null;
        try
        {
          result = executeQuery(finalRequest);
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
  
  public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest request)
  {
    return restoreTableFromBackupAsync(request, null);
  }
  
  public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest request, final AsyncHandler<RestoreTableFromBackupRequest, RestoreTableFromBackupResult> asyncHandler)
  {
    final RestoreTableFromBackupRequest finalRequest = (RestoreTableFromBackupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RestoreTableFromBackupResult call()
        throws Exception
      {
        RestoreTableFromBackupResult result = null;
        try
        {
          result = executeRestoreTableFromBackup(finalRequest);
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
  
  public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest request)
  {
    return restoreTableToPointInTimeAsync(request, null);
  }
  
  public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest request, final AsyncHandler<RestoreTableToPointInTimeRequest, RestoreTableToPointInTimeResult> asyncHandler)
  {
    final RestoreTableToPointInTimeRequest finalRequest = (RestoreTableToPointInTimeRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RestoreTableToPointInTimeResult call()
        throws Exception
      {
        RestoreTableToPointInTimeResult result = null;
        try
        {
          result = executeRestoreTableToPointInTime(finalRequest);
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
  
  public Future<ScanResult> scanAsync(ScanRequest request)
  {
    return scanAsync(request, null);
  }
  
  public Future<ScanResult> scanAsync(ScanRequest request, final AsyncHandler<ScanRequest, ScanResult> asyncHandler)
  {
    final ScanRequest finalRequest = (ScanRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ScanResult call()
        throws Exception
      {
        ScanResult result = null;
        try
        {
          result = executeScan(finalRequest);
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
  
  public Future<ScanResult> scanAsync(String tableName, List<String> attributesToGet)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet));
  }
  
  public Future<ScanResult> scanAsync(String tableName, List<String> attributesToGet, AsyncHandler<ScanRequest, ScanResult> asyncHandler)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet), asyncHandler);
  }
  
  public Future<ScanResult> scanAsync(String tableName, Map<String, Condition> scanFilter)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withScanFilter(scanFilter));
  }
  
  public Future<ScanResult> scanAsync(String tableName, Map<String, Condition> scanFilter, AsyncHandler<ScanRequest, ScanResult> asyncHandler)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withScanFilter(scanFilter), asyncHandler);
  }
  
  public Future<ScanResult> scanAsync(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet).withScanFilter(scanFilter));
  }
  
  public Future<ScanResult> scanAsync(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter, AsyncHandler<ScanRequest, ScanResult> asyncHandler)
  {
    return scanAsync(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet).withScanFilter(scanFilter), asyncHandler);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request)
  {
    return tagResourceAsync(request, null);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, final AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    final TagResourceRequest finalRequest = (TagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagResourceResult call()
        throws Exception
      {
        TagResourceResult result = null;
        try
        {
          result = executeTagResource(finalRequest);
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
  
  public Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest request)
  {
    return transactGetItemsAsync(request, null);
  }
  
  public Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest request, final AsyncHandler<TransactGetItemsRequest, TransactGetItemsResult> asyncHandler)
  {
    final TransactGetItemsRequest finalRequest = (TransactGetItemsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TransactGetItemsResult call()
        throws Exception
      {
        TransactGetItemsResult result = null;
        try
        {
          result = executeTransactGetItems(finalRequest);
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
  
  public Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest request)
  {
    return transactWriteItemsAsync(request, null);
  }
  
  public Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest request, final AsyncHandler<TransactWriteItemsRequest, TransactWriteItemsResult> asyncHandler)
  {
    final TransactWriteItemsRequest finalRequest = (TransactWriteItemsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TransactWriteItemsResult call()
        throws Exception
      {
        TransactWriteItemsResult result = null;
        try
        {
          result = executeTransactWriteItems(finalRequest);
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
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, final AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    final UntagResourceRequest finalRequest = (UntagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagResourceResult call()
        throws Exception
      {
        UntagResourceResult result = null;
        try
        {
          result = executeUntagResource(finalRequest);
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
  
  public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest request)
  {
    return updateContinuousBackupsAsync(request, null);
  }
  
  public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest request, final AsyncHandler<UpdateContinuousBackupsRequest, UpdateContinuousBackupsResult> asyncHandler)
  {
    final UpdateContinuousBackupsRequest finalRequest = (UpdateContinuousBackupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateContinuousBackupsResult call()
        throws Exception
      {
        UpdateContinuousBackupsResult result = null;
        try
        {
          result = executeUpdateContinuousBackups(finalRequest);
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
  
  public Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest request)
  {
    return updateGlobalTableAsync(request, null);
  }
  
  public Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest request, final AsyncHandler<UpdateGlobalTableRequest, UpdateGlobalTableResult> asyncHandler)
  {
    final UpdateGlobalTableRequest finalRequest = (UpdateGlobalTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateGlobalTableResult call()
        throws Exception
      {
        UpdateGlobalTableResult result = null;
        try
        {
          result = executeUpdateGlobalTable(finalRequest);
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
  
  public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest request)
  {
    return updateGlobalTableSettingsAsync(request, null);
  }
  
  public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest request, final AsyncHandler<UpdateGlobalTableSettingsRequest, UpdateGlobalTableSettingsResult> asyncHandler)
  {
    final UpdateGlobalTableSettingsRequest finalRequest = (UpdateGlobalTableSettingsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateGlobalTableSettingsResult call()
        throws Exception
      {
        UpdateGlobalTableSettingsResult result = null;
        try
        {
          result = executeUpdateGlobalTableSettings(finalRequest);
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
  
  public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest request)
  {
    return updateItemAsync(request, null);
  }
  
  public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest request, final AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler)
  {
    final UpdateItemRequest finalRequest = (UpdateItemRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateItemResult call()
        throws Exception
      {
        UpdateItemResult result = null;
        try
        {
          result = executeUpdateItem(finalRequest);
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
  
  public Future<UpdateItemResult> updateItemAsync(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates)
  {
    return updateItemAsync(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates));
  }
  
  public Future<UpdateItemResult> updateItemAsync(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler)
  {
    return updateItemAsync(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates), asyncHandler);
  }
  
  public Future<UpdateItemResult> updateItemAsync(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues)
  {
    return updateItemAsync(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates)
      .withReturnValues(returnValues));
  }
  
  public Future<UpdateItemResult> updateItemAsync(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues, AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler)
  {
    return updateItemAsync(new UpdateItemRequest()
      .withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates).withReturnValues(returnValues), asyncHandler);
  }
  
  public Future<UpdateTableResult> updateTableAsync(UpdateTableRequest request)
  {
    return updateTableAsync(request, null);
  }
  
  public Future<UpdateTableResult> updateTableAsync(UpdateTableRequest request, final AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler)
  {
    final UpdateTableRequest finalRequest = (UpdateTableRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateTableResult call()
        throws Exception
      {
        UpdateTableResult result = null;
        try
        {
          result = executeUpdateTable(finalRequest);
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
  
  public Future<UpdateTableResult> updateTableAsync(String tableName, ProvisionedThroughput provisionedThroughput)
  {
    return updateTableAsync(new UpdateTableRequest().withTableName(tableName).withProvisionedThroughput(provisionedThroughput));
  }
  
  public Future<UpdateTableResult> updateTableAsync(String tableName, ProvisionedThroughput provisionedThroughput, AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler)
  {
    return updateTableAsync(new UpdateTableRequest().withTableName(tableName).withProvisionedThroughput(provisionedThroughput), asyncHandler);
  }
  
  public Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest request)
  {
    return updateTimeToLiveAsync(request, null);
  }
  
  public Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest request, final AsyncHandler<UpdateTimeToLiveRequest, UpdateTimeToLiveResult> asyncHandler)
  {
    final UpdateTimeToLiveRequest finalRequest = (UpdateTimeToLiveRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateTimeToLiveResult call()
        throws Exception
      {
        UpdateTimeToLiveResult result = null;
        try
        {
          result = executeUpdateTimeToLive(finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */