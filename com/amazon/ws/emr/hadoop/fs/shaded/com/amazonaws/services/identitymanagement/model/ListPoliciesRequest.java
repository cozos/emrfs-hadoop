package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListPoliciesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String scope;
  private Boolean onlyAttached;
  private String pathPrefix;
  private String policyUsageFilter;
  private String marker;
  private Integer maxItems;
  
  public void setScope(String scope)
  {
    this.scope = scope;
  }
  
  public String getScope()
  {
    return scope;
  }
  
  public ListPoliciesRequest withScope(String scope)
  {
    setScope(scope);
    return this;
  }
  
  public void setScope(PolicyScopeType scope)
  {
    withScope(scope);
  }
  
  public ListPoliciesRequest withScope(PolicyScopeType scope)
  {
    this.scope = scope.toString();
    return this;
  }
  
  public void setOnlyAttached(Boolean onlyAttached)
  {
    this.onlyAttached = onlyAttached;
  }
  
  public Boolean getOnlyAttached()
  {
    return onlyAttached;
  }
  
  public ListPoliciesRequest withOnlyAttached(Boolean onlyAttached)
  {
    setOnlyAttached(onlyAttached);
    return this;
  }
  
  public Boolean isOnlyAttached()
  {
    return onlyAttached;
  }
  
  public void setPathPrefix(String pathPrefix)
  {
    this.pathPrefix = pathPrefix;
  }
  
  public String getPathPrefix()
  {
    return pathPrefix;
  }
  
  public ListPoliciesRequest withPathPrefix(String pathPrefix)
  {
    setPathPrefix(pathPrefix);
    return this;
  }
  
  public void setPolicyUsageFilter(String policyUsageFilter)
  {
    this.policyUsageFilter = policyUsageFilter;
  }
  
  public String getPolicyUsageFilter()
  {
    return policyUsageFilter;
  }
  
  public ListPoliciesRequest withPolicyUsageFilter(String policyUsageFilter)
  {
    setPolicyUsageFilter(policyUsageFilter);
    return this;
  }
  
  public void setPolicyUsageFilter(PolicyUsageType policyUsageFilter)
  {
    withPolicyUsageFilter(policyUsageFilter);
  }
  
  public ListPoliciesRequest withPolicyUsageFilter(PolicyUsageType policyUsageFilter)
  {
    this.policyUsageFilter = policyUsageFilter.toString();
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListPoliciesRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setMaxItems(Integer maxItems)
  {
    this.maxItems = maxItems;
  }
  
  public Integer getMaxItems()
  {
    return maxItems;
  }
  
  public ListPoliciesRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getScope() != null) {
      sb.append("Scope: ").append(getScope()).append(",");
    }
    if (getOnlyAttached() != null) {
      sb.append("OnlyAttached: ").append(getOnlyAttached()).append(",");
    }
    if (getPathPrefix() != null) {
      sb.append("PathPrefix: ").append(getPathPrefix()).append(",");
    }
    if (getPolicyUsageFilter() != null) {
      sb.append("PolicyUsageFilter: ").append(getPolicyUsageFilter()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems());
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
    if (!(obj instanceof ListPoliciesRequest)) {
      return false;
    }
    ListPoliciesRequest other = (ListPoliciesRequest)obj;
    if (((other.getScope() == null ? 1 : 0) ^ (getScope() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScope() != null) && (!other.getScope().equals(getScope()))) {
      return false;
    }
    if (((other.getOnlyAttached() == null ? 1 : 0) ^ (getOnlyAttached() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOnlyAttached() != null) && (!other.getOnlyAttached().equals(getOnlyAttached()))) {
      return false;
    }
    if (((other.getPathPrefix() == null ? 1 : 0) ^ (getPathPrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPathPrefix() != null) && (!other.getPathPrefix().equals(getPathPrefix()))) {
      return false;
    }
    if (((other.getPolicyUsageFilter() == null ? 1 : 0) ^ (getPolicyUsageFilter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyUsageFilter() != null) && (!other.getPolicyUsageFilter().equals(getPolicyUsageFilter()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getScope() == null ? 0 : getScope().hashCode());
    hashCode = 31 * hashCode + (getOnlyAttached() == null ? 0 : getOnlyAttached().hashCode());
    hashCode = 31 * hashCode + (getPathPrefix() == null ? 0 : getPathPrefix().hashCode());
    hashCode = 31 * hashCode + (getPolicyUsageFilter() == null ? 0 : getPolicyUsageFilter().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListPoliciesRequest clone()
  {
    return (ListPoliciesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */