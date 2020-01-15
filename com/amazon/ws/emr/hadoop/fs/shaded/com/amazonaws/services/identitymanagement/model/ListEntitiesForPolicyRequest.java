package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListEntitiesForPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyArn;
  private String entityFilter;
  private String pathPrefix;
  private String policyUsageFilter;
  private String marker;
  private Integer maxItems;
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public ListEntitiesForPolicyRequest withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
    return this;
  }
  
  public void setEntityFilter(String entityFilter)
  {
    this.entityFilter = entityFilter;
  }
  
  public String getEntityFilter()
  {
    return entityFilter;
  }
  
  public ListEntitiesForPolicyRequest withEntityFilter(String entityFilter)
  {
    setEntityFilter(entityFilter);
    return this;
  }
  
  public void setEntityFilter(EntityType entityFilter)
  {
    withEntityFilter(entityFilter);
  }
  
  public ListEntitiesForPolicyRequest withEntityFilter(EntityType entityFilter)
  {
    this.entityFilter = entityFilter.toString();
    return this;
  }
  
  public void setPathPrefix(String pathPrefix)
  {
    this.pathPrefix = pathPrefix;
  }
  
  public String getPathPrefix()
  {
    return pathPrefix;
  }
  
  public ListEntitiesForPolicyRequest withPathPrefix(String pathPrefix)
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
  
  public ListEntitiesForPolicyRequest withPolicyUsageFilter(String policyUsageFilter)
  {
    setPolicyUsageFilter(policyUsageFilter);
    return this;
  }
  
  public void setPolicyUsageFilter(PolicyUsageType policyUsageFilter)
  {
    withPolicyUsageFilter(policyUsageFilter);
  }
  
  public ListEntitiesForPolicyRequest withPolicyUsageFilter(PolicyUsageType policyUsageFilter)
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
  
  public ListEntitiesForPolicyRequest withMarker(String marker)
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
  
  public ListEntitiesForPolicyRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn()).append(",");
    }
    if (getEntityFilter() != null) {
      sb.append("EntityFilter: ").append(getEntityFilter()).append(",");
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
    if (!(obj instanceof ListEntitiesForPolicyRequest)) {
      return false;
    }
    ListEntitiesForPolicyRequest other = (ListEntitiesForPolicyRequest)obj;
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    if (((other.getEntityFilter() == null ? 1 : 0) ^ (getEntityFilter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityFilter() != null) && (!other.getEntityFilter().equals(getEntityFilter()))) {
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
    
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    hashCode = 31 * hashCode + (getEntityFilter() == null ? 0 : getEntityFilter().hashCode());
    hashCode = 31 * hashCode + (getPathPrefix() == null ? 0 : getPathPrefix().hashCode());
    hashCode = 31 * hashCode + (getPolicyUsageFilter() == null ? 0 : getPolicyUsageFilter().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListEntitiesForPolicyRequest clone()
  {
    return (ListEntitiesForPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */