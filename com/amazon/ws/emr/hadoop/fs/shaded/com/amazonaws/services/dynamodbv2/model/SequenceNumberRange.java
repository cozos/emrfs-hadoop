package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SequenceNumberRangeMarshaller;
import java.io.Serializable;

public class SequenceNumberRange
  implements Serializable, Cloneable, StructuredPojo
{
  private String startingSequenceNumber;
  private String endingSequenceNumber;
  
  public void setStartingSequenceNumber(String startingSequenceNumber)
  {
    this.startingSequenceNumber = startingSequenceNumber;
  }
  
  public String getStartingSequenceNumber()
  {
    return startingSequenceNumber;
  }
  
  public SequenceNumberRange withStartingSequenceNumber(String startingSequenceNumber)
  {
    setStartingSequenceNumber(startingSequenceNumber);
    return this;
  }
  
  public void setEndingSequenceNumber(String endingSequenceNumber)
  {
    this.endingSequenceNumber = endingSequenceNumber;
  }
  
  public String getEndingSequenceNumber()
  {
    return endingSequenceNumber;
  }
  
  public SequenceNumberRange withEndingSequenceNumber(String endingSequenceNumber)
  {
    setEndingSequenceNumber(endingSequenceNumber);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStartingSequenceNumber() != null) {
      sb.append("StartingSequenceNumber: ").append(getStartingSequenceNumber()).append(",");
    }
    if (getEndingSequenceNumber() != null) {
      sb.append("EndingSequenceNumber: ").append(getEndingSequenceNumber());
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
    if (!(obj instanceof SequenceNumberRange)) {
      return false;
    }
    SequenceNumberRange other = (SequenceNumberRange)obj;
    if (((other.getStartingSequenceNumber() == null ? 1 : 0) ^ (getStartingSequenceNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartingSequenceNumber() != null) && (!other.getStartingSequenceNumber().equals(getStartingSequenceNumber()))) {
      return false;
    }
    if (((other.getEndingSequenceNumber() == null ? 1 : 0) ^ (getEndingSequenceNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndingSequenceNumber() != null) && (!other.getEndingSequenceNumber().equals(getEndingSequenceNumber()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStartingSequenceNumber() == null ? 0 : getStartingSequenceNumber().hashCode());
    hashCode = 31 * hashCode + (getEndingSequenceNumber() == null ? 0 : getEndingSequenceNumber().hashCode());
    return hashCode;
  }
  
  public SequenceNumberRange clone()
  {
    try
    {
      return (SequenceNumberRange)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SequenceNumberRangeMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SequenceNumberRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */