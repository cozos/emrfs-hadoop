package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SpotProvisioningSpecificationMarshaller;
import java.io.Serializable;

public class SpotProvisioningSpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private Integer timeoutDurationMinutes;
  private String timeoutAction;
  private Integer blockDurationMinutes;
  
  public void setTimeoutDurationMinutes(Integer timeoutDurationMinutes)
  {
    this.timeoutDurationMinutes = timeoutDurationMinutes;
  }
  
  public Integer getTimeoutDurationMinutes()
  {
    return timeoutDurationMinutes;
  }
  
  public SpotProvisioningSpecification withTimeoutDurationMinutes(Integer timeoutDurationMinutes)
  {
    setTimeoutDurationMinutes(timeoutDurationMinutes);
    return this;
  }
  
  public void setTimeoutAction(String timeoutAction)
  {
    this.timeoutAction = timeoutAction;
  }
  
  public String getTimeoutAction()
  {
    return timeoutAction;
  }
  
  public SpotProvisioningSpecification withTimeoutAction(String timeoutAction)
  {
    setTimeoutAction(timeoutAction);
    return this;
  }
  
  public void setTimeoutAction(SpotProvisioningTimeoutAction timeoutAction)
  {
    withTimeoutAction(timeoutAction);
  }
  
  public SpotProvisioningSpecification withTimeoutAction(SpotProvisioningTimeoutAction timeoutAction)
  {
    this.timeoutAction = timeoutAction.toString();
    return this;
  }
  
  public void setBlockDurationMinutes(Integer blockDurationMinutes)
  {
    this.blockDurationMinutes = blockDurationMinutes;
  }
  
  public Integer getBlockDurationMinutes()
  {
    return blockDurationMinutes;
  }
  
  public SpotProvisioningSpecification withBlockDurationMinutes(Integer blockDurationMinutes)
  {
    setBlockDurationMinutes(blockDurationMinutes);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTimeoutDurationMinutes() != null) {
      sb.append("TimeoutDurationMinutes: ").append(getTimeoutDurationMinutes()).append(",");
    }
    if (getTimeoutAction() != null) {
      sb.append("TimeoutAction: ").append(getTimeoutAction()).append(",");
    }
    if (getBlockDurationMinutes() != null) {
      sb.append("BlockDurationMinutes: ").append(getBlockDurationMinutes());
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
    if (!(obj instanceof SpotProvisioningSpecification)) {
      return false;
    }
    SpotProvisioningSpecification other = (SpotProvisioningSpecification)obj;
    if (((other.getTimeoutDurationMinutes() == null ? 1 : 0) ^ (getTimeoutDurationMinutes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeoutDurationMinutes() != null) && (!other.getTimeoutDurationMinutes().equals(getTimeoutDurationMinutes()))) {
      return false;
    }
    if (((other.getTimeoutAction() == null ? 1 : 0) ^ (getTimeoutAction() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeoutAction() != null) && (!other.getTimeoutAction().equals(getTimeoutAction()))) {
      return false;
    }
    if (((other.getBlockDurationMinutes() == null ? 1 : 0) ^ (getBlockDurationMinutes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBlockDurationMinutes() != null) && (!other.getBlockDurationMinutes().equals(getBlockDurationMinutes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTimeoutDurationMinutes() == null ? 0 : getTimeoutDurationMinutes().hashCode());
    hashCode = 31 * hashCode + (getTimeoutAction() == null ? 0 : getTimeoutAction().hashCode());
    hashCode = 31 * hashCode + (getBlockDurationMinutes() == null ? 0 : getBlockDurationMinutes().hashCode());
    return hashCode;
  }
  
  public SpotProvisioningSpecification clone()
  {
    try
    {
      return (SpotProvisioningSpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SpotProvisioningSpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SpotProvisioningSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */