package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutMarshaller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Put
  implements Serializable, Cloneable, StructuredPojo
{
  private Map<String, AttributeValue> item;
  private String tableName;
  private String conditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  private String returnValuesOnConditionCheckFailure;
  
  public Map<String, AttributeValue> getItem()
  {
    return item;
  }
  
  public void setItem(Map<String, AttributeValue> item)
  {
    this.item = item;
  }
  
  public Put withItem(Map<String, AttributeValue> item)
  {
    setItem(item);
    return this;
  }
  
  public Put addItemEntry(String key, AttributeValue value)
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
  
  public Put clearItemEntries()
  {
    item = null;
    return this;
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public Put withTableName(String tableName)
  {
    setTableName(tableName);
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
  
  public Put withConditionExpression(String conditionExpression)
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
  
  public Put withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public Put addExpressionAttributeNamesEntry(String key, String value)
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
  
  public Put clearExpressionAttributeNamesEntries()
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
  
  public Put withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public Put addExpressionAttributeValuesEntry(String key, AttributeValue value)
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
  
  public Put clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
  
  public void setReturnValuesOnConditionCheckFailure(String returnValuesOnConditionCheckFailure)
  {
    this.returnValuesOnConditionCheckFailure = returnValuesOnConditionCheckFailure;
  }
  
  public String getReturnValuesOnConditionCheckFailure()
  {
    return returnValuesOnConditionCheckFailure;
  }
  
  public Put withReturnValuesOnConditionCheckFailure(String returnValuesOnConditionCheckFailure)
  {
    setReturnValuesOnConditionCheckFailure(returnValuesOnConditionCheckFailure);
    return this;
  }
  
  public Put withReturnValuesOnConditionCheckFailure(ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    this.returnValuesOnConditionCheckFailure = returnValuesOnConditionCheckFailure.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItem() != null) {
      sb.append("Item: ").append(getItem()).append(",");
    }
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getConditionExpression() != null) {
      sb.append("ConditionExpression: ").append(getConditionExpression()).append(",");
    }
    if (getExpressionAttributeNames() != null) {
      sb.append("ExpressionAttributeNames: ").append(getExpressionAttributeNames()).append(",");
    }
    if (getExpressionAttributeValues() != null) {
      sb.append("ExpressionAttributeValues: ").append(getExpressionAttributeValues()).append(",");
    }
    if (getReturnValuesOnConditionCheckFailure() != null) {
      sb.append("ReturnValuesOnConditionCheckFailure: ").append(getReturnValuesOnConditionCheckFailure());
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
    if (!(obj instanceof Put)) {
      return false;
    }
    Put other = (Put)obj;
    if (((other.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItem() != null) && (!other.getItem().equals(getItem()))) {
      return false;
    }
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
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
    if (((other.getReturnValuesOnConditionCheckFailure() == null ? 1 : 0) ^ (getReturnValuesOnConditionCheckFailure() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnValuesOnConditionCheckFailure() != null) && 
      (!other.getReturnValuesOnConditionCheckFailure().equals(getReturnValuesOnConditionCheckFailure()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getItem() == null ? 0 : getItem().hashCode());
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getConditionExpression() == null ? 0 : getConditionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeValues() == null ? 0 : getExpressionAttributeValues().hashCode());
    hashCode = 31 * hashCode + (getReturnValuesOnConditionCheckFailure() == null ? 0 : getReturnValuesOnConditionCheckFailure().hashCode());
    return hashCode;
  }
  
  public Put clone()
  {
    try
    {
      return (Put)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    PutMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Put
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */