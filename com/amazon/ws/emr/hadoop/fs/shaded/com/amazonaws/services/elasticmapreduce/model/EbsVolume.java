package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsVolumeMarshaller;
import java.io.Serializable;

public class EbsVolume
  implements Serializable, Cloneable, StructuredPojo
{
  private String device;
  private String volumeId;
  
  public void setDevice(String device)
  {
    this.device = device;
  }
  
  public String getDevice()
  {
    return device;
  }
  
  public EbsVolume withDevice(String device)
  {
    setDevice(device);
    return this;
  }
  
  public void setVolumeId(String volumeId)
  {
    this.volumeId = volumeId;
  }
  
  public String getVolumeId()
  {
    return volumeId;
  }
  
  public EbsVolume withVolumeId(String volumeId)
  {
    setVolumeId(volumeId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDevice() != null) {
      sb.append("Device: ").append(getDevice()).append(",");
    }
    if (getVolumeId() != null) {
      sb.append("VolumeId: ").append(getVolumeId());
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
    if (!(obj instanceof EbsVolume)) {
      return false;
    }
    EbsVolume other = (EbsVolume)obj;
    if (((other.getDevice() == null ? 1 : 0) ^ (getDevice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDevice() != null) && (!other.getDevice().equals(getDevice()))) {
      return false;
    }
    if (((other.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVolumeId() != null) && (!other.getVolumeId().equals(getVolumeId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDevice() == null ? 0 : getDevice().hashCode());
    hashCode = 31 * hashCode + (getVolumeId() == null ? 0 : getVolumeId().hashCode());
    return hashCode;
  }
  
  public EbsVolume clone()
  {
    try
    {
      return (EbsVolume)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    EbsVolumeMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsVolume
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */