package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BatchGetItemRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Map<String, KeysAndAttributes> requestItems;
  private String returnConsumedCapacity;
  
  public BatchGetItemRequest() {}
  
  public BatchGetItemRequest(Map<String, KeysAndAttributes> requestItems)
  {
    setRequestItems(requestItems);
  }
  
  public BatchGetItemRequest(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity)
  {
    setRequestItems(requestItems);
    setReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public BatchGetItemRequest(Map<String, KeysAndAttributes> requestItems, ReturnConsumedCapacity returnConsumedCapacity)
  {
    setRequestItems(requestItems);
    setReturnConsumedCapacity(returnConsumedCapacity.toString());
  }
  
  public Map<String, KeysAndAttributes> getRequestItems()
  {
    return requestItems;
  }
  
  public void setRequestItems(Map<String, KeysAndAttributes> requestItems)
  {
    this.requestItems = requestItems;
  }
  
  public BatchGetItemRequest withRequestItems(Map<String, KeysAndAttributes> requestItems)
  {
    setRequestItems(requestItems);
    return this;
  }
  
  public BatchGetItemRequest addRequestItemsEntry(String key, KeysAndAttributes value)
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
  
  public BatchGetItemRequest clearRequestItemsEntries()
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
  
  public BatchGetItemRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    withReturnConsumedCapacity(returnConsumedCapacity);
  }
  
  public BatchGetItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
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
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity());
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
    if (!(obj instanceof BatchGetItemRequest)) {
      return false;
    }
    BatchGetItemRequest other = (BatchGetItemRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRequestItems() == null ? 0 : getRequestItems().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public BatchGetItemRequest clone()
  {
    return (BatchGetItemRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */