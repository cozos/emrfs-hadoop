package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemResponseMarshaller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ItemResponse
  implements Serializable, Cloneable, StructuredPojo
{
  private Map<String, AttributeValue> item;
  
  public Map<String, AttributeValue> getItem()
  {
    return item;
  }
  
  public void setItem(Map<String, AttributeValue> item)
  {
    this.item = item;
  }
  
  public ItemResponse withItem(Map<String, AttributeValue> item)
  {
    setItem(item);
    return this;
  }
  
  public ItemResponse addItemEntry(String key, AttributeValue value)
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
  
  public ItemResponse clearItemEntries()
  {
    item = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItem() != null) {
      sb.append("Item: ").append(getItem());
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
    if (!(obj instanceof ItemResponse)) {
      return false;
    }
    ItemResponse other = (ItemResponse)obj;
    if (((other.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItem() != null) && (!other.getItem().equals(getItem()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getItem() == null ? 0 : getItem().hashCode());
    return hashCode;
  }
  
  public ItemResponse clone()
  {
    try
    {
      return (ItemResponse)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ItemResponseMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */