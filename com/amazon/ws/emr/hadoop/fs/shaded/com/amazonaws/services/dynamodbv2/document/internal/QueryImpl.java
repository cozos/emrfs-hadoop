package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyConditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.RangeKeyCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.QueryApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import java.util.Collection;
import java.util.Map;

public class QueryImpl
  extends AbstractImpl
  implements QueryApi
{
  public QueryImpl(AmazonDynamoDB client, Table table)
  {
    super(client, table);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKey)
  {
    return doQuery(new QuerySpec()
      .withHashKey(new KeyAttribute(hashKeyName, hashKey)));
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey)
  {
    return doQuery(new QuerySpec().withHashKey(hashKey));
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition)
  {
    return doQuery(new QuerySpec().withHashKey(hashKey)
      .withRangeKeyCondition(rangeKeyCondition));
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, QueryFilter... queryFilters)
  {
    return doQuery(new QuerySpec().withHashKey(hashKey)
      .withRangeKeyCondition(rangeKeyCondition)
      .withQueryFilters(queryFilters));
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doQuery(new QuerySpec().withHashKey(hashKey)
      .withRangeKeyCondition(rangeKeyCondition)
      .withFilterExpression(filterExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public ItemCollection<QueryOutcome> query(KeyAttribute hashKey, RangeKeyCondition rangeKeyCondition, String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doQuery(new QuerySpec().withHashKey(hashKey)
      .withRangeKeyCondition(rangeKeyCondition)
      .withFilterExpression(filterExpression)
      .withProjectionExpression(projectionExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public ItemCollection<QueryOutcome> query(QuerySpec spec)
  {
    return doQuery(spec);
  }
  
  protected ItemCollection<QueryOutcome> doQuery(QuerySpec spec)
  {
    String tableName = getTable().getTableName();
    QueryRequest req = ((QueryRequest)spec.getRequest()).withTableName(tableName);
    
    KeyAttribute hashKey = spec.getHashKey();
    if (hashKey != null) {
      addHashKeyCondition(req, hashKey);
    }
    RangeKeyCondition rangeKeyCond = spec.getRangeKeyCondition();
    if (rangeKeyCond != null) {
      addRangeKeyCondition(req, rangeKeyCond);
    }
    Collection<QueryFilter> filters = spec.getQueryFilters();
    if (filters != null) {
      req.setQueryFilter(InternalUtils.toAttributeConditionMap(filters));
    }
    Collection<KeyAttribute> startKey = spec.getExclusiveStartKey();
    if (startKey != null) {
      req.setExclusiveStartKey(InternalUtils.toAttributeValueMap(startKey));
    }
    Map<String, AttributeValue> attrValMap = InternalUtils.fromSimpleMap(spec.getValueMap());
    
    req.withExpressionAttributeNames(spec.getNameMap())
      .withExpressionAttributeValues(attrValMap);
    
    return new QueryCollection(getClient(), spec);
  }
  
  private void addHashKeyCondition(QueryRequest req, KeyAttribute hashKey)
  {
    addKeyCondition(req, hashKey.getName(), ComparisonOperator.EQ, new AttributeValue[] { InternalUtils.toAttributeValue(hashKey.getValue()) });
  }
  
  private void addRangeKeyCondition(QueryRequest req, RangeKeyCondition rangeKeyCond)
  {
    KeyConditions keyCond = rangeKeyCond.getKeyCondition();
    if (keyCond == null) {
      throw new IllegalArgumentException("key condition not specified in range key condition");
    }
    Object[] values = rangeKeyCond.getValues();
    if (values == null) {
      throw new IllegalArgumentException("key condition values not specified in range key condition");
    }
    addKeyCondition(req, rangeKeyCond.getAttrName(), keyCond.toComparisonOperator(), InternalUtils.toAttributeValues(values));
  }
  
  private void addKeyCondition(QueryRequest req, String keyName, ComparisonOperator comparison, AttributeValue... values)
  {
    Map<String, Condition> currentConditions = req.getKeyConditions();
    Condition currentCondition = currentConditions == null ? null : (Condition)currentConditions.get(keyName);
    
    Condition newCondition = new Condition().withComparisonOperator(comparison).withAttributeValueList(values);
    if (currentCondition == null) {
      req.addKeyConditionsEntry(keyName, newCondition);
    } else if (!currentCondition.equals(newCondition)) {
      throw new IllegalArgumentException("a different condition was specified for '" + keyName + "' in the query spec and the query request");
    }
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition)
  {
    return query(new KeyAttribute(hashKeyName, hashKeyValue), rangeKeyCondition);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, QueryFilter... queryFilters)
  {
    return query(new KeyAttribute(hashKeyName, hashKeyValue), rangeKeyCondition, queryFilters);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return query(new KeyAttribute(hashKeyName, hashKeyValue), rangeKeyCondition, filterExpression, nameMap, valueMap);
  }
  
  public ItemCollection<QueryOutcome> query(String hashKeyName, Object hashKeyValue, RangeKeyCondition rangeKeyCondition, String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return query(new KeyAttribute(hashKeyName, hashKeyValue), rangeKeyCondition, filterExpression, projectionExpression, nameMap, valueMap);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.QueryImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */