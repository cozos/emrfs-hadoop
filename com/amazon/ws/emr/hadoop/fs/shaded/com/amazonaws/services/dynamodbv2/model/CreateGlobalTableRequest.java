package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateGlobalTableRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String globalTableName;
  private List<Replica> replicationGroup;
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public CreateGlobalTableRequest withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public List<Replica> getReplicationGroup()
  {
    return replicationGroup;
  }
  
  public void setReplicationGroup(Collection<Replica> replicationGroup)
  {
    if (replicationGroup == null)
    {
      this.replicationGroup = null;
      return;
    }
    this.replicationGroup = new ArrayList(replicationGroup);
  }
  
  public CreateGlobalTableRequest withReplicationGroup(Replica... replicationGroup)
  {
    if (this.replicationGroup == null) {
      setReplicationGroup(new ArrayList(replicationGroup.length));
    }
    for (Replica ele : replicationGroup) {
      this.replicationGroup.add(ele);
    }
    return this;
  }
  
  public CreateGlobalTableRequest withReplicationGroup(Collection<Replica> replicationGroup)
  {
    setReplicationGroup(replicationGroup);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName()).append(",");
    }
    if (getReplicationGroup() != null) {
      sb.append("ReplicationGroup: ").append(getReplicationGroup());
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
    if (!(obj instanceof CreateGlobalTableRequest)) {
      return false;
    }
    CreateGlobalTableRequest other = (CreateGlobalTableRequest)obj;
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    if (((other.getReplicationGroup() == null ? 1 : 0) ^ (getReplicationGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicationGroup() != null) && (!other.getReplicationGroup().equals(getReplicationGroup()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    hashCode = 31 * hashCode + (getReplicationGroup() == null ? 0 : getReplicationGroup().hashCode());
    return hashCode;
  }
  
  public CreateGlobalTableRequest clone()
  {
    return (CreateGlobalTableRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */