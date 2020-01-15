package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

public class VirtualMFADevice
  implements Serializable, Cloneable
{
  private String serialNumber;
  private ByteBuffer base32StringSeed;
  private ByteBuffer qRCodePNG;
  private User user;
  private Date enableDate;
  
  public void setSerialNumber(String serialNumber)
  {
    this.serialNumber = serialNumber;
  }
  
  public String getSerialNumber()
  {
    return serialNumber;
  }
  
  public VirtualMFADevice withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public void setBase32StringSeed(ByteBuffer base32StringSeed)
  {
    this.base32StringSeed = base32StringSeed;
  }
  
  public ByteBuffer getBase32StringSeed()
  {
    return base32StringSeed;
  }
  
  public VirtualMFADevice withBase32StringSeed(ByteBuffer base32StringSeed)
  {
    setBase32StringSeed(base32StringSeed);
    return this;
  }
  
  public void setQRCodePNG(ByteBuffer qRCodePNG)
  {
    this.qRCodePNG = qRCodePNG;
  }
  
  public ByteBuffer getQRCodePNG()
  {
    return qRCodePNG;
  }
  
  public VirtualMFADevice withQRCodePNG(ByteBuffer qRCodePNG)
  {
    setQRCodePNG(qRCodePNG);
    return this;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public User getUser()
  {
    return user;
  }
  
  public VirtualMFADevice withUser(User user)
  {
    setUser(user);
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
  
  public VirtualMFADevice withEnableDate(Date enableDate)
  {
    setEnableDate(enableDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSerialNumber() != null) {
      sb.append("SerialNumber: ").append(getSerialNumber()).append(",");
    }
    if (getBase32StringSeed() != null) {
      sb.append("Base32StringSeed: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getQRCodePNG() != null) {
      sb.append("QRCodePNG: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getUser() != null) {
      sb.append("User: ").append(getUser()).append(",");
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
    if (!(obj instanceof VirtualMFADevice)) {
      return false;
    }
    VirtualMFADevice other = (VirtualMFADevice)obj;
    if (((other.getSerialNumber() == null ? 1 : 0) ^ (getSerialNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSerialNumber() != null) && (!other.getSerialNumber().equals(getSerialNumber()))) {
      return false;
    }
    if (((other.getBase32StringSeed() == null ? 1 : 0) ^ (getBase32StringSeed() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBase32StringSeed() != null) && (!other.getBase32StringSeed().equals(getBase32StringSeed()))) {
      return false;
    }
    if (((other.getQRCodePNG() == null ? 1 : 0) ^ (getQRCodePNG() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQRCodePNG() != null) && (!other.getQRCodePNG().equals(getQRCodePNG()))) {
      return false;
    }
    if (((other.getUser() == null ? 1 : 0) ^ (getUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUser() != null) && (!other.getUser().equals(getUser()))) {
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
    
    hashCode = 31 * hashCode + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());
    hashCode = 31 * hashCode + (getBase32StringSeed() == null ? 0 : getBase32StringSeed().hashCode());
    hashCode = 31 * hashCode + (getQRCodePNG() == null ? 0 : getQRCodePNG().hashCode());
    hashCode = 31 * hashCode + (getUser() == null ? 0 : getUser().hashCode());
    hashCode = 31 * hashCode + (getEnableDate() == null ? 0 : getEnableDate().hashCode());
    return hashCode;
  }
  
  public VirtualMFADevice clone()
  {
    try
    {
      return (VirtualMFADevice)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.VirtualMFADevice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */