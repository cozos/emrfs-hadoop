package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

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
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class AbstractAmazonDynamoDBAsync
  extends AbstractAmazonDynamoDB
  implements AmazonDynamoDBAsync
{
  public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest request)
  {
    return batchGetItemAsync(request, null);
  }
  
  public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest request, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest request, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<CreateBackupResult> createBackupAsync(CreateBackupRequest request, AsyncHandler<CreateBackupRequest, CreateBackupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest request)
  {
    return createGlobalTableAsync(request, null);
  }
  
  public Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest request, AsyncHandler<CreateGlobalTableRequest, CreateGlobalTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateTableResult> createTableAsync(CreateTableRequest request)
  {
    return createTableAsync(request, null);
  }
  
  public Future<CreateTableResult> createTableAsync(CreateTableRequest request, AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest request, AsyncHandler<DeleteBackupRequest, DeleteBackupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest request)
  {
    return deleteItemAsync(request, null);
  }
  
  public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest request, AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest request, AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest request, AsyncHandler<DescribeBackupRequest, DescribeBackupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest request)
  {
    return describeContinuousBackupsAsync(request, null);
  }
  
  public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest request, AsyncHandler<DescribeContinuousBackupsRequest, DescribeContinuousBackupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest request)
  {
    return describeEndpointsAsync(request, null);
  }
  
  public Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest request, AsyncHandler<DescribeEndpointsRequest, DescribeEndpointsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest request)
  {
    return describeGlobalTableAsync(request, null);
  }
  
  public Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest request, AsyncHandler<DescribeGlobalTableRequest, DescribeGlobalTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest request)
  {
    return describeGlobalTableSettingsAsync(request, null);
  }
  
  public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest request, AsyncHandler<DescribeGlobalTableSettingsRequest, DescribeGlobalTableSettingsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest request)
  {
    return describeLimitsAsync(request, null);
  }
  
  public Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest request, AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest request)
  {
    return describeTableAsync(request, null);
  }
  
  public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest request, AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest request, AsyncHandler<DescribeTimeToLiveRequest, DescribeTimeToLiveResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetItemResult> getItemAsync(GetItemRequest request)
  {
    return getItemAsync(request, null);
  }
  
  public Future<GetItemResult> getItemAsync(GetItemRequest request, AsyncHandler<GetItemRequest, GetItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest request, AsyncHandler<ListBackupsRequest, ListBackupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest request)
  {
    return listGlobalTablesAsync(request, null);
  }
  
  public Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest request, AsyncHandler<ListGlobalTablesRequest, ListGlobalTablesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListTablesResult> listTablesAsync(ListTablesRequest request)
  {
    return listTablesAsync(request, null);
  }
  
  public Future<ListTablesResult> listTablesAsync(ListTablesRequest request, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest request, AsyncHandler<ListTagsOfResourceRequest, ListTagsOfResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutItemResult> putItemAsync(PutItemRequest request)
  {
    return putItemAsync(request, null);
  }
  
  public Future<PutItemResult> putItemAsync(PutItemRequest request, AsyncHandler<PutItemRequest, PutItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<QueryResult> queryAsync(QueryRequest request, AsyncHandler<QueryRequest, QueryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest request)
  {
    return restoreTableFromBackupAsync(request, null);
  }
  
  public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest request, AsyncHandler<RestoreTableFromBackupRequest, RestoreTableFromBackupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest request)
  {
    return restoreTableToPointInTimeAsync(request, null);
  }
  
  public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest request, AsyncHandler<RestoreTableToPointInTimeRequest, RestoreTableToPointInTimeResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ScanResult> scanAsync(ScanRequest request)
  {
    return scanAsync(request, null);
  }
  
  public Future<ScanResult> scanAsync(ScanRequest request, AsyncHandler<ScanRequest, ScanResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest request)
  {
    return transactGetItemsAsync(request, null);
  }
  
  public Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest request, AsyncHandler<TransactGetItemsRequest, TransactGetItemsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest request)
  {
    return transactWriteItemsAsync(request, null);
  }
  
  public Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest request, AsyncHandler<TransactWriteItemsRequest, TransactWriteItemsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest request)
  {
    return updateContinuousBackupsAsync(request, null);
  }
  
  public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest request, AsyncHandler<UpdateContinuousBackupsRequest, UpdateContinuousBackupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest request)
  {
    return updateGlobalTableAsync(request, null);
  }
  
  public Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest request, AsyncHandler<UpdateGlobalTableRequest, UpdateGlobalTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest request)
  {
    return updateGlobalTableSettingsAsync(request, null);
  }
  
  public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest request, AsyncHandler<UpdateGlobalTableSettingsRequest, UpdateGlobalTableSettingsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest request)
  {
    return updateItemAsync(request, null);
  }
  
  public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest request, AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<UpdateTableResult> updateTableAsync(UpdateTableRequest request, AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest request, AsyncHandler<UpdateTimeToLiveRequest, UpdateTimeToLiveResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AbstractAmazonDynamoDBAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */