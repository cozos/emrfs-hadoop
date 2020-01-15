package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListBackupsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<BackupSummary> backupSummaries;
  private String lastEvaluatedBackupArn;
  
  public List<BackupSummary> getBackupSummaries()
  {
    return backupSummaries;
  }
  
  public void setBackupSummaries(Collection<BackupSummary> backupSummaries)
  {
    if (backupSummaries == null)
    {
      this.backupSummaries = null;
      return;
    }
    this.backupSummaries = new ArrayList(backupSummaries);
  }
  
  public ListBackupsResult withBackupSummaries(BackupSummary... backupSummaries)
  {
    if (this.backupSummaries == null) {
      setBackupSummaries(new ArrayList(backupSummaries.length));
    }
    for (BackupSummary ele : backupSummaries) {
      this.backupSummaries.add(ele);
    }
    return this;
  }
  
  public ListBackupsResult withBackupSummaries(Collection<BackupSummary> backupSummaries)
  {
    setBackupSummaries(backupSummaries);
    return this;
  }
  
  public void setLastEvaluatedBackupArn(String lastEvaluatedBackupArn)
  {
    this.lastEvaluatedBackupArn = lastEvaluatedBackupArn;
  }
  
  public String getLastEvaluatedBackupArn()
  {
    return lastEvaluatedBackupArn;
  }
  
  public ListBackupsResult withLastEvaluatedBackupArn(String lastEvaluatedBackupArn)
  {
    setLastEvaluatedBackupArn(lastEvaluatedBackupArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupSummaries() != null) {
      sb.append("BackupSummaries: ").append(getBackupSummaries()).append(",");
    }
    if (getLastEvaluatedBackupArn() != null) {
      sb.append("LastEvaluatedBackupArn: ").append(getLastEvaluatedBackupArn());
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
    if (!(obj instanceof ListBackupsResult)) {
      return false;
    }
    ListBackupsResult other = (ListBackupsResult)obj;
    if (((other.getBackupSummaries() == null ? 1 : 0) ^ (getBackupSummaries() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupSummaries() != null) && (!other.getBackupSummaries().equals(getBackupSummaries()))) {
      return false;
    }
    if (((other.getLastEvaluatedBackupArn() == null ? 1 : 0) ^ (getLastEvaluatedBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedBackupArn() != null) && (!other.getLastEvaluatedBackupArn().equals(getLastEvaluatedBackupArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupSummaries() == null ? 0 : getBackupSummaries().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedBackupArn() == null ? 0 : getLastEvaluatedBackupArn().hashCode());
    return hashCode;
  }
  
  public ListBackupsResult clone()
  {
    try
    {
      return (ListBackupsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */