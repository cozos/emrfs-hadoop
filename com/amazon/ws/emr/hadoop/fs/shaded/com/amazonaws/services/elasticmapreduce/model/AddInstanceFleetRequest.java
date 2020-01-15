package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class AddInstanceFleetRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String clusterId;
  private InstanceFleetConfig instanceFleet;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public AddInstanceFleetRequest withClusterId(String clusterId)
  {
    setClusterId(clusterId);
    return this;
  }
  
  public void setInstanceFleet(InstanceFleetConfig instanceFleet)
  {
    this.instanceFleet = instanceFleet;
  }
  
  public InstanceFleetConfig getInstanceFleet()
  {
    return instanceFleet;
  }
  
  public AddInstanceFleetRequest withInstanceFleet(InstanceFleetConfig instanceFleet)
  {
    setInstanceFleet(instanceFleet);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getInstanceFleet() != null) {
      sb.append("InstanceFleet: ").append(getInstanceFleet());
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
    if (!(obj instanceof AddInstanceFleetRequest)) {
      return false;
    }
    AddInstanceFleetRequest other = (AddInstanceFleetRequest)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getInstanceFleet() == null ? 1 : 0) ^ (getInstanceFleet() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleet() != null) && (!other.getInstanceFleet().equals(getInstanceFleet()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleet() == null ? 0 : getInstanceFleet().hashCode());
    return hashCode;
  }
  
  public AddInstanceFleetRequest clone()
  {
    return (AddInstanceFleetRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */