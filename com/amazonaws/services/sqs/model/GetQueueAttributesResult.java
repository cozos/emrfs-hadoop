package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class GetQueueAttributesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalMap<String, String> attributes;
  
  public Map<String, String> getAttributes()
  {
    if (attributes == null) {
      attributes = new SdkInternalMap();
    }
    return attributes;
  }
  
  public void setAttributes(Map<String, String> attributes)
  {
    this.attributes = (attributes == null ? null : new SdkInternalMap(attributes));
  }
  
  public GetQueueAttributesResult withAttributes(Map<String, String> attributes)
  {
    setAttributes(attributes);
    return this;
  }
  
  public GetQueueAttributesResult addAttributesEntry(String key, String value)
  {
    if (null == attributes) {
      attributes = new SdkInternalMap();
    }
    if (attributes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    attributes.put(key, value);
    return this;
  }
  
  public GetQueueAttributesResult clearAttributesEntries()
  {
    attributes = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributes() != null) {
      sb.append("Attributes: ").append(getAttributes());
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
    if (!(obj instanceof GetQueueAttributesResult)) {
      return false;
    }
    GetQueueAttributesResult other = (GetQueueAttributesResult)obj;
    if (((other.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributes() != null) && (!other.getAttributes().equals(getAttributes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttributes() == null ? 0 : getAttributes().hashCode());
    return hashCode;
  }
  
  public GetQueueAttributesResult clone()
  {
    try
    {
      return (GetQueueAttributesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.GetQueueAttributesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */