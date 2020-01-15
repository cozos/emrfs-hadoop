package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplicaSettingsDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String regionName;
  private String replicaStatus;
  private BillingModeSummary replicaBillingModeSummary;
  private Long replicaProvisionedReadCapacityUnits;
  private AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings;
  private Long replicaProvisionedWriteCapacityUnits;
  private AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings;
  private List<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings;
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public ReplicaSettingsDescription withRegionName(String regionName)
  {
    setRegionName(regionName);
    return this;
  }
  
  public void setReplicaStatus(String replicaStatus)
  {
    this.replicaStatus = replicaStatus;
  }
  
  public String getReplicaStatus()
  {
    return replicaStatus;
  }
  
  public ReplicaSettingsDescription withReplicaStatus(String replicaStatus)
  {
    setReplicaStatus(replicaStatus);
    return this;
  }
  
  public ReplicaSettingsDescription withReplicaStatus(ReplicaStatus replicaStatus)
  {
    this.replicaStatus = replicaStatus.toString();
    return this;
  }
  
  public void setReplicaBillingModeSummary(BillingModeSummary replicaBillingModeSummary)
  {
    this.replicaBillingModeSummary = replicaBillingModeSummary;
  }
  
  public BillingModeSummary getReplicaBillingModeSummary()
  {
    return replicaBillingModeSummary;
  }
  
  public ReplicaSettingsDescription withReplicaBillingModeSummary(BillingModeSummary replicaBillingModeSummary)
  {
    setReplicaBillingModeSummary(replicaBillingModeSummary);
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
  
  public ReplicaSettingsDescription withReplicaProvisionedReadCapacityUnits(Long replicaProvisionedReadCapacityUnits)
  {
    setReplicaProvisionedReadCapacityUnits(replicaProvisionedReadCapacityUnits);
    return this;
  }
  
  public void setReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings)
  {
    this.replicaProvisionedReadCapacityAutoScalingSettings = replicaProvisionedReadCapacityAutoScalingSettings;
  }
  
  public AutoScalingSettingsDescription getReplicaProvisionedReadCapacityAutoScalingSettings()
  {
    return replicaProvisionedReadCapacityAutoScalingSettings;
  }
  
  public ReplicaSettingsDescription withReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings)
  {
    setReplicaProvisionedReadCapacityAutoScalingSettings(replicaProvisionedReadCapacityAutoScalingSettings);
    return this;
  }
  
  public void setReplicaProvisionedWriteCapacityUnits(Long replicaProvisionedWriteCapacityUnits)
  {
    this.replicaProvisionedWriteCapacityUnits = replicaProvisionedWriteCapacityUnits;
  }
  
  public Long getReplicaProvisionedWriteCapacityUnits()
  {
    return replicaProvisionedWriteCapacityUnits;
  }
  
  public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityUnits(Long replicaProvisionedWriteCapacityUnits)
  {
    setReplicaProvisionedWriteCapacityUnits(replicaProvisionedWriteCapacityUnits);
    return this;
  }
  
  public void setReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings)
  {
    this.replicaProvisionedWriteCapacityAutoScalingSettings = replicaProvisionedWriteCapacityAutoScalingSettings;
  }
  
  public AutoScalingSettingsDescription getReplicaProvisionedWriteCapacityAutoScalingSettings()
  {
    return replicaProvisionedWriteCapacityAutoScalingSettings;
  }
  
  public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings)
  {
    setReplicaProvisionedWriteCapacityAutoScalingSettings(replicaProvisionedWriteCapacityAutoScalingSettings);
    return this;
  }
  
  public List<ReplicaGlobalSecondaryIndexSettingsDescription> getReplicaGlobalSecondaryIndexSettings()
  {
    return replicaGlobalSecondaryIndexSettings;
  }
  
  public void setReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings)
  {
    if (replicaGlobalSecondaryIndexSettings == null)
    {
      this.replicaGlobalSecondaryIndexSettings = null;
      return;
    }
    this.replicaGlobalSecondaryIndexSettings = new ArrayList(replicaGlobalSecondaryIndexSettings);
  }
  
  public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(ReplicaGlobalSecondaryIndexSettingsDescription... replicaGlobalSecondaryIndexSettings)
  {
    if (this.replicaGlobalSecondaryIndexSettings == null) {
      setReplicaGlobalSecondaryIndexSettings(new ArrayList(replicaGlobalSecondaryIndexSettings.length));
    }
    for (ReplicaGlobalSecondaryIndexSettingsDescription ele : replicaGlobalSecondaryIndexSettings) {
      this.replicaGlobalSecondaryIndexSettings.add(ele);
    }
    return this;
  }
  
  public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings)
  {
    setReplicaGlobalSecondaryIndexSettings(replicaGlobalSecondaryIndexSettings);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRegionName() != null) {
      sb.append("RegionName: ").append(getRegionName()).append(",");
    }
    if (getReplicaStatus() != null) {
      sb.append("ReplicaStatus: ").append(getReplicaStatus()).append(",");
    }
    if (getReplicaBillingModeSummary() != null) {
      sb.append("ReplicaBillingModeSummary: ").append(getReplicaBillingModeSummary()).append(",");
    }
    if (getReplicaProvisionedReadCapacityUnits() != null) {
      sb.append("ReplicaProvisionedReadCapacityUnits: ").append(getReplicaProvisionedReadCapacityUnits()).append(",");
    }
    if (getReplicaProvisionedReadCapacityAutoScalingSettings() != null) {
      sb.append("ReplicaProvisionedReadCapacityAutoScalingSettings: ").append(getReplicaProvisionedReadCapacityAutoScalingSettings()).append(",");
    }
    if (getReplicaProvisionedWriteCapacityUnits() != null) {
      sb.append("ReplicaProvisionedWriteCapacityUnits: ").append(getReplicaProvisionedWriteCapacityUnits()).append(",");
    }
    if (getReplicaProvisionedWriteCapacityAutoScalingSettings() != null) {
      sb.append("ReplicaProvisionedWriteCapacityAutoScalingSettings: ").append(getReplicaProvisionedWriteCapacityAutoScalingSettings()).append(",");
    }
    if (getReplicaGlobalSecondaryIndexSettings() != null) {
      sb.append("ReplicaGlobalSecondaryIndexSettings: ").append(getReplicaGlobalSecondaryIndexSettings());
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
    if (!(obj instanceof ReplicaSettingsDescription)) {
      return false;
    }
    ReplicaSettingsDescription other = (ReplicaSettingsDescription)obj;
    if (((other.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegionName() != null) && (!other.getRegionName().equals(getRegionName()))) {
      return false;
    }
    if (((other.getReplicaStatus() == null ? 1 : 0) ^ (getReplicaStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaStatus() != null) && (!other.getReplicaStatus().equals(getReplicaStatus()))) {
      return false;
    }
    if (((other.getReplicaBillingModeSummary() == null ? 1 : 0) ^ (getReplicaBillingModeSummary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaBillingModeSummary() != null) && (!other.getReplicaBillingModeSummary().equals(getReplicaBillingModeSummary()))) {
      return false;
    }
    if (((other.getReplicaProvisionedReadCapacityUnits() == null ? 1 : 0) ^ (getReplicaProvisionedReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedReadCapacityUnits() != null) && 
      (!other.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits()))) {
      return false;
    }
    if (((other.getReplicaProvisionedReadCapacityAutoScalingSettings() == null ? 1 : 0) ^ (getReplicaProvisionedReadCapacityAutoScalingSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedReadCapacityAutoScalingSettings() != null) && 
      (!other.getReplicaProvisionedReadCapacityAutoScalingSettings().equals(getReplicaProvisionedReadCapacityAutoScalingSettings()))) {
      return false;
    }
    if (((other.getReplicaProvisionedWriteCapacityUnits() == null ? 1 : 0) ^ (getReplicaProvisionedWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedWriteCapacityUnits() != null) && 
      (!other.getReplicaProvisionedWriteCapacityUnits().equals(getReplicaProvisionedWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getReplicaProvisionedWriteCapacityAutoScalingSettings() == null ? 1 : 0) ^ (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaProvisionedWriteCapacityAutoScalingSettings() != null) && 
      (!other.getReplicaProvisionedWriteCapacityAutoScalingSettings().equals(getReplicaProvisionedWriteCapacityAutoScalingSettings()))) {
      return false;
    }
    if (((other.getReplicaGlobalSecondaryIndexSettings() == null ? 1 : 0) ^ (getReplicaGlobalSecondaryIndexSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaGlobalSecondaryIndexSettings() != null) && 
      (!other.getReplicaGlobalSecondaryIndexSettings().equals(getReplicaGlobalSecondaryIndexSettings()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRegionName() == null ? 0 : getRegionName().hashCode());
    hashCode = 31 * hashCode + (getReplicaStatus() == null ? 0 : getReplicaStatus().hashCode());
    hashCode = 31 * hashCode + (getReplicaBillingModeSummary() == null ? 0 : getReplicaBillingModeSummary().hashCode());
    hashCode = 31 * hashCode + (getReplicaProvisionedReadCapacityUnits() == null ? 0 : getReplicaProvisionedReadCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getReplicaProvisionedReadCapacityAutoScalingSettings() == null ? 0 : getReplicaProvisionedReadCapacityAutoScalingSettings().hashCode());
    hashCode = 31 * hashCode + (getReplicaProvisionedWriteCapacityUnits() == null ? 0 : getReplicaProvisionedWriteCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null ? 0 : getReplicaProvisionedWriteCapacityAutoScalingSettings().hashCode());
    hashCode = 31 * hashCode + (getReplicaGlobalSecondaryIndexSettings() == null ? 0 : getReplicaGlobalSecondaryIndexSettings().hashCode());
    return hashCode;
  }
  
  public ReplicaSettingsDescription clone()
  {
    try
    {
      return (ReplicaSettingsDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaSettingsDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */