package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactWriteItemsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<ConsumedCapacity> consumedCapacity;
  private Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics;
  
  public List<ConsumedCapacity> getConsumedCapacity()
  {
    return consumedCapacity;
  }
  
  public void setConsumedCapacity(Collection<ConsumedCapacity> consumedCapacity)
  {
    if (consumedCapacity == null)
    {
      this.consumedCapacity = null;
      return;
    }
    this.consumedCapacity = new ArrayList(consumedCapacity);
  }
  
  public TransactWriteItemsResult withConsumedCapacity(ConsumedCapacity... consumedCapacity)
  {
    if (this.consumedCapacity == null) {
      setConsumedCapacity(new ArrayList(consumedCapacity.length));
    }
    for (ConsumedCapacity ele : consumedCapacity) {
      this.consumedCapacity.add(ele);
    }
    return this;
  }
  
  public TransactWriteItemsResult withConsumedCapacity(Collection<ConsumedCapacity> consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public Map<String, List<ItemCollectionMetrics>> getItemCollectionMetrics()
  {
    return itemCollectionMetrics;
  }
  
  public void setItemCollectionMetrics(Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics)
  {
    this.itemCollectionMetrics = itemCollectionMetrics;
  }
  
  public TransactWriteItemsResult withItemCollectionMetrics(Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics)
  {
    setItemCollectionMetrics(itemCollectionMetrics);
    return this;
  }
  
  public TransactWriteItemsResult addItemCollectionMetricsEntry(String key, List<ItemCollectionMetrics> value)
  {
    if (null == itemCollectionMetrics) {
      itemCollectionMetrics = new HashMap();
    }
    if (itemCollectionMetrics.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    itemCollectionMetrics.put(key, value);
    return this;
  }
  
  public TransactWriteItemsResult clearItemCollectionMetricsEntries()
  {
    itemCollectionMetrics = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getConsumedCapacity() != null) {
      sb.append("ConsumedCapacity: ").append(getConsumedCapacity()).append(",");
    }
    if (getItemCollectionMetrics() != null) {
      sb.append("ItemCollectionMetrics: ").append(getItemCollectionMetrics());
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
    if (!(obj instanceof TransactWriteItemsResult)) {
      return false;
    }
    TransactWriteItemsResult other = (TransactWriteItemsResult)obj;
    if (((other.getConsumedCapacity() == null ? 1 : 0) ^ (getConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConsumedCapacity() != null) && (!other.getConsumedCapacity().equals(getConsumedCapacity()))) {
      return false;
    }
    if (((other.getItemCollectionMetrics() == null ? 1 : 0) ^ (getItemCollectionMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCollectionMetrics() != null) && (!other.getItemCollectionMetrics().equals(getItemCollectionMetrics()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getItemCollectionMetrics() == null ? 0 : getItemCollectionMetrics().hashCode());
    return hashCode;
  }
  
  public TransactWriteItemsResult clone()
  {
    try
    {
      return (TransactWriteItemsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */