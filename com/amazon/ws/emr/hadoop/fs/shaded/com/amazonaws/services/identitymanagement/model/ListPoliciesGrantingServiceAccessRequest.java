package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListPoliciesGrantingServiceAccessRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String marker;
  private String arn;
  private SdkInternalList<String> serviceNamespaces;
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListPoliciesGrantingServiceAccessRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public ListPoliciesGrantingServiceAccessRequest withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public List<String> getServiceNamespaces()
  {
    if (serviceNamespaces == null) {
      serviceNamespaces = new SdkInternalList();
    }
    return serviceNamespaces;
  }
  
  public void setServiceNamespaces(Collection<String> serviceNamespaces)
  {
    if (serviceNamespaces == null)
    {
      this.serviceNamespaces = null;
      return;
    }
    this.serviceNamespaces = new SdkInternalList(serviceNamespaces);
  }
  
  public ListPoliciesGrantingServiceAccessRequest withServiceNamespaces(String... serviceNamespaces)
  {
    if (this.serviceNamespaces == null) {
      setServiceNamespaces(new SdkInternalList(serviceNamespaces.length));
    }
    for (String ele : serviceNamespaces) {
      this.serviceNamespaces.add(ele);
    }
    return this;
  }
  
  public ListPoliciesGrantingServiceAccessRequest withServiceNamespaces(Collection<String> serviceNamespaces)
  {
    setServiceNamespaces(serviceNamespaces);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getServiceNamespaces() != null) {
      sb.append("ServiceNamespaces: ").append(getServiceNamespaces());
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
    if (!(obj instanceof ListPoliciesGrantingServiceAccessRequest)) {
      return false;
    }
    ListPoliciesGrantingServiceAccessRequest other = (ListPoliciesGrantingServiceAccessRequest)obj;
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getServiceNamespaces() == null ? 1 : 0) ^ (getServiceNamespaces() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceNamespaces() != null) && (!other.getServiceNamespaces().equals(getServiceNamespaces()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getServiceNamespaces() == null ? 0 : getServiceNamespaces().hashCode());
    return hashCode;
  }
  
  public ListPoliciesGrantingServiceAccessRequest clone()
  {
    return (ListPoliciesGrantingServiceAccessRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */