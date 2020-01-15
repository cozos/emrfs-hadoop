package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceMarshaller;
import java.io.Serializable;

public class EbsBlockDevice
  implements Serializable, Cloneable, StructuredPojo
{
  private VolumeSpecification volumeSpecification;
  private String device;
  
  public void setVolumeSpecification(VolumeSpecification volumeSpecification)
  {
    this.volumeSpecification = volumeSpecification;
  }
  
  public VolumeSpecification getVolumeSpecification()
  {
    return volumeSpecification;
  }
  
  public EbsBlockDevice withVolumeSpecification(VolumeSpecification volumeSpecification)
  {
    setVolumeSpecification(volumeSpecification);
    return this;
  }
  
  public void setDevice(String device)
  {
    this.device = device;
  }
  
  public String getDevice()
  {
    return device;
  }
  
  public EbsBlockDevice withDevice(String device)
  {
    setDevice(device);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getVolumeSpecification() != null) {
      sb.append("VolumeSpecification: ").append(getVolumeSpecification()).append(",");
    }
    if (getDevice() != null) {
      sb.append("Device: ").append(getDevice());
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
    if (!(obj instanceof EbsBlockDevice)) {
      return false;
    }
    EbsBlockDevice other = (EbsBlockDevice)obj;
    if (((other.getVolumeSpecification() == null ? 1 : 0) ^ (getVolumeSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVolumeSpecification() != null) && (!other.getVolumeSpecification().equals(getVolumeSpecification()))) {
      return false;
    }
    if (((other.getDevice() == null ? 1 : 0) ^ (getDevice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDevice() != null) && (!other.getDevice().equals(getDevice()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getVolumeSpecification() == null ? 0 : getVolumeSpecification().hashCode());
    hashCode = 31 * hashCode + (getDevice() == null ? 0 : getDevice().hashCode());
    return hashCode;
  }
  
  public EbsBlockDevice clone()
  {
    try
    {
      return (EbsBlockDevice)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    EbsBlockDeviceMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDevice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */