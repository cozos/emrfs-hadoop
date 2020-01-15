package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceConfigMarshaller;
import java.io.Serializable;

public class EbsBlockDeviceConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private VolumeSpecification volumeSpecification;
  private Integer volumesPerInstance;
  
  public void setVolumeSpecification(VolumeSpecification volumeSpecification)
  {
    this.volumeSpecification = volumeSpecification;
  }
  
  public VolumeSpecification getVolumeSpecification()
  {
    return volumeSpecification;
  }
  
  public EbsBlockDeviceConfig withVolumeSpecification(VolumeSpecification volumeSpecification)
  {
    setVolumeSpecification(volumeSpecification);
    return this;
  }
  
  public void setVolumesPerInstance(Integer volumesPerInstance)
  {
    this.volumesPerInstance = volumesPerInstance;
  }
  
  public Integer getVolumesPerInstance()
  {
    return volumesPerInstance;
  }
  
  public EbsBlockDeviceConfig withVolumesPerInstance(Integer volumesPerInstance)
  {
    setVolumesPerInstance(volumesPerInstance);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getVolumeSpecification() != null) {
      sb.append("VolumeSpecification: ").append(getVolumeSpecification()).append(",");
    }
    if (getVolumesPerInstance() != null) {
      sb.append("VolumesPerInstance: ").append(getVolumesPerInstance());
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
    if (!(obj instanceof EbsBlockDeviceConfig)) {
      return false;
    }
    EbsBlockDeviceConfig other = (EbsBlockDeviceConfig)obj;
    if (((other.getVolumeSpecification() == null ? 1 : 0) ^ (getVolumeSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVolumeSpecification() != null) && (!other.getVolumeSpecification().equals(getVolumeSpecification()))) {
      return false;
    }
    if (((other.getVolumesPerInstance() == null ? 1 : 0) ^ (getVolumesPerInstance() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVolumesPerInstance() != null) && (!other.getVolumesPerInstance().equals(getVolumesPerInstance()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getVolumeSpecification() == null ? 0 : getVolumeSpecification().hashCode());
    hashCode = 31 * hashCode + (getVolumesPerInstance() == null ? 0 : getVolumesPerInstance().hashCode());
    return hashCode;
  }
  
  public EbsBlockDeviceConfig clone()
  {
    try
    {
      return (EbsBlockDeviceConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    EbsBlockDeviceConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDeviceConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */