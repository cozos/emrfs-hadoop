package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateInstanceProfileRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String instanceProfileName;
  private String path;
  
  public void setInstanceProfileName(String instanceProfileName)
  {
    this.instanceProfileName = instanceProfileName;
  }
  
  public String getInstanceProfileName()
  {
    return instanceProfileName;
  }
  
  public CreateInstanceProfileRequest withInstanceProfileName(String instanceProfileName)
  {
    setInstanceProfileName(instanceProfileName);
    return this;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public CreateInstanceProfileRequest withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceProfileName() != null) {
      sb.append("InstanceProfileName: ").append(getInstanceProfileName()).append(",");
    }
    if (getPath() != null) {
      sb.append("Path: ").append(getPath());
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
    if (!(obj instanceof CreateInstanceProfileRequest)) {
      return false;
    }
    CreateInstanceProfileRequest other = (CreateInstanceProfileRequest)obj;
    if (((other.getInstanceProfileName() == null ? 1 : 0) ^ (getInstanceProfileName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfileName() != null) && (!other.getInstanceProfileName().equals(getInstanceProfileName()))) {
      return false;
    }
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceProfileName() == null ? 0 : getInstanceProfileName().hashCode());
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    return hashCode;
  }
  
  public CreateInstanceProfileRequest clone()
  {
    return (CreateInstanceProfileRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */