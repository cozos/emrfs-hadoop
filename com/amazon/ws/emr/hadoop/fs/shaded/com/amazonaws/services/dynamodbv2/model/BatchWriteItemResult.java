package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchWriteItemResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Map<String, List<WriteRequest>> unprocessedItems;
  private Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics;
  private List<ConsumedCapacity> consumedCapacity;
  
  public Map<String, List<WriteRequest>> getUnprocessedItems()
  {
    return unprocessedItems;
  }
  
  public void setUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems)
  {
    this.unprocessedItems = unprocessedItems;
  }
  
  public BatchWriteItemResult withUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems)
  {
    setUnprocessedItems(unprocessedItems);
    return this;
  }
  
  public BatchWriteItemResult addUnprocessedItemsEntry(String key, List<WriteRequest> value)
  {
    if (null == unprocessedItems) {
      unprocessedItems = new HashMap();
    }
    if (unprocessedItems.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    unprocessedItems.put(key, value);
    return this;
  }
  
  public BatchWriteItemResult clearUnprocessedItemsEntries()
  {
    unprocessedItems = null;
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
  
  public BatchWriteItemResult withItemCollectionMetrics(Map<String, List<ItemCollectionMetrics>> itemCollectionMetrics)
  {
    setItemCollectionMetrics(itemCollectionMetrics);
    return this;
  }
  
  public BatchWriteItemResult addItemCollectionMetricsEntry(String key, List<ItemCollectionMetrics> value)
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
  
  public BatchWriteItemResult clearItemCollectionMetricsEntries()
  {
    itemCollectionMetrics = null;
    return this;
  }
  
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
  
  public BatchWriteItemResult withConsumedCapacity(ConsumedCapacity... consumedCapacity)
  {
    if (this.consumedCapacity == null) {
      setConsumedCapacity(new ArrayList(consumedCapacity.length));
    }
    for (ConsumedCapacity ele : consumedCapacity) {
      this.consumedCapacity.add(ele);
    }
    return this;
  }
  
  public BatchWriteItemResult withConsumedCapacity(Collection<ConsumedCapacity> consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUnprocessedItems() != null) {
      sb.append("UnprocessedItems: ").append(getUnprocessedItems()).append(",");
    }
    if (getItemCollectionMetrics() != null) {
      sb.append("ItemCollectionMetrics: ").append(getItemCollectionMetrics()).append(",");
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
    if (!(obj instanceof BatchWriteItemResult)) {
      return false;
    }
    BatchWriteItemResult other = (BatchWriteItemResult)obj;
    if (((other.getUnprocessedItems() == null ? 1 : 0) ^ (getUnprocessedItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnprocessedItems() != null) && (!other.getUnprocessedItems().equals(getUnprocessedItems()))) {
      return false;
    }
    if (((other.getItemCollectionMetrics() == null ? 1 : 0) ^ (getItemCollectionMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCollectionMetrics() != null) && (!other.getItemCollectionMetrics().equals(getItemCollectionMetrics()))) {
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
    
    hashCode = 31 * hashCode + (getUnprocessedItems() == null ? 0 : getUnprocessedItems().hashCode());
    hashCode = 31 * hashCode + (getItemCollectionMetrics() == null ? 0 : getItemCollectionMetrics().hashCode());
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public BatchWriteItemResult clone()
  {
    try
    {
      return (BatchWriteItemResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */