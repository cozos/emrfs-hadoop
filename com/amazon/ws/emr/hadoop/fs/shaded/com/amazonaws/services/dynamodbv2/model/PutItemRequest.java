package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PutItemRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private Map<String, AttributeValue> item;
  private Map<String, ExpectedAttributeValue> expected;
  private String returnValues;
  private String returnConsumedCapacity;
  private String returnItemCollectionMetrics;
  private String conditionalOperator;
  private String conditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  
  public PutItemRequest() {}
  
  public PutItemRequest(String tableName, Map<String, AttributeValue> item)
  {
    setTableName(tableName);
    setItem(item);
  }
  
  public PutItemRequest(String tableName, Map<String, AttributeValue> item, String returnValues)
  {
    setTableName(tableName);
    setItem(item);
    setReturnValues(returnValues);
  }
  
  public PutItemRequest(String tableName, Map<String, AttributeValue> item, ReturnValue returnValues)
  {
    setTableName(tableName);
    setItem(item);
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
  
  public PutItemRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public Map<String, AttributeValue> getItem()
  {
    return item;
  }
  
  public void setItem(Map<String, AttributeValue> item)
  {
    this.item = item;
  }
  
  public PutItemRequest withItem(Map<String, AttributeValue> item)
  {
    setItem(item);
    return this;
  }
  
  public PutItemRequest addItemEntry(String key, AttributeValue value)
  {
    if (null == item) {
      item = new HashMap();
    }
    if (item.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    item.put(key, value);
    return this;
  }
  
  public PutItemRequest clearItemEntries()
  {
    item = null;
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
  
  public PutItemRequest withExpected(Map<String, ExpectedAttributeValue> expected)
  {
    setExpected(expected);
    return this;
  }
  
  public PutItemRequest addExpectedEntry(String key, ExpectedAttributeValue value)
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
  
  public PutItemRequest clearExpectedEntries()
  {
    expected = null;
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
  
  public PutItemRequest withReturnValues(String returnValues)
  {
    setReturnValues(returnValues);
    return this;
  }
  
  public void setReturnValues(ReturnValue returnValues)
  {
    withReturnValues(returnValues);
  }
  
  public PutItemRequest withReturnValues(ReturnValue returnValues)
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
  
  public PutItemRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public PutItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
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
  
  public PutItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    withReturnItemCollectionMetrics(returnItemCollectionMetrics);
  }
  
  public PutItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
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
  
  public PutItemRequest withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    withConditionalOperator(conditionalOperator);
  }
  
  public PutItemRequest withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator.toString();
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
  
  public PutItemRequest withConditionExpression(String conditionExpression)
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
  
  public PutItemRequest withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public PutItemRequest addExpressionAttributeNamesEntry(String key, String value)
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
  
  public PutItemRequest clearExpressionAttributeNamesEntries()
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
  
  public PutItemRequest withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public PutItemRequest addExpressionAttributeValuesEntry(String key, AttributeValue value)
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
  
  public PutItemRequest clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getItem() != null) {
      sb.append("Item: ").append(getItem()).append(",");
    }
    if (getExpected() != null) {
      sb.append("Expected: ").append(getExpected()).append(",");
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
    if (getConditionalOperator() != null) {
      sb.append("ConditionalOperator: ").append(getConditionalOperator()).append(",");
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
    if (!(obj instanceof PutItemRequest)) {
      return false;
    }
    PutItemRequest other = (PutItemRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItem() != null) && (!other.getItem().equals(getItem()))) {
      return false;
    }
    if (((other.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpected() != null) && (!other.getExpected().equals(getExpected()))) {
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
    if (((other.getConditionalOperator() == null ? 1 : 0) ^ (getConditionalOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConditionalOperator() != null) && (!other.getConditionalOperator().equals(getConditionalOperator()))) {
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
    hashCode = 31 * hashCode + (getItem() == null ? 0 : getItem().hashCode());
    hashCode = 31 * hashCode + (getExpected() == null ? 0 : getExpected().hashCode());
    hashCode = 31 * hashCode + (getReturnValues() == null ? 0 : getReturnValues().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getReturnItemCollectionMetrics() == null ? 0 : getReturnItemCollectionMetrics().hashCode());
    hashCode = 31 * hashCode + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode());
    hashCode = 31 * hashCode + (getConditionExpression() == null ? 0 : getConditionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeValues() == null ? 0 : getExpressionAttributeValues().hashCode());
    return hashCode;
  }
  
  public PutItemRequest clone()
  {
    return (PutItemRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */