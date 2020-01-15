package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class OrganizationsDecisionDetail
  implements Serializable, Cloneable
{
  private Boolean allowedByOrganizations;
  
  public void setAllowedByOrganizations(Boolean allowedByOrganizations)
  {
    this.allowedByOrganizations = allowedByOrganizations;
  }
  
  public Boolean getAllowedByOrganizations()
  {
    return allowedByOrganizations;
  }
  
  public OrganizationsDecisionDetail withAllowedByOrganizations(Boolean allowedByOrganizations)
  {
    setAllowedByOrganizations(allowedByOrganizations);
    return this;
  }
  
  public Boolean isAllowedByOrganizations()
  {
    return allowedByOrganizations;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAllowedByOrganizations() != null) {
      sb.append("AllowedByOrganizations: ").append(getAllowedByOrganizations());
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
    if (!(obj instanceof OrganizationsDecisionDetail)) {
      return false;
    }
    OrganizationsDecisionDetail other = (OrganizationsDecisionDetail)obj;
    if (((other.getAllowedByOrganizations() == null ? 1 : 0) ^ (getAllowedByOrganizations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAllowedByOrganizations() != null) && (!other.getAllowedByOrganizations().equals(getAllowedByOrganizations()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAllowedByOrganizations() == null ? 0 : getAllowedByOrganizations().hashCode());
    return hashCode;
  }
  
  public OrganizationsDecisionDetail clone()
  {
    try
    {
      return (OrganizationsDecisionDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.OrganizationsDecisionDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */