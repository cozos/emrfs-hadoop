package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RoleUsageType
  implements Serializable, Cloneable
{
  private String region;
  private SdkInternalList<String> resources;
  
  public void setRegion(String region)
  {
    this.region = region;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public RoleUsageType withRegion(String region)
  {
    setRegion(region);
    return this;
  }
  
  public List<String> getResources()
  {
    if (resources == null) {
      resources = new SdkInternalList();
    }
    return resources;
  }
  
  public void setResources(Collection<String> resources)
  {
    if (resources == null)
    {
      this.resources = null;
      return;
    }
    this.resources = new SdkInternalList(resources);
  }
  
  public RoleUsageType withResources(String... resources)
  {
    if (this.resources == null) {
      setResources(new SdkInternalList(resources.length));
    }
    for (String ele : resources) {
      this.resources.add(ele);
    }
    return this;
  }
  
  public RoleUsageType withResources(Collection<String> resources)
  {
    setResources(resources);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRegion() != null) {
      sb.append("Region: ").append(getRegion()).append(",");
    }
    if (getResources() != null) {
      sb.append("Resources: ").append(getResources());
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
    if (!(obj instanceof RoleUsageType)) {
      return false;
    }
    RoleUsageType other = (RoleUsageType)obj;
    if (((other.getRegion() == null ? 1 : 0) ^ (getRegion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegion() != null) && (!other.getRegion().equals(getRegion()))) {
      return false;
    }
    if (((other.getResources() == null ? 1 : 0) ^ (getResources() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResources() != null) && (!other.getResources().equals(getResources()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRegion() == null ? 0 : getRegion().hashCode());
    hashCode = 31 * hashCode + (getResources() == null ? 0 : getResources().hashCode());
    return hashCode;
  }
  
  public RoleUsageType clone()
  {
    try
    {
      return (RoleUsageType)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RoleUsageType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */