package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateServiceLinkedRoleRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String aWSServiceName;
  private String description;
  private String customSuffix;
  
  public void setAWSServiceName(String aWSServiceName)
  {
    this.aWSServiceName = aWSServiceName;
  }
  
  public String getAWSServiceName()
  {
    return aWSServiceName;
  }
  
  public CreateServiceLinkedRoleRequest withAWSServiceName(String aWSServiceName)
  {
    setAWSServiceName(aWSServiceName);
    return this;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public CreateServiceLinkedRoleRequest withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public void setCustomSuffix(String customSuffix)
  {
    this.customSuffix = customSuffix;
  }
  
  public String getCustomSuffix()
  {
    return customSuffix;
  }
  
  public CreateServiceLinkedRoleRequest withCustomSuffix(String customSuffix)
  {
    setCustomSuffix(customSuffix);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAWSServiceName() != null) {
      sb.append("AWSServiceName: ").append(getAWSServiceName()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getCustomSuffix() != null) {
      sb.append("CustomSuffix: ").append(getCustomSuffix());
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
    if (!(obj instanceof CreateServiceLinkedRoleRequest)) {
      return false;
    }
    CreateServiceLinkedRoleRequest other = (CreateServiceLinkedRoleRequest)obj;
    if (((other.getAWSServiceName() == null ? 1 : 0) ^ (getAWSServiceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAWSServiceName() != null) && (!other.getAWSServiceName().equals(getAWSServiceName()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getCustomSuffix() == null ? 1 : 0) ^ (getCustomSuffix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomSuffix() != null) && (!other.getCustomSuffix().equals(getCustomSuffix()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAWSServiceName() == null ? 0 : getAWSServiceName().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getCustomSuffix() == null ? 0 : getCustomSuffix().hashCode());
    return hashCode;
  }
  
  public CreateServiceLinkedRoleRequest clone()
  {
    return (CreateServiceLinkedRoleRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */