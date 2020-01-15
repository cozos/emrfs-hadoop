package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UpdateItemRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private Map<String, AttributeValue> key;
  private Map<String, AttributeValueUpdate> attributeUpdates;
  private Map<String, ExpectedAttributeValue> expected;
  private String conditionalOperator;
  private String returnValues;
  private String returnConsumedCapacity;
  private String returnItemCollectionMetrics;
  private String updateExpression;
  private String conditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  
  public UpdateItemRequest() {}
  
  public UpdateItemRequest(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates)
  {
    setTableName(tableName);
    setKey(key);
    setAttributeUpdates(attributeUpdates);
  }
  
  public UpdateItemRequest(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues)
  {
    setTableName(tableName);
    setKey(key);
    setAttributeUpdates(attributeUpdates);
    setReturnValues(returnValues);
  }
  
  public UpdateItemRequest(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, ReturnValue returnValues)
  {
    setTableName(tableName);
    setKey(key);
    setAttributeUpdates(attributeUpdates);
    setReturnValues(returnValues.toString());
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public UpdateItemRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public Map<String, AttributeValue> getKey()
  {
    return key;
  }
  
  public void setKey(Map<String, AttributeValue> key)
  {
    this.key = key;
  }
  
  public UpdateItemRequest withKey(Map<String, AttributeValue> key)
  {
    setKey(key);
    return this;
  }
  
  public UpdateItemRequest addKeyEntry(String key, AttributeValue value)
  {
    if (null == this.key) {
      this.key = new HashMap();
    }
    if (this.key.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    this.key.put(key, value);
    return this;
  }
  
  public UpdateItemRequest clearKeyEntries()
  {
    key = null;
    return this;
  }
  
  public Map<String, AttributeValueUpdate> getAttributeUpdates()
  {
    return attributeUpdates;
  }
  
  public void setAttributeUpdates(Map<String, AttributeValueUpdate> attributeUpdates)
  {
    this.attributeUpdates = attributeUpdates;
  }
  
  public UpdateItemRequest withAttributeUpdates(Map<String, AttributeValueUpdate> attributeUpdates)
  {
    setAttributeUpdates(attributeUpdates);
    return this;
  }
  
  public UpdateItemRequest addAttributeUpdatesEntry(String key, AttributeValueUpdate value)
  {
    if (null == attributeUpdates) {
      attributeUpdates = new HashMap();
    }
    if (attributeUpdates.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    attributeUpdates.put(key, value);
    return this;
  }
  
  public UpdateItemRequest clearAttributeUpdatesEntries()
  {
    attributeUpdates = null;
    return this;
  }
  
  public Map<String, ExpectedAttributeValue> getExpected()
  {
    return expected;
  }
  
  public void setExpected(Map<String, ExpectedAttributeValue> expected)
  {
    this.expected = expected;
  }
  
  public UpdateItemRequest withExpected(Map<String, ExpectedAttributeValue> expected)
  {
    setExpected(expected);
    return this;
  }
  
  public UpdateItemRequest addExpectedEntry(String key, ExpectedAttributeValue value)
  {
    if (null == expected) {
      expected = new HashMap();
    }
    if (expected.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    expected.put(key, value);
    return this;
  }
  
  public UpdateItemRequest clearExpectedEntries()
  {
    expected = null;
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
  
  public UpdateItemRequest withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    withConditionalOperator(conditionalOperator);
  }
  
  public UpdateItemRequest withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator.toString();
    return this;
  }
  
  public void setReturnValues(String returnValues)
  {
    this.returnValues = returnValues;
  }
  
  public String getReturnValues()
  {
    return returnValues;
  }
  
  public UpdateItemRequest withReturnValues(String returnValues)
  {
    setReturnValues(returnValues);
    return this;
  }
  
  public void setReturnValues(ReturnValue returnValues)
  {
    withReturnValues(returnValues);
  }
  
  public UpdateItemRequest withReturnValues(ReturnValue returnValues)
  {
    this.returnValues = returnValues.toString();
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
  
  public UpdateItemRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public UpdateItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
  
  public void setReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics;
  }
  
  public String getReturnItemCollectionMetrics()
  {
    return returnItemCollectionMetrics;
  }
  
  public UpdateItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    withReturnItemCollectionMetrics(returnItemCollectionMetrics);
  }
  
  public UpdateItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
    return this;
  }
  
  public void setUpdateExpression(String updateExpression)
  {
    this.updateExpression = updateExpression;
  }
  
  public String getUpdateExpression()
  {
    return updateExpression;
  }
  
  public UpdateItemRequest withUpdateExpression(String updateExpression)
  {
    setUpdateExpression(updateExpression);
    return this;
  }
  
  public void setConditionExpression(String conditionExpression)
  {
    this.conditionExpression = conditionExpression;
  }
  
  public String getConditionExpression()
  {
    return conditionExpression;
  }
  
  public UpdateItemRequest withConditionExpression(String conditionExpression)
  {
    setConditionExpression(conditionExpression);
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
  
  public UpdateItemRequest withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public UpdateItemRequest addExpressionAttributeNamesEntry(String key, String value)
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
  
  public UpdateItemRequest clearExpressionAttributeNamesEntries()
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
  
  public UpdateItemRequest withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public UpdateItemRequest addExpressionAttributeValuesEntry(String key, AttributeValue value)
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
  
  public UpdateItemRequest clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
  
  public void setKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
    throws IllegalArgumentException
  {
    HashMap<String, AttributeValue> key = new HashMap();
    if (hashKey != null) {
      key.put(hashKey.getKey(), hashKey.getValue());
    } else {
      throw new IllegalArgumentException("hashKey must be non-null object.");
    }
    if (rangeKey != null) {
      key.put(rangeKey.getKey(), rangeKey.getValue());
    }
    setKey(key);
  }
  
  public UpdateItemRequest withKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
    throws IllegalArgumentException
  {
    setKey(hashKey, rangeKey);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getKey() != null) {
      sb.append("Key: ").append(getKey()).append(",");
    }
    if (getAttributeUpdates() != null) {
      sb.append("AttributeUpdates: ").append(getAttributeUpdates()).append(",");
    }
    if (getExpected() != null) {
      sb.append("Expected: ").append(getExpected()).append(",");
    }
    if (getConditionalOperator() != null) {
      sb.append("ConditionalOperator: ").append(getConditionalOperator()).append(",");
    }
    if (getReturnValues() != null) {
      sb.append("ReturnValues: ").append(getReturnValues()).append(",");
    }
    if (getReturnConsumedCapacity() != null) {
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity()).append(",");
    }
    if (getReturnItemCollectionMetrics() != null) {
      sb.append("ReturnItemCollectionMetrics: ").append(getReturnItemCollectionMetrics()).append(",");
    }
    if (getUpdateExpression() != null) {
      sb.append("UpdateExpression: ").append(getUpdateExpression()).append(",");
    }
    if (getConditionExpression() != null) {
      sb.append("ConditionExpression: ").append(getConditionExpression()).append(",");
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
    if (!(obj instanceof UpdateItemRequest)) {
      return false;
    }
    UpdateItemRequest other = (UpdateItemRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKey() != null) && (!other.getKey().equals(getKey()))) {
      return false;
    }
    if (((other.getAttributeUpdates() == null ? 1 : 0) ^ (getAttributeUpdates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeUpdates() != null) && (!other.getAttributeUpdates().equals(getAttributeUpdates()))) {
      return false;
    }
    if (((other.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpected() != null) && (!other.getExpected().equals(getExpected()))) {
      return false;
    }
    if (((other.getConditionalOperator() == null ? 1 : 0) ^ (getConditionalOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConditionalOperator() != null) && (!other.getConditionalOperator().equals(getConditionalOperator()))) {
      return false;
    }
    if (((other.getReturnValues() == null ? 1 : 0) ^ (getReturnValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnValues() != null) && (!other.getReturnValues().equals(getReturnValues()))) {
      return false;
    }
    if (((other.getReturnConsumedCapacity() == null ? 1 : 0) ^ (getReturnConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnConsumedCapacity() != null) && (!other.getReturnConsumedCapacity().equals(getReturnConsumedCapacity()))) {
      return false;
    }
    if (((other.getReturnItemCollectionMetrics() == null ? 1 : 0) ^ (getReturnItemCollectionMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnItemCollectionMetrics() != null) && (!other.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics()))) {
      return false;
    }
    if (((other.getUpdateExpression() == null ? 1 : 0) ^ (getUpdateExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUpdateExpression() != null) && (!other.getUpdateExpression().equals(getUpdateExpression()))) {
      return false;
    }
    if (((other.getConditionExpression() == null ? 1 : 0) ^ (getConditionExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConditionExpression() != null) && (!other.getConditionExpression().equals(getConditionExpression()))) {
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
    hashCode = 31 * hashCode + (getKey() == null ? 0 : getKey().hashCode());
    hashCode = 31 * hashCode + (getAttributeUpdates() == null ? 0 : getAttributeUpdates().hashCode());
    hashCode = 31 * hashCode + (getExpected() == null ? 0 : getExpected().hashCode());
    hashCode = 31 * hashCode + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode());
    hashCode = 31 * hashCode + (getReturnValues() == null ? 0 : getReturnValues().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getReturnItemCollectionMetrics() == null ? 0 : getReturnItemCollectionMetrics().hashCode());
    hashCode = 31 * hashCode + (getUpdateExpression() == null ? 0 : getUpdateExpression().hashCode());
    hashCode = 31 * hashCode + (getConditionExpression() == null ? 0 : getConditionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeValues() == null ? 0 : getExpressionAttributeValues().hashCode());
    return hashCode;
  }
  
  public UpdateItemRequest clone()
  {
    return (UpdateItemRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */