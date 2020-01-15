package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.IdentityMarshaller;
import java.io.Serializable;

public class Identity
  implements Serializable, Cloneable, StructuredPojo
{
  private String principalId;
  private String type;
  
  public void setPrincipalId(String principalId)
  {
    this.principalId = principalId;
  }
  
  public String getPrincipalId()
  {
    return principalId;
  }
  
  public Identity withPrincipalId(String principalId)
  {
    setPrincipalId(principalId);
    return this;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public String getType()
  {
    return type;
  }
  
  public Identity withType(String type)
  {
    setType(type);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPrincipalId() != null) {
      sb.append("PrincipalId: ").append(getPrincipalId()).append(",");
    }
    if (getType() != null) {
      sb.append("Type: ").append(getType());
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
    if (!(obj instanceof Identity)) {
      return false;
    }
    Identity other = (Identity)obj;
    if (((other.getPrincipalId() == null ? 1 : 0) ^ (getPrincipalId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrincipalId() != null) && (!other.getPrincipalId().equals(getPrincipalId()))) {
      return false;
    }
    if (((other.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getType() != null) && (!other.getType().equals(getType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPrincipalId() == null ? 0 : getPrincipalId().hashCode());
    hashCode = 31 * hashCode + (getType() == null ? 0 : getType().hashCode());
    return hashCode;
  }
  
  public Identity clone()
  {
    try
    {
      return (Identity)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    IdentityMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Identity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */