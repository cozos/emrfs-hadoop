package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteRequestMarshaller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DeleteRequest
  implements Serializable, Cloneable, StructuredPojo
{
  private Map<String, AttributeValue> key;
  
  public DeleteRequest() {}
  
  public DeleteRequest(Map<String, AttributeValue> key)
  {
    setKey(key);
  }
  
  public Map<String, AttributeValue> getKey()
  {
    return key;
  }
  
  public void setKey(Map<String, AttributeValue> key)
  {
    this.key = key;
  }
  
  public DeleteRequest withKey(Map<String, AttributeValue> key)
  {
    setKey(key);
    return this;
  }
  
  public DeleteRequest addKeyEntry(String key, AttributeValue value)
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
  
  public DeleteRequest clearKeyEntries()
  {
    key = null;
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
  
  public DeleteRequest withKey(Map.Entry<String, AttributeValue> hashKey, Map.Entry<String, AttributeValue> rangeKey)
    throws IllegalArgumentException
  {
    setKey(hashKey, rangeKey);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKey() != null) {
      sb.append("Key: ").append(getKey());
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
    if (!(obj instanceof DeleteRequest)) {
      return false;
    }
    DeleteRequest other = (DeleteRequest)obj;
    if (((other.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKey() != null) && (!other.getKey().equals(getKey()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKey() == null ? 0 : getKey().hashCode());
    return hashCode;
  }
  
  public DeleteRequest clone()
  {
    try
    {
      return (DeleteRequest)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    DeleteRequestMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */