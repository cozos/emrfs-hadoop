package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

public class ListBackupsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private Integer limit;
  private Date timeRangeLowerBound;
  private Date timeRangeUpperBound;
  private String exclusiveStartBackupArn;
  private String backupType;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public ListBackupsRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public ListBackupsRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void setTimeRangeLowerBound(Date timeRangeLowerBound)
  {
    this.timeRangeLowerBound = timeRangeLowerBound;
  }
  
  public Date getTimeRangeLowerBound()
  {
    return timeRangeLowerBound;
  }
  
  public ListBackupsRequest withTimeRangeLowerBound(Date timeRangeLowerBound)
  {
    setTimeRangeLowerBound(timeRangeLowerBound);
    return this;
  }
  
  public void setTimeRangeUpperBound(Date timeRangeUpperBound)
  {
    this.timeRangeUpperBound = timeRangeUpperBound;
  }
  
  public Date getTimeRangeUpperBound()
  {
    return timeRangeUpperBound;
  }
  
  public ListBackupsRequest withTimeRangeUpperBound(Date timeRangeUpperBound)
  {
    setTimeRangeUpperBound(timeRangeUpperBound);
    return this;
  }
  
  public void setExclusiveStartBackupArn(String exclusiveStartBackupArn)
  {
    this.exclusiveStartBackupArn = exclusiveStartBackupArn;
  }
  
  public String getExclusiveStartBackupArn()
  {
    return exclusiveStartBackupArn;
  }
  
  public ListBackupsRequest withExclusiveStartBackupArn(String exclusiveStartBackupArn)
  {
    setExclusiveStartBackupArn(exclusiveStartBackupArn);
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
  
  public ListBackupsRequest withBackupType(String backupType)
  {
    setBackupType(backupType);
    return this;
  }
  
  public ListBackupsRequest withBackupType(BackupTypeFilter backupType)
  {
    this.backupType = backupType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getTimeRangeLowerBound() != null) {
      sb.append("TimeRangeLowerBound: ").append(getTimeRangeLowerBound()).append(",");
    }
    if (getTimeRangeUpperBound() != null) {
      sb.append("TimeRangeUpperBound: ").append(getTimeRangeUpperBound()).append(",");
    }
    if (getExclusiveStartBackupArn() != null) {
      sb.append("ExclusiveStartBackupArn: ").append(getExclusiveStartBackupArn()).append(",");
    }
    if (getBackupType() != null) {
      sb.append("BackupType: ").append(getBackupType());
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
    if (!(obj instanceof ListBackupsRequest)) {
      return false;
    }
    ListBackupsRequest other = (ListBackupsRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    if (((other.getTimeRangeLowerBound() == null ? 1 : 0) ^ (getTimeRangeLowerBound() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeRangeLowerBound() != null) && (!other.getTimeRangeLowerBound().equals(getTimeRangeLowerBound()))) {
      return false;
    }
    if (((other.getTimeRangeUpperBound() == null ? 1 : 0) ^ (getTimeRangeUpperBound() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeRangeUpperBound() != null) && (!other.getTimeRangeUpperBound().equals(getTimeRangeUpperBound()))) {
      return false;
    }
    if (((other.getExclusiveStartBackupArn() == null ? 1 : 0) ^ (getExclusiveStartBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartBackupArn() != null) && (!other.getExclusiveStartBackupArn().equals(getExclusiveStartBackupArn()))) {
      return false;
    }
    if (((other.getBackupType() == null ? 1 : 0) ^ (getBackupType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupType() != null) && (!other.getBackupType().equals(getBackupType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getTimeRangeLowerBound() == null ? 0 : getTimeRangeLowerBound().hashCode());
    hashCode = 31 * hashCode + (getTimeRangeUpperBound() == null ? 0 : getTimeRangeUpperBound().hashCode());
    hashCode = 31 * hashCode + (getExclusiveStartBackupArn() == null ? 0 : getExclusiveStartBackupArn().hashCode());
    hashCode = 31 * hashCode + (getBackupType() == null ? 0 : getBackupType().hashCode());
    return hashCode;
  }
  
  public ListBackupsRequest clone()
  {
    return (ListBackupsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */