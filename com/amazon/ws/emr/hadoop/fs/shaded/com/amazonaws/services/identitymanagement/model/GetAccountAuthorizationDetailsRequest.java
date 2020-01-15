package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetAccountAuthorizationDetailsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> filter;
  private Integer maxItems;
  private String marker;
  
  public List<String> getFilter()
  {
    if (filter == null) {
      filter = new SdkInternalList();
    }
    return filter;
  }
  
  public void setFilter(Collection<String> filter)
  {
    if (filter == null)
    {
      this.filter = null;
      return;
    }
    this.filter = new SdkInternalList(filter);
  }
  
  public GetAccountAuthorizationDetailsRequest withFilter(String... filter)
  {
    if (this.filter == null) {
      setFilter(new SdkInternalList(filter.length));
    }
    for (String ele : filter) {
      this.filter.add(ele);
    }
    return this;
  }
  
  public GetAccountAuthorizationDetailsRequest withFilter(Collection<String> filter)
  {
    setFilter(filter);
    return this;
  }
  
  public GetAccountAuthorizationDetailsRequest withFilter(EntityType... filter)
  {
    SdkInternalList<String> filterCopy = new SdkInternalList(filter.length);
    for (EntityType value : filter) {
      filterCopy.add(value.toString());
    }
    if (getFilter() == null) {
      setFilter(filterCopy);
    } else {
      getFilter().addAll(filterCopy);
    }
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
  
  public GetAccountAuthorizationDetailsRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
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
  
  public GetAccountAuthorizationDetailsRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getFilter() != null) {
      sb.append("Filter: ").append(getFilter()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof GetAccountAuthorizationDetailsRequest)) {
      return false;
    }
    GetAccountAuthorizationDetailsRequest other = (GetAccountAuthorizationDetailsRequest)obj;
    if (((other.getFilter() == null ? 1 : 0) ^ (getFilter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFilter() != null) && (!other.getFilter().equals(getFilter()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getFilter() == null ? 0 : getFilter().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public GetAccountAuthorizationDetailsRequest clone()
  {
    return (GetAccountAuthorizationDetailsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */