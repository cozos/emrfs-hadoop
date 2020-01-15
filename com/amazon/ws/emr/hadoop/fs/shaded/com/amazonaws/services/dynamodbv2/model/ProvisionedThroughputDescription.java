package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputDescriptionMarshaller;
import java.io.Serializable;
import java.util.Date;

public class ProvisionedThroughputDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private Date lastIncreaseDateTime;
  private Date lastDecreaseDateTime;
  private Long numberOfDecreasesToday;
  private Long readCapacityUnits;
  private Long writeCapacityUnits;
  
  public void setLastIncreaseDateTime(Date lastIncreaseDateTime)
  {
    this.lastIncreaseDateTime = lastIncreaseDateTime;
  }
  
  public Date getLastIncreaseDateTime()
  {
    return lastIncreaseDateTime;
  }
  
  public ProvisionedThroughputDescription withLastIncreaseDateTime(Date lastIncreaseDateTime)
  {
    setLastIncreaseDateTime(lastIncreaseDateTime);
    return this;
  }
  
  public void setLastDecreaseDateTime(Date lastDecreaseDateTime)
  {
    this.lastDecreaseDateTime = lastDecreaseDateTime;
  }
  
  public Date getLastDecreaseDateTime()
  {
    return lastDecreaseDateTime;
  }
  
  public ProvisionedThroughputDescription withLastDecreaseDateTime(Date lastDecreaseDateTime)
  {
    setLastDecreaseDateTime(lastDecreaseDateTime);
    return this;
  }
  
  public void setNumberOfDecreasesToday(Long numberOfDecreasesToday)
  {
    this.numberOfDecreasesToday = numberOfDecreasesToday;
  }
  
  public Long getNumberOfDecreasesToday()
  {
    return numberOfDecreasesToday;
  }
  
  public ProvisionedThroughputDescription withNumberOfDecreasesToday(Long numberOfDecreasesToday)
  {
    setNumberOfDecreasesToday(numberOfDecreasesToday);
    return this;
  }
  
  public void setReadCapacityUnits(Long readCapacityUnits)
  {
    this.readCapacityUnits = readCapacityUnits;
  }
  
  public Long getReadCapacityUnits()
  {
    return readCapacityUnits;
  }
  
  public ProvisionedThroughputDescription withReadCapacityUnits(Long readCapacityUnits)
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
  
  public ProvisionedThroughputDescription withWriteCapacityUnits(Long writeCapacityUnits)
  {
    setWriteCapacityUnits(writeCapacityUnits);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLastIncreaseDateTime() != null) {
      sb.append("LastIncreaseDateTime: ").append(getLastIncreaseDateTime()).append(",");
    }
    if (getLastDecreaseDateTime() != null) {
      sb.append("LastDecreaseDateTime: ").append(getLastDecreaseDateTime()).append(",");
    }
    if (getNumberOfDecreasesToday() != null) {
      sb.append("NumberOfDecreasesToday: ").append(getNumberOfDecreasesToday()).append(",");
    }
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
    if (!(obj instanceof ProvisionedThroughputDescription)) {
      return false;
    }
    ProvisionedThroughputDescription other = (ProvisionedThroughputDescription)obj;
    if (((other.getLastIncreaseDateTime() == null ? 1 : 0) ^ (getLastIncreaseDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastIncreaseDateTime() != null) && (!other.getLastIncreaseDateTime().equals(getLastIncreaseDateTime()))) {
      return false;
    }
    if (((other.getLastDecreaseDateTime() == null ? 1 : 0) ^ (getLastDecreaseDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastDecreaseDateTime() != null) && (!other.getLastDecreaseDateTime().equals(getLastDecreaseDateTime()))) {
      return false;
    }
    if (((other.getNumberOfDecreasesToday() == null ? 1 : 0) ^ (getNumberOfDecreasesToday() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNumberOfDecreasesToday() != null) && (!other.getNumberOfDecreasesToday().equals(getNumberOfDecreasesToday()))) {
      return false;
    }
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
    
    hashCode = 31 * hashCode + (getLastIncreaseDateTime() == null ? 0 : getLastIncreaseDateTime().hashCode());
    hashCode = 31 * hashCode + (getLastDecreaseDateTime() == null ? 0 : getLastDecreaseDateTime().hashCode());
    hashCode = 31 * hashCode + (getNumberOfDecreasesToday() == null ? 0 : getNumberOfDecreasesToday().hashCode());
    hashCode = 31 * hashCode + (getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getWriteCapacityUnits() == null ? 0 : getWriteCapacityUnits().hashCode());
    return hashCode;
  }
  
  public ProvisionedThroughputDescription clone()
  {
    try
    {
      return (ProvisionedThroughputDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ProvisionedThroughputDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */