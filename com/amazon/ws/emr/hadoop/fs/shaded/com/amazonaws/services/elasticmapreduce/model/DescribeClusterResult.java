package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeClusterResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Cluster cluster;
  
  public void setCluster(Cluster cluster)
  {
    this.cluster = cluster;
  }
  
  public Cluster getCluster()
  {
    return cluster;
  }
  
  public DescribeClusterResult withCluster(Cluster cluster)
  {
    setCluster(cluster);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCluster() != null) {
      sb.append("Cluster: ").append(getCluster());
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
    if (!(obj instanceof DescribeClusterResult)) {
      return false;
    }
    DescribeClusterResult other = (DescribeClusterResult)obj;
    if (((other.getCluster() == null ? 1 : 0) ^ (getCluster() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCluster() != null) && (!other.getCluster().equals(getCluster()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCluster() == null ? 0 : getCluster().hashCode());
    return hashCode;
  }
  
  public DescribeClusterResult clone()
  {
    try
    {
      return (DescribeClusterResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */