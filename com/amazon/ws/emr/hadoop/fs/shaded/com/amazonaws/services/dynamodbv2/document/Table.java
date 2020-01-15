package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.DeleteItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.GetItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.PutItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.QueryApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ScanApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.UpdateItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.DeleteItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.GetItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PutItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.QueryImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ScanImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.UpdateItemImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateTableSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalSecondaryIndexAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.IndexStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.AmazonDynamoDBWaiters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.DeleteItemExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.GetItemExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.QueryExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ScanExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.UpdateItemExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class Table
  implements PutItemApi, GetItemApi, QueryApi, ScanApi, UpdateItemApi, DeleteItemApi
{
  private static final long SLEEP_TIME_MILLIS = 5000L;
  private final String tableName;
  private final AmazonDynamoDB client;
  private volatile TableDescription tableDescription;
  private final PutItemImpl putItemDelegate;
  private final GetItemImpl getItemDelegate;
  private final UpdateItemImpl updateItemDelegate;
  private final DeleteItemImpl deleteItemDelegate;
  private final QueryImpl queryDelegate;
  private final ScanImpl scanDelegate;
  
  public Table(AmazonDynamoDB client, String tableName)
  {
    this(client, tableName, null);
  }
  
  public Table(AmazonDynamoDB client, String tableName, TableDescription tableDescription)
  {
    if (client == null) {
      throw new IllegalArgumentException("client must be specified");
    }
    if ((tableName == null) || (tableName.trim().length() == 0)) {
      throw new IllegalArgumentException("table name must not be null or empty");
    }
    this.client = client;
    this.tableName = tableName;
    this.tableDescription = tableDescription;
    
    putItemDelegate = new PutItemImpl(client, this);
    getItemDelegate = new GetItemImpl(client, this);
    updateItemDelegate = new UpdateItemImpl(client, this);
    deleteItemDelegate = new DeleteItemImpl(client, this);
    
    queryDelegate = new QueryImpl(client, this);
    scanDelegate = new ScanImpl(client, this);
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public TableDescription getDescription()
  {
    return tableDescription;
  }
  
  public TableDescription describe()
  {
    DescribeTableResult result = client.describeTable(
      (DescribeTableRequest)InternalUtils.applyUserAgent(new DescribeTableRequest(tableName)));
    return tableDescription = result.getTable();
  }
  
  public Index getIndex(String indexName)
  {
    return new Index(client, indexName, this);
  }
  
  public PutItemOutcome putItem(Item item)
  {
    return putItemDelegate.putItem(item);
  }
  
  public PutItemOutcome putItem(Item item, Expected... expected)
  {
    return putItemDelegate.putItem(item, expected);
  }
  
  public PutItemOutcome putItem(Item item, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return putItemDelegate.putItem(item, conditionExpression, nameMap, valueMap);
  }
  
  public PutItemOutcome putItem(PutItemSpec spec)
  {
    return putItemDelegate.putItem(spec);
  }
  
  public GetItemOutcome getItemOutcome(KeyAttribute... primaryKeyComponents)
  {
    return getItemDelegate.getItemOutcome(primaryKeyComponents);
  }
  
  public GetItemOutcome getItemOutcome(PrimaryKey primaryKey)
  {
    return getItemDelegate.getItemOutcome(primaryKey);
  }
  
  public GetItemOutcome getItemOutcome(PrimaryKey primaryKey, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItemOutcome(primaryKey, projectionExpression, nameMap);
  }
  
  public GetItemOutcome getItemOutcome(GetItemSpec params)
  {
    return getItemDelegate.getItemOutcome(params);
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(primaryKey, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(primaryKey, expected, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(primaryKey, updateExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(primaryKey, updateExpression, conditionExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(UpdateItemSpec updateItemSpec)
  {
    return updateItemDelegate.updateItem(updateItemSpec);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey)
  {
    return queryDelegate.query(hashKey);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, filterExpression, projectionExpression, nameMap, valueMap);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, QueryFilter... queryFilters)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, queryFilters);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, filterExpression, nameMap, valueMap);
  }
  
  public ItemCollection<QueryOutcome> query(QuerySpec spec)
  {
    return queryDelegate.query(spec);
  }
  
  public ItemCollection<ScanOutcome> scan(ScanFilter... scanFilters)
  {
    return scanDelegate.scan(scanFilters);
  }
  
  public ItemCollection<ScanOutcome> scan(String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return scanDelegate.scan(filterExpression, nameMap, valueMap);
  }
  
  public ItemCollection<ScanOutcome> scan(String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return scanDelegate.scan(filterExpression, projectionExpression, nameMap, valueMap);
  }
  
  public ItemCollection<ScanOutcome> scan(ScanSpec params)
  {
    return scanDelegate.scan(params);
  }
  
  @Beta
  public ItemCollection<ScanOutcome> scan(ScanExpressionSpec scanExpressions)
  {
    return scanDelegate.scan(new ScanSpec()
      .withProjectionExpression(scanExpressions.getProjectionExpression())
      .withFilterExpression(scanExpressions.getFilterExpression())
      .withNameMap(scanExpressions.getNameMap())
      .withValueMap(scanExpressions.getValueMap()));
  }
  
  public DeleteItemOutcome deleteItem(KeyAttribute... primaryKeyComponents)
  {
    return deleteItemDelegate.deleteItem(primaryKeyComponents);
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKey)
  {
    return deleteItemDelegate.deleteItem(primaryKey);
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKey, Expected... expected)
  {
    return deleteItemDelegate.deleteItem(primaryKey, expected);
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKey, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return deleteItemDelegate.deleteItem(primaryKey, conditionExpression, nameMap, valueMap);
  }
  
  @Beta
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKey, DeleteItemExpressionSpec conditionExpressions)
  {
    return deleteItemDelegate.deleteItem(primaryKey, conditionExpressions
      .getConditionExpression(), conditionExpressions
      .getNameMap(), conditionExpressions
      .getValueMap());
  }
  
  public DeleteItemOutcome deleteItem(DeleteItemSpec spec)
  {
    return deleteItemDelegate.deleteItem(spec);
  }
  
  public TableDescription updateTable(UpdateTableSpec spec)
  {
    UpdateTableRequest req = (UpdateTableRequest)spec.getRequest();
    req.setTableName(getTableName());
    UpdateTableResult result = client.updateTable(req);
    return tableDescription = result.getTableDescription();
  }
  
  public Index createGSI(CreateGlobalSecondaryIndexAction create, AttributeDefinition hashKeyDefinition)
  {
    return doCreateGSI(create, new AttributeDefinition[] { hashKeyDefinition });
  }
  
  public Index createGSI(CreateGlobalSecondaryIndexAction create, AttributeDefinition hashKeyDefinition, AttributeDefinition rangeKeyDefinition)
  {
    return doCreateGSI(create, new AttributeDefinition[] { hashKeyDefinition, rangeKeyDefinition });
  }
  
  private Index doCreateGSI(CreateGlobalSecondaryIndexAction create, AttributeDefinition... keyDefinitions)
  {
    UpdateTableSpec spec = new UpdateTableSpec().withAttributeDefinitions(keyDefinitions).withGlobalSecondaryIndexUpdates(new GlobalSecondaryIndexUpdate[] {new GlobalSecondaryIndexUpdate()
      .withCreate(create) });
    
    updateTable(spec);
    return getIndex(create.getIndexName());
  }
  
  public TableDescription updateTable(ProvisionedThroughput provisionedThroughput)
  {
    return updateTable(new UpdateTableSpec()
      .withProvisionedThroughput(provisionedThroughput));
  }
  
  public TableDescription waitForActive()
    throws InterruptedException
  {
    Waiter waiter = client.waiters().tableExists();
    try
    {
      waiter.run(new WaiterParameters(new DescribeTableRequest(tableName))
        .withPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(25), new FixedDelayStrategy(5))));
      return describe();
    }
    catch (Exception exception)
    {
      describe();
      throw new IllegalArgumentException("Table " + tableName + " did not transition into ACTIVE state.", exception);
    }
  }
  
  public void waitForDelete()
    throws InterruptedException
  {
    Waiter waiter = client.waiters().tableNotExists();
    try
    {
      waiter.run(new WaiterParameters(new DescribeTableRequest(tableName))
        .withPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(25), new FixedDelayStrategy(5))));
    }
    catch (Exception exception)
    {
      throw new IllegalArgumentException("Table " + tableName + " is not deleted.", exception);
    }
  }
  
  @Deprecated
  public TableDescription waitForActiveOrDelete()
    throws InterruptedException
  {
    try
    {
      for (;;)
      {
        TableDescription desc = describe();
        String status = desc.getTableStatus();
        if (TableStatus.fromValue(status) == TableStatus.ACTIVE) {
          return desc;
        }
        Thread.sleep(5000L);
      }
      return null;
    }
    catch (ResourceNotFoundException localResourceNotFoundException) {}
  }
  
  @Deprecated
  public TableDescription waitForAllActiveOrDelete()
    throws InterruptedException
  {
    try
    {
      for (;;)
      {
        TableDescription desc = describe();
        String status = desc.getTableStatus();
        if (TableStatus.fromValue(status) == TableStatus.ACTIVE)
        {
          List<GlobalSecondaryIndexDescription> descriptions = desc.getGlobalSecondaryIndexes();
          if (descriptions != null)
          {
            Iterator localIterator = descriptions.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label87;
              }
              GlobalSecondaryIndexDescription d = (GlobalSecondaryIndexDescription)localIterator.next();
              status = d.getIndexStatus();
              if (IndexStatus.fromValue(status) != IndexStatus.ACTIVE)
              {
                Thread.sleep(5000L);
                break;
              }
            }
          }
          label87:
          return desc;
        }
        Thread.sleep(5000L);
      }
      return null;
    }
    catch (ResourceNotFoundException localResourceNotFoundException) {}
  }
  
  public DeleteTableResult delete()
  {
    return client.deleteTable(tableName);
  }
  
  public Item getItem(KeyAttribute... primaryKeyComponents)
  {
    return getItemDelegate.getItem(primaryKeyComponents);
  }
  
  public Item getItem(PrimaryKey primaryKey)
  {
    return getItemDelegate.getItem(primaryKey);
  }
  
  public Item getItem(PrimaryKey primaryKey, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItem(primaryKey, projectionExpression, nameMap);
  }
  
  public Item getItem(GetItemSpec spec)
  {
    return getItemDelegate.getItem(spec);
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue)
  {
    return getItemDelegate.getItemOutcome(hashKeyName, hashKeyValue);
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return getItemDelegate.getItemOutcome(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue)
  {
    return getItemDelegate.getItem(hashKeyName, hashKeyValue);
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return getItemDelegate.getItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue, rangeKeyCondition);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, QueryFilter... queryFilters)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue, rangeKeyCondition, queryFilters);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue, rangeKeyCondition, filterExpression, nameMap, valueMap);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue, rangeKeyCondition, filterExpression, projectionExpression, nameMap, valueMap);
  }
  
  @Beta
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, QueryExpressionSpec queryExpressions)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue, rangeKeyCondition, queryExpressions
      .getFilterExpression(), queryExpressions
      .getProjectionExpression(), queryExpressions
      .getNameMap(), queryExpressions.getValueMap());
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, expected, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, expected, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, updateExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, updateExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, updateExpression, conditionExpression, nameMap, valueMap);
  }
  
  @Beta
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, UpdateItemExpressionSpec updateExpressions)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, updateExpressions
      .getUpdateExpression(), updateExpressions
      .getConditionExpression(), updateExpressions
      .getNameMap(), updateExpressions
      .getValueMap());
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, updateExpression, conditionExpression, nameMap, valueMap);
  }
  
  @Beta
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, UpdateItemExpressionSpec updateExpressions)
  {
    return updateItemDelegate.updateItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, updateExpressions
    
      .getUpdateExpression(), updateExpressions
      .getConditionExpression(), updateExpressions
      .getNameMap(), updateExpressions
      .getValueMap());
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItemOutcome(hashKeyName, hashKeyValue, projectionExpression, nameMap);
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItemOutcome(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, projectionExpression, nameMap);
  }
  
  @Beta
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, GetItemExpressionSpec projectionExpressions)
  {
    return getItemDelegate.getItemOutcome(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, projectionExpressions
    
      .getProjectionExpression(), projectionExpressions
      .getNameMap());
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItem(hashKeyName, hashKeyValue, projectionExpression, nameMap);
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemDelegate.getItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, projectionExpression, nameMap);
  }
  
  @Beta
  public Item getItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, GetItemExpressionSpec projectionExpressions)
  {
    return getItemDelegate.getItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, projectionExpressions
      .getProjectionExpression(), projectionExpressions
      .getNameMap());
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, Expected... expected)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, expected);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, Expected... expected)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, expected);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, conditionExpression, nameMap, valueMap);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, conditionExpression, nameMap, valueMap);
  }
  
  @Beta
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, DeleteItemExpressionSpec conditionExpressions)
  {
    return deleteItemDelegate.deleteItem(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue, conditionExpressions
    
      .getConditionExpression(), conditionExpressions
      .getNameMap(), conditionExpressions
      .getValueMap());
  }
  
  public String toString()
  {
    return "{" + tableName + ": " + tableDescription + "}";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */