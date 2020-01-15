package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.VolumeSpecificationMarshaller;
import java.io.Serializable;

public class VolumeSpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private String volumeType;
  private Integer iops;
  private Integer sizeInGB;
  
  public void setVolumeType(String volumeType)
  {
    this.volumeType = volumeType;
  }
  
  public String getVolumeType()
  {
    return volumeType;
  }
  
  public VolumeSpecification withVolumeType(String volumeType)
  {
    setVolumeType(volumeType);
    return this;
  }
  
  public void setIops(Integer iops)
  {
    this.iops = iops;
  }
  
  public Integer getIops()
  {
    return iops;
  }
  
  public VolumeSpecification withIops(Integer iops)
  {
    setIops(iops);
    return this;
  }
  
  public void setSizeInGB(Integer sizeInGB)
  {
    this.sizeInGB = sizeInGB;
  }
  
  public Integer getSizeInGB()
  {
    return sizeInGB;
  }
  
  public VolumeSpecification withSizeInGB(Integer sizeInGB)
  {
    setSizeInGB(sizeInGB);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getVolumeType() != null) {
      sb.append("VolumeType: ").append(getVolumeType()).append(",");
    }
    if (getIops() != null) {
      sb.append("Iops: ").append(getIops()).append(",");
    }
    if (getSizeInGB() != null) {
      sb.append("SizeInGB: ").append(getSizeInGB());
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
    if (!(obj instanceof VolumeSpecification)) {
      return false;
    }
    VolumeSpecification other = (VolumeSpecification)obj;
    if (((other.getVolumeType() == null ? 1 : 0) ^ (getVolumeType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVolumeType() != null) && (!other.getVolumeType().equals(getVolumeType()))) {
      return false;
    }
    if (((other.getIops() == null ? 1 : 0) ^ (getIops() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIops() != null) && (!other.getIops().equals(getIops()))) {
      return false;
    }
    if (((other.getSizeInGB() == null ? 1 : 0) ^ (getSizeInGB() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSizeInGB() != null) && (!other.getSizeInGB().equals(getSizeInGB()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getVolumeType() == null ? 0 : getVolumeType().hashCode());
    hashCode = 31 * hashCode + (getIops() == null ? 0 : getIops().hashCode());
    hashCode = 31 * hashCode + (getSizeInGB() == null ? 0 : getSizeInGB().hashCode());
    return hashCode;
  }
  
  public VolumeSpecification clone()
  {
    try
    {
      return (VolumeSpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    VolumeSpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.VolumeSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */