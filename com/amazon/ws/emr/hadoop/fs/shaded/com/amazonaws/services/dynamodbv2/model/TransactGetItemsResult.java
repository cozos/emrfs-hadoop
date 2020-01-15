package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransactGetItemsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<ConsumedCapacity> consumedCapacity;
  private List<ItemResponse> responses;
  
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
  
  public TransactGetItemsResult withConsumedCapacity(ConsumedCapacity... consumedCapacity)
  {
    if (this.consumedCapacity == null) {
      setConsumedCapacity(new ArrayList(consumedCapacity.length));
    }
    for (ConsumedCapacity ele : consumedCapacity) {
      this.consumedCapacity.add(ele);
    }
    return this;
  }
  
  public TransactGetItemsResult withConsumedCapacity(Collection<ConsumedCapacity> consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public List<ItemResponse> getResponses()
  {
    return responses;
  }
  
  public void setResponses(Collection<ItemResponse> responses)
  {
    if (responses == null)
    {
      this.responses = null;
      return;
    }
    this.responses = new ArrayList(responses);
  }
  
  public TransactGetItemsResult withResponses(ItemResponse... responses)
  {
    if (this.responses == null) {
      setResponses(new ArrayList(responses.length));
    }
    for (ItemResponse ele : responses) {
      this.responses.add(ele);
    }
    return this;
  }
  
  public TransactGetItemsResult withResponses(Collection<ItemResponse> responses)
  {
    setResponses(responses);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getConsumedCapacity() != null) {
      sb.append("ConsumedCapacity: ").append(getConsumedCapacity()).append(",");
    }
    if (getResponses() != null) {
      sb.append("Responses: ").append(getResponses());
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
    if (!(obj instanceof TransactGetItemsResult)) {
      return false;
    }
    TransactGetItemsResult other = (TransactGetItemsResult)obj;
    if (((other.getConsumedCapacity() == null ? 1 : 0) ^ (getConsumedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConsumedCapacity() != null) && (!other.getConsumedCapacity().equals(getConsumedCapacity()))) {
      return false;
    }
    if (((other.getResponses() == null ? 1 : 0) ^ (getResponses() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResponses() != null) && (!other.getResponses().equals(getResponses()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getResponses() == null ? 0 : getResponses().hashCode());
    return hashCode;
  }
  
  public TransactGetItemsResult clone()
  {
    try
    {
      return (TransactGetItemsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */