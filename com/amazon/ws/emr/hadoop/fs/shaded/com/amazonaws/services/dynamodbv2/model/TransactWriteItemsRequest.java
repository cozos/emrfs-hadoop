package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransactWriteItemsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private List<TransactWriteItem> transactItems;
  private String returnConsumedCapacity;
  private String returnItemCollectionMetrics;
  private String clientRequestToken;
  
  public List<TransactWriteItem> getTransactItems()
  {
    return transactItems;
  }
  
  public void setTransactItems(Collection<TransactWriteItem> transactItems)
  {
    if (transactItems == null)
    {
      this.transactItems = null;
      return;
    }
    this.transactItems = new ArrayList(transactItems);
  }
  
  public TransactWriteItemsRequest withTransactItems(TransactWriteItem... transactItems)
  {
    if (this.transactItems == null) {
      setTransactItems(new ArrayList(transactItems.length));
    }
    for (TransactWriteItem ele : transactItems) {
      this.transactItems.add(ele);
    }
    return this;
  }
  
  public TransactWriteItemsRequest withTransactItems(Collection<TransactWriteItem> transactItems)
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
  
  public TransactWriteItemsRequest withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public TransactWriteItemsRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
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
  
  public TransactWriteItemsRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public TransactWriteItemsRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
    return this;
  }
  
  public void setClientRequestToken(String clientRequestToken)
  {
    this.clientRequestToken = clientRequestToken;
  }
  
  public String getClientRequestToken()
  {
    return clientRequestToken;
  }
  
  public TransactWriteItemsRequest withClientRequestToken(String clientRequestToken)
  {
    setClientRequestToken(clientRequestToken);
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
      sb.append("ReturnConsumedCapacity: ").append(getReturnConsumedCapacity()).append(",");
    }
    if (getReturnItemCollectionMetrics() != null) {
      sb.append("ReturnItemCollectionMetrics: ").append(getReturnItemCollectionMetrics()).append(",");
    }
    if (getClientRequestToken() != null) {
      sb.append("ClientRequestToken: ").append(getClientRequestToken());
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
    if (!(obj instanceof TransactWriteItemsRequest)) {
      return false;
    }
    TransactWriteItemsRequest other = (TransactWriteItemsRequest)obj;
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
    if (((other.getReturnItemCollectionMetrics() == null ? 1 : 0) ^ (getReturnItemCollectionMetrics() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReturnItemCollectionMetrics() != null) && (!other.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics()))) {
      return false;
    }
    if (((other.getClientRequestToken() == null ? 1 : 0) ^ (getClientRequestToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClientRequestToken() != null) && (!other.getClientRequestToken().equals(getClientRequestToken()))) {
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
    hashCode = 31 * hashCode + (getReturnItemCollectionMetrics() == null ? 0 : getReturnItemCollectionMetrics().hashCode());
    hashCode = 31 * hashCode + (getClientRequestToken() == null ? 0 : getClientRequestToken().hashCode());
    return hashCode;
  }
  
  public TransactWriteItemsRequest clone()
  {
    return (TransactWriteItemsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */