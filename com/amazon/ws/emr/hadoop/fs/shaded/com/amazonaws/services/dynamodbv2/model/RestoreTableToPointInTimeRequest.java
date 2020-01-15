package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

public class RestoreTableToPointInTimeRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String sourceTableName;
  private String targetTableName;
  private Boolean useLatestRestorableTime;
  private Date restoreDateTime;
  
  public void setSourceTableName(String sourceTableName)
  {
    this.sourceTableName = sourceTableName;
  }
  
  public String getSourceTableName()
  {
    return sourceTableName;
  }
  
  public RestoreTableToPointInTimeRequest withSourceTableName(String sourceTableName)
  {
    setSourceTableName(sourceTableName);
    return this;
  }
  
  public void setTargetTableName(String targetTableName)
  {
    this.targetTableName = targetTableName;
  }
  
  public String getTargetTableName()
  {
    return targetTableName;
  }
  
  public RestoreTableToPointInTimeRequest withTargetTableName(String targetTableName)
  {
    setTargetTableName(targetTableName);
    return this;
  }
  
  public void setUseLatestRestorableTime(Boolean useLatestRestorableTime)
  {
    this.useLatestRestorableTime = useLatestRestorableTime;
  }
  
  public Boolean getUseLatestRestorableTime()
  {
    return useLatestRestorableTime;
  }
  
  public RestoreTableToPointInTimeRequest withUseLatestRestorableTime(Boolean useLatestRestorableTime)
  {
    setUseLatestRestorableTime(useLatestRestorableTime);
    return this;
  }
  
  public Boolean isUseLatestRestorableTime()
  {
    return useLatestRestorableTime;
  }
  
  public void setRestoreDateTime(Date restoreDateTime)
  {
    this.restoreDateTime = restoreDateTime;
  }
  
  public Date getRestoreDateTime()
  {
    return restoreDateTime;
  }
  
  public RestoreTableToPointInTimeRequest withRestoreDateTime(Date restoreDateTime)
  {
    setRestoreDateTime(restoreDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSourceTableName() != null) {
      sb.append("SourceTableName: ").append(getSourceTableName()).append(",");
    }
    if (getTargetTableName() != null) {
      sb.append("TargetTableName: ").append(getTargetTableName()).append(",");
    }
    if (getUseLatestRestorableTime() != null) {
      sb.append("UseLatestRestorableTime: ").append(getUseLatestRestorableTime()).append(",");
    }
    if (getRestoreDateTime() != null) {
      sb.append("RestoreDateTime: ").append(getRestoreDateTime());
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
    if (!(obj instanceof RestoreTableToPointInTimeRequest)) {
      return false;
    }
    RestoreTableToPointInTimeRequest other = (RestoreTableToPointInTimeRequest)obj;
    if (((other.getSourceTableName() == null ? 1 : 0) ^ (getSourceTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceTableName() != null) && (!other.getSourceTableName().equals(getSourceTableName()))) {
      return false;
    }
    if (((other.getTargetTableName() == null ? 1 : 0) ^ (getTargetTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetTableName() != null) && (!other.getTargetTableName().equals(getTargetTableName()))) {
      return false;
    }
    if (((other.getUseLatestRestorableTime() == null ? 1 : 0) ^ (getUseLatestRestorableTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUseLatestRestorableTime() != null) && (!other.getUseLatestRestorableTime().equals(getUseLatestRestorableTime()))) {
      return false;
    }
    if (((other.getRestoreDateTime() == null ? 1 : 0) ^ (getRestoreDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRestoreDateTime() != null) && (!other.getRestoreDateTime().equals(getRestoreDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSourceTableName() == null ? 0 : getSourceTableName().hashCode());
    hashCode = 31 * hashCode + (getTargetTableName() == null ? 0 : getTargetTableName().hashCode());
    hashCode = 31 * hashCode + (getUseLatestRestorableTime() == null ? 0 : getUseLatestRestorableTime().hashCode());
    hashCode = 31 * hashCode + (getRestoreDateTime() == null ? 0 : getRestoreDateTime().hashCode());
    return hashCode;
  }
  
  public RestoreTableToPointInTimeRequest clone()
  {
    return (RestoreTableToPointInTimeRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */