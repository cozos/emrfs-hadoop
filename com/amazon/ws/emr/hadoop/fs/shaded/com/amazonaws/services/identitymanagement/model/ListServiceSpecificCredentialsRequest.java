package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListServiceSpecificCredentialsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String serviceName;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ListServiceSpecificCredentialsRequest withUserName(String userName)
  {
    setUserName(userName);
    return this;
  }
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public ListServiceSpecificCredentialsRequest withServiceName(String serviceName)
  {
    setServiceName(serviceName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
    }
    if (getServiceName() != null) {
      sb.append("ServiceName: ").append(getServiceName());
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
    if (!(obj instanceof ListServiceSpecificCredentialsRequest)) {
      return false;
    }
    ListServiceSpecificCredentialsRequest other = (ListServiceSpecificCredentialsRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
      return false;
    }
    if (((other.getServiceName() == null ? 1 : 0) ^ (getServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceName() != null) && (!other.getServiceName().equals(getServiceName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getServiceName() == null ? 0 : getServiceName().hashCode());
    return hashCode;
  }
  
  public ListServiceSpecificCredentialsRequest clone()
  {
    return (ListServiceSpecificCredentialsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */