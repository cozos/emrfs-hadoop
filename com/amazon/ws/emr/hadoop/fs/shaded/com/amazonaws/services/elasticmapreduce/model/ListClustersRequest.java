package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ListClustersRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Date createdAfter;
  private Date createdBefore;
  private SdkInternalList<String> clusterStates;
  private String marker;
  
  public void setCreatedAfter(Date createdAfter)
  {
    this.createdAfter = createdAfter;
  }
  
  public Date getCreatedAfter()
  {
    return createdAfter;
  }
  
  public ListClustersRequest withCreatedAfter(Date createdAfter)
  {
    setCreatedAfter(createdAfter);
    return this;
  }
  
  public void setCreatedBefore(Date createdBefore)
  {
    this.createdBefore = createdBefore;
  }
  
  public Date getCreatedBefore()
  {
    return createdBefore;
  }
  
  public ListClustersRequest withCreatedBefore(Date createdBefore)
  {
    setCreatedBefore(createdBefore);
    return this;
  }
  
  public List<String> getClusterStates()
  {
    if (clusterStates == null) {
      clusterStates = new SdkInternalList();
    }
    return clusterStates;
  }
  
  public void setClusterStates(Collection<String> clusterStates)
  {
    if (clusterStates == null)
    {
      this.clusterStates = null;
      return;
    }
    this.clusterStates = new SdkInternalList(clusterStates);
  }
  
  public ListClustersRequest withClusterStates(String... clusterStates)
  {
    if (this.clusterStates == null) {
      setClusterStates(new SdkInternalList(clusterStates.length));
    }
    for (String ele : clusterStates) {
      this.clusterStates.add(ele);
    }
    return this;
  }
  
  public ListClustersRequest withClusterStates(Collection<String> clusterStates)
  {
    setClusterStates(clusterStates);
    return this;
  }
  
  public ListClustersRequest withClusterStates(ClusterState... clusterStates)
  {
    SdkInternalList<String> clusterStatesCopy = new SdkInternalList(clusterStates.length);
    for (ClusterState value : clusterStates) {
      clusterStatesCopy.add(value.toString());
    }
    if (getClusterStates() == null) {
      setClusterStates(clusterStatesCopy);
    } else {
      getClusterStates().addAll(clusterStatesCopy);
    }
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
  
  public ListClustersRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCreatedAfter() != null) {
      sb.append("CreatedAfter: ").append(getCreatedAfter()).append(",");
    }
    if (getCreatedBefore() != null) {
      sb.append("CreatedBefore: ").append(getCreatedBefore()).append(",");
    }
    if (getClusterStates() != null) {
      sb.append("ClusterStates: ").append(getClusterStates()).append(",");
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
    if (!(obj instanceof ListClustersRequest)) {
      return false;
    }
    ListClustersRequest other = (ListClustersRequest)obj;
    if (((other.getCreatedAfter() == null ? 1 : 0) ^ (getCreatedAfter() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreatedAfter() != null) && (!other.getCreatedAfter().equals(getCreatedAfter()))) {
      return false;
    }
    if (((other.getCreatedBefore() == null ? 1 : 0) ^ (getCreatedBefore() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreatedBefore() != null) && (!other.getCreatedBefore().equals(getCreatedBefore()))) {
      return false;
    }
    if (((other.getClusterStates() == null ? 1 : 0) ^ (getClusterStates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterStates() != null) && (!other.getClusterStates().equals(getClusterStates()))) {
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
    
    hashCode = 31 * hashCode + (getCreatedAfter() == null ? 0 : getCreatedAfter().hashCode());
    hashCode = 31 * hashCode + (getCreatedBefore() == null ? 0 : getCreatedBefore().hashCode());
    hashCode = 31 * hashCode + (getClusterStates() == null ? 0 : getClusterStates().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListClustersRequest clone()
  {
    return (ListClustersRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */