package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBScanExpression
{
  private Map<String, Condition> scanFilter;
  private Map<String, AttributeValue> exclusiveStartKey;
  private Integer limit;
  private Integer totalSegments;
  private Integer segment;
  private String conditionalOperator;
  private String filterExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  private String select;
  private String projectionExpression;
  private String returnConsumedCapacity;
  private String indexName;
  private Boolean consistentRead;
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public DynamoDBScanExpression withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public Map<String, Condition> getScanFilter()
  {
    return scanFilter;
  }
  
  public void setScanFilter(Map<String, Condition> scanFilter)
  {
    this.scanFilter = scanFilter;
  }
  
  public DynamoDBScanExpression withScanFilter(Map<String, Condition> scanFilter)
  {
    setScanFilter(scanFilter);
    return this;
  }
  
  public void addFilterCondition(String attributeName, Condition condition)
  {
    if (scanFilter == null) {
      scanFilter = new HashMap();
    }
    scanFilter.put(attributeName, condition);
  }
  
  public DynamoDBScanExpression withFilterConditionEntry(String attributeName, Condition condition)
  {
    if (scanFilter == null) {
      scanFilter = new HashMap();
    }
    scanFilter.put(attributeName, condition);
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
  
  public DynamoDBScanExpression withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey)
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
  
  public DynamoDBScanExpression withLimit(Integer limit)
  {
    this.limit = limit;
    return this;
  }
  
  public Integer getTotalSegments()
  {
    return totalSegments;
  }
  
  public void setTotalSegments(Integer totalSegments)
  {
    this.totalSegments = totalSegments;
  }
  
  public DynamoDBScanExpression withTotalSegments(Integer totalSegments)
  {
    setTotalSegments(totalSegments);
    return this;
  }
  
  public Integer getSegment()
  {
    return segment;
  }
  
  public void setSegment(Integer segment)
  {
    this.segment = segment;
  }
  
  public DynamoDBScanExpression withSegment(Integer segment)
  {
    setSegment(segment);
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
  
  public DynamoDBScanExpression withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    setConditionalOperator(conditionalOperator.toString());
  }
  
  public DynamoDBScanExpression withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    return withConditionalOperator(conditionalOperator.toString());
  }
  
  public String getFilterExpression()
  {
    return filterExpression;
  }
  
  public void setFilterExpression(String filterExpression)
  {
    this.filterExpression = filterExpression;
  }
  
  public DynamoDBScanExpression withFilterExpression(String filterExpression)
  {
    this.filterExpression = filterExpression;
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
  
  public DynamoDBScanExpression withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public DynamoDBScanExpression addExpressionAttributeNamesEntry(String key, String value)
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
  
  public DynamoDBScanExpression clearExpressionAttributeNamesEntries()
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
  
  public DynamoDBScanExpression withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public DynamoDBScanExpression addExpressionAttributeValuesEntry(String key, AttributeValue value)
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
  
  public DynamoDBScanExpression clearExpressionAttributeValuesEntries()
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
  
  public DynamoDBScanExpression withSelect(String select)
  {
    this.select = select;
    return this;
  }
  
  public void setSelect(Select select)
  {
    this.select = select.toString();
  }
  
  public DynamoDBScanExpression withSelect(Select select)
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
  
  public DynamoDBScanExpression withProjectionExpression(String projectionExpression)
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
  
  public DynamoDBScanExpression withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
  }
  
  public DynamoDBScanExpression withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public void setConsistentRead(Boolean consistentRead)
  {
    this.consistentRead = consistentRead;
  }
  
  public DynamoDBScanExpression withConsistentRead(Boolean consistentRead)
  {
    this.consistentRead = consistentRead;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */