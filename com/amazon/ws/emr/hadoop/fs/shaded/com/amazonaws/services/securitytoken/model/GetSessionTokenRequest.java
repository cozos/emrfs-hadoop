package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetSessionTokenRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Integer durationSeconds;
  private String serialNumber;
  private String tokenCode;
  
  public void setDurationSeconds(Integer durationSeconds)
  {
    this.durationSeconds = durationSeconds;
  }
  
  public Integer getDurationSeconds()
  {
    return durationSeconds;
  }
  
  public GetSessionTokenRequest withDurationSeconds(Integer durationSeconds)
  {
    setDurationSeconds(durationSeconds);
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
  
  public GetSessionTokenRequest withSerialNumber(String serialNumber)
  {
    setSerialNumber(serialNumber);
    return this;
  }
  
  public void setTokenCode(String tokenCode)
  {
    this.tokenCode = tokenCode;
  }
  
  public String getTokenCode()
  {
    return tokenCode;
  }
  
  public GetSessionTokenRequest withTokenCode(String tokenCode)
  {
    setTokenCode(tokenCode);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDurationSeconds() != null) {
      sb.append("DurationSeconds: ").append(getDurationSeconds()).append(",");
    }
    if (getSerialNumber() != null) {
      sb.append("SerialNumber: ").append(getSerialNumber()).append(",");
    }
    if (getTokenCode() != null) {
      sb.append("TokenCode: ").append(getTokenCode());
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
    if (!(obj instanceof GetSessionTokenRequest)) {
      return false;
    }
    GetSessionTokenRequest other = (GetSessionTokenRequest)obj;
    if (((other.getDurationSeconds() == null ? 1 : 0) ^ (getDurationSeconds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDurationSeconds() != null) && (!other.getDurationSeconds().equals(getDurationSeconds()))) {
      return false;
    }
    if (((other.getSerialNumber() == null ? 1 : 0) ^ (getSerialNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSerialNumber() != null) && (!other.getSerialNumber().equals(getSerialNumber()))) {
      return false;
    }
    if (((other.getTokenCode() == null ? 1 : 0) ^ (getTokenCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTokenCode() != null) && (!other.getTokenCode().equals(getTokenCode()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode());
    hashCode = 31 * hashCode + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());
    hashCode = 31 * hashCode + (getTokenCode() == null ? 0 : getTokenCode().hashCode());
    return hashCode;
  }
  
  public GetSessionTokenRequest clone()
  {
    return (GetSessionTokenRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */