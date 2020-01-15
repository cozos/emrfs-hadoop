package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceFleet
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String name;
  private InstanceFleetStatus status;
  private String instanceFleetType;
  private Integer targetOnDemandCapacity;
  private Integer targetSpotCapacity;
  private Integer provisionedOnDemandCapacity;
  private Integer provisionedSpotCapacity;
  private SdkInternalList<InstanceTypeSpecification> instanceTypeSpecifications;
  private InstanceFleetProvisioningSpecifications launchSpecifications;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public InstanceFleet withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public InstanceFleet withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setStatus(InstanceFleetStatus status)
  {
    this.status = status;
  }
  
  public InstanceFleetStatus getStatus()
  {
    return status;
  }
  
  public InstanceFleet withStatus(InstanceFleetStatus status)
  {
    setStatus(status);
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
  
  public InstanceFleet withInstanceFleetType(String instanceFleetType)
  {
    setInstanceFleetType(instanceFleetType);
    return this;
  }
  
  public void setInstanceFleetType(InstanceFleetType instanceFleetType)
  {
    withInstanceFleetType(instanceFleetType);
  }
  
  public InstanceFleet withInstanceFleetType(InstanceFleetType instanceFleetType)
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
  
  public InstanceFleet withTargetOnDemandCapacity(Integer targetOnDemandCapacity)
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
  
  public InstanceFleet withTargetSpotCapacity(Integer targetSpotCapacity)
  {
    setTargetSpotCapacity(targetSpotCapacity);
    return this;
  }
  
  public void setProvisionedOnDemandCapacity(Integer provisionedOnDemandCapacity)
  {
    this.provisionedOnDemandCapacity = provisionedOnDemandCapacity;
  }
  
  public Integer getProvisionedOnDemandCapacity()
  {
    return provisionedOnDemandCapacity;
  }
  
  public InstanceFleet withProvisionedOnDemandCapacity(Integer provisionedOnDemandCapacity)
  {
    setProvisionedOnDemandCapacity(provisionedOnDemandCapacity);
    return this;
  }
  
  public void setProvisionedSpotCapacity(Integer provisionedSpotCapacity)
  {
    this.provisionedSpotCapacity = provisionedSpotCapacity;
  }
  
  public Integer getProvisionedSpotCapacity()
  {
    return provisionedSpotCapacity;
  }
  
  public InstanceFleet withProvisionedSpotCapacity(Integer provisionedSpotCapacity)
  {
    setProvisionedSpotCapacity(provisionedSpotCapacity);
    return this;
  }
  
  public List<InstanceTypeSpecification> getInstanceTypeSpecifications()
  {
    if (instanceTypeSpecifications == null) {
      instanceTypeSpecifications = new SdkInternalList();
    }
    return instanceTypeSpecifications;
  }
  
  public void setInstanceTypeSpecifications(Collection<InstanceTypeSpecification> instanceTypeSpecifications)
  {
    if (instanceTypeSpecifications == null)
    {
      this.instanceTypeSpecifications = null;
      return;
    }
    this.instanceTypeSpecifications = new SdkInternalList(instanceTypeSpecifications);
  }
  
  public InstanceFleet withInstanceTypeSpecifications(InstanceTypeSpecification... instanceTypeSpecifications)
  {
    if (this.instanceTypeSpecifications == null) {
      setInstanceTypeSpecifications(new SdkInternalList(instanceTypeSpecifications.length));
    }
    for (InstanceTypeSpecification ele : instanceTypeSpecifications) {
      this.instanceTypeSpecifications.add(ele);
    }
    return this;
  }
  
  public InstanceFleet withInstanceTypeSpecifications(Collection<InstanceTypeSpecification> instanceTypeSpecifications)
  {
    setInstanceTypeSpecifications(instanceTypeSpecifications);
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
  
  public InstanceFleet withLaunchSpecifications(InstanceFleetProvisioningSpecifications launchSpecifications)
  {
    setLaunchSpecifications(launchSpecifications);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
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
    if (getProvisionedOnDemandCapacity() != null) {
      sb.append("ProvisionedOnDemandCapacity: ").append(getProvisionedOnDemandCapacity()).append(",");
    }
    if (getProvisionedSpotCapacity() != null) {
      sb.append("ProvisionedSpotCapacity: ").append(getProvisionedSpotCapacity()).append(",");
    }
    if (getInstanceTypeSpecifications() != null) {
      sb.append("InstanceTypeSpecifications: ").append(getInstanceTypeSpecifications()).append(",");
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
    if (!(obj instanceof InstanceFleet)) {
      return false;
    }
    InstanceFleet other = (InstanceFleet)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
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
    if (((other.getProvisionedOnDemandCapacity() == null ? 1 : 0) ^ (getProvisionedOnDemandCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedOnDemandCapacity() != null) && (!other.getProvisionedOnDemandCapacity().equals(getProvisionedOnDemandCapacity()))) {
      return false;
    }
    if (((other.getProvisionedSpotCapacity() == null ? 1 : 0) ^ (getProvisionedSpotCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedSpotCapacity() != null) && (!other.getProvisionedSpotCapacity().equals(getProvisionedSpotCapacity()))) {
      return false;
    }
    if (((other.getInstanceTypeSpecifications() == null ? 1 : 0) ^ (getInstanceTypeSpecifications() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceTypeSpecifications() != null) && (!other.getInstanceTypeSpecifications().equals(getInstanceTypeSpecifications()))) {
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
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetType() == null ? 0 : getInstanceFleetType().hashCode());
    hashCode = 31 * hashCode + (getTargetOnDemandCapacity() == null ? 0 : getTargetOnDemandCapacity().hashCode());
    hashCode = 31 * hashCode + (getTargetSpotCapacity() == null ? 0 : getTargetSpotCapacity().hashCode());
    hashCode = 31 * hashCode + (getProvisionedOnDemandCapacity() == null ? 0 : getProvisionedOnDemandCapacity().hashCode());
    hashCode = 31 * hashCode + (getProvisionedSpotCapacity() == null ? 0 : getProvisionedSpotCapacity().hashCode());
    hashCode = 31 * hashCode + (getInstanceTypeSpecifications() == null ? 0 : getInstanceTypeSpecifications().hashCode());
    hashCode = 31 * hashCode + (getLaunchSpecifications() == null ? 0 : getLaunchSpecifications().hashCode());
    return hashCode;
  }
  
  public InstanceFleet clone()
  {
    try
    {
      return (InstanceFleet)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceFleetMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */