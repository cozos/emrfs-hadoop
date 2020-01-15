package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RestoreTableFromBackupRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String targetTableName;
  private String backupArn;
  
  public void setTargetTableName(String targetTableName)
  {
    this.targetTableName = targetTableName;
  }
  
  public String getTargetTableName()
  {
    return targetTableName;
  }
  
  public RestoreTableFromBackupRequest withTargetTableName(String targetTableName)
  {
    setTargetTableName(targetTableName);
    return this;
  }
  
  public void setBackupArn(String backupArn)
  {
    this.backupArn = backupArn;
  }
  
  public String getBackupArn()
  {
    return backupArn;
  }
  
  public RestoreTableFromBackupRequest withBackupArn(String backupArn)
  {
    setBackupArn(backupArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTargetTableName() != null) {
      sb.append("TargetTableName: ").append(getTargetTableName()).append(",");
    }
    if (getBackupArn() != null) {
      sb.append("BackupArn: ").append(getBackupArn());
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
    if (!(obj instanceof RestoreTableFromBackupRequest)) {
      return false;
    }
    RestoreTableFromBackupRequest other = (RestoreTableFromBackupRequest)obj;
    if (((other.getTargetTableName() == null ? 1 : 0) ^ (getTargetTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetTableName() != null) && (!other.getTargetTableName().equals(getTargetTableName()))) {
      return false;
    }
    if (((other.getBackupArn() == null ? 1 : 0) ^ (getBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupArn() != null) && (!other.getBackupArn().equals(getBackupArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTargetTableName() == null ? 0 : getTargetTableName().hashCode());
    hashCode = 31 * hashCode + (getBackupArn() == null ? 0 : getBackupArn().hashCode());
    return hashCode;
  }
  
  public RestoreTableFromBackupRequest clone()
  {
    return (RestoreTableFromBackupRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */