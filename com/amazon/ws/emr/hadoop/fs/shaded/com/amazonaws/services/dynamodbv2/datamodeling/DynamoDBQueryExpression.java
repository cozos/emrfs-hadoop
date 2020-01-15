package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBQueryExpression<T>
{
  private boolean consistentRead = true;
  private boolean scanIndexForward = true;
  private T hashKeyValues;
  private Map<String, Condition> rangeKeyConditions;
  private Map<String, AttributeValue> exclusiveStartKey;
  private Integer limit;
  private String indexName;
  private Map<String, Condition> queryFilter;
  private String conditionalOperator;
  private String filterExpression;
  private String keyConditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  private String select;
  private String projectionExpression;
  private String returnConsumedCapacity;
  
  public boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public void setConsistentRead(boolean consistentRead)
  {
    this.consistentRead = consistentRead;
  }
  
  public DynamoDBQueryExpression<T> withConsistentRead(boolean consistentRead)
  {
    this.consistentRead = consistentRead;
    return this;
  }
  
  public boolean isScanIndexForward()
  {
    return scanIndexForward;
  }
  
  public void setScanIndexForward(boolean scanIndexForward)
  {
    this.scanIndexForward = scanIndexForward;
  }
  
  public DynamoDBQueryExpression<T> withScanIndexForward(boolean scanIndexForward)
  {
    this.scanIndexForward = scanIndexForward;
    return this;
  }
  
  public Map<String, AttributeValue> getExclusiveStartKey()
  {
    return exclusiveStartKey;
  }
  
  public void setExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey)
  {
    this.exclusiveStartKey = exclusiveStartKey;
  }
  
  public DynamoDBQueryExpression<T> withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey)
  {
    this.exclusiveStartKey = exclusiveStartKey;
    return this;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public DynamoDBQueryExpression<T> withLimit(Integer limit)
  {
    this.limit = limit;
    return this;
  }
  
  public T getHashKeyValues()
  {
    return (T)hashKeyValues;
  }
  
  public void setHashKeyValues(T hashKeyValues)
  {
    this.hashKeyValues = hashKeyValues;
  }
  
  public DynamoDBQueryExpression<T> withHashKeyValues(T hashKObject)
  {
    setHashKeyValues(hashKObject);
    return this;
  }
  
  public Map<String, Condition> getRangeKeyConditions()
  {
    return rangeKeyConditions;
  }
  
  public void setRangeKeyConditions(Map<String, Condition> rangeKeyConditions)
  {
    this.rangeKeyConditions = rangeKeyConditions;
  }
  
  public DynamoDBQueryExpression<T> withRangeKeyConditions(Map<String, Condition> rangeKeyConditions)
  {
    setRangeKeyConditions(rangeKeyConditions);
    return this;
  }
  
  public DynamoDBQueryExpression<T> withRangeKeyCondition(String rangeKeyAttributeName, Condition rangeKeyCondition)
  {
    if (rangeKeyConditions == null) {
      rangeKeyConditions = new HashMap();
    }
    rangeKeyConditions.put(rangeKeyAttributeName, rangeKeyCondition);
    return this;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public DynamoDBQueryExpression<T> withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public Map<String, Condition> getQueryFilter()
  {
    return queryFilter;
  }
  
  public void setQueryFilter(Map<String, Condition> queryFilter)
  {
    this.queryFilter = queryFilter;
  }
  
  public DynamoDBQueryExpression<T> withQueryFilter(Map<String, Condition> queryFilter)
  {
    setQueryFilter(queryFilter);
    return this;
  }
  
  public DynamoDBQueryExpression<T> withQueryFilterEntry(String attributeName, Condition condition)
  {
    if (queryFilter == null) {
      queryFilter = new HashMap();
    }
    queryFilter.put(attributeName, condition);
    return this;
  }
  
  public String getConditionalOperator()
  {
    return conditionalOperator;
  }
  
  public void setConditionalOperator(String conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator;
  }
  
  public DynamoDBQueryExpression<T> withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator.toString();
  }
  
  public DynamoDBQueryExpression<T> withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public String getFilterExpression()
  {
    return filterExpression;
  }
  
  public void setFilterExpression(String filterExpression)
  {
    this.filterExpression = filterExpression;
  }
  
  public DynamoDBQueryExpression<T> withFilterExpression(String filterExpression)
  {
    this.filterExpression = filterExpression;
    return this;
  }
  
  public String getKeyConditionExpression()
  {
    return keyConditionExpression;
  }
  
  public void setKeyConditionExpression(String keyConditionExpression)
  {
    this.keyConditionExpression = keyConditionExpression;
  }
  
  public DynamoDBQueryExpression<T> withKeyConditionExpression(String keyConditionExpression)
  {
    this.keyConditionExpression = keyConditionExpression;
    return this;
  }
  
  public Map<String, String> getExpressionAttributeNames()
  {
    return expressionAttributeNames;
  }
  
  public void setExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    this.expressionAttributeNames = expressionAttributeNames;
  }
  
  public DynamoDBQueryExpression<T> withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public DynamoDBQueryExpression<T> addExpressionAttributeNamesEntry(String key, String value)
  {
    if (null == expressionAttributeNames) {
      expressionAttributeNames = new HashMap();
    }
    if (expressionAttributeNames.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    expressionAttributeNames.put(key, value);
    return this;
  }
  
  public DynamoDBQueryExpression<T> clearExpressionAttributeNamesEntries()
  {
    expressionAttributeNames = null;
    return this;
  }
  
  public Map<String, AttributeValue> getExpressionAttributeValues()
  {
    return expressionAttributeValues;
  }
  
  public void setExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    this.expressionAttributeValues = expressionAttributeValues;
  }
  
  public DynamoDBQueryExpression<T> withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public DynamoDBQueryExpression<T> addExpressionAttributeValuesEntry(String key, AttributeValue value)
  {
    if (null == expressionAttributeValues) {
      expressionAttributeValues = new HashMap();
    }
    if (expressionAttributeValues.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    expressionAttributeValues.put(key, value);
    return this;
  }
  
  public DynamoDBQueryExpression<T> clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
  
  public String getSelect()
  {
    return select;
  }
  
  public void setSelect(String select)
  {
    this.select = select;
  }
  
  public DynamoDBQueryExpression<T> withSelect(String select)
  {
    this.select = select;
    return this;
  }
  
  public void setSelect(Select select)
  {
    this.select = select.toString();
  }
  
  public DynamoDBQueryExpression<T> withSelect(Select select)
  {
    this.select = select.toString();
    return this;
  }
  
  public String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public void setProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
  }
  
  public DynamoDBQueryExpression<T> withProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return returnConsumedCapacity;
  }
  
  public void setReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
  }
  
  public DynamoDBQueryExpression<T> withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
  }
  
  public DynamoDBQueryExpression<T> withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */