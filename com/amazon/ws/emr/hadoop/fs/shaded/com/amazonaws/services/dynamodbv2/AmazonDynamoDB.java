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

public abstract interface AmazonDynamoDB
{
  public static final String ENDPOINT_PREFIX = "dynamodb";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract BatchGetItemResult batchGetItem(BatchGetItemRequest paramBatchGetItemRequest);
  
  public abstract BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> paramMap, String paramString);
  
  public abstract BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> paramMap);
  
  public abstract BatchWriteItemResult batchWriteItem(BatchWriteItemRequest paramBatchWriteItemRequest);
  
  public abstract BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> paramMap);
  
  public abstract CreateBackupResult createBackup(CreateBackupRequest paramCreateBackupRequest);
  
  public abstract CreateGlobalTableResult createGlobalTable(CreateGlobalTableRequest paramCreateGlobalTableRequest);
  
  public abstract CreateTableResult createTable(CreateTableRequest paramCreateTableRequest);
  
  public abstract CreateTableResult createTable(List<AttributeDefinition> paramList, String paramString, List<KeySchemaElement> paramList1, ProvisionedThroughput paramProvisionedThroughput);
  
  public abstract DeleteBackupResult deleteBackup(DeleteBackupRequest paramDeleteBackupRequest);
  
  public abstract DeleteItemResult deleteItem(DeleteItemRequest paramDeleteItemRequest);
  
  public abstract DeleteItemResult deleteItem(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract DeleteItemResult deleteItem(String paramString1, Map<String, AttributeValue> paramMap, String paramString2);
  
  public abstract DeleteTableResult deleteTable(DeleteTableRequest paramDeleteTableRequest);
  
  public abstract DeleteTableResult deleteTable(String paramString);
  
  public abstract DescribeBackupResult describeBackup(DescribeBackupRequest paramDescribeBackupRequest);
  
  public abstract DescribeContinuousBackupsResult describeContinuousBackups(DescribeContinuousBackupsRequest paramDescribeContinuousBackupsRequest);
  
  public abstract DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest paramDescribeEndpointsRequest);
  
  public abstract DescribeGlobalTableResult describeGlobalTable(DescribeGlobalTableRequest paramDescribeGlobalTableRequest);
  
  public abstract DescribeGlobalTableSettingsResult describeGlobalTableSettings(DescribeGlobalTableSettingsRequest paramDescribeGlobalTableSettingsRequest);
  
  public abstract DescribeLimitsResult describeLimits(DescribeLimitsRequest paramDescribeLimitsRequest);
  
  public abstract DescribeTableResult describeTable(DescribeTableRequest paramDescribeTableRequest);
  
  public abstract DescribeTableResult describeTable(String paramString);
  
  public abstract DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest paramDescribeTimeToLiveRequest);
  
  public abstract GetItemResult getItem(GetItemRequest paramGetItemRequest);
  
  public abstract GetItemResult getItem(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract GetItemResult getItem(String paramString, Map<String, AttributeValue> paramMap, Boolean paramBoolean);
  
  public abstract ListBackupsResult listBackups(ListBackupsRequest paramListBackupsRequest);
  
  public abstract ListGlobalTablesResult listGlobalTables(ListGlobalTablesRequest paramListGlobalTablesRequest);
  
  public abstract ListTablesResult listTables(ListTablesRequest paramListTablesRequest);
  
  public abstract ListTablesResult listTables();
  
  public abstract ListTablesResult listTables(String paramString);
  
  public abstract ListTablesResult listTables(String paramString, Integer paramInteger);
  
  public abstract ListTablesResult listTables(Integer paramInteger);
  
  public abstract ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest paramListTagsOfResourceRequest);
  
  public abstract PutItemResult putItem(PutItemRequest paramPutItemRequest);
  
  public abstract PutItemResult putItem(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract PutItemResult putItem(String paramString1, Map<String, AttributeValue> paramMap, String paramString2);
  
  public abstract QueryResult query(QueryRequest paramQueryRequest);
  
  public abstract RestoreTableFromBackupResult restoreTableFromBackup(RestoreTableFromBackupRequest paramRestoreTableFromBackupRequest);
  
  public abstract RestoreTableToPointInTimeResult restoreTableToPointInTime(RestoreTableToPointInTimeRequest paramRestoreTableToPointInTimeRequest);
  
  public abstract ScanResult scan(ScanRequest paramScanRequest);
  
  public abstract ScanResult scan(String paramString, List<String> paramList);
  
  public abstract ScanResult scan(String paramString, Map<String, Condition> paramMap);
  
  public abstract ScanResult scan(String paramString, List<String> paramList, Map<String, Condition> paramMap);
  
  public abstract TagResourceResult tagResource(TagResourceRequest paramTagResourceRequest);
  
  public abstract TransactGetItemsResult transactGetItems(TransactGetItemsRequest paramTransactGetItemsRequest);
  
  public abstract TransactWriteItemsResult transactWriteItems(TransactWriteItemsRequest paramTransactWriteItemsRequest);
  
  public abstract UntagResourceResult untagResource(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract UpdateContinuousBackupsResult updateContinuousBackups(UpdateContinuousBackupsRequest paramUpdateContinuousBackupsRequest);
  
  public abstract UpdateGlobalTableResult updateGlobalTable(UpdateGlobalTableRequest paramUpdateGlobalTableRequest);
  
  public abstract UpdateGlobalTableSettingsResult updateGlobalTableSettings(UpdateGlobalTableSettingsRequest paramUpdateGlobalTableSettingsRequest);
  
  public abstract UpdateItemResult updateItem(UpdateItemRequest paramUpdateItemRequest);
  
  public abstract UpdateItemResult updateItem(String paramString, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1);
  
  public abstract UpdateItemResult updateItem(String paramString1, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1, String paramString2);
  
  public abstract UpdateTableResult updateTable(UpdateTableRequest paramUpdateTableRequest);
  
  public abstract UpdateTableResult updateTable(String paramString, ProvisionedThroughput paramProvisionedThroughput);
  
  public abstract UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest paramUpdateTimeToLiveRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract AmazonDynamoDBWaiters waiters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */