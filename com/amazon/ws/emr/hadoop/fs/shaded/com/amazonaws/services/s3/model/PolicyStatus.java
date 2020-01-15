package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class PolicyStatus
  implements Serializable, Cloneable
{
  private Boolean isPublic;
  
  public Boolean getIsPublic()
  {
    return isPublic;
  }
  
  public void setIsPublic(Boolean isPublic)
  {
    this.isPublic = isPublic;
  }
  
  public PolicyStatus withIsPublic(Boolean isPublic)
  {
    setIsPublic(isPublic);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    PolicyStatus that = (PolicyStatus)o;
    
    return isPublic == null ? true : isPublic != null ? isPublic.equals(isPublic) : false;
  }
  
  public int hashCode()
  {
    return isPublic != null ? isPublic.hashCode() : 0;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getIsPublic() != null) {
      sb.append("IsPublic: ").append(getIsPublic()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public PolicyStatus clone()
  {
    try
    {
      return (PolicyStatus)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PolicyStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */