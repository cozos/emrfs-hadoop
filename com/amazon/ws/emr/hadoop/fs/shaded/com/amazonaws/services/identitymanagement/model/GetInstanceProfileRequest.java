package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetInstanceProfileRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String instanceProfileName;
  
  public void setInstanceProfileName(String instanceProfileName)
  {
    this.instanceProfileName = instanceProfileName;
  }
  
  public String getInstanceProfileName()
  {
    return instanceProfileName;
  }
  
  public GetInstanceProfileRequest withInstanceProfileName(String instanceProfileName)
  {
    setInstanceProfileName(instanceProfileName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceProfileName() != null) {
      sb.append("InstanceProfileName: ").append(getInstanceProfileName());
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
    if (!(obj instanceof GetInstanceProfileRequest)) {
      return false;
    }
    GetInstanceProfileRequest other = (GetInstanceProfileRequest)obj;
    if (((other.getInstanceProfileName() == null ? 1 : 0) ^ (getInstanceProfileName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfileName() != null) && (!other.getInstanceProfileName().equals(getInstanceProfileName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceProfileName() == null ? 0 : getInstanceProfileName().hashCode());
    return hashCode;
  }
  
  public GetInstanceProfileRequest clone()
  {
    return (GetInstanceProfileRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */