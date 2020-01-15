package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class AccessControlTranslation
  implements Serializable, Cloneable
{
  private String owner;
  
  public String getOwner()
  {
    return owner;
  }
  
  public void setOwner(String owner)
  {
    this.owner = owner;
  }
  
  public AccessControlTranslation withOwner(String owner)
  {
    setOwner(owner);
    return this;
  }
  
  public AccessControlTranslation withOwner(OwnerOverride owner)
  {
    setOwner(owner == null ? null : owner.toString());
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOwner() != null) {
      sb.append("Owner: ").append(getOwner()).append(",");
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
    if (!(obj instanceof AccessControlTranslation)) {
      return false;
    }
    AccessControlTranslation other = (AccessControlTranslation)obj;
    if (((other.getOwner() == null ? 1 : 0) ^ (getOwner() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOwner() != null) && (!other.getOwner().equals(getOwner()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOwner() == null ? 0 : getOwner().hashCode());
    return hashCode;
  }
  
  public AccessControlTranslation clone()
  {
    try
    {
      return (AccessControlTranslation)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlTranslation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */