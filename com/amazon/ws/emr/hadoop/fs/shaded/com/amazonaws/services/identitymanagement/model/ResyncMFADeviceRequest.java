package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ResyncMFADeviceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String serialNumber;
  private String authenticationCode1;
  private String authenticationCode2;
  
  public ResyncMFADeviceRequest() {}
  
  public ResyncMFADeviceRequest(String userName, String serialNumber, String authenticationCode1, String authenticationCode2)
  {
    setUserName(userName);
    setSerialNumber(serialNumber);
    setAuthenticationCode1(authenticationCode1);
    setAuthenticationCode2(authenticationCode2);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ResyncMFADeviceRequest withUserName(String userName)
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
  
  public ResyncMFADeviceRequest withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public void setAuthenticationCode1(String authenticationCode1)
  {
    this.authenticationCode1 = authenticationCode1;
  }
  
  public String getAuthenticationCode1()
  {
    return authenticationCode1;
  }
  
  public ResyncMFADeviceRequest withAuthenticationCode1(String authenticationCode1)
  {
    setAuthenticationCode1(authenticationCode1);
    return this;
  }
  
  public void setAuthenticationCode2(String authenticationCode2)
  {
    this.authenticationCode2 = authenticationCode2;
  }
  
  public String getAuthenticationCode2()
  {
    return authenticationCode2;
  }
  
  public ResyncMFADeviceRequest withAuthenticationCode2(String authenticationCode2)
  {
    setAuthenticationCode2(authenticationCode2);
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
      sb.append("SerialNumber: ").append(getSerialNumber()).append(",");
    }
    if (getAuthenticationCode1() != null) {
      sb.append("AuthenticationCode1: ").append(getAuthenticationCode1()).append(",");
    }
    if (getAuthenticationCode2() != null) {
      sb.append("AuthenticationCode2: ").append(getAuthenticationCode2());
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
    if (!(obj instanceof ResyncMFADeviceRequest)) {
      return false;
    }
    ResyncMFADeviceRequest other = (ResyncMFADeviceRequest)obj;
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
    if (((other.getAuthenticationCode1() == null ? 1 : 0) ^ (getAuthenticationCode1() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAuthenticationCode1() != null) && (!other.getAuthenticationCode1().equals(getAuthenticationCode1()))) {
      return false;
    }
    if (((other.getAuthenticationCode2() == null ? 1 : 0) ^ (getAuthenticationCode2() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAuthenticationCode2() != null) && (!other.getAuthenticationCode2().equals(getAuthenticationCode2()))) {
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
    hashCode = 31 * hashCode + (getAuthenticationCode1() == null ? 0 : getAuthenticationCode1().hashCode());
    hashCode = 31 * hashCode + (getAuthenticationCode2() == null ? 0 : getAuthenticationCode2().hashCode());
    return hashCode;
  }
  
  public ResyncMFADeviceRequest clone()
  {
    return (ResyncMFADeviceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */