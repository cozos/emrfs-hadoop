package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsConfigurationMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class EbsConfiguration
  implements Serializable, Cloneable, StructuredPojo
{
  private SdkInternalList<EbsBlockDeviceConfig> ebsBlockDeviceConfigs;
  private Boolean ebsOptimized;
  
  public List<EbsBlockDeviceConfig> getEbsBlockDeviceConfigs()
  {
    if (ebsBlockDeviceConfigs == null) {
      ebsBlockDeviceConfigs = new SdkInternalList();
    }
    return ebsBlockDeviceConfigs;
  }
  
  public void setEbsBlockDeviceConfigs(Collection<EbsBlockDeviceConfig> ebsBlockDeviceConfigs)
  {
    if (ebsBlockDeviceConfigs == null)
    {
      this.ebsBlockDeviceConfigs = null;
      return;
    }
    this.ebsBlockDeviceConfigs = new SdkInternalList(ebsBlockDeviceConfigs);
  }
  
  public EbsConfiguration withEbsBlockDeviceConfigs(EbsBlockDeviceConfig... ebsBlockDeviceConfigs)
  {
    if (this.ebsBlockDeviceConfigs == null) {
      setEbsBlockDeviceConfigs(new SdkInternalList(ebsBlockDeviceConfigs.length));
    }
    for (EbsBlockDeviceConfig ele : ebsBlockDeviceConfigs) {
      this.ebsBlockDeviceConfigs.add(ele);
    }
    return this;
  }
  
  public EbsConfiguration withEbsBlockDeviceConfigs(Collection<EbsBlockDeviceConfig> ebsBlockDeviceConfigs)
  {
    setEbsBlockDeviceConfigs(ebsBlockDeviceConfigs);
    return this;
  }
  
  public void setEbsOptimized(Boolean ebsOptimized)
  {
    this.ebsOptimized = ebsOptimized;
  }
  
  public Boolean getEbsOptimized()
  {
    return ebsOptimized;
  }
  
  public EbsConfiguration withEbsOptimized(Boolean ebsOptimized)
  {
    setEbsOptimized(ebsOptimized);
    return this;
  }
  
  public Boolean isEbsOptimized()
  {
    return ebsOptimized;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEbsBlockDeviceConfigs() != null) {
      sb.append("EbsBlockDeviceConfigs: ").append(getEbsBlockDeviceConfigs()).append(",");
    }
    if (getEbsOptimized() != null) {
      sb.append("EbsOptimized: ").append(getEbsOptimized());
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
    if (!(obj instanceof EbsConfiguration)) {
      return false;
    }
    EbsConfiguration other = (EbsConfiguration)obj;
    if (((other.getEbsBlockDeviceConfigs() == null ? 1 : 0) ^ (getEbsBlockDeviceConfigs() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsBlockDeviceConfigs() != null) && (!other.getEbsBlockDeviceConfigs().equals(getEbsBlockDeviceConfigs()))) {
      return false;
    }
    if (((other.getEbsOptimized() == null ? 1 : 0) ^ (getEbsOptimized() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsOptimized() != null) && (!other.getEbsOptimized().equals(getEbsOptimized()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEbsBlockDeviceConfigs() == null ? 0 : getEbsBlockDeviceConfigs().hashCode());
    hashCode = 31 * hashCode + (getEbsOptimized() == null ? 0 : getEbsOptimized().hashCode());
    return hashCode;
  }
  
  public EbsConfiguration clone()
  {
    try
    {
      return (EbsConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    EbsConfigurationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */