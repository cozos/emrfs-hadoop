package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.QueryApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ScanApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.IndexQueryImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.IndexScanImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ScanImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateTableSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteGlobalSecondaryIndexAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.IndexStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalSecondaryIndexAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.QueryExpressionSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ScanExpressionSpec;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class Index
  implements QueryApi, ScanApi
{
  private static final long SLEEP_TIME_MILLIS = 5000L;
  private final Table table;
  private final String indexName;
  private final QueryApi queryDelegate;
  private final ScanImpl scanDelegate;
  
  Index(AmazonDynamoDB client, String indexName, Table table)
  {
    if (client == null) {
      throw new IllegalArgumentException("client must be specified");
    }
    if ((indexName == null) || (indexName.trim().length() == 0)) {
      throw new IllegalArgumentException("index name must not be null or empty");
    }
    if (table == null) {
      throw new IllegalArgumentException("table must be specified");
    }
    this.table = table;
    this.indexName = indexName;
    queryDelegate = new IndexQueryImpl(client, this);
    scanDelegate = new IndexScanImpl(client, this);
  }
  
  public final Table getTable()
  {
    return table;
  }
  
  public final String getIndexName()
  {
    return indexName;
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, QueryFilter... queryFilters)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, queryFilters);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, filterExpression, nameMap, valueMap);
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String projectionExpression, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, projectionExpression, filterExpression, nameMap, valueMap);
  }
  
  @Beta
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, QueryExpressionSpec queryExpressions)
  {
    return queryDelegate.query(hashKey, rangeKeyCondition, queryExpressions
      .getProjectionExpression(), queryExpressions
      .getFilterExpression(), queryExpressions
      .getNameMap(), queryExpressions.getValueMap());
  }
  
  public ItemCollection<QueryOutcome> query(QuerySpec spec)
  {
    return queryDelegate.query(spec);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue)
  {
    return queryDelegate.query(hashKeyName, hashKeyValue);
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
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey)
  {
    return queryDelegate.query(hashKey);
  }
  
  public TableDescription updateGSI(ProvisionedThroughput provisionedThroughput)
  {
    return table.updateTable(new UpdateTableSpec()
      .withGlobalSecondaryIndexUpdates(new GlobalSecondaryIndexUpdate[] {new GlobalSecondaryIndexUpdate()
      .withUpdate(new UpdateGlobalSecondaryIndexAction()
      
      .withIndexName(indexName)
      .withProvisionedThroughput(provisionedThroughput)) }));
  }
  
  public TableDescription deleteGSI()
  {
    return table.updateTable(new UpdateTableSpec()
      .withGlobalSecondaryIndexUpdates(new GlobalSecondaryIndexUpdate[] {new GlobalSecondaryIndexUpdate()
      .withDelete(new DeleteGlobalSecondaryIndexAction()
      
      .withIndexName(indexName)) }));
  }
  
  public TableDescription waitForActive()
    throws InterruptedException
  {
    Table table = getTable();
    String tableName = table.getTableName();
    String indexName = getIndexName();
    
    TableDescription desc = table.waitForActive();
    List<GlobalSecondaryIndexDescription> list = desc.getGlobalSecondaryIndexes();
    if (list != null)
    {
      Iterator localIterator = list.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label180;
        }
        GlobalSecondaryIndexDescription d = (GlobalSecondaryIndexDescription)localIterator.next();
        if (d.getIndexName().equals(indexName))
        {
          String status = d.getIndexStatus();
          switch (IndexStatus.fromValue(status))
          {
          case ACTIVE: 
            return desc;
          case CREATING: 
          case UPDATING: 
            Thread.sleep(5000L);
            break;
          default: 
            throw new IllegalArgumentException("Global Secondary Index " + indexName + " is not being created or updated (with status=" + status + ")");
          }
        }
      }
    }
    label180:
    throw new IllegalArgumentException("Global Secondary Index " + indexName + " does not exist in Table " + tableName + ")");
  }
  
  public TableDescription waitForDelete()
    throws InterruptedException
  {
    String indexName = getIndexName();
    
    TableDescription desc = getTable().waitForActive();
    List<GlobalSecondaryIndexDescription> list = desc.getGlobalSecondaryIndexes();
    if (list != null)
    {
      Iterator localIterator = list.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return desc;
        }
        GlobalSecondaryIndexDescription d = (GlobalSecondaryIndexDescription)localIterator.next();
        if (d.getIndexName().equals(indexName))
        {
          String status = d.getIndexStatus();
          if (IndexStatus.fromValue(status) == IndexStatus.DELETING)
          {
            Thread.sleep(5000L);
            break;
          }
          throw new IllegalArgumentException("Global Secondary Index " + indexName + " is not being deleted (with status=" + status + ")");
        }
      }
    }
    return desc;
  }
  
  public TableDescription waitForActiveOrDelete()
    throws InterruptedException
  {
    Table table = getTable();
    String indexName = getIndexName();
    
    TableDescription desc = table.waitForActive();
    List<GlobalSecondaryIndexDescription> list = desc.getGlobalSecondaryIndexes();
    if (list != null)
    {
      Iterator localIterator = desc.getGlobalSecondaryIndexes().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return desc;
        }
        GlobalSecondaryIndexDescription d = (GlobalSecondaryIndexDescription)localIterator.next();
        if (d.getIndexName().equals(indexName))
        {
          String status = d.getIndexStatus();
          if (IndexStatus.fromValue(status) == IndexStatus.ACTIVE) {
            return desc;
          }
          Thread.sleep(5000L);
          break;
        }
      }
    }
    return desc;
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
  
  @Beta
  public ItemCollection<ScanOutcome> scan(ScanExpressionSpec xspec)
  {
    return scanDelegate.scan(xspec.getFilterExpression(), xspec
      .getProjectionExpression(), xspec
      .getNameMap(), xspec
      .getValueMap());
  }
  
  public ItemCollection<ScanOutcome> scan(ScanSpec params)
  {
    return scanDelegate.scan(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Index
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */