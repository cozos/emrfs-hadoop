package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupDescriptionMarshaller;
import java.io.Serializable;

public class BackupDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private BackupDetails backupDetails;
  private SourceTableDetails sourceTableDetails;
  private SourceTableFeatureDetails sourceTableFeatureDetails;
  
  public void setBackupDetails(BackupDetails backupDetails)
  {
    this.backupDetails = backupDetails;
  }
  
  public BackupDetails getBackupDetails()
  {
    return backupDetails;
  }
  
  public BackupDescription withBackupDetails(BackupDetails backupDetails)
  {
    setBackupDetails(backupDetails);
    return this;
  }
  
  public void setSourceTableDetails(SourceTableDetails sourceTableDetails)
  {
    this.sourceTableDetails = sourceTableDetails;
  }
  
  public SourceTableDetails getSourceTableDetails()
  {
    return sourceTableDetails;
  }
  
  public BackupDescription withSourceTableDetails(SourceTableDetails sourceTableDetails)
  {
    setSourceTableDetails(sourceTableDetails);
    return this;
  }
  
  public void setSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails)
  {
    this.sourceTableFeatureDetails = sourceTableFeatureDetails;
  }
  
  public SourceTableFeatureDetails getSourceTableFeatureDetails()
  {
    return sourceTableFeatureDetails;
  }
  
  public BackupDescription withSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails)
  {
    setSourceTableFeatureDetails(sourceTableFeatureDetails);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupDetails() != null) {
      sb.append("BackupDetails: ").append(getBackupDetails()).append(",");
    }
    if (getSourceTableDetails() != null) {
      sb.append("SourceTableDetails: ").append(getSourceTableDetails()).append(",");
    }
    if (getSourceTableFeatureDetails() != null) {
      sb.append("SourceTableFeatureDetails: ").append(getSourceTableFeatureDetails());
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
    if (!(obj instanceof BackupDescription)) {
      return false;
    }
    BackupDescription other = (BackupDescription)obj;
    if (((other.getBackupDetails() == null ? 1 : 0) ^ (getBackupDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupDetails() != null) && (!other.getBackupDetails().equals(getBackupDetails()))) {
      return false;
    }
    if (((other.getSourceTableDetails() == null ? 1 : 0) ^ (getSourceTableDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceTableDetails() != null) && (!other.getSourceTableDetails().equals(getSourceTableDetails()))) {
      return false;
    }
    if (((other.getSourceTableFeatureDetails() == null ? 1 : 0) ^ (getSourceTableFeatureDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourceTableFeatureDetails() != null) && (!other.getSourceTableFeatureDetails().equals(getSourceTableFeatureDetails()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupDetails() == null ? 0 : getBackupDetails().hashCode());
    hashCode = 31 * hashCode + (getSourceTableDetails() == null ? 0 : getSourceTableDetails().hashCode());
    hashCode = 31 * hashCode + (getSourceTableFeatureDetails() == null ? 0 : getSourceTableFeatureDetails().hashCode());
    return hashCode;
  }
  
  public BackupDescription clone()
  {
    try
    {
      return (BackupDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BackupDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */