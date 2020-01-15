package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreSummaryMarshaller;
import java.io.Serializable;
import java.util.Date;

public class RestoreSummary
  implements Serializable, Cloneable, StructuredPojo
{
  private String sourceBackupArn;
  private String sourceTableArn;
  private Date restoreDateTime;
  private Boolean restoreInProgress;
  
  public void setSourceBackupArn(String sourceBackupArn)
  {
    this.sourceBackupArn = sourceBackupArn;
  }
  
  public String getSourceBackupArn()
  {
    return sourceBackupArn;
  }
  
  public RestoreSummary withSourceBackupArn(String sourceBackupArn)
  {
    setSourceBackupArn(sourceBackupArn);
    return this;
  }
  
  public void setSourceTableArn(String sourceTableArn)
  {
    this.sourceTableArn = sourceTableArn;
  }
  
  public String getSourceTableArn()
  {
    return sourceTableArn;
  }
  
  public RestoreSummary withSourceTableArn(String sourceTableArn)
  {
    setSourceTableArn(sourceTableArn);
    return this;
  }
  
  public void setRestoreDateTime(Date restoreDateTime)
  {
    this.restoreDateTime = restoreDateTime;
  }
  
  public Date getRestoreDateTime()
  {
    return restoreDateTime;
  }
  
  public RestoreSummary withRestoreDateTime(Date restoreDateTime)
  {
    setRestoreDateTime(restoreDateTime);
    return this;
  }
  
  public void setRestoreInProgress(Boolean restoreInProgress)
  {
    this.restoreInProgress = restoreInProgress;
  }
  
  public Boolean getRestoreInProgress()
  {
    return restoreInProgress;
  }
  
  public RestoreSummary withRestoreInProgress(Boolean restoreInProgress)
  {
    setRestoreInProgress(restoreInProgress);
    return this;
  }
  
  public Boolean isRestoreInProgress()
  {
    return restoreInProgress;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSourceBackupArn() != null) {
      sb.append("SourceBackupArn: ").append(getSourceBackupArn()).append(",");
    }
    if (getSourceTableArn() != null) {
      sb.append("SourceTableArn: ").append(getSourceTableArn()).append(",");
    }
    if (getRestoreDateTime() != null) {
      sb.append("RestoreDateTime: ").append(getRestoreDateTime()).append(",");
    }
    if (getRestoreInProgress() != null) {
      sb.append("RestoreInProgress: ").append(getRestoreInProgress());
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
    if (!(obj instanceof RestoreSummary)) {
      return false;
    }
    RestoreSummary other = (RestoreSummary)obj;
    if (((other.getSourceBackupArn() == null ? 1 : 0) ^ (getSourceBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceBackupArn() != null) && (!other.getSourceBackupArn().equals(getSourceBackupArn()))) {
      return false;
    }
    if (((other.getSourceTableArn() == null ? 1 : 0) ^ (getSourceTableArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceTableArn() != null) && (!other.getSourceTableArn().equals(getSourceTableArn()))) {
      return false;
    }
    if (((other.getRestoreDateTime() == null ? 1 : 0) ^ (getRestoreDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRestoreDateTime() != null) && (!other.getRestoreDateTime().equals(getRestoreDateTime()))) {
      return false;
    }
    if (((other.getRestoreInProgress() == null ? 1 : 0) ^ (getRestoreInProgress() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRestoreInProgress() != null) && (!other.getRestoreInProgress().equals(getRestoreInProgress()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSourceBackupArn() == null ? 0 : getSourceBackupArn().hashCode());
    hashCode = 31 * hashCode + (getSourceTableArn() == null ? 0 : getSourceTableArn().hashCode());
    hashCode = 31 * hashCode + (getRestoreDateTime() == null ? 0 : getRestoreDateTime().hashCode());
    hashCode = 31 * hashCode + (getRestoreInProgress() == null ? 0 : getRestoreInProgress().hashCode());
    return hashCode;
  }
  
  public RestoreSummary clone()
  {
    try
    {
      return (RestoreSummary)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    RestoreSummaryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */