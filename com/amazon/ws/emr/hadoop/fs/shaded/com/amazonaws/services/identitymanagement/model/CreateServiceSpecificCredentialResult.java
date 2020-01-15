package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateServiceSpecificCredentialResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ServiceSpecificCredential serviceSpecificCredential;
  
  public void setServiceSpecificCredential(ServiceSpecificCredential serviceSpecificCredential)
  {
    this.serviceSpecificCredential = serviceSpecificCredential;
  }
  
  public ServiceSpecificCredential getServiceSpecificCredential()
  {
    return serviceSpecificCredential;
  }
  
  public CreateServiceSpecificCredentialResult withServiceSpecificCredential(ServiceSpecificCredential serviceSpecificCredential)
  {
    setServiceSpecificCredential(serviceSpecificCredential);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServiceSpecificCredential() != null) {
      sb.append("ServiceSpecificCredential: ").append(getServiceSpecificCredential());
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
    if (!(obj instanceof CreateServiceSpecificCredentialResult)) {
      return false;
    }
    CreateServiceSpecificCredentialResult other = (CreateServiceSpecificCredentialResult)obj;
    if (((other.getServiceSpecificCredential() == null ? 1 : 0) ^ (getServiceSpecificCredential() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceSpecificCredential() != null) && (!other.getServiceSpecificCredential().equals(getServiceSpecificCredential()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServiceSpecificCredential() == null ? 0 : getServiceSpecificCredential().hashCode());
    return hashCode;
  }
  
  public CreateServiceSpecificCredentialResult clone()
  {
    try
    {
      return (CreateServiceSpecificCredentialResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */