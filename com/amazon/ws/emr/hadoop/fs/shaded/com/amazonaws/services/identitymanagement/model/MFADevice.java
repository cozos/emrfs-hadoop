package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class MFADevice
  implements Serializable, Cloneable
{
  private String userName;
  private String serialNumber;
  private Date enableDate;
  
  public MFADevice() {}
  
  public MFADevice(String userName, String serialNumber, Date enableDate)
  {
    setUserName(userName);
    setSerialNumber(serialNumber);
    setEnableDate(enableDate);
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public MFADevice withUserName(String userName)
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
  
  public MFADevice withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public void setEnableDate(Date enableDate)
  {
    this.enableDate = enableDate;
  }
  
  public Date getEnableDate()
  {
    return enableDate;
  }
  
  public MFADevice withEnableDate(Date enableDate)
  {
    setEnableDate(enableDate);
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
    if (getEnableDate() != null) {
      sb.append("EnableDate: ").append(getEnableDate());
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
    if (!(obj instanceof MFADevice)) {
      return false;
    }
    MFADevice other = (MFADevice)obj;
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
    if (((other.getEnableDate() == null ? 1 : 0) ^ (getEnableDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEnableDate() != null) && (!other.getEnableDate().equals(getEnableDate()))) {
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
    hashCode = 31 * hashCode + (getEnableDate() == null ? 0 : getEnableDate().hashCode());
    return hashCode;
  }
  
  public MFADevice clone()
  {
    try
    {
      return (MFADevice)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.MFADevice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */