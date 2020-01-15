package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsDescriptionMarshaller;
import java.io.Serializable;

public class ContinuousBackupsDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String continuousBackupsStatus;
  private PointInTimeRecoveryDescription pointInTimeRecoveryDescription;
  
  public void setContinuousBackupsStatus(String continuousBackupsStatus)
  {
    this.continuousBackupsStatus = continuousBackupsStatus;
  }
  
  public String getContinuousBackupsStatus()
  {
    return continuousBackupsStatus;
  }
  
  public ContinuousBackupsDescription withContinuousBackupsStatus(String continuousBackupsStatus)
  {
    setContinuousBackupsStatus(continuousBackupsStatus);
    return this;
  }
  
  public ContinuousBackupsDescription withContinuousBackupsStatus(ContinuousBackupsStatus continuousBackupsStatus)
  {
    this.continuousBackupsStatus = continuousBackupsStatus.toString();
    return this;
  }
  
  public void setPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription)
  {
    this.pointInTimeRecoveryDescription = pointInTimeRecoveryDescription;
  }
  
  public PointInTimeRecoveryDescription getPointInTimeRecoveryDescription()
  {
    return pointInTimeRecoveryDescription;
  }
  
  public ContinuousBackupsDescription withPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription)
  {
    setPointInTimeRecoveryDescription(pointInTimeRecoveryDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getContinuousBackupsStatus() != null) {
      sb.append("ContinuousBackupsStatus: ").append(getContinuousBackupsStatus()).append(",");
    }
    if (getPointInTimeRecoveryDescription() != null) {
      sb.append("PointInTimeRecoveryDescription: ").append(getPointInTimeRecoveryDescription());
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
    if (!(obj instanceof ContinuousBackupsDescription)) {
      return false;
    }
    ContinuousBackupsDescription other = (ContinuousBackupsDescription)obj;
    if (((other.getContinuousBackupsStatus() == null ? 1 : 0) ^ (getContinuousBackupsStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContinuousBackupsStatus() != null) && (!other.getContinuousBackupsStatus().equals(getContinuousBackupsStatus()))) {
      return false;
    }
    if (((other.getPointInTimeRecoveryDescription() == null ? 1 : 0) ^ (getPointInTimeRecoveryDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPointInTimeRecoveryDescription() != null) && 
      (!other.getPointInTimeRecoveryDescription().equals(getPointInTimeRecoveryDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getContinuousBackupsStatus() == null ? 0 : getContinuousBackupsStatus().hashCode());
    hashCode = 31 * hashCode + (getPointInTimeRecoveryDescription() == null ? 0 : getPointInTimeRecoveryDescription().hashCode());
    return hashCode;
  }
  
  public ContinuousBackupsDescription clone()
  {
    try
    {
      return (ContinuousBackupsDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ContinuousBackupsDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ContinuousBackupsDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */