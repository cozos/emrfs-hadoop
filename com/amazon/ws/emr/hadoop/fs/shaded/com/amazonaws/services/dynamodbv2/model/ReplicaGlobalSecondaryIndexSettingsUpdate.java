package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller;
import java.io.Serializable;

public class ReplicaGlobalSecondaryIndexSettingsUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private Long provisionedReadCapacityUnits;
  private AutoScalingSettingsUpdate provisionedReadCapacityAutoScalingSettingsUpdate;
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsUpdate withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public void setProvisionedReadCapacityUnits(Long provisionedReadCapacityUnits)
  {
    this.provisionedReadCapacityUnits = provisionedReadCapacityUnits;
  }
  
  public Long getProvisionedReadCapacityUnits()
  {
    return provisionedReadCapacityUnits;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsUpdate withProvisionedReadCapacityUnits(Long provisionedReadCapacityUnits)
  {
    setProvisionedReadCapacityUnits(provisionedReadCapacityUnits);
    return this;
  }
  
  public void setProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate provisionedReadCapacityAutoScalingSettingsUpdate)
  {
    this.provisionedReadCapacityAutoScalingSettingsUpdate = provisionedReadCapacityAutoScalingSettingsUpdate;
  }
  
  public AutoScalingSettingsUpdate getProvisionedReadCapacityAutoScalingSettingsUpdate()
  {
    return provisionedReadCapacityAutoScalingSettingsUpdate;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsUpdate withProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate provisionedReadCapacityAutoScalingSettingsUpdate)
  {
    setProvisionedReadCapacityAutoScalingSettingsUpdate(provisionedReadCapacityAutoScalingSettingsUpdate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getIndexName() != null) {
      sb.append("IndexName: ").append(getIndexName()).append(",");
    }
    if (getProvisionedReadCapacityUnits() != null) {
      sb.append("ProvisionedReadCapacityUnits: ").append(getProvisionedReadCapacityUnits()).append(",");
    }
    if (getProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
      sb.append("ProvisionedReadCapacityAutoScalingSettingsUpdate: ").append(getProvisionedReadCapacityAutoScalingSettingsUpdate());
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
    if (!(obj instanceof ReplicaGlobalSecondaryIndexSettingsUpdate)) {
      return false;
    }
    ReplicaGlobalSecondaryIndexSettingsUpdate other = (ReplicaGlobalSecondaryIndexSettingsUpdate)obj;
    if (((other.getIndexName() == null ? 1 : 0) ^ (getIndexName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexName() != null) && (!other.getIndexName().equals(getIndexName()))) {
      return false;
    }
    if (((other.getProvisionedReadCapacityUnits() == null ? 1 : 0) ^ (getProvisionedReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedReadCapacityUnits() != null) && (!other.getProvisionedReadCapacityUnits().equals(getProvisionedReadCapacityUnits()))) {
      return false;
    }
    if (((other.getProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 1 : 0) ^ (getProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedReadCapacityAutoScalingSettingsUpdate() != null) && 
      (!other.getProvisionedReadCapacityAutoScalingSettingsUpdate().equals(getProvisionedReadCapacityAutoScalingSettingsUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getIndexName() == null ? 0 : getIndexName().hashCode());
    hashCode = 31 * hashCode + (getProvisionedReadCapacityUnits() == null ? 0 : getProvisionedReadCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 0 : getProvisionedReadCapacityAutoScalingSettingsUpdate().hashCode());
    return hashCode;
  }
  
  public ReplicaGlobalSecondaryIndexSettingsUpdate clone()
  {
    try
    {
      return (ReplicaGlobalSecondaryIndexSettingsUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */