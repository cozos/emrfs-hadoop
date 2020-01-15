package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BootstrapActionDetailMarshaller;
import java.io.Serializable;

public class BootstrapActionDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private BootstrapActionConfig bootstrapActionConfig;
  
  public BootstrapActionDetail() {}
  
  public BootstrapActionDetail(BootstrapActionConfig bootstrapActionConfig)
  {
    setBootstrapActionConfig(bootstrapActionConfig);
  }
  
  public void setBootstrapActionConfig(BootstrapActionConfig bootstrapActionConfig)
  {
    this.bootstrapActionConfig = bootstrapActionConfig;
  }
  
  public BootstrapActionConfig getBootstrapActionConfig()
  {
    return bootstrapActionConfig;
  }
  
  public BootstrapActionDetail withBootstrapActionConfig(BootstrapActionConfig bootstrapActionConfig)
  {
    setBootstrapActionConfig(bootstrapActionConfig);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBootstrapActionConfig() != null) {
      sb.append("BootstrapActionConfig: ").append(getBootstrapActionConfig());
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
    if (!(obj instanceof BootstrapActionDetail)) {
      return false;
    }
    BootstrapActionDetail other = (BootstrapActionDetail)obj;
    if (((other.getBootstrapActionConfig() == null ? 1 : 0) ^ (getBootstrapActionConfig() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBootstrapActionConfig() != null) && (!other.getBootstrapActionConfig().equals(getBootstrapActionConfig()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBootstrapActionConfig() == null ? 0 : getBootstrapActionConfig().hashCode());
    return hashCode;
  }
  
  public BootstrapActionDetail clone()
  {
    try
    {
      return (BootstrapActionDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BootstrapActionDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */