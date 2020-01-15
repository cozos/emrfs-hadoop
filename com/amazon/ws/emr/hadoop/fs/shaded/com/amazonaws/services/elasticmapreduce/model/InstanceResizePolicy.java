package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceResizePolicyMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceResizePolicy
  implements Serializable, Cloneable, StructuredPojo
{
  private SdkInternalList<String> instancesToTerminate;
  private SdkInternalList<String> instancesToProtect;
  private Integer instanceTerminationTimeout;
  
  public List<String> getInstancesToTerminate()
  {
    if (instancesToTerminate == null) {
      instancesToTerminate = new SdkInternalList();
    }
    return instancesToTerminate;
  }
  
  public void setInstancesToTerminate(Collection<String> instancesToTerminate)
  {
    if (instancesToTerminate == null)
    {
      this.instancesToTerminate = null;
      return;
    }
    this.instancesToTerminate = new SdkInternalList(instancesToTerminate);
  }
  
  public InstanceResizePolicy withInstancesToTerminate(String... instancesToTerminate)
  {
    if (this.instancesToTerminate == null) {
      setInstancesToTerminate(new SdkInternalList(instancesToTerminate.length));
    }
    for (String ele : instancesToTerminate) {
      this.instancesToTerminate.add(ele);
    }
    return this;
  }
  
  public InstanceResizePolicy withInstancesToTerminate(Collection<String> instancesToTerminate)
  {
    setInstancesToTerminate(instancesToTerminate);
    return this;
  }
  
  public List<String> getInstancesToProtect()
  {
    if (instancesToProtect == null) {
      instancesToProtect = new SdkInternalList();
    }
    return instancesToProtect;
  }
  
  public void setInstancesToProtect(Collection<String> instancesToProtect)
  {
    if (instancesToProtect == null)
    {
      this.instancesToProtect = null;
      return;
    }
    this.instancesToProtect = new SdkInternalList(instancesToProtect);
  }
  
  public InstanceResizePolicy withInstancesToProtect(String... instancesToProtect)
  {
    if (this.instancesToProtect == null) {
      setInstancesToProtect(new SdkInternalList(instancesToProtect.length));
    }
    for (String ele : instancesToProtect) {
      this.instancesToProtect.add(ele);
    }
    return this;
  }
  
  public InstanceResizePolicy withInstancesToProtect(Collection<String> instancesToProtect)
  {
    setInstancesToProtect(instancesToProtect);
    return this;
  }
  
  public void setInstanceTerminationTimeout(Integer instanceTerminationTimeout)
  {
    this.instanceTerminationTimeout = instanceTerminationTimeout;
  }
  
  public Integer getInstanceTerminationTimeout()
  {
    return instanceTerminationTimeout;
  }
  
  public InstanceResizePolicy withInstanceTerminationTimeout(Integer instanceTerminationTimeout)
  {
    setInstanceTerminationTimeout(instanceTerminationTimeout);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstancesToTerminate() != null) {
      sb.append("InstancesToTerminate: ").append(getInstancesToTerminate()).append(",");
    }
    if (getInstancesToProtect() != null) {
      sb.append("InstancesToProtect: ").append(getInstancesToProtect()).append(",");
    }
    if (getInstanceTerminationTimeout() != null) {
      sb.append("InstanceTerminationTimeout: ").append(getInstanceTerminationTimeout());
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
    if (!(obj instanceof InstanceResizePolicy)) {
      return false;
    }
    InstanceResizePolicy other = (InstanceResizePolicy)obj;
    if (((other.getInstancesToTerminate() == null ? 1 : 0) ^ (getInstancesToTerminate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstancesToTerminate() != null) && (!other.getInstancesToTerminate().equals(getInstancesToTerminate()))) {
      return false;
    }
    if (((other.getInstancesToProtect() == null ? 1 : 0) ^ (getInstancesToProtect() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstancesToProtect() != null) && (!other.getInstancesToProtect().equals(getInstancesToProtect()))) {
      return false;
    }
    if (((other.getInstanceTerminationTimeout() == null ? 1 : 0) ^ (getInstanceTerminationTimeout() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceTerminationTimeout() != null) && (!other.getInstanceTerminationTimeout().equals(getInstanceTerminationTimeout()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstancesToTerminate() == null ? 0 : getInstancesToTerminate().hashCode());
    hashCode = 31 * hashCode + (getInstancesToProtect() == null ? 0 : getInstancesToProtect().hashCode());
    hashCode = 31 * hashCode + (getInstanceTerminationTimeout() == null ? 0 : getInstanceTerminationTimeout().hashCode());
    return hashCode;
  }
  
  public InstanceResizePolicy clone()
  {
    try
    {
      return (InstanceResizePolicy)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceResizePolicyMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceResizePolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */