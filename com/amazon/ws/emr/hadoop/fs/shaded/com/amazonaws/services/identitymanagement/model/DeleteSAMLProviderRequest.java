package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteSAMLProviderRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String sAMLProviderArn;
  
  public void setSAMLProviderArn(String sAMLProviderArn)
  {
    this.sAMLProviderArn = sAMLProviderArn;
  }
  
  public String getSAMLProviderArn()
  {
    return sAMLProviderArn;
  }
  
  public DeleteSAMLProviderRequest withSAMLProviderArn(String sAMLProviderArn)
  {
    setSAMLProviderArn(sAMLProviderArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSAMLProviderArn() != null) {
      sb.append("SAMLProviderArn: ").append(getSAMLProviderArn());
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
    if (!(obj instanceof DeleteSAMLProviderRequest)) {
      return false;
    }
    DeleteSAMLProviderRequest other = (DeleteSAMLProviderRequest)obj;
    if (((other.getSAMLProviderArn() == null ? 1 : 0) ^ (getSAMLProviderArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLProviderArn() != null) && (!other.getSAMLProviderArn().equals(getSAMLProviderArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSAMLProviderArn() == null ? 0 : getSAMLProviderArn().hashCode());
    return hashCode;
  }
  
  public DeleteSAMLProviderRequest clone()
  {
    return (DeleteSAMLProviderRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */