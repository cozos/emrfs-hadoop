package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GetItemRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private Map<String, AttributeValue> key;
  private List<String> attributesToGet;
  private Boolean consistentRead;
  private String returnConsumedCapacity;
  private String projectionExpression;
  private Map<String, String> expressionAttributeNames;
  
  public GetItemRequest() {}
  
  public GetItemRequest(String tableName, Map<String, AttributeValue> key)
  {
    setTableName(tableName);
    setKey(key);
  }
  
  public GetItemRequest(String tableName, Map<String, AttributeValue> key, Boolean consistentRead)
  {
    setTableName(tableName);
    setKey(key);
    setConsistentRead(consistentRead);
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public GetItemRequest withTableName(String tableName)
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
  
  public GetItemRequest withKey(Map<String, AttributeValue> key)
  {
    setKey(key);
    return this;
  }
  
  public GetItemRequest addKeyEntry(String key, AttributeValue value)
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
  
  public GetItemRequest clearKeyEntries()
  {
    key = null;
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
  
  public GetItemRequest withAttributesToGet(String... attributesToGet)
  {
    if (this.attributesToGet == null) {
      setAttributesToGet(new ArrayList(attributesToGet.length));
    }
    for (String ele : attributesToGet) {
      this.attributesToGet.add(ele);
    }
    return this;
  }
  
  public GetItemRequest withAttributesToGet(Collection<String> attributesToGet)
  {
    setAttributesToGet(attributesToGet);
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
  
  public GetItemRequest withConsistentRead(Boolean consistentRead)
  {
    setConsistentRead(consistentRead);
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public void setReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
  }
  
  public String getReturnConsumedCapacity()
  {
    return returnConsumedCapacity;
  }
  
  public GetItemRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public GetItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
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
  
  public GetItemRequest withProjectionExpression(String projectionExpression)
  {
    setProjectionExpression(projectionExpression);
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
  
  public GetItemRequest withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public GetItemRequest addExpressionAttributeNamesEntry(String key, String value)
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
  
  public GetItemRequest clearExpressionAttributeNamesEntries()
  {
    expressionAttributeNames = null;
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
  
  public GetItemRequest withKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
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
    if (getAttributesToGet() != null) {
      sb.append("AttributesToGet: ").append(getAttributesToGet()).append(",");
    }
    if (getConsistentRead() != null) {
      sb.append("ConsistentRead: ").append(getConsistentRead()).append(",");
    }
    if (getReturnConsumedCapacity() != null) {
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity()).append(",");
    }
    if (getProjectionExpression() != null) {
      sb.append("ProjectionExpression: ").append(getProjectionExpression()).append(",");
    }
    if (getExpressionAttributeNames() != null) {
      sb.append("ExpressionAttributeNames: ").append(getExpressionAttributeNames());
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
    if (!(obj instanceof GetItemRequest)) {
      return false;
    }
    GetItemRequest other = (GetItemRequest)obj;
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
    if (((other.getAttributesToGet() == null ? 1 : 0) ^ (getAttributesToGet() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributesToGet() != null) && (!other.getAttributesToGet().equals(getAttributesToGet()))) {
      return false;
    }
    if (((other.getConsistentRead() == null ? 1 : 0) ^ (getConsistentRead() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConsistentRead() != null) && (!other.getConsistentRead().equals(getConsistentRead()))) {
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
    if (((other.getExpressionAttributeNames() == null ? 1 : 0) ^ (getExpressionAttributeNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpressionAttributeNames() != null) && (!other.getExpressionAttributeNames().equals(getExpressionAttributeNames()))) {
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
    hashCode = 31 * hashCode + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode());
    hashCode = 31 * hashCode + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    return hashCode;
  }
  
  public GetItemRequest clone()
  {
    return (GetItemRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */