package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListInstancesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private String instanceGroupId;
  private SdkInternalList<String> instanceGroupTypes;
  private String instanceFleetId;
  private String instanceFleetType;
  private SdkInternalList<String> instanceStates;
  private String marker;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public ListInstancesRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public void setInstanceGroupId(String instanceGroupId)
  {
    this.instanceGroupId = instanceGroupId;
  }
  
  public String getInstanceGroupId()
  {
    return instanceGroupId;
  }
  
  public ListInstancesRequest withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
    return this;
  }
  
  public List<String> getInstanceGroupTypes()
  {
    if (instanceGroupTypes == null) {
      instanceGroupTypes = new SdkInternalList();
    }
    return instanceGroupTypes;
  }
  
  public void setInstanceGroupTypes(Collection<String> instanceGroupTypes)
  {
    if (instanceGroupTypes == null)
    {
      this.instanceGroupTypes = null;
      return;
    }
    this.instanceGroupTypes = new SdkInternalList(instanceGroupTypes);
  }
  
  public ListInstancesRequest withInstanceGroupTypes(String... instanceGroupTypes)
  {
    if (this.instanceGroupTypes == null) {
      setInstanceGroupTypes(new SdkInternalList(instanceGroupTypes.length));
    }
    for (String ele : instanceGroupTypes) {
      this.instanceGroupTypes.add(ele);
    }
    return this;
  }
  
  public ListInstancesRequest withInstanceGroupTypes(Collection<String> instanceGroupTypes)
  {
    setInstanceGroupTypes(instanceGroupTypes);
    return this;
  }
  
  public ListInstancesRequest withInstanceGroupTypes(InstanceGroupType... instanceGroupTypes)
  {
    SdkInternalList<String> instanceGroupTypesCopy = new SdkInternalList(instanceGroupTypes.length);
    for (InstanceGroupType value : instanceGroupTypes) {
      instanceGroupTypesCopy.add(value.toString());
    }
    if (getInstanceGroupTypes() == null) {
      setInstanceGroupTypes(instanceGroupTypesCopy);
    } else {
      getInstanceGroupTypes().addAll(instanceGroupTypesCopy);
    }
    return this;
  }
  
  public void setInstanceFleetId(String instanceFleetId)
  {
    this.instanceFleetId = instanceFleetId;
  }
  
  public String getInstanceFleetId()
  {
    return instanceFleetId;
  }
  
  public ListInstancesRequest withInstanceFleetId(String instanceFleetId)
  {
    setInstanceFleetId(instanceFleetId);
    return this;
  }
  
  public void setInstanceFleetType(String instanceFleetType)
  {
    this.instanceFleetType = instanceFleetType;
  }
  
  public String getInstanceFleetType()
  {
    return instanceFleetType;
  }
  
  public ListInstancesRequest withInstanceFleetType(String instanceFleetType)
  {
    setInstanceFleetType(instanceFleetType);
    return this;
  }
  
  public void setInstanceFleetType(InstanceFleetType instanceFleetType)
  {
    withInstanceFleetType(instanceFleetType);
  }
  
  public ListInstancesRequest withInstanceFleetType(InstanceFleetType instanceFleetType)
  {
    this.instanceFleetType = instanceFleetType.toString();
    return this;
  }
  
  public List<String> getInstanceStates()
  {
    if (instanceStates == null) {
      instanceStates = new SdkInternalList();
    }
    return instanceStates;
  }
  
  public void setInstanceStates(Collection<String> instanceStates)
  {
    if (instanceStates == null)
    {
      this.instanceStates = null;
      return;
    }
    this.instanceStates = new SdkInternalList(instanceStates);
  }
  
  public ListInstancesRequest withInstanceStates(String... instanceStates)
  {
    if (this.instanceStates == null) {
      setInstanceStates(new SdkInternalList(instanceStates.length));
    }
    for (String ele : instanceStates) {
      this.instanceStates.add(ele);
    }
    return this;
  }
  
  public ListInstancesRequest withInstanceStates(Collection<String> instanceStates)
  {
    setInstanceStates(instanceStates);
    return this;
  }
  
  public ListInstancesRequest withInstanceStates(InstanceState... instanceStates)
  {
    SdkInternalList<String> instanceStatesCopy = new SdkInternalList(instanceStates.length);
    for (InstanceState value : instanceStates) {
      instanceStatesCopy.add(value.toString());
    }
    if (getInstanceStates() == null) {
      setInstanceStates(instanceStatesCopy);
    } else {
      getInstanceStates().addAll(instanceStatesCopy);
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
  
  public ListInstancesRequest withMarker(String marker)
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
    if (getInstanceGroupId() != null) {
      sb.append("InstanceGroupId: ").append(getInstanceGroupId()).append(",");
    }
    if (getInstanceGroupTypes() != null) {
      sb.append("InstanceGroupTypes: ").append(getInstanceGroupTypes()).append(",");
    }
    if (getInstanceFleetId() != null) {
      sb.append("InstanceFleetId: ").append(getInstanceFleetId()).append(",");
    }
    if (getInstanceFleetType() != null) {
      sb.append("InstanceFleetType: ").append(getInstanceFleetType()).append(",");
    }
    if (getInstanceStates() != null) {
      sb.append("InstanceStates: ").append(getInstanceStates()).append(",");
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
    if (!(obj instanceof ListInstancesRequest)) {
      return false;
    }
    ListInstancesRequest other = (ListInstancesRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getInstanceGroupId() == null ? 1 : 0) ^ (getInstanceGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupId() != null) && (!other.getInstanceGroupId().equals(getInstanceGroupId()))) {
      return false;
    }
    if (((other.getInstanceGroupTypes() == null ? 1 : 0) ^ (getInstanceGroupTypes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupTypes() != null) && (!other.getInstanceGroupTypes().equals(getInstanceGroupTypes()))) {
      return false;
    }
    if (((other.getInstanceFleetId() == null ? 1 : 0) ^ (getInstanceFleetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetId() != null) && (!other.getInstanceFleetId().equals(getInstanceFleetId()))) {
      return false;
    }
    if (((other.getInstanceFleetType() == null ? 1 : 0) ^ (getInstanceFleetType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetType() != null) && (!other.getInstanceFleetType().equals(getInstanceFleetType()))) {
      return false;
    }
    if (((other.getInstanceStates() == null ? 1 : 0) ^ (getInstanceStates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceStates() != null) && (!other.getInstanceStates().equals(getInstanceStates()))) {
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
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupTypes() == null ? 0 : getInstanceGroupTypes().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetId() == null ? 0 : getInstanceFleetId().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetType() == null ? 0 : getInstanceFleetType().hashCode());
    hashCode = 31 * hashCode + (getInstanceStates() == null ? 0 : getInstanceStates().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstancesRequest clone()
  {
    return (ListInstancesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */