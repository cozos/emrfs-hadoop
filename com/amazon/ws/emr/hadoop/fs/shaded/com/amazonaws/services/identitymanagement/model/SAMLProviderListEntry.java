package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class SAMLProviderListEntry
  implements Serializable, Cloneable
{
  private String arn;
  private Date validUntil;
  private Date createDate;
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public SAMLProviderListEntry withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public void setValidUntil(Date validUntil)
  {
    this.validUntil = validUntil;
  }
  
  public Date getValidUntil()
  {
    return validUntil;
  }
  
  public SAMLProviderListEntry withValidUntil(Date validUntil)
  {
    setValidUntil(validUntil);
    return this;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public SAMLProviderListEntry withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getValidUntil() != null) {
      sb.append("ValidUntil: ").append(getValidUntil()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate());
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
    if (!(obj instanceof SAMLProviderListEntry)) {
      return false;
    }
    SAMLProviderListEntry other = (SAMLProviderListEntry)obj;
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getValidUntil() == null ? 1 : 0) ^ (getValidUntil() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValidUntil() != null) && (!other.getValidUntil().equals(getValidUntil()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getValidUntil() == null ? 0 : getValidUntil().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    return hashCode;
  }
  
  public SAMLProviderListEntry clone()
  {
    try
    {
      return (SAMLProviderListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SAMLProviderListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */