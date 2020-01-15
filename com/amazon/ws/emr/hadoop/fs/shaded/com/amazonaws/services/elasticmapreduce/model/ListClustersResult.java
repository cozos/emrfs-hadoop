package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListClustersResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<ClusterSummary> clusters;
  private String marker;
  
  public List<ClusterSummary> getClusters()
  {
    if (clusters == null) {
      clusters = new SdkInternalList();
    }
    return clusters;
  }
  
  public void setClusters(Collection<ClusterSummary> clusters)
  {
    if (clusters == null)
    {
      this.clusters = null;
      return;
    }
    this.clusters = new SdkInternalList(clusters);
  }
  
  public ListClustersResult withClusters(ClusterSummary... clusters)
  {
    if (this.clusters == null) {
      setClusters(new SdkInternalList(clusters.length));
    }
    for (ClusterSummary ele : clusters) {
      this.clusters.add(ele);
    }
    return this;
  }
  
  public ListClustersResult withClusters(Collection<ClusterSummary> clusters)
  {
    setClusters(clusters);
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
  
  public ListClustersResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusters() != null) {
      sb.append("Clusters: ").append(getClusters()).append(",");
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
    if (!(obj instanceof ListClustersResult)) {
      return false;
    }
    ListClustersResult other = (ListClustersResult)obj;
    if (((other.getClusters() == null ? 1 : 0) ^ (getClusters() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusters() != null) && (!other.getClusters().equals(getClusters()))) {
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
    
    hashCode = 31 * hashCode + (getClusters() == null ? 0 : getClusters().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListClustersResult clone()
  {
    try
    {
      return (ListClustersResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */