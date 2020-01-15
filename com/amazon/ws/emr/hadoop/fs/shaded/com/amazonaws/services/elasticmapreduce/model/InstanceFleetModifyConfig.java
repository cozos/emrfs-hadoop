package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetModifyConfigMarshaller;
import java.io.Serializable;

public class InstanceFleetModifyConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String instanceFleetId;
  private Integer targetOnDemandCapacity;
  private Integer targetSpotCapacity;
  
  public void setInstanceFleetId(String instanceFleetId)
  {
    this.instanceFleetId = instanceFleetId;
  }
  
  public String getInstanceFleetId()
  {
    return instanceFleetId;
  }
  
  public InstanceFleetModifyConfig withInstanceFleetId(String instanceFleetId)
  {
    setInstanceFleetId(instanceFleetId);
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
  
  public InstanceFleetModifyConfig withTargetOnDemandCapacity(Integer targetOnDemandCapacity)
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
  
  public InstanceFleetModifyConfig withTargetSpotCapacity(Integer targetSpotCapacity)
  {
    setTargetSpotCapacity(targetSpotCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceFleetId() != null) {
      sb.append("InstanceFleetId: ").append(getInstanceFleetId()).append(",");
    }
    if (getTargetOnDemandCapacity() != null) {
      sb.append("TargetOnDemandCapacity: ").append(getTargetOnDemandCapacity()).append(",");
    }
    if (getTargetSpotCapacity() != null) {
      sb.append("TargetSpotCapacity: ").append(getTargetSpotCapacity());
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
    if (!(obj instanceof InstanceFleetModifyConfig)) {
      return false;
    }
    InstanceFleetModifyConfig other = (InstanceFleetModifyConfig)obj;
    if (((other.getInstanceFleetId() == null ? 1 : 0) ^ (getInstanceFleetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetId() != null) && (!other.getInstanceFleetId().equals(getInstanceFleetId()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceFleetId() == null ? 0 : getInstanceFleetId().hashCode());
    hashCode = 31 * hashCode + (getTargetOnDemandCapacity() == null ? 0 : getTargetOnDemandCapacity().hashCode());
    hashCode = 31 * hashCode + (getTargetSpotCapacity() == null ? 0 : getTargetSpotCapacity().hashCode());
    return hashCode;
  }
  
  public InstanceFleetModifyConfig clone()
  {
    try
    {
      return (InstanceFleetModifyConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceFleetModifyConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetModifyConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */