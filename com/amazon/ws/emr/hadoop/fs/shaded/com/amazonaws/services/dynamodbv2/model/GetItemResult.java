package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetItemResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Map<String, AttributeValue> item;
  private ConsumedCapacity consumedCapacity;
  
  public Map<String, AttributeValue> getItem()
  {
    return item;
  }
  
  public void setItem(Map<String, AttributeValue> item)
  {
    this.item = item;
  }
  
  public GetItemResult withItem(Map<String, AttributeValue> item)
  {
    setItem(item);
    return this;
  }
  
  public GetItemResult addItemEntry(String key, AttributeValue value)
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
  
  public GetItemResult clearItemEntries()
  {
    item = null;
    return this;
  }
  
  public void setConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    this.consumedCapacity = consumedCapacity;
  }
  
  public ConsumedCapacity getConsumedCapacity()
  {
    return consumedCapacity;
  }
  
  public GetItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItem() != null) {
      sb.append("Item: ").append(getItem()).append(",");
    }
    if (getConsumedCapacity() != null) {
      sb.append("ConsumedCapacity: ").append(getConsumedCapacity());
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
    if (!(obj instanceof GetItemResult)) {
      return false;
    }
    GetItemResult other = (GetItemResult)obj;
    if (((other.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItem() != null) && (!other.getItem().equals(getItem()))) {
      return false;
    }
    if (((other.getConsumedCapacity() == null ? 1 : 0) ^ (getConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConsumedCapacity() != null) && (!other.getConsumedCapacity().equals(getConsumedCapacity()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getItem() == null ? 0 : getItem().hashCode());
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public GetItemResult clone()
  {
    try
    {
      return (GetItemResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */