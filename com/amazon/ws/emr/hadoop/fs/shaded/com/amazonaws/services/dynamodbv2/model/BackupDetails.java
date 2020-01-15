package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupDetailsMarshaller;
import java.io.Serializable;
import java.util.Date;

public class BackupDetails
  implements Serializable, Cloneable, StructuredPojo
{
  private String backupArn;
  private String backupName;
  private Long backupSizeBytes;
  private String backupStatus;
  private String backupType;
  private Date backupCreationDateTime;
  private Date backupExpiryDateTime;
  
  public void setBackupArn(String backupArn)
  {
    this.backupArn = backupArn;
  }
  
  public String getBackupArn()
  {
    return backupArn;
  }
  
  public BackupDetails withBackupArn(String backupArn)
  {
    setBackupArn(backupArn);
    return this;
  }
  
  public void setBackupName(String backupName)
  {
    this.backupName = backupName;
  }
  
  public String getBackupName()
  {
    return backupName;
  }
  
  public BackupDetails withBackupName(String backupName)
  {
    setBackupName(backupName);
    return this;
  }
  
  public void setBackupSizeBytes(Long backupSizeBytes)
  {
    this.backupSizeBytes = backupSizeBytes;
  }
  
  public Long getBackupSizeBytes()
  {
    return backupSizeBytes;
  }
  
  public BackupDetails withBackupSizeBytes(Long backupSizeBytes)
  {
    setBackupSizeBytes(backupSizeBytes);
    return this;
  }
  
  public void setBackupStatus(String backupStatus)
  {
    this.backupStatus = backupStatus;
  }
  
  public String getBackupStatus()
  {
    return backupStatus;
  }
  
  public BackupDetails withBackupStatus(String backupStatus)
  {
    setBackupStatus(backupStatus);
    return this;
  }
  
  public BackupDetails withBackupStatus(BackupStatus backupStatus)
  {
    this.backupStatus = backupStatus.toString();
    return this;
  }
  
  public void setBackupType(String backupType)
  {
    this.backupType = backupType;
  }
  
  public String getBackupType()
  {
    return backupType;
  }
  
  public BackupDetails withBackupType(String backupType)
  {
    setBackupType(backupType);
    return this;
  }
  
  public BackupDetails withBackupType(BackupType backupType)
  {
    this.backupType = backupType.toString();
    return this;
  }
  
  public void setBackupCreationDateTime(Date backupCreationDateTime)
  {
    this.backupCreationDateTime = backupCreationDateTime;
  }
  
  public Date getBackupCreationDateTime()
  {
    return backupCreationDateTime;
  }
  
  public BackupDetails withBackupCreationDateTime(Date backupCreationDateTime)
  {
    setBackupCreationDateTime(backupCreationDateTime);
    return this;
  }
  
  public void setBackupExpiryDateTime(Date backupExpiryDateTime)
  {
    this.backupExpiryDateTime = backupExpiryDateTime;
  }
  
  public Date getBackupExpiryDateTime()
  {
    return backupExpiryDateTime;
  }
  
  public BackupDetails withBackupExpiryDateTime(Date backupExpiryDateTime)
  {
    setBackupExpiryDateTime(backupExpiryDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupArn() != null) {
      sb.append("BackupArn: ").append(getBackupArn()).append(",");
    }
    if (getBackupName() != null) {
      sb.append("BackupName: ").append(getBackupName()).append(",");
    }
    if (getBackupSizeBytes() != null) {
      sb.append("BackupSizeBytes: ").append(getBackupSizeBytes()).append(",");
    }
    if (getBackupStatus() != null) {
      sb.append("BackupStatus: ").append(getBackupStatus()).append(",");
    }
    if (getBackupType() != null) {
      sb.append("BackupType: ").append(getBackupType()).append(",");
    }
    if (getBackupCreationDateTime() != null) {
      sb.append("BackupCreationDateTime: ").append(getBackupCreationDateTime()).append(",");
    }
    if (getBackupExpiryDateTime() != null) {
      sb.append("BackupExpiryDateTime: ").append(getBackupExpiryDateTime());
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
    if (!(obj instanceof BackupDetails)) {
      return false;
    }
    BackupDetails other = (BackupDetails)obj;
    if (((other.getBackupArn() == null ? 1 : 0) ^ (getBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupArn() != null) && (!other.getBackupArn().equals(getBackupArn()))) {
      return false;
    }
    if (((other.getBackupName() == null ? 1 : 0) ^ (getBackupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupName() != null) && (!other.getBackupName().equals(getBackupName()))) {
      return false;
    }
    if (((other.getBackupSizeBytes() == null ? 1 : 0) ^ (getBackupSizeBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupSizeBytes() != null) && (!other.getBackupSizeBytes().equals(getBackupSizeBytes()))) {
      return false;
    }
    if (((other.getBackupStatus() == null ? 1 : 0) ^ (getBackupStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupStatus() != null) && (!other.getBackupStatus().equals(getBackupStatus()))) {
      return false;
    }
    if (((other.getBackupType() == null ? 1 : 0) ^ (getBackupType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupType() != null) && (!other.getBackupType().equals(getBackupType()))) {
      return false;
    }
    if (((other.getBackupCreationDateTime() == null ? 1 : 0) ^ (getBackupCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupCreationDateTime() != null) && (!other.getBackupCreationDateTime().equals(getBackupCreationDateTime()))) {
      return false;
    }
    if (((other.getBackupExpiryDateTime() == null ? 1 : 0) ^ (getBackupExpiryDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupExpiryDateTime() != null) && (!other.getBackupExpiryDateTime().equals(getBackupExpiryDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupArn() == null ? 0 : getBackupArn().hashCode());
    hashCode = 31 * hashCode + (getBackupName() == null ? 0 : getBackupName().hashCode());
    hashCode = 31 * hashCode + (getBackupSizeBytes() == null ? 0 : getBackupSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getBackupStatus() == null ? 0 : getBackupStatus().hashCode());
    hashCode = 31 * hashCode + (getBackupType() == null ? 0 : getBackupType().hashCode());
    hashCode = 31 * hashCode + (getBackupCreationDateTime() == null ? 0 : getBackupCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getBackupExpiryDateTime() == null ? 0 : getBackupExpiryDateTime().hashCode());
    return hashCode;
  }
  
  public BackupDetails clone()
  {
    try
    {
      return (BackupDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BackupDetailsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */