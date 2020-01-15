package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GenerateOrganizationsAccessReportRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String entityPath;
  private String organizationsPolicyId;
  
  public void setEntityPath(String entityPath)
  {
    this.entityPath = entityPath;
  }
  
  public String getEntityPath()
  {
    return entityPath;
  }
  
  public GenerateOrganizationsAccessReportRequest withEntityPath(String entityPath)
  {
    setEntityPath(entityPath);
    return this;
  }
  
  public void setOrganizationsPolicyId(String organizationsPolicyId)
  {
    this.organizationsPolicyId = organizationsPolicyId;
  }
  
  public String getOrganizationsPolicyId()
  {
    return organizationsPolicyId;
  }
  
  public GenerateOrganizationsAccessReportRequest withOrganizationsPolicyId(String organizationsPolicyId)
  {
    setOrganizationsPolicyId(organizationsPolicyId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEntityPath() != null) {
      sb.append("EntityPath: ").append(getEntityPath()).append(",");
    }
    if (getOrganizationsPolicyId() != null) {
      sb.append("OrganizationsPolicyId: ").append(getOrganizationsPolicyId());
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
    if (!(obj instanceof GenerateOrganizationsAccessReportRequest)) {
      return false;
    }
    GenerateOrganizationsAccessReportRequest other = (GenerateOrganizationsAccessReportRequest)obj;
    if (((other.getEntityPath() == null ? 1 : 0) ^ (getEntityPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityPath() != null) && (!other.getEntityPath().equals(getEntityPath()))) {
      return false;
    }
    if (((other.getOrganizationsPolicyId() == null ? 1 : 0) ^ (getOrganizationsPolicyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOrganizationsPolicyId() != null) && (!other.getOrganizationsPolicyId().equals(getOrganizationsPolicyId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEntityPath() == null ? 0 : getEntityPath().hashCode());
    hashCode = 31 * hashCode + (getOrganizationsPolicyId() == null ? 0 : getOrganizationsPolicyId().hashCode());
    return hashCode;
  }
  
  public GenerateOrganizationsAccessReportRequest clone()
  {
    return (GenerateOrganizationsAccessReportRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */