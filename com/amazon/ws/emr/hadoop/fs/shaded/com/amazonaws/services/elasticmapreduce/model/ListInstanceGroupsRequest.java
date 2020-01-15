package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListInstanceGroupsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private String marker;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public ListInstanceGroupsRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
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
  
  public ListInstanceGroupsRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
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
    if (!(obj instanceof ListInstanceGroupsRequest)) {
      return false;
    }
    ListInstanceGroupsRequest other = (ListInstanceGroupsRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
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
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstanceGroupsRequest clone()
  {
    return (ListInstanceGroupsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */