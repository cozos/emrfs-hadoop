package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsUpdateMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplicaSettingsUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private String regionName;
  private Long replicaProvisionedReadCapacityUnits;
  private AutoScalingSettingsUpdate replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
  private List<ReplicaGlobalSecondaryIndexSettingsUpdate> replicaGlobalSecondaryIndexSettingsUpdate;
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public ReplicaSettingsUpdate withRegionName(String regionName)
  {
    setRegionName(regionName);
    return this;
  }
  
  public void setReplicaProvisionedReadCapacityUnits(Long replicaProvisionedReadCapacityUnits)
  {
    this.replicaProvisionedReadCapacityUnits = replicaProvisionedReadCapacityUnits;
  }
  
  public Long getReplicaProvisionedReadCapacityUnits()
  {
    return replicaProvisionedReadCapacityUnits;
  }
  
  public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityUnits(Long replicaProvisionedReadCapacityUnits)
  {
    setReplicaProvisionedReadCapacityUnits(replicaProvisionedReadCapacityUnits);
    return this;
  }
  
  public void setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate replicaProvisionedReadCapacityAutoScalingSettingsUpdate)
  {
    this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate = replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
  }
  
  public AutoScalingSettingsUpdate getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate()
  {
    return replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
  }
  
  public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate replicaProvisionedReadCapacityAutoScalingSettingsUpdate)
  {
    setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(replicaProvisionedReadCapacityAutoScalingSettingsUpdate);
    return this;
  }
  
  public List<ReplicaGlobalSecondaryIndexSettingsUpdate> getReplicaGlobalSecondaryIndexSettingsUpdate()
  {
    return replicaGlobalSecondaryIndexSettingsUpdate;
  }
  
  public void setReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> replicaGlobalSecondaryIndexSettingsUpdate)
  {
    if (replicaGlobalSecondaryIndexSettingsUpdate == null)
    {
      this.replicaGlobalSecondaryIndexSettingsUpdate = null;
      return;
    }
    this.replicaGlobalSecondaryIndexSettingsUpdate = new ArrayList(replicaGlobalSecondaryIndexSettingsUpdate);
  }
  
  public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(ReplicaGlobalSecondaryIndexSettingsUpdate... replicaGlobalSecondaryIndexSettingsUpdate)
  {
    if (this.replicaGlobalSecondaryIndexSettingsUpdate == null) {
      setReplicaGlobalSecondaryIndexSettingsUpdate(new ArrayList(replicaGlobalSecondaryIndexSettingsUpdate.length));
    }
    for (ReplicaGlobalSecondaryIndexSettingsUpdate ele : replicaGlobalSecondaryIndexSettingsUpdate) {
      this.replicaGlobalSecondaryIndexSettingsUpdate.add(ele);
    }
    return this;
  }
  
  public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> replicaGlobalSecondaryIndexSettingsUpdate)
  {
    setReplicaGlobalSecondaryIndexSettingsUpdate(replicaGlobalSecondaryIndexSettingsUpdate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRegionName() != null) {
      sb.append("RegionName: ").append(getRegionName()).append(",");
    }
    if (getReplicaProvisionedReadCapacityUnits() != null) {
      sb.append("ReplicaProvisionedReadCapacityUnits: ").append(getReplicaProvisionedReadCapacityUnits()).append(",");
    }
    if (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
      sb.append("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate: ").append(getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate()).append(",");
    }
    if (getReplicaGlobalSecondaryIndexSettingsUpdate() != null) {
      sb.append("ReplicaGlobalSecondaryIndexSettingsUpdate: ").append(getReplicaGlobalSecondaryIndexSettingsUpdate());
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
    if (!(obj instanceof ReplicaSettingsUpdate)) {
      return false;
    }
    ReplicaSettingsUpdate other = (ReplicaSettingsUpdate)obj;
    if (((other.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegionName() != null) && (!other.getRegionName().equals(getRegionName()))) {
      return false;
    }
    if (((other.getReplicaProvisionedReadCapacityUnits() == null ? 1 : 0) ^ (getReplicaProvisionedReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedReadCapacityUnits() != null) && 
      (!other.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits()))) {
      return false;
    }
    if (((other.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 1 : 0) ^ (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null) && 
      (!other.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().equals(getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate()))) {
      return false;
    }
    if (((other.getReplicaGlobalSecondaryIndexSettingsUpdate() == null ? 1 : 0) ^ (getReplicaGlobalSecondaryIndexSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaGlobalSecondaryIndexSettingsUpdate() != null) && 
      (!other.getReplicaGlobalSecondaryIndexSettingsUpdate().equals(getReplicaGlobalSecondaryIndexSettingsUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRegionName() == null ? 0 : getRegionName().hashCode());
    hashCode = 31 * hashCode + (getReplicaProvisionedReadCapacityUnits() == null ? 0 : getReplicaProvisionedReadCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 0 : getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().hashCode());
    
    hashCode = 31 * hashCode + (getReplicaGlobalSecondaryIndexSettingsUpdate() == null ? 0 : getReplicaGlobalSecondaryIndexSettingsUpdate().hashCode());
    return hashCode;
  }
  
  public ReplicaSettingsUpdate clone()
  {
    try
    {
      return (ReplicaSettingsUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaSettingsUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */