package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListInstancesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<Instance> instances;
  private String marker;
  
  public List<Instance> getInstances()
  {
    if (instances == null) {
      instances = new SdkInternalList();
    }
    return instances;
  }
  
  public void setInstances(Collection<Instance> instances)
  {
    if (instances == null)
    {
      this.instances = null;
      return;
    }
    this.instances = new SdkInternalList(instances);
  }
  
  public ListInstancesResult withInstances(Instance... instances)
  {
    if (this.instances == null) {
      setInstances(new SdkInternalList(instances.length));
    }
    for (Instance ele : instances) {
      this.instances.add(ele);
    }
    return this;
  }
  
  public ListInstancesResult withInstances(Collection<Instance> instances)
  {
    setInstances(instances);
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
  
  public ListInstancesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstances() != null) {
      sb.append("Instances: ").append(getInstances()).append(",");
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
    if (!(obj instanceof ListInstancesResult)) {
      return false;
    }
    ListInstancesResult other = (ListInstancesResult)obj;
    if (((other.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstances() != null) && (!other.getInstances().equals(getInstances()))) {
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
    
    hashCode = 31 * hashCode + (getInstances() == null ? 0 : getInstances().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstancesResult clone()
  {
    try
    {
      return (ListInstancesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */