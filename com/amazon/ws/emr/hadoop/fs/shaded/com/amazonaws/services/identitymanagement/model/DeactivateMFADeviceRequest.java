package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeactivateMFADeviceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String serialNumber;
  
  public DeactivateMFADeviceRequest() {}
  
  public DeactivateMFADeviceRequest(String userName, String serialNumber)
  {
    setUserName(userName);
    setSerialNumber(serialNumber);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public DeactivateMFADeviceRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setSerialNumber(String serialNumber)
  {
    this.serialNumber = serialNumber;
  }
  
  public String getSerialNumber()
  {
    return serialNumber;
  }
  
  public DeactivateMFADeviceRequest withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getSerialNumber() != null) {
      sb.append("SerialNumber: ").append(getSerialNumber());
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
    if (!(obj instanceof DeactivateMFADeviceRequest)) {
      return false;
    }
    DeactivateMFADeviceRequest other = (DeactivateMFADeviceRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getSerialNumber() == null ? 1 : 0) ^ (getSerialNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSerialNumber() != null) && (!other.getSerialNumber().equals(getSerialNumber()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());
    return hashCode;
  }
  
  public DeactivateMFADeviceRequest clone()
  {
    return (DeactivateMFADeviceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */