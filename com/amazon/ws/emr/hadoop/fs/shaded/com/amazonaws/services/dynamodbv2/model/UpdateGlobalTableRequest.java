package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateGlobalTableRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String globalTableName;
  private List<ReplicaUpdate> replicaUpdates;
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public UpdateGlobalTableRequest withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public List<ReplicaUpdate> getReplicaUpdates()
  {
    return replicaUpdates;
  }
  
  public void setReplicaUpdates(Collection<ReplicaUpdate> replicaUpdates)
  {
    if (replicaUpdates == null)
    {
      this.replicaUpdates = null;
      return;
    }
    this.replicaUpdates = new ArrayList(replicaUpdates);
  }
  
  public UpdateGlobalTableRequest withReplicaUpdates(ReplicaUpdate... replicaUpdates)
  {
    if (this.replicaUpdates == null) {
      setReplicaUpdates(new ArrayList(replicaUpdates.length));
    }
    for (ReplicaUpdate ele : replicaUpdates) {
      this.replicaUpdates.add(ele);
    }
    return this;
  }
  
  public UpdateGlobalTableRequest withReplicaUpdates(Collection<ReplicaUpdate> replicaUpdates)
  {
    setReplicaUpdates(replicaUpdates);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName()).append(",");
    }
    if (getReplicaUpdates() != null) {
      sb.append("ReplicaUpdates: ").append(getReplicaUpdates());
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
    if (!(obj instanceof UpdateGlobalTableRequest)) {
      return false;
    }
    UpdateGlobalTableRequest other = (UpdateGlobalTableRequest)obj;
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    if (((other.getReplicaUpdates() == null ? 1 : 0) ^ (getReplicaUpdates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaUpdates() != null) && (!other.getReplicaUpdates().equals(getReplicaUpdates()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    hashCode = 31 * hashCode + (getReplicaUpdates() == null ? 0 : getReplicaUpdates().hashCode());
    return hashCode;
  }
  
  public UpdateGlobalTableRequest clone()
  {
    return (UpdateGlobalTableRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */