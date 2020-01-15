package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchWriteItemRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Map<String, List<WriteRequest>> requestItems;
  private String returnConsumedCapacity;
  private String returnItemCollectionMetrics;
  
  public BatchWriteItemRequest() {}
  
  public BatchWriteItemRequest(Map<String, List<WriteRequest>> requestItems)
  {
    setRequestItems(requestItems);
  }
  
  public Map<String, List<WriteRequest>> getRequestItems()
  {
    return requestItems;
  }
  
  public void setRequestItems(Map<String, List<WriteRequest>> requestItems)
  {
    this.requestItems = requestItems;
  }
  
  public BatchWriteItemRequest withRequestItems(Map<String, List<WriteRequest>> requestItems)
  {
    setRequestItems(requestItems);
    return this;
  }
  
  public BatchWriteItemRequest addRequestItemsEntry(String key, List<WriteRequest> value)
  {
    if (null == requestItems) {
      requestItems = new HashMap();
    }
    if (requestItems.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    requestItems.put(key, value);
    return this;
  }
  
  public BatchWriteItemRequest clearRequestItemsEntries()
  {
    requestItems = null;
    return this;
  }
  
  public void setReturnConsumedCapacity(String returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity;
  }
  
  public String getReturnConsumedCapacity()
  {
    return returnConsumedCapacity;
  }
  
  public BatchWriteItemRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public BatchWriteItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
  
  public void setReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics;
  }
  
  public String getReturnItemCollectionMetrics()
  {
    return returnItemCollectionMetrics;
  }
  
  public BatchWriteItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    withReturnItemCollectionMetrics(returnItemCollectionMetrics);
  }
  
  public BatchWriteItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRequestItems() != null) {
      sb.append("RequestItems: ").append(getRequestItems()).append(",");
    }
    if (getReturnConsumedCapacity() != null) {
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity()).append(",");
    }
    if (getReturnItemCollectionMetrics() != null) {
      sb.append("ReturnItemCollectionMetrics: ").append(getReturnItemCollectionMetrics());
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
    if (!(obj instanceof BatchWriteItemRequest)) {
      return false;
    }
    BatchWriteItemRequest other = (BatchWriteItemRequest)obj;
    if (((other.getRequestItems() == null ? 1 : 0) ^ (getRequestItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequestItems() != null) && (!other.getRequestItems().equals(getRequestItems()))) {
      return false;
    }
    if (((other.getReturnConsumedCapacity() == null ? 1 : 0) ^ (getReturnConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnConsumedCapacity() != null) && (!other.getReturnConsumedCapacity().equals(getReturnConsumedCapacity()))) {
      return false;
    }
    if (((other.getReturnItemCollectionMetrics() == null ? 1 : 0) ^ (getReturnItemCollectionMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnItemCollectionMetrics() != null) && (!other.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRequestItems() == null ? 0 : getRequestItems().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getReturnItemCollectionMetrics() == null ? 0 : getReturnItemCollectionMetrics().hashCode());
    return hashCode;
  }
  
  public BatchWriteItemRequest clone()
  {
    return (BatchWriteItemRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */