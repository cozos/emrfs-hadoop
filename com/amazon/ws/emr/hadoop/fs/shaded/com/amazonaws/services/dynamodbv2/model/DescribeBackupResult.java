package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeBackupResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private BackupDescription backupDescription;
  
  public void setBackupDescription(BackupDescription backupDescription)
  {
    this.backupDescription = backupDescription;
  }
  
  public BackupDescription getBackupDescription()
  {
    return backupDescription;
  }
  
  public DescribeBackupResult withBackupDescription(BackupDescription backupDescription)
  {
    setBackupDescription(backupDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupDescription() != null) {
      sb.append("BackupDescription: ").append(getBackupDescription());
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
    if (!(obj instanceof DescribeBackupResult)) {
      return false;
    }
    DescribeBackupResult other = (DescribeBackupResult)obj;
    if (((other.getBackupDescription() == null ? 1 : 0) ^ (getBackupDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupDescription() != null) && (!other.getBackupDescription().equals(getBackupDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupDescription() == null ? 0 : getBackupDescription().hashCode());
    return hashCode;
  }
  
  public DescribeBackupResult clone()
  {
    try
    {
      return (DescribeBackupResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */