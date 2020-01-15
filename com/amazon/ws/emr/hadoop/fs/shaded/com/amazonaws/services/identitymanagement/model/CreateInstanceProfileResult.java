package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateInstanceProfileResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private InstanceProfile instanceProfile;
  
  public void setInstanceProfile(InstanceProfile instanceProfile)
  {
    this.instanceProfile = instanceProfile;
  }
  
  public InstanceProfile getInstanceProfile()
  {
    return instanceProfile;
  }
  
  public CreateInstanceProfileResult withInstanceProfile(InstanceProfile instanceProfile)
  {
    setInstanceProfile(instanceProfile);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceProfile() != null) {
      sb.append("InstanceProfile: ").append(getInstanceProfile());
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
    if (!(obj instanceof CreateInstanceProfileResult)) {
      return false;
    }
    CreateInstanceProfileResult other = (CreateInstanceProfileResult)obj;
    if (((other.getInstanceProfile() == null ? 1 : 0) ^ (getInstanceProfile() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceProfile() != null) && (!other.getInstanceProfile().equals(getInstanceProfile()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceProfile() == null ? 0 : getInstanceProfile().hashCode());
    return hashCode;
  }
  
  public CreateInstanceProfileResult clone()
  {
    try
    {
      return (CreateInstanceProfileResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */