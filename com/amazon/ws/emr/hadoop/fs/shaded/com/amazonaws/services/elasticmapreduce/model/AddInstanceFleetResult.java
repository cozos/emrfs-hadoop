package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class AddInstanceFleetResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String clusterId;
  private String instanceFleetId;
  
  public void setClusterId(String clusterId)
  {
    this.clusterId = clusterId;
  }
  
  public String getClusterId()
  {
    return clusterId;
  }
  
  public AddInstanceFleetResult withClusterId(String clusterId)
  {
    setClusterId(clusterId);
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
  
  public AddInstanceFleetResult withInstanceFleetId(String instanceFleetId)
  {
    setInstanceFleetId(instanceFleetId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClusterId() != null) {
      sb.append("ClusterId: ").append(getClusterId()).append(",");
    }
    if (getInstanceFleetId() != null) {
      sb.append("InstanceFleetId: ").append(getInstanceFleetId());
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
    if (!(obj instanceof AddInstanceFleetResult)) {
      return false;
    }
    AddInstanceFleetResult other = (AddInstanceFleetResult)obj;
    if (((other.getClusterId() == null ? 1 : 0) ^ (getClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClusterId() != null) && (!other.getClusterId().equals(getClusterId()))) {
      return false;
    }
    if (((other.getInstanceFleetId() == null ? 1 : 0) ^ (getInstanceFleetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetId() != null) && (!other.getInstanceFleetId().equals(getInstanceFleetId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClusterId() == null ? 0 : getClusterId().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetId() == null ? 0 : getInstanceFleetId().hashCode());
    return hashCode;
  }
  
  public AddInstanceFleetResult clone()
  {
    try
    {
      return (AddInstanceFleetResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */