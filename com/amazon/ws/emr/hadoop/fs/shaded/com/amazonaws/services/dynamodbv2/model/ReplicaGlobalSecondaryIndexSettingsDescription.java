package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller;
import java.io.Serializable;

public class ReplicaGlobalSecondaryIndexSettingsDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private String indexStatus;
  private Long provisionedReadCapacityUnits;
  private AutoScalingSettingsDescription provisionedReadCapacityAutoScalingSettings;
  private Long provisionedWriteCapacityUnits;
  private AutoScalingSettingsDescription provisionedWriteCapacityAutoScalingSettings;
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public void setIndexStatus(String indexStatus)
  {
    this.indexStatus = indexStatus;
  }
  
  public String getIndexStatus()
  {
    return indexStatus;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(String indexStatus)
  {
    setIndexStatus(indexStatus);
    return this;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(IndexStatus indexStatus)
  {
    this.indexStatus = indexStatus.toString();
    return this;
  }
  
  public void setProvisionedReadCapacityUnits(Long provisionedReadCapacityUnits)
  {
    this.provisionedReadCapacityUnits = provisionedReadCapacityUnits;
  }
  
  public Long getProvisionedReadCapacityUnits()
  {
    return provisionedReadCapacityUnits;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityUnits(Long provisionedReadCapacityUnits)
  {
    setProvisionedReadCapacityUnits(provisionedReadCapacityUnits);
    return this;
  }
  
  public void setProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription provisionedReadCapacityAutoScalingSettings)
  {
    this.provisionedReadCapacityAutoScalingSettings = provisionedReadCapacityAutoScalingSettings;
  }
  
  public AutoScalingSettingsDescription getProvisionedReadCapacityAutoScalingSettings()
  {
    return provisionedReadCapacityAutoScalingSettings;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription provisionedReadCapacityAutoScalingSettings)
  {
    setProvisionedReadCapacityAutoScalingSettings(provisionedReadCapacityAutoScalingSettings);
    return this;
  }
  
  public void setProvisionedWriteCapacityUnits(Long provisionedWriteCapacityUnits)
  {
    this.provisionedWriteCapacityUnits = provisionedWriteCapacityUnits;
  }
  
  public Long getProvisionedWriteCapacityUnits()
  {
    return provisionedWriteCapacityUnits;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityUnits(Long provisionedWriteCapacityUnits)
  {
    setProvisionedWriteCapacityUnits(provisionedWriteCapacityUnits);
    return this;
  }
  
  public void setProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription provisionedWriteCapacityAutoScalingSettings)
  {
    this.provisionedWriteCapacityAutoScalingSettings = provisionedWriteCapacityAutoScalingSettings;
  }
  
  public AutoScalingSettingsDescription getProvisionedWriteCapacityAutoScalingSettings()
  {
    return provisionedWriteCapacityAutoScalingSettings;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription provisionedWriteCapacityAutoScalingSettings)
  {
    setProvisionedWriteCapacityAutoScalingSettings(provisionedWriteCapacityAutoScalingSettings);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getIndexName() != null) {
      sb.append("IndexName: ").append(getIndexName()).append(",");
    }
    if (getIndexStatus() != null) {
      sb.append("IndexStatus: ").append(getIndexStatus()).append(",");
    }
    if (getProvisionedReadCapacityUnits() != null) {
      sb.append("ProvisionedReadCapacityUnits: ").append(getProvisionedReadCapacityUnits()).append(",");
    }
    if (getProvisionedReadCapacityAutoScalingSettings() != null) {
      sb.append("ProvisionedReadCapacityAutoScalingSettings: ").append(getProvisionedReadCapacityAutoScalingSettings()).append(",");
    }
    if (getProvisionedWriteCapacityUnits() != null) {
      sb.append("ProvisionedWriteCapacityUnits: ").append(getProvisionedWriteCapacityUnits()).append(",");
    }
    if (getProvisionedWriteCapacityAutoScalingSettings() != null) {
      sb.append("ProvisionedWriteCapacityAutoScalingSettings: ").append(getProvisionedWriteCapacityAutoScalingSettings());
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
    if (!(obj instanceof ReplicaGlobalSecondaryIndexSettingsDescription)) {
      return false;
    }
    ReplicaGlobalSecondaryIndexSettingsDescription other = (ReplicaGlobalSecondaryIndexSettingsDescription)obj;
    if (((other.getIndexName() == null ? 1 : 0) ^ (getIndexName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexName() != null) && (!other.getIndexName().equals(getIndexName()))) {
      return false;
    }
    if (((other.getIndexStatus() == null ? 1 : 0) ^ (getIndexStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexStatus() != null) && (!other.getIndexStatus().equals(getIndexStatus()))) {
      return false;
    }
    if (((other.getProvisionedReadCapacityUnits() == null ? 1 : 0) ^ (getProvisionedReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedReadCapacityUnits() != null) && (!other.getProvisionedReadCapacityUnits().equals(getProvisionedReadCapacityUnits()))) {
      return false;
    }
    if (((other.getProvisionedReadCapacityAutoScalingSettings() == null ? 1 : 0) ^ (getProvisionedReadCapacityAutoScalingSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedReadCapacityAutoScalingSettings() != null) && 
      (!other.getProvisionedReadCapacityAutoScalingSettings().equals(getProvisionedReadCapacityAutoScalingSettings()))) {
      return false;
    }
    if (((other.getProvisionedWriteCapacityUnits() == null ? 1 : 0) ^ (getProvisionedWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedWriteCapacityUnits() != null) && 
      (!other.getProvisionedWriteCapacityUnits().equals(getProvisionedWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getProvisionedWriteCapacityAutoScalingSettings() == null ? 1 : 0) ^ (getProvisionedWriteCapacityAutoScalingSettings() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedWriteCapacityAutoScalingSettings() != null) && 
      (!other.getProvisionedWriteCapacityAutoScalingSettings().equals(getProvisionedWriteCapacityAutoScalingSettings()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getIndexName() == null ? 0 : getIndexName().hashCode());
    hashCode = 31 * hashCode + (getIndexStatus() == null ? 0 : getIndexStatus().hashCode());
    hashCode = 31 * hashCode + (getProvisionedReadCapacityUnits() == null ? 0 : getProvisionedReadCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getProvisionedReadCapacityAutoScalingSettings() == null ? 0 : getProvisionedReadCapacityAutoScalingSettings().hashCode());
    hashCode = 31 * hashCode + (getProvisionedWriteCapacityUnits() == null ? 0 : getProvisionedWriteCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getProvisionedWriteCapacityAutoScalingSettings() == null ? 0 : getProvisionedWriteCapacityAutoScalingSettings().hashCode());
    return hashCode;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsDescription clone()
  {
    try
    {
      return (ReplicaGlobalSecondaryIndexSettingsDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */