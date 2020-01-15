package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateBackupRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private String backupName;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public CreateBackupRequest withTableName(String tableName)
  {
    setTableName(tableName);
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
  
  public CreateBackupRequest withBackupName(String backupName)
  {
    setBackupName(backupName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getBackupName() != null) {
      sb.append("BackupName: ").append(getBackupName());
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
    if (!(obj instanceof CreateBackupRequest)) {
      return false;
    }
    CreateBackupRequest other = (CreateBackupRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getBackupName() == null ? 1 : 0) ^ (getBackupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupName() != null) && (!other.getBackupName().equals(getBackupName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getBackupName() == null ? 0 : getBackupName().hashCode());
    return hashCode;
  }
  
  public CreateBackupRequest clone()
  {
    return (CreateBackupRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */