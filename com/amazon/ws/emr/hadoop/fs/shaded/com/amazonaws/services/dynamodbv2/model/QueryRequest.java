package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class QueryRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private String indexName;
  private String select;
  private List<String> attributesToGet;
  private Integer limit;
  private Boolean consistentRead;
  private Map<String, Condition> keyConditions;
  private Map<String, Condition> queryFilter;
  private String conditionalOperator;
  private Boolean scanIndexForward;
  private Map<String, AttributeValue> exclusiveStartKey;
  private String returnConsumedCapacity;
  private String projectionExpression;
  private String filterExpression;
  private String keyConditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  
  public QueryRequest() {}
  
  public QueryRequest(String tableName)
  {
    setTableName(tableName);
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public QueryRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public QueryRequest withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public void setSelect(String select)
  {
    this.select = select;
  }
  
  public String getSelect()
  {
    return select;
  }
  
  public QueryRequest withSelect(String select)
  {
    setSelect(select);
    return this;
  }
  
  public void setSelect(Select select)
  {
    withSelect(select);
  }
  
  public QueryRequest withSelect(Select select)
  {
    this.select = select.toString();
    return this;
  }
  
  public List<String> getAttributesToGet()
  {
    return attributesToGet;
  }
  
  public void setAttributesToGet(Collection<String> attributesToGet)
  {
    if (attributesToGet == null)
    {
      this.attributesToGet = null;
      return;
    }
    this.attributesToGet = new ArrayList(attributesToGet);
  }
  
  public QueryRequest withAttributesToGet(String... attributesToGet)
  {
    if (this.attributesToGet == null) {
      setAttributesToGet(new ArrayList(attributesToGet.length));
    }
    for (String ele : attributesToGet) {
      this.attributesToGet.add(ele);
    }
    return this;
  }
  
  public QueryRequest withAttributesToGet(Collection<String> attributesToGet)
  {
    setAttributesToGet(attributesToGet);
    return this;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public QueryRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void setConsistentRead(Boolean consistentRead)
  {
    this.consistentRead = consistentRead;
  }
  
  public Boolean getConsistentRead()
  {
    return consistentRead;
  }
  
  public QueryRequest withConsistentRead(Boolean consistentRead)
  {
    setConsistentRead(consistentRead);
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public Map<String, Condition> getKeyConditions()
  {
    return keyConditions;
  }
  
  public void setKeyConditions(Map<String, Condition> keyConditions)
  {
    this.keyConditions = keyConditions;
  }
  
  public QueryRequest withKeyConditions(Map<String, Condition> keyConditions)
  {
    setKeyConditions(keyConditions);
    return this;
  }
  
  public QueryRequest addKeyConditionsEntry(String key, Condition value)
  {
    if (null == keyConditions) {
      keyConditions = new HashMap();
    }
    if (keyConditions.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    keyConditions.put(key, value);
    return this;
  }
  
  public QueryRequest clearKeyConditionsEntries()
  {
    keyConditions = null;
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
  
  public QueryRequest withQueryFilter(Map<String, Condition> queryFilter)
  {
    setQueryFilter(queryFilter);
    return this;
  }
  
  public QueryRequest addQueryFilterEntry(String key, Condition value)
  {
    if (null == queryFilter) {
      queryFilter = new HashMap();
    }
    if (queryFilter.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    queryFilter.put(key, value);
    return this;
  }
  
  public QueryRequest clearQueryFilterEntries()
  {
    queryFilter = null;
    return this;
  }
  
  public void setConditionalOperator(String conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator;
  }
  
  public String getConditionalOperator()
  {
    return conditionalOperator;
  }
  
  public QueryRequest withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    withConditionalOperator(conditionalOperator);
  }
  
  public QueryRequest withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator.toString();
    return this;
  }
  
  public void setScanIndexForward(Boolean scanIndexForward)
  {
    this.scanIndexForward = scanIndexForward;
  }
  
  public Boolean getScanIndexForward()
  {
    return scanIndexForward;
  }
  
  public QueryRequest withScanIndexForward(Boolean scanIndexForward)
  {
    setScanIndexForward(scanIndexForward);
    return this;
  }
  
  public Boolean isScanIndexForward()
  {
    return scanIndexForward;
  }
  
  public Map<String, AttributeValue> getExclusiveStartKey()
  {
    return exclusiveStartKey;
  }
  
  public void setExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey)
  {
    this.exclusiveStartKey = exclusiveStartKey;
  }
  
  public QueryRequest withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey)
  {
    setExclusiveStartKey(exclusiveStartKey);
    return this;
  }
  
  public QueryRequest addExclusiveStartKeyEntry(String key, AttributeValue value)
  {
    if (null == exclusiveStartKey) {
      exclusiveStartKey = new HashMap();
    }
    if (exclusiveStartKey.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    exclusiveStartKey.put(key, value);
    return this;
  }
  
  public QueryRequest clearExclusiveStartKeyEntries()
  {
    exclusiveStartKey = null;
    return this;
  }
  
  public void setReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
  }
  
  public String getReturnConsumedCapacity()
  {
    return returnConsumedCapacity;
  }
  
  public QueryRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public QueryRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
  
  public void setProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
  }
  
  public String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public QueryRequest withProjectionExpression(String projectionExpression)
  {
    setProjectionExpression(projectionExpression);
    return this;
  }
  
  public void setFilterExpression(String filterExpression)
  {
    this.filterExpression = filterExpression;
  }
  
  public String getFilterExpression()
  {
    return filterExpression;
  }
  
  public QueryRequest withFilterExpression(String filterExpression)
  {
    setFilterExpression(filterExpression);
    return this;
  }
  
  public void setKeyConditionExpression(String keyConditionExpression)
  {
    this.keyConditionExpression = keyConditionExpression;
  }
  
  public String getKeyConditionExpression()
  {
    return keyConditionExpression;
  }
  
  public QueryRequest withKeyConditionExpression(String keyConditionExpression)
  {
    setKeyConditionExpression(keyConditionExpression);
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
  
  public QueryRequest withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public QueryRequest addExpressionAttributeNamesEntry(String key, String value)
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
  
  public QueryRequest clearExpressionAttributeNamesEntries()
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
  
  public QueryRequest withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public QueryRequest addExpressionAttributeValuesEntry(String key, AttributeValue value)
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
  
  public QueryRequest clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
  
  public void setExclusiveStartKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
    throws IllegalArgumentException
  {
    HashMap<String, AttributeValue> exclusiveStartKey = new HashMap();
    if (hashKey != null) {
      exclusiveStartKey.put(hashKey.getKey(), hashKey.getValue());
    } else {
      throw new IllegalArgumentException("hashKey must be non-null object.");
    }
    if (rangeKey != null) {
      exclusiveStartKey.put(rangeKey.getKey(), rangeKey.getValue());
    }
    setExclusiveStartKey(exclusiveStartKey);
  }
  
  public QueryRequest withExclusiveStartKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
    throws IllegalArgumentException
  {
    setExclusiveStartKey(hashKey, rangeKey);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getIndexName() != null) {
      sb.append("IndexName: ").append(getIndexName()).append(",");
    }
    if (getSelect() != null) {
      sb.append("Select: ").append(getSelect()).append(",");
    }
    if (getAttributesToGet() != null) {
      sb.append("AttributesToGet: ").append(getAttributesToGet()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getConsistentRead() != null) {
      sb.append("ConsistentRead: ").append(getConsistentRead()).append(",");
    }
    if (getKeyConditions() != null) {
      sb.append("KeyConditions: ").append(getKeyConditions()).append(",");
    }
    if (getQueryFilter() != null) {
      sb.append("QueryFilter: ").append(getQueryFilter()).append(",");
    }
    if (getConditionalOperator() != null) {
      sb.append("ConditionalOperator: ").append(getConditionalOperator()).append(",");
    }
    if (getScanIndexForward() != null) {
      sb.append("ScanIndexForward: ").append(getScanIndexForward()).append(",");
    }
    if (getExclusiveStartKey() != null) {
      sb.append("ExclusiveStartKey: ").append(getExclusiveStartKey()).append(",");
    }
    if (getReturnConsumedCapacity() != null) {
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity()).append(",");
    }
    if (getProjectionExpression() != null) {
      sb.append("ProjectionExpression: ").append(getProjectionExpression()).append(",");
    }
    if (getFilterExpression() != null) {
      sb.append("FilterExpression: ").append(getFilterExpression()).append(",");
    }
    if (getKeyConditionExpression() != null) {
      sb.append("KeyConditionExpression: ").append(getKeyConditionExpression()).append(",");
    }
    if (getExpressionAttributeNames() != null) {
      sb.append("ExpressionAttributeNames: ").append(getExpressionAttributeNames()).append(",");
    }
    if (getExpressionAttributeValues() != null) {
      sb.append("ExpressionAttributeValues: ").append(getExpressionAttributeValues());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof QueryRequest)) {
      return false;
    }
    QueryRequest other = (QueryRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getIndexName() == null ? 1 : 0) ^ (getIndexName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexName() != null) && (!other.getIndexName().equals(getIndexName()))) {
      return false;
    }
    if (((other.getSelect() == null ? 1 : 0) ^ (getSelect() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSelect() != null) && (!other.getSelect().equals(getSelect()))) {
      return false;
    }
    if (((other.getAttributesToGet() == null ? 1 : 0) ^ (getAttributesToGet() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributesToGet() != null) && (!other.getAttributesToGet().equals(getAttributesToGet()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    if (((other.getConsistentRead() == null ? 1 : 0) ^ (getConsistentRead() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConsistentRead() != null) && (!other.getConsistentRead().equals(getConsistentRead()))) {
      return false;
    }
    if (((other.getKeyConditions() == null ? 1 : 0) ^ (getKeyConditions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyConditions() != null) && (!other.getKeyConditions().equals(getKeyConditions()))) {
      return false;
    }
    if (((other.getQueryFilter() == null ? 1 : 0) ^ (getQueryFilter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueryFilter() != null) && (!other.getQueryFilter().equals(getQueryFilter()))) {
      return false;
    }
    if (((other.getConditionalOperator() == null ? 1 : 0) ^ (getConditionalOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConditionalOperator() != null) && (!other.getConditionalOperator().equals(getConditionalOperator()))) {
      return false;
    }
    if (((other.getScanIndexForward() == null ? 1 : 0) ^ (getScanIndexForward() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScanIndexForward() != null) && (!other.getScanIndexForward().equals(getScanIndexForward()))) {
      return false;
    }
    if (((other.getExclusiveStartKey() == null ? 1 : 0) ^ (getExclusiveStartKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartKey() != null) && (!other.getExclusiveStartKey().equals(getExclusiveStartKey()))) {
      return false;
    }
    if (((other.getReturnConsumedCapacity() == null ? 1 : 0) ^ (getReturnConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnConsumedCapacity() != null) && (!other.getReturnConsumedCapacity().equals(getReturnConsumedCapacity()))) {
      return false;
    }
    if (((other.getProjectionExpression() == null ? 1 : 0) ^ (getProjectionExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProjectionExpression() != null) && (!other.getProjectionExpression().equals(getProjectionExpression()))) {
      return false;
    }
    if (((other.getFilterExpression() == null ? 1 : 0) ^ (getFilterExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFilterExpression() != null) && (!other.getFilterExpression().equals(getFilterExpression()))) {
      return false;
    }
    if (((other.getKeyConditionExpression() == null ? 1 : 0) ^ (getKeyConditionExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyConditionExpression() != null) && (!other.getKeyConditionExpression().equals(getKeyConditionExpression()))) {
      return false;
    }
    if (((other.getExpressionAttributeNames() == null ? 1 : 0) ^ (getExpressionAttributeNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpressionAttributeNames() != null) && (!other.getExpressionAttributeNames().equals(getExpressionAttributeNames()))) {
      return false;
    }
    if (((other.getExpressionAttributeValues() == null ? 1 : 0) ^ (getExpressionAttributeValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpressionAttributeValues() != null) && (!other.getExpressionAttributeValues().equals(getExpressionAttributeValues()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getIndexName() == null ? 0 : getIndexName().hashCode());
    hashCode = 31 * hashCode + (getSelect() == null ? 0 : getSelect().hashCode());
    hashCode = 31 * hashCode + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode());
    hashCode = 31 * hashCode + (getKeyConditions() == null ? 0 : getKeyConditions().hashCode());
    hashCode = 31 * hashCode + (getQueryFilter() == null ? 0 : getQueryFilter().hashCode());
    hashCode = 31 * hashCode + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode());
    hashCode = 31 * hashCode + (getScanIndexForward() == null ? 0 : getScanIndexForward().hashCode());
    hashCode = 31 * hashCode + (getExclusiveStartKey() == null ? 0 : getExclusiveStartKey().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode());
    hashCode = 31 * hashCode + (getFilterExpression() == null ? 0 : getFilterExpression().hashCode());
    hashCode = 31 * hashCode + (getKeyConditionExpression() == null ? 0 : getKeyConditionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeValues() == null ? 0 : getExpressionAttributeValues().hashCode());
    return hashCode;
  }
  
  public QueryRequest clone()
  {
    return (QueryRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */