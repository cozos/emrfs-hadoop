package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchGetItemResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Map<String, List<Map<String, AttributeValue>>> responses;
  private Map<String, KeysAndAttributes> unprocessedKeys;
  private List<ConsumedCapacity> consumedCapacity;
  
  public Map<String, List<Map<String, AttributeValue>>> getResponses()
  {
    return responses;
  }
  
  public void setResponses(Map<String, List<Map<String, AttributeValue>>> responses)
  {
    this.responses = responses;
  }
  
  public BatchGetItemResult withResponses(Map<String, List<Map<String, AttributeValue>>> responses)
  {
    setResponses(responses);
    return this;
  }
  
  public BatchGetItemResult addResponsesEntry(String key, List<Map<String, AttributeValue>> value)
  {
    if (null == responses) {
      responses = new HashMap();
    }
    if (responses.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    responses.put(key, value);
    return this;
  }
  
  public BatchGetItemResult clearResponsesEntries()
  {
    responses = null;
    return this;
  }
  
  public Map<String, KeysAndAttributes> getUnprocessedKeys()
  {
    return unprocessedKeys;
  }
  
  public void setUnprocessedKeys(Map<String, KeysAndAttributes> unprocessedKeys)
  {
    this.unprocessedKeys = unprocessedKeys;
  }
  
  public BatchGetItemResult withUnprocessedKeys(Map<String, KeysAndAttributes> unprocessedKeys)
  {
    setUnprocessedKeys(unprocessedKeys);
    return this;
  }
  
  public BatchGetItemResult addUnprocessedKeysEntry(String key, KeysAndAttributes value)
  {
    if (null == unprocessedKeys) {
      unprocessedKeys = new HashMap();
    }
    if (unprocessedKeys.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    unprocessedKeys.put(key, value);
    return this;
  }
  
  public BatchGetItemResult clearUnprocessedKeysEntries()
  {
    unprocessedKeys = null;
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
  
  public BatchGetItemResult withConsumedCapacity(ConsumedCapacity... consumedCapacity)
  {
    if (this.consumedCapacity == null) {
      setConsumedCapacity(new ArrayList(consumedCapacity.length));
    }
    for (ConsumedCapacity ele : consumedCapacity) {
      this.consumedCapacity.add(ele);
    }
    return this;
  }
  
  public BatchGetItemResult withConsumedCapacity(Collection<ConsumedCapacity> consumedCapacity)
  {
    setConsumedCapacity(consumedCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResponses() != null) {
      sb.append("Responses: ").append(getResponses()).append(",");
    }
    if (getUnprocessedKeys() != null) {
      sb.append("UnprocessedKeys: ").append(getUnprocessedKeys()).append(",");
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
    if (!(obj instanceof BatchGetItemResult)) {
      return false;
    }
    BatchGetItemResult other = (BatchGetItemResult)obj;
    if (((other.getResponses() == null ? 1 : 0) ^ (getResponses() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResponses() != null) && (!other.getResponses().equals(getResponses()))) {
      return false;
    }
    if (((other.getUnprocessedKeys() == null ? 1 : 0) ^ (getUnprocessedKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUnprocessedKeys() != null) && (!other.getUnprocessedKeys().equals(getUnprocessedKeys()))) {
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
    
    hashCode = 31 * hashCode + (getResponses() == null ? 0 : getResponses().hashCode());
    hashCode = 31 * hashCode + (getUnprocessedKeys() == null ? 0 : getUnprocessedKeys().hashCode());
    hashCode = 31 * hashCode + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode());
    return hashCode;
  }
  
  public BatchGetItemResult clone()
  {
    try
    {
      return (BatchGetItemResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */