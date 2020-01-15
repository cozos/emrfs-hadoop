package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateVirtualMFADeviceResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private VirtualMFADevice virtualMFADevice;
  
  public void setVirtualMFADevice(VirtualMFADevice virtualMFADevice)
  {
    this.virtualMFADevice = virtualMFADevice;
  }
  
  public VirtualMFADevice getVirtualMFADevice()
  {
    return virtualMFADevice;
  }
  
  public CreateVirtualMFADeviceResult withVirtualMFADevice(VirtualMFADevice virtualMFADevice)
  {
    setVirtualMFADevice(virtualMFADevice);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getVirtualMFADevice() != null) {
      sb.append("VirtualMFADevice: ").append(getVirtualMFADevice());
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
    if (!(obj instanceof CreateVirtualMFADeviceResult)) {
      return false;
    }
    CreateVirtualMFADeviceResult other = (CreateVirtualMFADeviceResult)obj;
    if (((other.getVirtualMFADevice() == null ? 1 : 0) ^ (getVirtualMFADevice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVirtualMFADevice() != null) && (!other.getVirtualMFADevice().equals(getVirtualMFADevice()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getVirtualMFADevice() == null ? 0 : getVirtualMFADevice().hashCode());
    return hashCode;
  }
  
  public CreateVirtualMFADeviceResult clone()
  {
    try
    {
      return (CreateVirtualMFADeviceResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */