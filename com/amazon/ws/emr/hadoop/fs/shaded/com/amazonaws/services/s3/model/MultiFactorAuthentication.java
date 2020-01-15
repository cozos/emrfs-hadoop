package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class MultiFactorAuthentication
  implements Serializable
{
  private String deviceSerialNumber;
  private String token;
  
  public MultiFactorAuthentication(String deviceSerialNumber, String token)
  {
    this.deviceSerialNumber = deviceSerialNumber;
    this.token = token;
  }
  
  public String getDeviceSerialNumber()
  {
    return deviceSerialNumber;
  }
  
  public void setDeviceSerialNumber(String deviceSerialNumber)
  {
    this.deviceSerialNumber = deviceSerialNumber;
  }
  
  public MultiFactorAuthentication withDeviceSerialNumber(String deviceSerialNumber)
  {
    setDeviceSerialNumber(deviceSerialNumber);
    return this;
  }
  
  public String getToken()
  {
    return token;
  }
  
  public void setToken(String token)
  {
    this.token = token;
  }
  
  public MultiFactorAuthentication withToken(String token)
  {
    setToken(token);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiFactorAuthentication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */