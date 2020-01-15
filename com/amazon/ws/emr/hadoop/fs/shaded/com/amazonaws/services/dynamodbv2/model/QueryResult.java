package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<Map<String, AttributeValue>> items;
  private Integer count;
  private Integer scannedCount;
  private Map<String, AttributeValue> lastEvaluatedKey;
  private ConsumedCapacity consumedCapacity;
  
  public List<Map<String, AttributeValue>> getItems()
  {
    return items;
  }
  
  public void setItems(Collection<Map<String, AttributeValue>> items)
  {
    if (items == null)
    {
      this.items = null;
      return;
    }
    this.items = new ArrayList(items);
  }
  
  public QueryResult withItems(Map<String, AttributeValue>... items)
  {
    if (this.items == null) {
      setItems(new ArrayList(items.length));
    }
    for (Map<String, AttributeValue> ele : items) {
      this.items.add(ele);
    }
    return this;
  }
  
  public QueryResult withItems(Collection<Map<String, AttributeValue>> items)
  {
    setItems(items);
    return this;
  }
  
  public void setCount(Integer count)
  {
    this.count = count;
  }
  
  public Integer getCount()
  {
    return count;
  }
  
  public QueryResult withCount(Integer count)
  {
    setCount(count);
    return this;
  }
  
  public void setScannedCount(Integer scannedCount)
  {
    this.scannedCount = scannedCount;
  }
  
  public Integer getScannedCount()
  {
    return scannedCount;
  }
  
  public QueryResult withScannedCount(Integer scannedCount)
  {
    setScannedCount(scannedCount);
    return this;
  }
  
  public Map<String, AttributeValue> getLastEvaluatedKey()
  {
    return lastEvaluatedKey;
  }
  
  public void setLastEvaluatedKey(Map<String, AttributeValue> lastEvaluatedKey)
  {
    this.lastEvaluatedKey = lastEvaluatedKey;
  }
  
  public QueryResult withLastEvaluatedKey(Map<String, AttributeValue> lastEvaluatedKey)
  {
    setLastEvaluatedKey(lastEvaluatedKey);
    return this;
  }
  
  public QueryResult addLastEvaluatedKeyEntry(String key, AttributeValue value)
  {
    if (null == lastEvaluatedKey) {
      lastEvaluatedKey = new HashMap();
    }
    if (lastEvaluatedKey.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    lastEvaluatedKey.put(key, value);
    return this;
  }
  
  public QueryResult clearLastEvaluatedKeyEntries()
  {
    lastEvaluatedKey = null;
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
  
  public QueryResult withConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItems() != null) {
      sb.append("Items: ").append(getItems()).append(",");
    }
    if (getCount() != null) {
      sb.append("Count: ").append(getCount()).append(",");
    }
    if (getScannedCount() != null) {
      sb.append("ScannedCount: ").append(getScannedCount()).append(",");
    }
    if (getLastEvaluatedKey() != null) {
      sb.append("LastEvaluatedKey: ").append(getLastEvaluatedKey()).append(",");
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
    if (!(obj instanceof QueryResult)) {
      return false;
    }
    QueryResult other = (QueryResult)obj;
    if (((other.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItems() != null) && (!other.getItems().equals(getItems()))) {
      return false;
    }
    if (((other.getCount() == null ? 1 : 0) ^ (getCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCount() != null) && (!other.getCount().equals(getCount()))) {
      return false;
    }
    if (((other.getScannedCount() == null ? 1 : 0) ^ (getScannedCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScannedCount() != null) && (!other.getScannedCount().equals(getScannedCount()))) {
      return false;
    }
    if (((other.getLastEvaluatedKey() == null ? 1 : 0) ^ (getLastEvaluatedKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedKey() != null) && (!other.getLastEvaluatedKey().equals(getLastEvaluatedKey()))) {
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
    
    hashCode = 31 * hashCode + (getItems() == null ? 0 : getItems().hashCode());
    hashCode = 31 * hashCode + (getCount() == null ? 0 : getCount().hashCode());
    hashCode = 31 * hashCode + (getScannedCount() == null ? 0 : getScannedCount().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedKey() == null ? 0 : getLastEvaluatedKey().hashCode());
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public QueryResult clone()
  {
    try
    {
      return (QueryResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */