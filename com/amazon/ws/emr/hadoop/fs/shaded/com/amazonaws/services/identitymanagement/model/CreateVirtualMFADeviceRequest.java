package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateVirtualMFADeviceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String path;
  private String virtualMFADeviceName;
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public CreateVirtualMFADeviceRequest withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public void setVirtualMFADeviceName(String virtualMFADeviceName)
  {
    this.virtualMFADeviceName = virtualMFADeviceName;
  }
  
  public String getVirtualMFADeviceName()
  {
    return virtualMFADeviceName;
  }
  
  public CreateVirtualMFADeviceRequest withVirtualMFADeviceName(String virtualMFADeviceName)
  {
    setVirtualMFADeviceName(virtualMFADeviceName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
    }
    if (getVirtualMFADeviceName() != null) {
      sb.append("VirtualMFADeviceName: ").append(getVirtualMFADeviceName());
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
    if (!(obj instanceof CreateVirtualMFADeviceRequest)) {
      return false;
    }
    CreateVirtualMFADeviceRequest other = (CreateVirtualMFADeviceRequest)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    if (((other.getVirtualMFADeviceName() == null ? 1 : 0) ^ (getVirtualMFADeviceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVirtualMFADeviceName() != null) && (!other.getVirtualMFADeviceName().equals(getVirtualMFADeviceName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getVirtualMFADeviceName() == null ? 0 : getVirtualMFADeviceName().hashCode());
    return hashCode;
  }
  
  public CreateVirtualMFADeviceRequest clone()
  {
    return (CreateVirtualMFADeviceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */