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

public abstract interface AmazonDynamoDBAsync
  extends AmazonDynamoDB
{
  public abstract Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest paramBatchGetItemRequest);
  
  public abstract Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest paramBatchGetItemRequest, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> paramAsyncHandler);
  
  public abstract Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> paramMap, String paramString);
  
  public abstract Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> paramMap, String paramString, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> paramAsyncHandler);
  
  public abstract Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> paramMap);
  
  public abstract Future<BatchGetItemResult> batchGetItemAsync(Map<String, KeysAndAttributes> paramMap, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> paramAsyncHandler);
  
  public abstract Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest paramBatchWriteItemRequest);
  
  public abstract Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest paramBatchWriteItemRequest, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> paramAsyncHandler);
  
  public abstract Future<BatchWriteItemResult> batchWriteItemAsync(Map<String, List<WriteRequest>> paramMap);
  
  public abstract Future<BatchWriteItemResult> batchWriteItemAsync(Map<String, List<WriteRequest>> paramMap, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> paramAsyncHandler);
  
  public abstract Future<CreateBackupResult> createBackupAsync(CreateBackupRequest paramCreateBackupRequest);
  
  public abstract Future<CreateBackupResult> createBackupAsync(CreateBackupRequest paramCreateBackupRequest, AsyncHandler<CreateBackupRequest, CreateBackupResult> paramAsyncHandler);
  
  public abstract Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest paramCreateGlobalTableRequest);
  
  public abstract Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest paramCreateGlobalTableRequest, AsyncHandler<CreateGlobalTableRequest, CreateGlobalTableResult> paramAsyncHandler);
  
  public abstract Future<CreateTableResult> createTableAsync(CreateTableRequest paramCreateTableRequest);
  
  public abstract Future<CreateTableResult> createTableAsync(CreateTableRequest paramCreateTableRequest, AsyncHandler<CreateTableRequest, CreateTableResult> paramAsyncHandler);
  
  public abstract Future<CreateTableResult> createTableAsync(List<AttributeDefinition> paramList, String paramString, List<KeySchemaElement> paramList1, ProvisionedThroughput paramProvisionedThroughput);
  
  public abstract Future<CreateTableResult> createTableAsync(List<AttributeDefinition> paramList, String paramString, List<KeySchemaElement> paramList1, ProvisionedThroughput paramProvisionedThroughput, AsyncHandler<CreateTableRequest, CreateTableResult> paramAsyncHandler);
  
  public abstract Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest paramDeleteBackupRequest);
  
  public abstract Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest paramDeleteBackupRequest, AsyncHandler<DeleteBackupRequest, DeleteBackupResult> paramAsyncHandler);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest paramDeleteItemRequest);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest paramDeleteItemRequest, AsyncHandler<DeleteItemRequest, DeleteItemResult> paramAsyncHandler);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(String paramString, Map<String, AttributeValue> paramMap, AsyncHandler<DeleteItemRequest, DeleteItemResult> paramAsyncHandler);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(String paramString1, Map<String, AttributeValue> paramMap, String paramString2);
  
  public abstract Future<DeleteItemResult> deleteItemAsync(String paramString1, Map<String, AttributeValue> paramMap, String paramString2, AsyncHandler<DeleteItemRequest, DeleteItemResult> paramAsyncHandler);
  
  public abstract Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest paramDeleteTableRequest);
  
  public abstract Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest paramDeleteTableRequest, AsyncHandler<DeleteTableRequest, DeleteTableResult> paramAsyncHandler);
  
  public abstract Future<DeleteTableResult> deleteTableAsync(String paramString);
  
  public abstract Future<DeleteTableResult> deleteTableAsync(String paramString, AsyncHandler<DeleteTableRequest, DeleteTableResult> paramAsyncHandler);
  
  public abstract Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest paramDescribeBackupRequest);
  
  public abstract Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest paramDescribeBackupRequest, AsyncHandler<DescribeBackupRequest, DescribeBackupResult> paramAsyncHandler);
  
  public abstract Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest paramDescribeContinuousBackupsRequest);
  
  public abstract Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest paramDescribeContinuousBackupsRequest, AsyncHandler<DescribeContinuousBackupsRequest, DescribeContinuousBackupsResult> paramAsyncHandler);
  
  public abstract Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest paramDescribeEndpointsRequest);
  
  public abstract Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest paramDescribeEndpointsRequest, AsyncHandler<DescribeEndpointsRequest, DescribeEndpointsResult> paramAsyncHandler);
  
  public abstract Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest paramDescribeGlobalTableRequest);
  
  public abstract Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest paramDescribeGlobalTableRequest, AsyncHandler<DescribeGlobalTableRequest, DescribeGlobalTableResult> paramAsyncHandler);
  
  public abstract Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest paramDescribeGlobalTableSettingsRequest);
  
  public abstract Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest paramDescribeGlobalTableSettingsRequest, AsyncHandler<DescribeGlobalTableSettingsRequest, DescribeGlobalTableSettingsResult> paramAsyncHandler);
  
  public abstract Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest paramDescribeLimitsRequest);
  
  public abstract Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest paramDescribeLimitsRequest, AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> paramAsyncHandler);
  
  public abstract Future<DescribeTableResult> describeTableAsync(DescribeTableRequest paramDescribeTableRequest);
  
  public abstract Future<DescribeTableResult> describeTableAsync(DescribeTableRequest paramDescribeTableRequest, AsyncHandler<DescribeTableRequest, DescribeTableResult> paramAsyncHandler);
  
  public abstract Future<DescribeTableResult> describeTableAsync(String paramString);
  
  public abstract Future<DescribeTableResult> describeTableAsync(String paramString, AsyncHandler<DescribeTableRequest, DescribeTableResult> paramAsyncHandler);
  
  public abstract Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest paramDescribeTimeToLiveRequest);
  
  public abstract Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest paramDescribeTimeToLiveRequest, AsyncHandler<DescribeTimeToLiveRequest, DescribeTimeToLiveResult> paramAsyncHandler);
  
  public abstract Future<GetItemResult> getItemAsync(GetItemRequest paramGetItemRequest);
  
  public abstract Future<GetItemResult> getItemAsync(GetItemRequest paramGetItemRequest, AsyncHandler<GetItemRequest, GetItemResult> paramAsyncHandler);
  
  public abstract Future<GetItemResult> getItemAsync(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract Future<GetItemResult> getItemAsync(String paramString, Map<String, AttributeValue> paramMap, AsyncHandler<GetItemRequest, GetItemResult> paramAsyncHandler);
  
  public abstract Future<GetItemResult> getItemAsync(String paramString, Map<String, AttributeValue> paramMap, Boolean paramBoolean);
  
  public abstract Future<GetItemResult> getItemAsync(String paramString, Map<String, AttributeValue> paramMap, Boolean paramBoolean, AsyncHandler<GetItemRequest, GetItemResult> paramAsyncHandler);
  
  public abstract Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest paramListBackupsRequest);
  
  public abstract Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest paramListBackupsRequest, AsyncHandler<ListBackupsRequest, ListBackupsResult> paramAsyncHandler);
  
  public abstract Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest paramListGlobalTablesRequest);
  
  public abstract Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest paramListGlobalTablesRequest, AsyncHandler<ListGlobalTablesRequest, ListGlobalTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTablesResult> listTablesAsync(ListTablesRequest paramListTablesRequest);
  
  public abstract Future<ListTablesResult> listTablesAsync(ListTablesRequest paramListTablesRequest, AsyncHandler<ListTablesRequest, ListTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTablesResult> listTablesAsync();
  
  public abstract Future<ListTablesResult> listTablesAsync(AsyncHandler<ListTablesRequest, ListTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTablesResult> listTablesAsync(String paramString);
  
  public abstract Future<ListTablesResult> listTablesAsync(String paramString, AsyncHandler<ListTablesRequest, ListTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTablesResult> listTablesAsync(String paramString, Integer paramInteger);
  
  public abstract Future<ListTablesResult> listTablesAsync(String paramString, Integer paramInteger, AsyncHandler<ListTablesRequest, ListTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTablesResult> listTablesAsync(Integer paramInteger);
  
  public abstract Future<ListTablesResult> listTablesAsync(Integer paramInteger, AsyncHandler<ListTablesRequest, ListTablesResult> paramAsyncHandler);
  
  public abstract Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest paramListTagsOfResourceRequest);
  
  public abstract Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest paramListTagsOfResourceRequest, AsyncHandler<ListTagsOfResourceRequest, ListTagsOfResourceResult> paramAsyncHandler);
  
  public abstract Future<PutItemResult> putItemAsync(PutItemRequest paramPutItemRequest);
  
  public abstract Future<PutItemResult> putItemAsync(PutItemRequest paramPutItemRequest, AsyncHandler<PutItemRequest, PutItemResult> paramAsyncHandler);
  
  public abstract Future<PutItemResult> putItemAsync(String paramString, Map<String, AttributeValue> paramMap);
  
  public abstract Future<PutItemResult> putItemAsync(String paramString, Map<String, AttributeValue> paramMap, AsyncHandler<PutItemRequest, PutItemResult> paramAsyncHandler);
  
  public abstract Future<PutItemResult> putItemAsync(String paramString1, Map<String, AttributeValue> paramMap, String paramString2);
  
  public abstract Future<PutItemResult> putItemAsync(String paramString1, Map<String, AttributeValue> paramMap, String paramString2, AsyncHandler<PutItemRequest, PutItemResult> paramAsyncHandler);
  
  public abstract Future<QueryResult> queryAsync(QueryRequest paramQueryRequest);
  
  public abstract Future<QueryResult> queryAsync(QueryRequest paramQueryRequest, AsyncHandler<QueryRequest, QueryResult> paramAsyncHandler);
  
  public abstract Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest paramRestoreTableFromBackupRequest);
  
  public abstract Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest paramRestoreTableFromBackupRequest, AsyncHandler<RestoreTableFromBackupRequest, RestoreTableFromBackupResult> paramAsyncHandler);
  
  public abstract Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest paramRestoreTableToPointInTimeRequest);
  
  public abstract Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest paramRestoreTableToPointInTimeRequest, AsyncHandler<RestoreTableToPointInTimeRequest, RestoreTableToPointInTimeResult> paramAsyncHandler);
  
  public abstract Future<ScanResult> scanAsync(ScanRequest paramScanRequest);
  
  public abstract Future<ScanResult> scanAsync(ScanRequest paramScanRequest, AsyncHandler<ScanRequest, ScanResult> paramAsyncHandler);
  
  public abstract Future<ScanResult> scanAsync(String paramString, List<String> paramList);
  
  public abstract Future<ScanResult> scanAsync(String paramString, List<String> paramList, AsyncHandler<ScanRequest, ScanResult> paramAsyncHandler);
  
  public abstract Future<ScanResult> scanAsync(String paramString, Map<String, Condition> paramMap);
  
  public abstract Future<ScanResult> scanAsync(String paramString, Map<String, Condition> paramMap, AsyncHandler<ScanRequest, ScanResult> paramAsyncHandler);
  
  public abstract Future<ScanResult> scanAsync(String paramString, List<String> paramList, Map<String, Condition> paramMap);
  
  public abstract Future<ScanResult> scanAsync(String paramString, List<String> paramList, Map<String, Condition> paramMap, AsyncHandler<ScanRequest, ScanResult> paramAsyncHandler);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest, AsyncHandler<TagResourceRequest, TagResourceResult> paramAsyncHandler);
  
  public abstract Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest paramTransactGetItemsRequest);
  
  public abstract Future<TransactGetItemsResult> transactGetItemsAsync(TransactGetItemsRequest paramTransactGetItemsRequest, AsyncHandler<TransactGetItemsRequest, TransactGetItemsResult> paramAsyncHandler);
  
  public abstract Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest paramTransactWriteItemsRequest);
  
  public abstract Future<TransactWriteItemsResult> transactWriteItemsAsync(TransactWriteItemsRequest paramTransactWriteItemsRequest, AsyncHandler<TransactWriteItemsRequest, TransactWriteItemsResult> paramAsyncHandler);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest, AsyncHandler<UntagResourceRequest, UntagResourceResult> paramAsyncHandler);
  
  public abstract Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest paramUpdateContinuousBackupsRequest);
  
  public abstract Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest paramUpdateContinuousBackupsRequest, AsyncHandler<UpdateContinuousBackupsRequest, UpdateContinuousBackupsResult> paramAsyncHandler);
  
  public abstract Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest paramUpdateGlobalTableRequest);
  
  public abstract Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest paramUpdateGlobalTableRequest, AsyncHandler<UpdateGlobalTableRequest, UpdateGlobalTableResult> paramAsyncHandler);
  
  public abstract Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest paramUpdateGlobalTableSettingsRequest);
  
  public abstract Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest paramUpdateGlobalTableSettingsRequest, AsyncHandler<UpdateGlobalTableSettingsRequest, UpdateGlobalTableSettingsResult> paramAsyncHandler);
  
  public abstract Future<UpdateItemResult> updateItemAsync(UpdateItemRequest paramUpdateItemRequest);
  
  public abstract Future<UpdateItemResult> updateItemAsync(UpdateItemRequest paramUpdateItemRequest, AsyncHandler<UpdateItemRequest, UpdateItemResult> paramAsyncHandler);
  
  public abstract Future<UpdateItemResult> updateItemAsync(String paramString, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1);
  
  public abstract Future<UpdateItemResult> updateItemAsync(String paramString, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1, AsyncHandler<UpdateItemRequest, UpdateItemResult> paramAsyncHandler);
  
  public abstract Future<UpdateItemResult> updateItemAsync(String paramString1, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1, String paramString2);
  
  public abstract Future<UpdateItemResult> updateItemAsync(String paramString1, Map<String, AttributeValue> paramMap, Map<String, AttributeValueUpdate> paramMap1, String paramString2, AsyncHandler<UpdateItemRequest, UpdateItemResult> paramAsyncHandler);
  
  public abstract Future<UpdateTableResult> updateTableAsync(UpdateTableRequest paramUpdateTableRequest);
  
  public abstract Future<UpdateTableResult> updateTableAsync(UpdateTableRequest paramUpdateTableRequest, AsyncHandler<UpdateTableRequest, UpdateTableResult> paramAsyncHandler);
  
  public abstract Future<UpdateTableResult> updateTableAsync(String paramString, ProvisionedThroughput paramProvisionedThroughput);
  
  public abstract Future<UpdateTableResult> updateTableAsync(String paramString, ProvisionedThroughput paramProvisionedThroughput, AsyncHandler<UpdateTableRequest, UpdateTableResult> paramAsyncHandler);
  
  public abstract Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest paramUpdateTimeToLiveRequest);
  
  public abstract Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest paramUpdateTimeToLiveRequest, AsyncHandler<UpdateTimeToLiveRequest, UpdateTimeToLiveResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */