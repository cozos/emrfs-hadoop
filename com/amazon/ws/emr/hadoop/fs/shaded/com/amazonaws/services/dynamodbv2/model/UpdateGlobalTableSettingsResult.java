package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateGlobalTableSettingsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String globalTableName;
  private List<ReplicaSettingsDescription> replicaSettings;
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public UpdateGlobalTableSettingsResult withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public List<ReplicaSettingsDescription> getReplicaSettings()
  {
    return replicaSettings;
  }
  
  public void setReplicaSettings(Collection<ReplicaSettingsDescription> replicaSettings)
  {
    if (replicaSettings == null)
    {
      this.replicaSettings = null;
      return;
    }
    this.replicaSettings = new ArrayList(replicaSettings);
  }
  
  public UpdateGlobalTableSettingsResult withReplicaSettings(ReplicaSettingsDescription... replicaSettings)
  {
    if (this.replicaSettings == null) {
      setReplicaSettings(new ArrayList(replicaSettings.length));
    }
    for (ReplicaSettingsDescription ele : replicaSettings) {
      this.replicaSettings.add(ele);
    }
    return this;
  }
  
  public UpdateGlobalTableSettingsResult withReplicaSettings(Collection<ReplicaSettingsDescription> replicaSettings)
  {
    setReplicaSettings(replicaSettings);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName()).append(",");
    }
    if (getReplicaSettings() != null) {
      sb.append("ReplicaSettings: ").append(getReplicaSettings());
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
    if (!(obj instanceof UpdateGlobalTableSettingsResult)) {
      return false;
    }
    UpdateGlobalTableSettingsResult other = (UpdateGlobalTableSettingsResult)obj;
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    if (((other.getReplicaSettings() == null ? 1 : 0) ^ (getReplicaSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaSettings() != null) && (!other.getReplicaSettings().equals(getReplicaSettings()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    hashCode = 31 * hashCode + (getReplicaSettings() == null ? 0 : getReplicaSettings().hashCode());
    return hashCode;
  }
  
  public UpdateGlobalTableSettingsResult clone()
  {
    try
    {
      return (UpdateGlobalTableSettingsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */