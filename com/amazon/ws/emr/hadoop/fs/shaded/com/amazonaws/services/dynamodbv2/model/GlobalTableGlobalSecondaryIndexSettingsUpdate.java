package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller;
import java.io.Serializable;

public class GlobalTableGlobalSecondaryIndexSettingsUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private Long provisionedWriteCapacityUnits;
  private AutoScalingSettingsUpdate provisionedWriteCapacityAutoScalingSettingsUpdate;
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public GlobalTableGlobalSecondaryIndexSettingsUpdate withIndexName(String indexName)
  {
    setIndexName(indexName);
    return this;
  }
  
  public void setProvisionedWriteCapacityUnits(Long provisionedWriteCapacityUnits)
  {
    this.provisionedWriteCapacityUnits = provisionedWriteCapacityUnits;
  }
  
  public Long getProvisionedWriteCapacityUnits()
  {
    return provisionedWriteCapacityUnits;
  }
  
  public GlobalTableGlobalSecondaryIndexSettingsUpdate withProvisionedWriteCapacityUnits(Long provisionedWriteCapacityUnits)
  {
    setProvisionedWriteCapacityUnits(provisionedWriteCapacityUnits);
    return this;
  }
  
  public void setProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate provisionedWriteCapacityAutoScalingSettingsUpdate)
  {
    this.provisionedWriteCapacityAutoScalingSettingsUpdate = provisionedWriteCapacityAutoScalingSettingsUpdate;
  }
  
  public AutoScalingSettingsUpdate getProvisionedWriteCapacityAutoScalingSettingsUpdate()
  {
    return provisionedWriteCapacityAutoScalingSettingsUpdate;
  }
  
  public GlobalTableGlobalSecondaryIndexSettingsUpdate withProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate provisionedWriteCapacityAutoScalingSettingsUpdate)
  {
    setProvisionedWriteCapacityAutoScalingSettingsUpdate(provisionedWriteCapacityAutoScalingSettingsUpdate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getIndexName() != null) {
      sb.append("IndexName: ").append(getIndexName()).append(",");
    }
    if (getProvisionedWriteCapacityUnits() != null) {
      sb.append("ProvisionedWriteCapacityUnits: ").append(getProvisionedWriteCapacityUnits()).append(",");
    }
    if (getProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
      sb.append("ProvisionedWriteCapacityAutoScalingSettingsUpdate: ").append(getProvisionedWriteCapacityAutoScalingSettingsUpdate());
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
    if (!(obj instanceof GlobalTableGlobalSecondaryIndexSettingsUpdate)) {
      return false;
    }
    GlobalTableGlobalSecondaryIndexSettingsUpdate other = (GlobalTableGlobalSecondaryIndexSettingsUpdate)obj;
    if (((other.getIndexName() == null ? 1 : 0) ^ (getIndexName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexName() != null) && (!other.getIndexName().equals(getIndexName()))) {
      return false;
    }
    if (((other.getProvisionedWriteCapacityUnits() == null ? 1 : 0) ^ (getProvisionedWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedWriteCapacityUnits() != null) && 
      (!other.getProvisionedWriteCapacityUnits().equals(getProvisionedWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 1 : 0) ^ (getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) && 
      (!other.getProvisionedWriteCapacityAutoScalingSettingsUpdate().equals(getProvisionedWriteCapacityAutoScalingSettingsUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getIndexName() == null ? 0 : getIndexName().hashCode());
    hashCode = 31 * hashCode + (getProvisionedWriteCapacityUnits() == null ? 0 : getProvisionedWriteCapacityUnits().hashCode());
    
    hashCode = 31 * hashCode + (getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null ? 0 : getProvisionedWriteCapacityAutoScalingSettingsUpdate().hashCode());
    return hashCode;
  }
  
  public GlobalTableGlobalSecondaryIndexSettingsUpdate clone()
  {
    try
    {
      return (GlobalTableGlobalSecondaryIndexSettingsUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */