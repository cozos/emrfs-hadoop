package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateBackupResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private BackupDetails backupDetails;
  
  public void setBackupDetails(BackupDetails backupDetails)
  {
    this.backupDetails = backupDetails;
  }
  
  public BackupDetails getBackupDetails()
  {
    return backupDetails;
  }
  
  public CreateBackupResult withBackupDetails(BackupDetails backupDetails)
  {
    setBackupDetails(backupDetails);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupDetails() != null) {
      sb.append("BackupDetails: ").append(getBackupDetails());
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
    if (!(obj instanceof CreateBackupResult)) {
      return false;
    }
    CreateBackupResult other = (CreateBackupResult)obj;
    if (((other.getBackupDetails() == null ? 1 : 0) ^ (getBackupDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupDetails() != null) && (!other.getBackupDetails().equals(getBackupDetails()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupDetails() == null ? 0 : getBackupDetails().hashCode());
    return hashCode;
  }
  
  public CreateBackupResult clone()
  {
    try
    {
      return (CreateBackupResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */