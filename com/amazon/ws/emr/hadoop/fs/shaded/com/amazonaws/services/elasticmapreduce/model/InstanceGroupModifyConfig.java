package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupModifyConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceGroupModifyConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String instanceGroupId;
  private Integer instanceCount;
  private SdkInternalList<String> eC2InstanceIdsToTerminate;
  private ShrinkPolicy shrinkPolicy;
  private SdkInternalList<Configuration> configurations;
  
  public InstanceGroupModifyConfig() {}
  
  public InstanceGroupModifyConfig(String instanceGroupId, Integer instanceCount)
  {
    setInstanceGroupId(instanceGroupId);
    setInstanceCount(instanceCount);
  }
  
  public void setInstanceGroupId(String instanceGroupId)
  {
    this.instanceGroupId = instanceGroupId;
  }
  
  public String getInstanceGroupId()
  {
    return instanceGroupId;
  }
  
  public InstanceGroupModifyConfig withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
    return this;
  }
  
  public void setInstanceCount(Integer instanceCount)
  {
    this.instanceCount = instanceCount;
  }
  
  public Integer getInstanceCount()
  {
    return instanceCount;
  }
  
  public InstanceGroupModifyConfig withInstanceCount(Integer instanceCount)
  {
    setInstanceCount(instanceCount);
    return this;
  }
  
  public List<String> getEC2InstanceIdsToTerminate()
  {
    if (eC2InstanceIdsToTerminate == null) {
      eC2InstanceIdsToTerminate = new SdkInternalList();
    }
    return eC2InstanceIdsToTerminate;
  }
  
  public void setEC2InstanceIdsToTerminate(Collection<String> eC2InstanceIdsToTerminate)
  {
    if (eC2InstanceIdsToTerminate == null)
    {
      this.eC2InstanceIdsToTerminate = null;
      return;
    }
    this.eC2InstanceIdsToTerminate = new SdkInternalList(eC2InstanceIdsToTerminate);
  }
  
  public InstanceGroupModifyConfig withEC2InstanceIdsToTerminate(String... eC2InstanceIdsToTerminate)
  {
    if (this.eC2InstanceIdsToTerminate == null) {
      setEC2InstanceIdsToTerminate(new SdkInternalList(eC2InstanceIdsToTerminate.length));
    }
    for (String ele : eC2InstanceIdsToTerminate) {
      this.eC2InstanceIdsToTerminate.add(ele);
    }
    return this;
  }
  
  public InstanceGroupModifyConfig withEC2InstanceIdsToTerminate(Collection<String> eC2InstanceIdsToTerminate)
  {
    setEC2InstanceIdsToTerminate(eC2InstanceIdsToTerminate);
    return this;
  }
  
  public void setShrinkPolicy(ShrinkPolicy shrinkPolicy)
  {
    this.shrinkPolicy = shrinkPolicy;
  }
  
  public ShrinkPolicy getShrinkPolicy()
  {
    return shrinkPolicy;
  }
  
  public InstanceGroupModifyConfig withShrinkPolicy(ShrinkPolicy shrinkPolicy)
  {
    setShrinkPolicy(shrinkPolicy);
    return this;
  }
  
  public List<Configuration> getConfigurations()
  {
    if (configurations == null) {
      configurations = new SdkInternalList();
    }
    return configurations;
  }
  
  public void setConfigurations(Collection<Configuration> configurations)
  {
    if (configurations == null)
    {
      this.configurations = null;
      return;
    }
    this.configurations = new SdkInternalList(configurations);
  }
  
  public InstanceGroupModifyConfig withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public InstanceGroupModifyConfig withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceGroupId() != null) {
      sb.append("InstanceGroupId: ").append(getInstanceGroupId()).append(",");
    }
    if (getInstanceCount() != null) {
      sb.append("InstanceCount: ").append(getInstanceCount()).append(",");
    }
    if (getEC2InstanceIdsToTerminate() != null) {
      sb.append("EC2InstanceIdsToTerminate: ").append(getEC2InstanceIdsToTerminate()).append(",");
    }
    if (getShrinkPolicy() != null) {
      sb.append("ShrinkPolicy: ").append(getShrinkPolicy()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations());
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
    if (!(obj instanceof InstanceGroupModifyConfig)) {
      return false;
    }
    InstanceGroupModifyConfig other = (InstanceGroupModifyConfig)obj;
    if (((other.getInstanceGroupId() == null ? 1 : 0) ^ (getInstanceGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupId() != null) && (!other.getInstanceGroupId().equals(getInstanceGroupId()))) {
      return false;
    }
    if (((other.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceCount() != null) && (!other.getInstanceCount().equals(getInstanceCount()))) {
      return false;
    }
    if (((other.getEC2InstanceIdsToTerminate() == null ? 1 : 0) ^ (getEC2InstanceIdsToTerminate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEC2InstanceIdsToTerminate() != null) && (!other.getEC2InstanceIdsToTerminate().equals(getEC2InstanceIdsToTerminate()))) {
      return false;
    }
    if (((other.getShrinkPolicy() == null ? 1 : 0) ^ (getShrinkPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShrinkPolicy() != null) && (!other.getShrinkPolicy().equals(getShrinkPolicy()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    hashCode = 31 * hashCode + (getInstanceCount() == null ? 0 : getInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getEC2InstanceIdsToTerminate() == null ? 0 : getEC2InstanceIdsToTerminate().hashCode());
    hashCode = 31 * hashCode + (getShrinkPolicy() == null ? 0 : getShrinkPolicy().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    return hashCode;
  }
  
  public InstanceGroupModifyConfig clone()
  {
    try
    {
      return (InstanceGroupModifyConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceGroupModifyConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */