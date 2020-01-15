package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetAccessKeyInfoRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String accessKeyId;
  
  public void setAccessKeyId(String accessKeyId)
  {
    this.accessKeyId = accessKeyId;
  }
  
  public String getAccessKeyId()
  {
    return accessKeyId;
  }
  
  public GetAccessKeyInfoRequest withAccessKeyId(String accessKeyId)
  {
    setAccessKeyId(accessKeyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccessKeyId() != null) {
      sb.append("AccessKeyId: ").append(getAccessKeyId());
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
    if (!(obj instanceof GetAccessKeyInfoRequest)) {
      return false;
    }
    GetAccessKeyInfoRequest other = (GetAccessKeyInfoRequest)obj;
    if (((other.getAccessKeyId() == null ? 1 : 0) ^ (getAccessKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKeyId() != null) && (!other.getAccessKeyId().equals(getAccessKeyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode());
    return hashCode;
  }
  
  public GetAccessKeyInfoRequest clone()
  {
    return (GetAccessKeyInfoRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */