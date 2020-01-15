package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransactGetItemsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private List<TransactGetItem> transactItems;
  private String returnConsumedCapacity;
  
  public List<TransactGetItem> getTransactItems()
  {
    return transactItems;
  }
  
  public void setTransactItems(Collection<TransactGetItem> transactItems)
  {
    if (transactItems == null)
    {
      this.transactItems = null;
      return;
    }
    this.transactItems = new ArrayList(transactItems);
  }
  
  public TransactGetItemsRequest withTransactItems(TransactGetItem... transactItems)
  {
    if (this.transactItems == null) {
      setTransactItems(new ArrayList(transactItems.length));
    }
    for (TransactGetItem ele : transactItems) {
      this.transactItems.add(ele);
    }
    return this;
  }
  
  public TransactGetItemsRequest withTransactItems(Collection<TransactGetItem> transactItems)
  {
    setTransactItems(transactItems);
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
  
  public TransactGetItemsRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public TransactGetItemsRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    this.returnConsumedCapacity = returnConsumedCapacity.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTransactItems() != null) {
      sb.append("TransactItems: ").append(getTransactItems()).append(",");
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
    if (!(obj instanceof TransactGetItemsRequest)) {
      return false;
    }
    TransactGetItemsRequest other = (TransactGetItemsRequest)obj;
    if (((other.getTransactItems() == null ? 1 : 0) ^ (getTransactItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTransactItems() != null) && (!other.getTransactItems().equals(getTransactItems()))) {
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
    
    hashCode = 31 * hashCode + (getTransactItems() == null ? 0 : getTransactItems().hashCode());
    hashCode = 31 * hashCode + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public TransactGetItemsRequest clone()
  {
    return (TransactGetItemsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */