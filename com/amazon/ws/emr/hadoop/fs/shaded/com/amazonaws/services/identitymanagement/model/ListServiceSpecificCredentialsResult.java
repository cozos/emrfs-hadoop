package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListServiceSpecificCredentialsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<ServiceSpecificCredentialMetadata> serviceSpecificCredentials;
  
  public List<ServiceSpecificCredentialMetadata> getServiceSpecificCredentials()
  {
    if (serviceSpecificCredentials == null) {
      serviceSpecificCredentials = new SdkInternalList();
    }
    return serviceSpecificCredentials;
  }
  
  public void setServiceSpecificCredentials(Collection<ServiceSpecificCredentialMetadata> serviceSpecificCredentials)
  {
    if (serviceSpecificCredentials == null)
    {
      this.serviceSpecificCredentials = null;
      return;
    }
    this.serviceSpecificCredentials = new SdkInternalList(serviceSpecificCredentials);
  }
  
  public ListServiceSpecificCredentialsResult withServiceSpecificCredentials(ServiceSpecificCredentialMetadata... serviceSpecificCredentials)
  {
    if (this.serviceSpecificCredentials == null) {
      setServiceSpecificCredentials(new SdkInternalList(serviceSpecificCredentials.length));
    }
    for (ServiceSpecificCredentialMetadata ele : serviceSpecificCredentials) {
      this.serviceSpecificCredentials.add(ele);
    }
    return this;
  }
  
  public ListServiceSpecificCredentialsResult withServiceSpecificCredentials(Collection<ServiceSpecificCredentialMetadata> serviceSpecificCredentials)
  {
    setServiceSpecificCredentials(serviceSpecificCredentials);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServiceSpecificCredentials() != null) {
      sb.append("ServiceSpecificCredentials: ").append(getServiceSpecificCredentials());
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
    if (!(obj instanceof ListServiceSpecificCredentialsResult)) {
      return false;
    }
    ListServiceSpecificCredentialsResult other = (ListServiceSpecificCredentialsResult)obj;
    if (((other.getServiceSpecificCredentials() == null ? 1 : 0) ^ (getServiceSpecificCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceSpecificCredentials() != null) && (!other.getServiceSpecificCredentials().equals(getServiceSpecificCredentials()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServiceSpecificCredentials() == null ? 0 : getServiceSpecificCredentials().hashCode());
    return hashCode;
  }
  
  public ListServiceSpecificCredentialsResult clone()
  {
    try
    {
      return (ListServiceSpecificCredentialsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */