package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.AmazonDynamoDBWaiters;
import java.util.List;
import java.util.Map;

public class AbstractAmazonDynamoDB
  implements AmazonDynamoDB
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public BatchGetItemResult batchGetItem(BatchGetItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity)
  {
    return batchGetItem(new BatchGetItemRequest().withRequestItems(requestItems).withReturnConsumedCapacity(returnConsumedCapacity));
  }
  
  public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems)
  {
    return batchGetItem(new BatchGetItemRequest().withRequestItems(requestItems));
  }
  
  public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> requestItems)
  {
    return batchWriteItem(new BatchWriteItemRequest().withRequestItems(requestItems));
  }
  
  public CreateBackupResult createBackup(CreateBackupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateGlobalTableResult createGlobalTable(CreateGlobalTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateTableResult createTable(CreateTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateTableResult createTable(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput)
  {
    return createTable(new CreateTableRequest().withAttributeDefinitions(attributeDefinitions).withTableName(tableName).withKeySchema(keySchema)
      .withProvisionedThroughput(provisionedThroughput));
  }
  
  public DeleteBackupResult deleteBackup(DeleteBackupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteItemResult deleteItem(DeleteItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key)
  {
    return deleteItem(new DeleteItemRequest().withTableName(tableName).withKey(key));
  }
  
  public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key, String returnValues)
  {
    return deleteItem(new DeleteItemRequest().withTableName(tableName).withKey(key).withReturnValues(returnValues));
  }
  
  public DeleteTableResult deleteTable(DeleteTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteTableResult deleteTable(String tableName)
  {
    return deleteTable(new DeleteTableRequest().withTableName(tableName));
  }
  
  public DescribeBackupResult describeBackup(DescribeBackupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeContinuousBackupsResult describeContinuousBackups(DescribeContinuousBackupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeGlobalTableResult describeGlobalTable(DescribeGlobalTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeGlobalTableSettingsResult describeGlobalTableSettings(DescribeGlobalTableSettingsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeLimitsResult describeLimits(DescribeLimitsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeTableResult describeTable(DescribeTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeTableResult describeTable(String tableName)
  {
    return describeTable(new DescribeTableRequest().withTableName(tableName));
  }
  
  public DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetItemResult getItem(GetItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetItemResult getItem(String tableName, Map<String, AttributeValue> key)
  {
    return getItem(new GetItemRequest().withTableName(tableName).withKey(key));
  }
  
  public GetItemResult getItem(String tableName, Map<String, AttributeValue> key, Boolean consistentRead)
  {
    return getItem(new GetItemRequest().withTableName(tableName).withKey(key).withConsistentRead(consistentRead));
  }
  
  public ListBackupsResult listBackups(ListBackupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListGlobalTablesResult listGlobalTables(ListGlobalTablesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListTablesResult listTables(ListTablesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListTablesResult listTables()
  {
    return listTables(new ListTablesRequest());
  }
  
  public ListTablesResult listTables(String exclusiveStartTableName)
  {
    return listTables(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName));
  }
  
  public ListTablesResult listTables(String exclusiveStartTableName, Integer limit)
  {
    return listTables(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName).withLimit(limit));
  }
  
  public ListTablesResult listTables(Integer limit)
  {
    return listTables(new ListTablesRequest().withLimit(limit));
  }
  
  public ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutItemResult putItem(PutItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutItemResult putItem(String tableName, Map<String, AttributeValue> item)
  {
    return putItem(new PutItemRequest().withTableName(tableName).withItem(item));
  }
  
  public PutItemResult putItem(String tableName, Map<String, AttributeValue> item, String returnValues)
  {
    return putItem(new PutItemRequest().withTableName(tableName).withItem(item).withReturnValues(returnValues));
  }
  
  public QueryResult query(QueryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RestoreTableFromBackupResult restoreTableFromBackup(RestoreTableFromBackupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RestoreTableToPointInTimeResult restoreTableToPointInTime(RestoreTableToPointInTimeRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ScanResult scan(ScanRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ScanResult scan(String tableName, List<String> attributesToGet)
  {
    return scan(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet));
  }
  
  public ScanResult scan(String tableName, Map<String, Condition> scanFilter)
  {
    return scan(new ScanRequest().withTableName(tableName).withScanFilter(scanFilter));
  }
  
  public ScanResult scan(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter)
  {
    return scan(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet).withScanFilter(scanFilter));
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TransactGetItemsResult transactGetItems(TransactGetItemsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TransactWriteItemsResult transactWriteItems(TransactWriteItemsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateContinuousBackupsResult updateContinuousBackups(UpdateContinuousBackupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateGlobalTableResult updateGlobalTable(UpdateGlobalTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateGlobalTableSettingsResult updateGlobalTableSettings(UpdateGlobalTableSettingsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateItemResult updateItem(UpdateItemRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates)
  {
    return updateItem(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates));
  }
  
  public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues)
  {
    return updateItem(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates).withReturnValues(returnValues));
  }
  
  public UpdateTableResult updateTable(UpdateTableRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateTableResult updateTable(String tableName, ProvisionedThroughput provisionedThroughput)
  {
    return updateTable(new UpdateTableRequest().withTableName(tableName).withProvisionedThroughput(provisionedThroughput));
  }
  
  public UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AmazonDynamoDBWaiters waiters()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AbstractAmazonDynamoDB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */