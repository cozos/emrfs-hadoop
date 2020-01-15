package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CapacityMarshaller;
import java.io.Serializable;

public class Capacity
  implements Serializable, Cloneable, StructuredPojo
{
  private Double readCapacityUnits;
  private Double writeCapacityUnits;
  private Double capacityUnits;
  
  public void setReadCapacityUnits(Double readCapacityUnits)
  {
    this.readCapacityUnits = readCapacityUnits;
  }
  
  public Double getReadCapacityUnits()
  {
    return readCapacityUnits;
  }
  
  public Capacity withReadCapacityUnits(Double readCapacityUnits)
  {
    setReadCapacityUnits(readCapacityUnits);
    return this;
  }
  
  public void setWriteCapacityUnits(Double writeCapacityUnits)
  {
    this.writeCapacityUnits = writeCapacityUnits;
  }
  
  public Double getWriteCapacityUnits()
  {
    return writeCapacityUnits;
  }
  
  public Capacity withWriteCapacityUnits(Double writeCapacityUnits)
  {
    setWriteCapacityUnits(writeCapacityUnits);
    return this;
  }
  
  public void setCapacityUnits(Double capacityUnits)
  {
    this.capacityUnits = capacityUnits;
  }
  
  public Double getCapacityUnits()
  {
    return capacityUnits;
  }
  
  public Capacity withCapacityUnits(Double capacityUnits)
  {
    setCapacityUnits(capacityUnits);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getReadCapacityUnits() != null) {
      sb.append("ReadCapacityUnits: ").append(getReadCapacityUnits()).append(",");
    }
    if (getWriteCapacityUnits() != null) {
      sb.append("WriteCapacityUnits: ").append(getWriteCapacityUnits()).append(",");
    }
    if (getCapacityUnits() != null) {
      sb.append("CapacityUnits: ").append(getCapacityUnits());
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
    if (!(obj instanceof Capacity)) {
      return false;
    }
    Capacity other = (Capacity)obj;
    if (((other.getReadCapacityUnits() == null ? 1 : 0) ^ (getReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReadCapacityUnits() != null) && (!other.getReadCapacityUnits().equals(getReadCapacityUnits()))) {
      return false;
    }
    if (((other.getWriteCapacityUnits() == null ? 1 : 0) ^ (getWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWriteCapacityUnits() != null) && (!other.getWriteCapacityUnits().equals(getWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getCapacityUnits() == null ? 1 : 0) ^ (getCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCapacityUnits() != null) && (!other.getCapacityUnits().equals(getCapacityUnits()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getWriteCapacityUnits() == null ? 0 : getWriteCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getCapacityUnits() == null ? 0 : getCapacityUnits().hashCode());
    return hashCode;
  }
  
  public Capacity clone()
  {
    try
    {
      return (Capacity)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CapacityMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Capacity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */