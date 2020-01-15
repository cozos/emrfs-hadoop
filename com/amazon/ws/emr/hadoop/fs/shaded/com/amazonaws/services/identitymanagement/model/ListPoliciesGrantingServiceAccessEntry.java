package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListPoliciesGrantingServiceAccessEntry
  implements Serializable, Cloneable
{
  private String serviceNamespace;
  private SdkInternalList<PolicyGrantingServiceAccess> policies;
  
  public void setServiceNamespace(String serviceNamespace)
  {
    this.serviceNamespace = serviceNamespace;
  }
  
  public String getServiceNamespace()
  {
    return serviceNamespace;
  }
  
  public ListPoliciesGrantingServiceAccessEntry withServiceNamespace(String serviceNamespace)
  {
    setServiceNamespace(serviceNamespace);
    return this;
  }
  
  public List<PolicyGrantingServiceAccess> getPolicies()
  {
    if (policies == null) {
      policies = new SdkInternalList();
    }
    return policies;
  }
  
  public void setPolicies(Collection<PolicyGrantingServiceAccess> policies)
  {
    if (policies == null)
    {
      this.policies = null;
      return;
    }
    this.policies = new SdkInternalList(policies);
  }
  
  public ListPoliciesGrantingServiceAccessEntry withPolicies(PolicyGrantingServiceAccess... policies)
  {
    if (this.policies == null) {
      setPolicies(new SdkInternalList(policies.length));
    }
    for (PolicyGrantingServiceAccess ele : policies) {
      this.policies.add(ele);
    }
    return this;
  }
  
  public ListPoliciesGrantingServiceAccessEntry withPolicies(Collection<PolicyGrantingServiceAccess> policies)
  {
    setPolicies(policies);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServiceNamespace() != null) {
      sb.append("ServiceNamespace: ").append(getServiceNamespace()).append(",");
    }
    if (getPolicies() != null) {
      sb.append("Policies: ").append(getPolicies());
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
    if (!(obj instanceof ListPoliciesGrantingServiceAccessEntry)) {
      return false;
    }
    ListPoliciesGrantingServiceAccessEntry other = (ListPoliciesGrantingServiceAccessEntry)obj;
    if (((other.getServiceNamespace() == null ? 1 : 0) ^ (getServiceNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceNamespace() != null) && (!other.getServiceNamespace().equals(getServiceNamespace()))) {
      return false;
    }
    if (((other.getPolicies() == null ? 1 : 0) ^ (getPolicies() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicies() != null) && (!other.getPolicies().equals(getPolicies()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServiceNamespace() == null ? 0 : getServiceNamespace().hashCode());
    hashCode = 31 * hashCode + (getPolicies() == null ? 0 : getPolicies().hashCode());
    return hashCode;
  }
  
  public ListPoliciesGrantingServiceAccessEntry clone()
  {
    try
    {
      return (ListPoliciesGrantingServiceAccessEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */