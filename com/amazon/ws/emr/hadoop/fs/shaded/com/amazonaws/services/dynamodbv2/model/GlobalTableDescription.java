package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GlobalTableDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private List<ReplicaDescription> replicationGroup;
  private String globalTableArn;
  private Date creationDateTime;
  private String globalTableStatus;
  private String globalTableName;
  
  public List<ReplicaDescription> getReplicationGroup()
  {
    return replicationGroup;
  }
  
  public void setReplicationGroup(Collection<ReplicaDescription> replicationGroup)
  {
    if (replicationGroup == null)
    {
      this.replicationGroup = null;
      return;
    }
    this.replicationGroup = new ArrayList(replicationGroup);
  }
  
  public GlobalTableDescription withReplicationGroup(ReplicaDescription... replicationGroup)
  {
    if (this.replicationGroup == null) {
      setReplicationGroup(new ArrayList(replicationGroup.length));
    }
    for (ReplicaDescription ele : replicationGroup) {
      this.replicationGroup.add(ele);
    }
    return this;
  }
  
  public GlobalTableDescription withReplicationGroup(Collection<ReplicaDescription> replicationGroup)
  {
    setReplicationGroup(replicationGroup);
    return this;
  }
  
  public void setGlobalTableArn(String globalTableArn)
  {
    this.globalTableArn = globalTableArn;
  }
  
  public String getGlobalTableArn()
  {
    return globalTableArn;
  }
  
  public GlobalTableDescription withGlobalTableArn(String globalTableArn)
  {
    setGlobalTableArn(globalTableArn);
    return this;
  }
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public GlobalTableDescription withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setGlobalTableStatus(String globalTableStatus)
  {
    this.globalTableStatus = globalTableStatus;
  }
  
  public String getGlobalTableStatus()
  {
    return globalTableStatus;
  }
  
  public GlobalTableDescription withGlobalTableStatus(String globalTableStatus)
  {
    setGlobalTableStatus(globalTableStatus);
    return this;
  }
  
  public GlobalTableDescription withGlobalTableStatus(GlobalTableStatus globalTableStatus)
  {
    this.globalTableStatus = globalTableStatus.toString();
    return this;
  }
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public GlobalTableDescription withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getReplicationGroup() != null) {
      sb.append("ReplicationGroup: ").append(getReplicationGroup()).append(",");
    }
    if (getGlobalTableArn() != null) {
      sb.append("GlobalTableArn: ").append(getGlobalTableArn()).append(",");
    }
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getGlobalTableStatus() != null) {
      sb.append("GlobalTableStatus: ").append(getGlobalTableStatus()).append(",");
    }
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName());
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
    if (!(obj instanceof GlobalTableDescription)) {
      return false;
    }
    GlobalTableDescription other = (GlobalTableDescription)obj;
    if (((other.getReplicationGroup() == null ? 1 : 0) ^ (getReplicationGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicationGroup() != null) && (!other.getReplicationGroup().equals(getReplicationGroup()))) {
      return false;
    }
    if (((other.getGlobalTableArn() == null ? 1 : 0) ^ (getGlobalTableArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableArn() != null) && (!other.getGlobalTableArn().equals(getGlobalTableArn()))) {
      return false;
    }
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getGlobalTableStatus() == null ? 1 : 0) ^ (getGlobalTableStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableStatus() != null) && (!other.getGlobalTableStatus().equals(getGlobalTableStatus()))) {
      return false;
    }
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReplicationGroup() == null ? 0 : getReplicationGroup().hashCode());
    hashCode = 31 * hashCode + (getGlobalTableArn() == null ? 0 : getGlobalTableArn().hashCode());
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getGlobalTableStatus() == null ? 0 : getGlobalTableStatus().hashCode());
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    return hashCode;
  }
  
  public GlobalTableDescription clone()
  {
    try
    {
      return (GlobalTableDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GlobalTableDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */