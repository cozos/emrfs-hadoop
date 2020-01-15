package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListInstanceGroupsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<InstanceGroup> instanceGroups;
  private String marker;
  
  public List<InstanceGroup> getInstanceGroups()
  {
    if (instanceGroups == null) {
      instanceGroups = new SdkInternalList();
    }
    return instanceGroups;
  }
  
  public void setInstanceGroups(Collection<InstanceGroup> instanceGroups)
  {
    if (instanceGroups == null)
    {
      this.instanceGroups = null;
      return;
    }
    this.instanceGroups = new SdkInternalList(instanceGroups);
  }
  
  public ListInstanceGroupsResult withInstanceGroups(InstanceGroup... instanceGroups)
  {
    if (this.instanceGroups == null) {
      setInstanceGroups(new SdkInternalList(instanceGroups.length));
    }
    for (InstanceGroup ele : instanceGroups) {
      this.instanceGroups.add(ele);
    }
    return this;
  }
  
  public ListInstanceGroupsResult withInstanceGroups(Collection<InstanceGroup> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
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
  
  public ListInstanceGroupsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceGroups() != null) {
      sb.append("InstanceGroups: ").append(getInstanceGroups()).append(",");
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
    if (!(obj instanceof ListInstanceGroupsResult)) {
      return false;
    }
    ListInstanceGroupsResult other = (ListInstanceGroupsResult)obj;
    if (((other.getInstanceGroups() == null ? 1 : 0) ^ (getInstanceGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroups() != null) && (!other.getInstanceGroups().equals(getInstanceGroups()))) {
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
    
    hashCode = 31 * hashCode + (getInstanceGroups() == null ? 0 : getInstanceGroups().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstanceGroupsResult clone()
  {
    try
    {
      return (ListInstanceGroupsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */