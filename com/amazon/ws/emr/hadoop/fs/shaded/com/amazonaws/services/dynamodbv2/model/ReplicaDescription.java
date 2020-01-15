package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaDescriptionMarshaller;
import java.io.Serializable;

public class ReplicaDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String regionName;
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public ReplicaDescription withRegionName(String regionName)
  {
    setRegionName(regionName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRegionName() != null) {
      sb.append("RegionName: ").append(getRegionName());
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
    if (!(obj instanceof ReplicaDescription)) {
      return false;
    }
    ReplicaDescription other = (ReplicaDescription)obj;
    if (((other.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegionName() != null) && (!other.getRegionName().equals(getRegionName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRegionName() == null ? 0 : getRegionName().hashCode());
    return hashCode;
  }
  
  public ReplicaDescription clone()
  {
    try
    {
      return (ReplicaDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */