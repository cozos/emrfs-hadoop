package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchGetItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchWriteItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ListTablesApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.BatchGetItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.BatchWriteItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ListTablesImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchGetItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchWriteItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class DynamoDB
  implements ListTablesApi, BatchGetItemApi, BatchWriteItemApi
{
  private final AmazonDynamoDB client;
  private final ListTablesImpl listTablesDelegate;
  private final BatchGetItemImpl batchGetItemDelegate;
  private final BatchWriteItemImpl batchWriteItemDelegate;
  
  public DynamoDB(AmazonDynamoDB client)
  {
    if (client == null) {
      throw new IllegalArgumentException();
    }
    this.client = client;
    listTablesDelegate = new ListTablesImpl(client);
    batchGetItemDelegate = new BatchGetItemImpl(client);
    batchWriteItemDelegate = new BatchWriteItemImpl(client);
  }
  
  public DynamoDB(Regions regionEnum)
  {
    this(
      (AmazonDynamoDB)new AmazonDynamoDBClient().withRegion(regionEnum));
  }
  
  public Table getTable(String tableName)
  {
    return new Table(client, tableName);
  }
  
  public Table createTable(CreateTableRequest req)
  {
    CreateTableResult result = client.createTable(req);
    return new Table(client, req.getTableName(), result
      .getTableDescription());
  }
  
  public Table createTable(String tableName, List<KeySchemaElement> keySchema, List<AttributeDefinition> attributeDefinitions, ProvisionedThroughput provisionedThroughput)
  {
    return createTable(new CreateTableRequest()
      .withTableName(tableName)
      .withKeySchema(keySchema)
      .withAttributeDefinitions(attributeDefinitions)
      .withProvisionedThroughput(provisionedThroughput));
  }
  
  public TableCollection<ListTablesResult> listTables()
  {
    return listTablesDelegate.listTables();
  }
  
  public TableCollection<ListTablesResult> listTables(String exclusiveStartTableName)
  {
    return listTablesDelegate.listTables(exclusiveStartTableName);
  }
  
  public TableCollection<ListTablesResult> listTables(String exclusiveStartTableName, int maxResultSize)
  {
    return listTablesDelegate.listTables(exclusiveStartTableName, maxResultSize);
  }
  
  public TableCollection<ListTablesResult> listTables(int maxResultSize)
  {
    return listTablesDelegate.listTables(maxResultSize);
  }
  
  public TableCollection<ListTablesResult> listTables(ListTablesSpec spec)
  {
    return listTablesDelegate.listTables(spec);
  }
  
  public BatchGetItemOutcome batchGetItem(ReturnConsumedCapacity returnConsumedCapacity, TableKeysAndAttributes... tableKeysAndAttributes)
  {
    return batchGetItemDelegate.batchGetItem(returnConsumedCapacity, tableKeysAndAttributes);
  }
  
  public BatchGetItemOutcome batchGetItem(TableKeysAndAttributes... tableKeysAndAttributes)
  {
    return batchGetItemDelegate.batchGetItem(tableKeysAndAttributes);
  }
  
  public BatchGetItemOutcome batchGetItem(BatchGetItemSpec spec)
  {
    return batchGetItemDelegate.batchGetItem(spec);
  }
  
  public BatchGetItemOutcome batchGetItemUnprocessed(ReturnConsumedCapacity returnConsumedCapacity, Map<String, KeysAndAttributes> unprocessedKeys)
  {
    return batchGetItemDelegate.batchGetItemUnprocessed(returnConsumedCapacity, unprocessedKeys);
  }
  
  public BatchGetItemOutcome batchGetItemUnprocessed(Map<String, KeysAndAttributes> unprocessedKeys)
  {
    return batchGetItemDelegate.batchGetItemUnprocessed(unprocessedKeys);
  }
  
  public BatchWriteItemOutcome batchWriteItem(TableWriteItems... tableWriteItems)
  {
    return batchWriteItemDelegate.batchWriteItem(tableWriteItems);
  }
  
  public BatchWriteItemOutcome batchWriteItem(BatchWriteItemSpec spec)
  {
    return batchWriteItemDelegate.batchWriteItem(spec);
  }
  
  public BatchWriteItemOutcome batchWriteItemUnprocessed(Map<String, List<WriteRequest>> unprocessedItems)
  {
    return batchWriteItemDelegate.batchWriteItemUnprocessed(unprocessedItems);
  }
  
  public void shutdown()
  {
    client.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.DynamoDB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */