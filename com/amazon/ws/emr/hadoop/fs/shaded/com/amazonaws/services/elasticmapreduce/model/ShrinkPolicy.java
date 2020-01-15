package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ShrinkPolicyMarshaller;
import java.io.Serializable;

public class ShrinkPolicy
  implements Serializable, Cloneable, StructuredPojo
{
  private Integer decommissionTimeout;
  private InstanceResizePolicy instanceResizePolicy;
  
  public void setDecommissionTimeout(Integer decommissionTimeout)
  {
    this.decommissionTimeout = decommissionTimeout;
  }
  
  public Integer getDecommissionTimeout()
  {
    return decommissionTimeout;
  }
  
  public ShrinkPolicy withDecommissionTimeout(Integer decommissionTimeout)
  {
    setDecommissionTimeout(decommissionTimeout);
    return this;
  }
  
  public void setInstanceResizePolicy(InstanceResizePolicy instanceResizePolicy)
  {
    this.instanceResizePolicy = instanceResizePolicy;
  }
  
  public InstanceResizePolicy getInstanceResizePolicy()
  {
    return instanceResizePolicy;
  }
  
  public ShrinkPolicy withInstanceResizePolicy(InstanceResizePolicy instanceResizePolicy)
  {
    setInstanceResizePolicy(instanceResizePolicy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDecommissionTimeout() != null) {
      sb.append("DecommissionTimeout: ").append(getDecommissionTimeout()).append(",");
    }
    if (getInstanceResizePolicy() != null) {
      sb.append("InstanceResizePolicy: ").append(getInstanceResizePolicy());
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
    if (!(obj instanceof ShrinkPolicy)) {
      return false;
    }
    ShrinkPolicy other = (ShrinkPolicy)obj;
    if (((other.getDecommissionTimeout() == null ? 1 : 0) ^ (getDecommissionTimeout() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDecommissionTimeout() != null) && (!other.getDecommissionTimeout().equals(getDecommissionTimeout()))) {
      return false;
    }
    if (((other.getInstanceResizePolicy() == null ? 1 : 0) ^ (getInstanceResizePolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceResizePolicy() != null) && (!other.getInstanceResizePolicy().equals(getInstanceResizePolicy()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDecommissionTimeout() == null ? 0 : getDecommissionTimeout().hashCode());
    hashCode = 31 * hashCode + (getInstanceResizePolicy() == null ? 0 : getInstanceResizePolicy().hashCode());
    return hashCode;
  }
  
  public ShrinkPolicy clone()
  {
    try
    {
      return (ShrinkPolicy)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ShrinkPolicyMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ShrinkPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */