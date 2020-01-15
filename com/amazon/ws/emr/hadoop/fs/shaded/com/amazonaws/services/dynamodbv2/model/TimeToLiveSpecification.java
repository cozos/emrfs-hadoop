package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TimeToLiveSpecificationMarshaller;
import java.io.Serializable;

public class TimeToLiveSpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean enabled;
  private String attributeName;
  
  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }
  
  public Boolean getEnabled()
  {
    return enabled;
  }
  
  public TimeToLiveSpecification withEnabled(Boolean enabled)
  {
    setEnabled(enabled);
    return this;
  }
  
  public Boolean isEnabled()
  {
    return enabled;
  }
  
  public void setAttributeName(String attributeName)
  {
    this.attributeName = attributeName;
  }
  
  public String getAttributeName()
  {
    return attributeName;
  }
  
  public TimeToLiveSpecification withAttributeName(String attributeName)
  {
    setAttributeName(attributeName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEnabled() != null) {
      sb.append("Enabled: ").append(getEnabled()).append(",");
    }
    if (getAttributeName() != null) {
      sb.append("AttributeName: ").append(getAttributeName());
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
    if (!(obj instanceof TimeToLiveSpecification)) {
      return false;
    }
    TimeToLiveSpecification other = (TimeToLiveSpecification)obj;
    if (((other.getEnabled() == null ? 1 : 0) ^ (getEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEnabled() != null) && (!other.getEnabled().equals(getEnabled()))) {
      return false;
    }
    if (((other.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeName() != null) && (!other.getAttributeName().equals(getAttributeName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEnabled() == null ? 0 : getEnabled().hashCode());
    hashCode = 31 * hashCode + (getAttributeName() == null ? 0 : getAttributeName().hashCode());
    return hashCode;
  }
  
  public TimeToLiveSpecification clone()
  {
    try
    {
      return (TimeToLiveSpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TimeToLiveSpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TimeToLiveSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */