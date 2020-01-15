package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputMarshaller;
import java.io.Serializable;

public class ProvisionedThroughput
  implements Serializable, Cloneable, StructuredPojo
{
  private Long readCapacityUnits;
  private Long writeCapacityUnits;
  
  public ProvisionedThroughput() {}
  
  public ProvisionedThroughput(Long readCapacityUnits, Long writeCapacityUnits)
  {
    setReadCapacityUnits(readCapacityUnits);
    setWriteCapacityUnits(writeCapacityUnits);
  }
  
  public void setReadCapacityUnits(Long readCapacityUnits)
  {
    this.readCapacityUnits = readCapacityUnits;
  }
  
  public Long getReadCapacityUnits()
  {
    return readCapacityUnits;
  }
  
  public ProvisionedThroughput withReadCapacityUnits(Long readCapacityUnits)
  {
    setReadCapacityUnits(readCapacityUnits);
    return this;
  }
  
  public void setWriteCapacityUnits(Long writeCapacityUnits)
  {
    this.writeCapacityUnits = writeCapacityUnits;
  }
  
  public Long getWriteCapacityUnits()
  {
    return writeCapacityUnits;
  }
  
  public ProvisionedThroughput withWriteCapacityUnits(Long writeCapacityUnits)
  {
    setWriteCapacityUnits(writeCapacityUnits);
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
      sb.append("WriteCapacityUnits: ").append(getWriteCapacityUnits());
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
    if (!(obj instanceof ProvisionedThroughput)) {
      return false;
    }
    ProvisionedThroughput other = (ProvisionedThroughput)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getWriteCapacityUnits() == null ? 0 : getWriteCapacityUnits().hashCode());
    return hashCode;
  }
  
  public ProvisionedThroughput clone()
  {
    try
    {
      return (ProvisionedThroughput)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ProvisionedThroughputMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */