package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListBootstrapActionsRequest
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
  
  public ListBootstrapActionsRequest withClusterId(String clusterId)
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
  
  public ListBootstrapActionsRequest withMarker(String marker)
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
    if (!(obj instanceof ListBootstrapActionsRequest)) {
      return false;
    }
    ListBootstrapActionsRequest other = (ListBootstrapActionsRequest)obj;
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
  
  public ListBootstrapActionsRequest clone()
  {
    return (ListBootstrapActionsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */