package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.EndpointMarshaller;
import java.io.Serializable;

public class Endpoint
  implements Serializable, Cloneable, StructuredPojo
{
  private String address;
  private Long cachePeriodInMinutes;
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getAddress()
  {
    return address;
  }
  
  public Endpoint withAddress(String address)
  {
    setAddress(address);
    return this;
  }
  
  public void setCachePeriodInMinutes(Long cachePeriodInMinutes)
  {
    this.cachePeriodInMinutes = cachePeriodInMinutes;
  }
  
  public Long getCachePeriodInMinutes()
  {
    return cachePeriodInMinutes;
  }
  
  public Endpoint withCachePeriodInMinutes(Long cachePeriodInMinutes)
  {
    setCachePeriodInMinutes(cachePeriodInMinutes);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAddress() != null) {
      sb.append("Address: ").append(getAddress()).append(",");
    }
    if (getCachePeriodInMinutes() != null) {
      sb.append("CachePeriodInMinutes: ").append(getCachePeriodInMinutes());
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
    if (!(obj instanceof Endpoint)) {
      return false;
    }
    Endpoint other = (Endpoint)obj;
    if (((other.getAddress() == null ? 1 : 0) ^ (getAddress() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAddress() != null) && (!other.getAddress().equals(getAddress()))) {
      return false;
    }
    if (((other.getCachePeriodInMinutes() == null ? 1 : 0) ^ (getCachePeriodInMinutes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCachePeriodInMinutes() != null) && (!other.getCachePeriodInMinutes().equals(getCachePeriodInMinutes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAddress() == null ? 0 : getAddress().hashCode());
    hashCode = 31 * hashCode + (getCachePeriodInMinutes() == null ? 0 : getCachePeriodInMinutes().hashCode());
    return hashCode;
  }
  
  public Endpoint clone()
  {
    try
    {
      return (Endpoint)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    EndpointMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Endpoint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */