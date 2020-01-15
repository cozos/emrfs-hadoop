package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateGlobalTableSettingsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String globalTableName;
  private String globalTableBillingMode;
  private Long globalTableProvisionedWriteCapacityUnits;
  private AutoScalingSettingsUpdate globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate;
  private List<GlobalTableGlobalSecondaryIndexSettingsUpdate> globalTableGlobalSecondaryIndexSettingsUpdate;
  private List<ReplicaSettingsUpdate> replicaSettingsUpdate;
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public void setGlobalTableBillingMode(String globalTableBillingMode)
  {
    this.globalTableBillingMode = globalTableBillingMode;
  }
  
  public String getGlobalTableBillingMode()
  {
    return globalTableBillingMode;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableBillingMode(String globalTableBillingMode)
  {
    setGlobalTableBillingMode(globalTableBillingMode);
    return this;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableBillingMode(BillingMode globalTableBillingMode)
  {
    this.globalTableBillingMode = globalTableBillingMode.toString();
    return this;
  }
  
  public void setGlobalTableProvisionedWriteCapacityUnits(Long globalTableProvisionedWriteCapacityUnits)
  {
    this.globalTableProvisionedWriteCapacityUnits = globalTableProvisionedWriteCapacityUnits;
  }
  
  public Long getGlobalTableProvisionedWriteCapacityUnits()
  {
    return globalTableProvisionedWriteCapacityUnits;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableProvisionedWriteCapacityUnits(Long globalTableProvisionedWriteCapacityUnits)
  {
    setGlobalTableProvisionedWriteCapacityUnits(globalTableProvisionedWriteCapacityUnits);
    return this;
  }
  
  public void setGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate)
  {
    this.globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate = globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate;
  }
  
  public AutoScalingSettingsUpdate getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate()
  {
    return globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate)
  {
    setGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate);
    return this;
  }
  
  public List<GlobalTableGlobalSecondaryIndexSettingsUpdate> getGlobalTableGlobalSecondaryIndexSettingsUpdate()
  {
    return globalTableGlobalSecondaryIndexSettingsUpdate;
  }
  
  public void setGlobalTableGlobalSecondaryIndexSettingsUpdate(Collection<GlobalTableGlobalSecondaryIndexSettingsUpdate> globalTableGlobalSecondaryIndexSettingsUpdate)
  {
    if (globalTableGlobalSecondaryIndexSettingsUpdate == null)
    {
      this.globalTableGlobalSecondaryIndexSettingsUpdate = null;
      return;
    }
    this.globalTableGlobalSecondaryIndexSettingsUpdate = new ArrayList(globalTableGlobalSecondaryIndexSettingsUpdate);
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableGlobalSecondaryIndexSettingsUpdate(GlobalTableGlobalSecondaryIndexSettingsUpdate... globalTableGlobalSecondaryIndexSettingsUpdate)
  {
    if (this.globalTableGlobalSecondaryIndexSettingsUpdate == null) {
      setGlobalTableGlobalSecondaryIndexSettingsUpdate(new ArrayList(globalTableGlobalSecondaryIndexSettingsUpdate.length));
    }
    for (GlobalTableGlobalSecondaryIndexSettingsUpdate ele : globalTableGlobalSecondaryIndexSettingsUpdate) {
      this.globalTableGlobalSecondaryIndexSettingsUpdate.add(ele);
    }
    return this;
  }
  
  public UpdateGlobalTableSettingsRequest withGlobalTableGlobalSecondaryIndexSettingsUpdate(Collection<GlobalTableGlobalSecondaryIndexSettingsUpdate> globalTableGlobalSecondaryIndexSettingsUpdate)
  {
    setGlobalTableGlobalSecondaryIndexSettingsUpdate(globalTableGlobalSecondaryIndexSettingsUpdate);
    return this;
  }
  
  public List<ReplicaSettingsUpdate> getReplicaSettingsUpdate()
  {
    return replicaSettingsUpdate;
  }
  
  public void setReplicaSettingsUpdate(Collection<ReplicaSettingsUpdate> replicaSettingsUpdate)
  {
    if (replicaSettingsUpdate == null)
    {
      this.replicaSettingsUpdate = null;
      return;
    }
    this.replicaSettingsUpdate = new ArrayList(replicaSettingsUpdate);
  }
  
  public UpdateGlobalTableSettingsRequest withReplicaSettingsUpdate(ReplicaSettingsUpdate... replicaSettingsUpdate)
  {
    if (this.replicaSettingsUpdate == null) {
      setReplicaSettingsUpdate(new ArrayList(replicaSettingsUpdate.length));
    }
    for (ReplicaSettingsUpdate ele : replicaSettingsUpdate) {
      this.replicaSettingsUpdate.add(ele);
    }
    return this;
  }
  
  public UpdateGlobalTableSettingsRequest withReplicaSettingsUpdate(Collection<ReplicaSettingsUpdate> replicaSettingsUpdate)
  {
    setReplicaSettingsUpdate(replicaSettingsUpdate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName()).append(",");
    }
    if (getGlobalTableBillingMode() != null) {
      sb.append("GlobalTableBillingMode: ").append(getGlobalTableBillingMode()).append(",");
    }
    if (getGlobalTableProvisionedWriteCapacityUnits() != null) {
      sb.append("GlobalTableProvisionedWriteCapacityUnits: ").append(getGlobalTableProvisionedWriteCapacityUnits()).append(",");
    }
    if (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
      sb.append("GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate: ").append(getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate()).append(",");
    }
    if (getGlobalTableGlobalSecondaryIndexSettingsUpdate() != null) {
      sb.append("GlobalTableGlobalSecondaryIndexSettingsUpdate: ").append(getGlobalTableGlobalSecondaryIndexSettingsUpdate()).append(",");
    }
    if (getReplicaSettingsUpdate() != null) {
      sb.append("ReplicaSettingsUpdate: ").append(getReplicaSettingsUpdate());
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
    if (!(obj instanceof UpdateGlobalTableSettingsRequest)) {
      return false;
    }
    UpdateGlobalTableSettingsRequest other = (UpdateGlobalTableSettingsRequest)obj;
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    if (((other.getGlobalTableBillingMode() == null ? 1 : 0) ^ (getGlobalTableBillingMode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableBillingMode() != null) && (!other.getGlobalTableBillingMode().equals(getGlobalTableBillingMode()))) {
      return false;
    }
    if (((other.getGlobalTableProvisionedWriteCapacityUnits() == null ? 1 : 0) ^ (getGlobalTableProvisionedWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableProvisionedWriteCapacityUnits() != null) && 
      (!other.getGlobalTableProvisionedWriteCapacityUnits().equals(getGlobalTableProvisionedWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 1 : 0) ^ (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) && 
      (!other.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate().equals(
      getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate()))) {
      return false;
    }
    if (((other.getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null ? 1 : 0) ^ (getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableGlobalSecondaryIndexSettingsUpdate() != null) && 
      (!other.getGlobalTableGlobalSecondaryIndexSettingsUpdate().equals(getGlobalTableGlobalSecondaryIndexSettingsUpdate()))) {
      return false;
    }
    if (((other.getReplicaSettingsUpdate() == null ? 1 : 0) ^ (getReplicaSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaSettingsUpdate() != null) && (!other.getReplicaSettingsUpdate().equals(getReplicaSettingsUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    hashCode = 31 * hashCode + (getGlobalTableBillingMode() == null ? 0 : getGlobalTableBillingMode().hashCode());
    hashCode = 31 * hashCode + (getGlobalTableProvisionedWriteCapacityUnits() == null ? 0 : getGlobalTableProvisionedWriteCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 0 : getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate().hashCode());
    
    hashCode = 31 * hashCode + (getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null ? 0 : getGlobalTableGlobalSecondaryIndexSettingsUpdate().hashCode());
    hashCode = 31 * hashCode + (getReplicaSettingsUpdate() == null ? 0 : getReplicaSettingsUpdate().hashCode());
    return hashCode;
  }
  
  public UpdateGlobalTableSettingsRequest clone()
  {
    return (UpdateGlobalTableSettingsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */