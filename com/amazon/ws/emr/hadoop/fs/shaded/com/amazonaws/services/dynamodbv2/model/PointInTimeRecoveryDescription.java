package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryDescriptionMarshaller;
import java.io.Serializable;
import java.util.Date;

public class PointInTimeRecoveryDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String pointInTimeRecoveryStatus;
  private Date earliestRestorableDateTime;
  private Date latestRestorableDateTime;
  
  public void setPointInTimeRecoveryStatus(String pointInTimeRecoveryStatus)
  {
    this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus;
  }
  
  public String getPointInTimeRecoveryStatus()
  {
    return pointInTimeRecoveryStatus;
  }
  
  public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(String pointInTimeRecoveryStatus)
  {
    setPointInTimeRecoveryStatus(pointInTimeRecoveryStatus);
    return this;
  }
  
  public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(PointInTimeRecoveryStatus pointInTimeRecoveryStatus)
  {
    this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus.toString();
    return this;
  }
  
  public void setEarliestRestorableDateTime(Date earliestRestorableDateTime)
  {
    this.earliestRestorableDateTime = earliestRestorableDateTime;
  }
  
  public Date getEarliestRestorableDateTime()
  {
    return earliestRestorableDateTime;
  }
  
  public PointInTimeRecoveryDescription withEarliestRestorableDateTime(Date earliestRestorableDateTime)
  {
    setEarliestRestorableDateTime(earliestRestorableDateTime);
    return this;
  }
  
  public void setLatestRestorableDateTime(Date latestRestorableDateTime)
  {
    this.latestRestorableDateTime = latestRestorableDateTime;
  }
  
  public Date getLatestRestorableDateTime()
  {
    return latestRestorableDateTime;
  }
  
  public PointInTimeRecoveryDescription withLatestRestorableDateTime(Date latestRestorableDateTime)
  {
    setLatestRestorableDateTime(latestRestorableDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPointInTimeRecoveryStatus() != null) {
      sb.append("PointInTimeRecoveryStatus: ").append(getPointInTimeRecoveryStatus()).append(",");
    }
    if (getEarliestRestorableDateTime() != null) {
      sb.append("EarliestRestorableDateTime: ").append(getEarliestRestorableDateTime()).append(",");
    }
    if (getLatestRestorableDateTime() != null) {
      sb.append("LatestRestorableDateTime: ").append(getLatestRestorableDateTime());
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
    if (!(obj instanceof PointInTimeRecoveryDescription)) {
      return false;
    }
    PointInTimeRecoveryDescription other = (PointInTimeRecoveryDescription)obj;
    if (((other.getPointInTimeRecoveryStatus() == null ? 1 : 0) ^ (getPointInTimeRecoveryStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPointInTimeRecoveryStatus() != null) && (!other.getPointInTimeRecoveryStatus().equals(getPointInTimeRecoveryStatus()))) {
      return false;
    }
    if (((other.getEarliestRestorableDateTime() == null ? 1 : 0) ^ (getEarliestRestorableDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEarliestRestorableDateTime() != null) && (!other.getEarliestRestorableDateTime().equals(getEarliestRestorableDateTime()))) {
      return false;
    }
    if (((other.getLatestRestorableDateTime() == null ? 1 : 0) ^ (getLatestRestorableDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLatestRestorableDateTime() != null) && (!other.getLatestRestorableDateTime().equals(getLatestRestorableDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPointInTimeRecoveryStatus() == null ? 0 : getPointInTimeRecoveryStatus().hashCode());
    hashCode = 31 * hashCode + (getEarliestRestorableDateTime() == null ? 0 : getEarliestRestorableDateTime().hashCode());
    hashCode = 31 * hashCode + (getLatestRestorableDateTime() == null ? 0 : getLatestRestorableDateTime().hashCode());
    return hashCode;
  }
  
  public PointInTimeRecoveryDescription clone()
  {
    try
    {
      return (PointInTimeRecoveryDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    PointInTimeRecoveryDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */