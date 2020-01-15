package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.TagMarshaller;
import java.io.Serializable;

public class Tag
  implements Serializable, Cloneable, StructuredPojo
{
  private String tagKey;
  private String tagValue;
  
  public void setTagKey(String tagKey)
  {
    this.tagKey = tagKey;
  }
  
  public String getTagKey()
  {
    return tagKey;
  }
  
  public Tag withTagKey(String tagKey)
  {
    setTagKey(tagKey);
    return this;
  }
  
  public void setTagValue(String tagValue)
  {
    this.tagValue = tagValue;
  }
  
  public String getTagValue()
  {
    return tagValue;
  }
  
  public Tag withTagValue(String tagValue)
  {
    setTagValue(tagValue);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTagKey() != null) {
      sb.append("TagKey: ").append(getTagKey()).append(",");
    }
    if (getTagValue() != null) {
      sb.append("TagValue: ").append(getTagValue());
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
    if (!(obj instanceof Tag)) {
      return false;
    }
    Tag other = (Tag)obj;
    if (((other.getTagKey() == null ? 1 : 0) ^ (getTagKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTagKey() != null) && (!other.getTagKey().equals(getTagKey()))) {
      return false;
    }
    if (((other.getTagValue() == null ? 1 : 0) ^ (getTagValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTagValue() != null) && (!other.getTagValue().equals(getTagValue()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTagKey() == null ? 0 : getTagKey().hashCode());
    hashCode = 31 * hashCode + (getTagValue() == null ? 0 : getTagValue().hashCode());
    return hashCode;
  }
  
  public Tag clone()
  {
    try
    {
      return (Tag)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TagMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.Tag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */