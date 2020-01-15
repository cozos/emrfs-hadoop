package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeysAndAttributesMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeysAndAttributes
  implements Serializable, Cloneable, StructuredPojo
{
  private List<Map<String, AttributeValue>> keys;
  private List<String> attributesToGet;
  private Boolean consistentRead;
  private String projectionExpression;
  private Map<String, String> expressionAttributeNames;
  
  public List<Map<String, AttributeValue>> getKeys()
  {
    return keys;
  }
  
  public void setKeys(Collection<Map<String, AttributeValue>> keys)
  {
    if (keys == null)
    {
      this.keys = null;
      return;
    }
    this.keys = new ArrayList(keys);
  }
  
  public KeysAndAttributes withKeys(Map<String, AttributeValue>... keys)
  {
    if (this.keys == null) {
      setKeys(new ArrayList(keys.length));
    }
    for (Map<String, AttributeValue> ele : keys) {
      this.keys.add(ele);
    }
    return this;
  }
  
  public KeysAndAttributes withKeys(Collection<Map<String, AttributeValue>> keys)
  {
    setKeys(keys);
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
  
  public KeysAndAttributes withAttributesToGet(String... attributesToGet)
  {
    if (this.attributesToGet == null) {
      setAttributesToGet(new ArrayList(attributesToGet.length));
    }
    for (String ele : attributesToGet) {
      this.attributesToGet.add(ele);
    }
    return this;
  }
  
  public KeysAndAttributes withAttributesToGet(Collection<String> attributesToGet)
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
  
  public KeysAndAttributes withConsistentRead(Boolean consistentRead)
  {
    setConsistentRead(consistentRead);
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public void setProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
  }
  
  public String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public KeysAndAttributes withProjectionExpression(String projectionExpression)
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
  
  public KeysAndAttributes withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public KeysAndAttributes addExpressionAttributeNamesEntry(String key, String value)
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
  
  public KeysAndAttributes clearExpressionAttributeNamesEntries()
  {
    expressionAttributeNames = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeys() != null) {
      sb.append("Keys: ").append(getKeys()).append(",");
    }
    if (getAttributesToGet() != null) {
      sb.append("AttributesToGet: ").append(getAttributesToGet()).append(",");
    }
    if (getConsistentRead() != null) {
      sb.append("ConsistentRead: ").append(getConsistentRead()).append(",");
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
    if (!(obj instanceof KeysAndAttributes)) {
      return false;
    }
    KeysAndAttributes other = (KeysAndAttributes)obj;
    if (((other.getKeys() == null ? 1 : 0) ^ (getKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeys() != null) && (!other.getKeys().equals(getKeys()))) {
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
    
    hashCode = 31 * hashCode + (getKeys() == null ? 0 : getKeys().hashCode());
    hashCode = 31 * hashCode + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode());
    hashCode = 31 * hashCode + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode());
    hashCode = 31 * hashCode + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode());
    hashCode = 31 * hashCode + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode());
    return hashCode;
  }
  
  public KeysAndAttributes clone()
  {
    try
    {
      return (KeysAndAttributes)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    KeysAndAttributesMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */