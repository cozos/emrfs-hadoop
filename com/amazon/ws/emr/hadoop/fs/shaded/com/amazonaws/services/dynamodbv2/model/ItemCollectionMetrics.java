package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionMetricsMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCollectionMetrics
  implements Serializable, Cloneable, StructuredPojo
{
  private Map<String, AttributeValue> itemCollectionKey;
  private List<Double> sizeEstimateRangeGB;
  
  public Map<String, AttributeValue> getItemCollectionKey()
  {
    return itemCollectionKey;
  }
  
  public void setItemCollectionKey(Map<String, AttributeValue> itemCollectionKey)
  {
    this.itemCollectionKey = itemCollectionKey;
  }
  
  public ItemCollectionMetrics withItemCollectionKey(Map<String, AttributeValue> itemCollectionKey)
  {
    setItemCollectionKey(itemCollectionKey);
    return this;
  }
  
  public ItemCollectionMetrics addItemCollectionKeyEntry(String key, AttributeValue value)
  {
    if (null == itemCollectionKey) {
      itemCollectionKey = new HashMap();
    }
    if (itemCollectionKey.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    itemCollectionKey.put(key, value);
    return this;
  }
  
  public ItemCollectionMetrics clearItemCollectionKeyEntries()
  {
    itemCollectionKey = null;
    return this;
  }
  
  public List<Double> getSizeEstimateRangeGB()
  {
    return sizeEstimateRangeGB;
  }
  
  public void setSizeEstimateRangeGB(Collection<Double> sizeEstimateRangeGB)
  {
    if (sizeEstimateRangeGB == null)
    {
      this.sizeEstimateRangeGB = null;
      return;
    }
    this.sizeEstimateRangeGB = new ArrayList(sizeEstimateRangeGB);
  }
  
  public ItemCollectionMetrics withSizeEstimateRangeGB(Double... sizeEstimateRangeGB)
  {
    if (this.sizeEstimateRangeGB == null) {
      setSizeEstimateRangeGB(new ArrayList(sizeEstimateRangeGB.length));
    }
    for (Double ele : sizeEstimateRangeGB) {
      this.sizeEstimateRangeGB.add(ele);
    }
    return this;
  }
  
  public ItemCollectionMetrics withSizeEstimateRangeGB(Collection<Double> sizeEstimateRangeGB)
  {
    setSizeEstimateRangeGB(sizeEstimateRangeGB);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItemCollectionKey() != null) {
      sb.append("ItemCollectionKey: ").append(getItemCollectionKey()).append(",");
    }
    if (getSizeEstimateRangeGB() != null) {
      sb.append("SizeEstimateRangeGB: ").append(getSizeEstimateRangeGB());
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
    if (!(obj instanceof ItemCollectionMetrics)) {
      return false;
    }
    ItemCollectionMetrics other = (ItemCollectionMetrics)obj;
    if (((other.getItemCollectionKey() == null ? 1 : 0) ^ (getItemCollectionKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCollectionKey() != null) && (!other.getItemCollectionKey().equals(getItemCollectionKey()))) {
      return false;
    }
    if (((other.getSizeEstimateRangeGB() == null ? 1 : 0) ^ (getSizeEstimateRangeGB() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSizeEstimateRangeGB() != null) && (!other.getSizeEstimateRangeGB().equals(getSizeEstimateRangeGB()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getItemCollectionKey() == null ? 0 : getItemCollectionKey().hashCode());
    hashCode = 31 * hashCode + (getSizeEstimateRangeGB() == null ? 0 : getSizeEstimateRangeGB().hashCode());
    return hashCode;
  }
  
  public ItemCollectionMetrics clone()
  {
    try
    {
      return (ItemCollectionMetrics)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ItemCollectionMetricsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemCollectionMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */