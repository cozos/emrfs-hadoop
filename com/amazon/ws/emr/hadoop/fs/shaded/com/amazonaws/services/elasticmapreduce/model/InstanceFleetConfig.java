package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceFleetConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String instanceFleetType;
  private Integer targetOnDemandCapacity;
  private Integer targetSpotCapacity;
  private SdkInternalList<InstanceTypeConfig> instanceTypeConfigs;
  private InstanceFleetProvisioningSpecifications launchSpecifications;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public InstanceFleetConfig withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setInstanceFleetType(String instanceFleetType)
  {
    this.instanceFleetType = instanceFleetType;
  }
  
  public String getInstanceFleetType()
  {
    return instanceFleetType;
  }
  
  public InstanceFleetConfig withInstanceFleetType(String instanceFleetType)
  {
    setInstanceFleetType(instanceFleetType);
    return this;
  }
  
  public void setInstanceFleetType(InstanceFleetType instanceFleetType)
  {
    withInstanceFleetType(instanceFleetType);
  }
  
  public InstanceFleetConfig withInstanceFleetType(InstanceFleetType instanceFleetType)
  {
    this.instanceFleetType = instanceFleetType.toString();
    return this;
  }
  
  public void setTargetOnDemandCapacity(Integer targetOnDemandCapacity)
  {
    this.targetOnDemandCapacity = targetOnDemandCapacity;
  }
  
  public Integer getTargetOnDemandCapacity()
  {
    return targetOnDemandCapacity;
  }
  
  public InstanceFleetConfig withTargetOnDemandCapacity(Integer targetOnDemandCapacity)
  {
    setTargetOnDemandCapacity(targetOnDemandCapacity);
    return this;
  }
  
  public void setTargetSpotCapacity(Integer targetSpotCapacity)
  {
    this.targetSpotCapacity = targetSpotCapacity;
  }
  
  public Integer getTargetSpotCapacity()
  {
    return targetSpotCapacity;
  }
  
  public InstanceFleetConfig withTargetSpotCapacity(Integer targetSpotCapacity)
  {
    setTargetSpotCapacity(targetSpotCapacity);
    return this;
  }
  
  public List<InstanceTypeConfig> getInstanceTypeConfigs()
  {
    if (instanceTypeConfigs == null) {
      instanceTypeConfigs = new SdkInternalList();
    }
    return instanceTypeConfigs;
  }
  
  public void setInstanceTypeConfigs(Collection<InstanceTypeConfig> instanceTypeConfigs)
  {
    if (instanceTypeConfigs == null)
    {
      this.instanceTypeConfigs = null;
      return;
    }
    this.instanceTypeConfigs = new SdkInternalList(instanceTypeConfigs);
  }
  
  public InstanceFleetConfig withInstanceTypeConfigs(InstanceTypeConfig... instanceTypeConfigs)
  {
    if (this.instanceTypeConfigs == null) {
      setInstanceTypeConfigs(new SdkInternalList(instanceTypeConfigs.length));
    }
    for (InstanceTypeConfig ele : instanceTypeConfigs) {
      this.instanceTypeConfigs.add(ele);
    }
    return this;
  }
  
  public InstanceFleetConfig withInstanceTypeConfigs(Collection<InstanceTypeConfig> instanceTypeConfigs)
  {
    setInstanceTypeConfigs(instanceTypeConfigs);
    return this;
  }
  
  public void setLaunchSpecifications(InstanceFleetProvisioningSpecifications launchSpecifications)
  {
    this.launchSpecifications = launchSpecifications;
  }
  
  public InstanceFleetProvisioningSpecifications getLaunchSpecifications()
  {
    return launchSpecifications;
  }
  
  public InstanceFleetConfig withLaunchSpecifications(InstanceFleetProvisioningSpecifications launchSpecifications)
  {
    setLaunchSpecifications(launchSpecifications);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getInstanceFleetType() != null) {
      sb.append("InstanceFleetType: ").append(getInstanceFleetType()).append(",");
    }
    if (getTargetOnDemandCapacity() != null) {
      sb.append("TargetOnDemandCapacity: ").append(getTargetOnDemandCapacity()).append(",");
    }
    if (getTargetSpotCapacity() != null) {
      sb.append("TargetSpotCapacity: ").append(getTargetSpotCapacity()).append(",");
    }
    if (getInstanceTypeConfigs() != null) {
      sb.append("InstanceTypeConfigs: ").append(getInstanceTypeConfigs()).append(",");
    }
    if (getLaunchSpecifications() != null) {
      sb.append("LaunchSpecifications: ").append(getLaunchSpecifications());
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
    if (!(obj instanceof InstanceFleetConfig)) {
      return false;
    }
    InstanceFleetConfig other = (InstanceFleetConfig)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getInstanceFleetType() == null ? 1 : 0) ^ (getInstanceFleetType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetType() != null) && (!other.getInstanceFleetType().equals(getInstanceFleetType()))) {
      return false;
    }
    if (((other.getTargetOnDemandCapacity() == null ? 1 : 0) ^ (getTargetOnDemandCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetOnDemandCapacity() != null) && (!other.getTargetOnDemandCapacity().equals(getTargetOnDemandCapacity()))) {
      return false;
    }
    if (((other.getTargetSpotCapacity() == null ? 1 : 0) ^ (getTargetSpotCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTargetSpotCapacity() != null) && (!other.getTargetSpotCapacity().equals(getTargetSpotCapacity()))) {
      return false;
    }
    if (((other.getInstanceTypeConfigs() == null ? 1 : 0) ^ (getInstanceTypeConfigs() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceTypeConfigs() != null) && (!other.getInstanceTypeConfigs().equals(getInstanceTypeConfigs()))) {
      return false;
    }
    if (((other.getLaunchSpecifications() == null ? 1 : 0) ^ (getLaunchSpecifications() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLaunchSpecifications() != null) && (!other.getLaunchSpecifications().equals(getLaunchSpecifications()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetType() == null ? 0 : getInstanceFleetType().hashCode());
    hashCode = 31 * hashCode + (getTargetOnDemandCapacity() == null ? 0 : getTargetOnDemandCapacity().hashCode());
    hashCode = 31 * hashCode + (getTargetSpotCapacity() == null ? 0 : getTargetSpotCapacity().hashCode());
    hashCode = 31 * hashCode + (getInstanceTypeConfigs() == null ? 0 : getInstanceTypeConfigs().hashCode());
    hashCode = 31 * hashCode + (getLaunchSpecifications() == null ? 0 : getLaunchSpecifications().hashCode());
    return hashCode;
  }
  
  public InstanceFleetConfig clone()
  {
    try
    {
      return (InstanceFleetConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceFleetConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */