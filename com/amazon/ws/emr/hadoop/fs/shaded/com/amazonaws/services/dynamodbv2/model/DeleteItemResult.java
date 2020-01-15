package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DeleteItemResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Map<String, AttributeValue> attributes;
  private ConsumedCapacity consumedCapacity;
  private ItemCollectionMetrics itemCollectionMetrics;
  
  public Map<String, AttributeValue> getAttributes()
  {
    return attributes;
  }
  
  public void setAttributes(Map<String, AttributeValue> attributes)
  {
    this.attributes = attributes;
  }
  
  public DeleteItemResult withAttributes(Map<String, AttributeValue> attributes)
  {
    setAttributes(attributes);
    return this;
  }
  
  public DeleteItemResult addAttributesEntry(String key, AttributeValue value)
  {
    if (null == attributes) {
      attributes = new HashMap();
    }
    if (attributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    attributes.put(key, value);
    return this;
  }
  
  public DeleteItemResult clearAttributesEntries()
  {
    attributes = null;
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
  
  public DeleteItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public void setItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics)
  {
    this.itemCollectionMetrics = itemCollectionMetrics;
  }
  
  public ItemCollectionMetrics getItemCollectionMetrics()
  {
    return itemCollectionMetrics;
  }
  
  public DeleteItemResult withItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics)
  {
    setItemCollectionMetrics(itemCollectionMetrics);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributes() != null) {
      sb.append("Attributes: ").append(getAttributes()).append(",");
    }
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
    if (!(obj instanceof DeleteItemResult)) {
      return false;
    }
    DeleteItemResult other = (DeleteItemResult)obj;
    if (((other.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributes() != null) && (!other.getAttributes().equals(getAttributes()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getAttributes() == null ? 0 : getAttributes().hashCode());
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    hashCode = 31 * hashCode + (getItemCollectionMetrics() == null ? 0 : getItemCollectionMetrics().hashCode());
    return hashCode;
  }
  
  public DeleteItemResult clone()
  {
    try
    {
      return (DeleteItemResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */