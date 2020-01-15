package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateTableRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private List<AttributeDefinition> attributeDefinitions;
  private String tableName;
  private String billingMode;
  private ProvisionedThroughput provisionedThroughput;
  private List<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates;
  private StreamSpecification streamSpecification;
  private SSESpecification sSESpecification;
  
  public UpdateTableRequest() {}
  
  public UpdateTableRequest(String tableName, ProvisionedThroughput provisionedThroughput)
  {
    setTableName(tableName);
    setProvisionedThroughput(provisionedThroughput);
  }
  
  public List<AttributeDefinition> getAttributeDefinitions()
  {
    return attributeDefinitions;
  }
  
  public void setAttributeDefinitions(Collection<AttributeDefinition> attributeDefinitions)
  {
    if (attributeDefinitions == null)
    {
      this.attributeDefinitions = null;
      return;
    }
    this.attributeDefinitions = new ArrayList(attributeDefinitions);
  }
  
  public UpdateTableRequest withAttributeDefinitions(AttributeDefinition... attributeDefinitions)
  {
    if (this.attributeDefinitions == null) {
      setAttributeDefinitions(new ArrayList(attributeDefinitions.length));
    }
    for (AttributeDefinition ele : attributeDefinitions) {
      this.attributeDefinitions.add(ele);
    }
    return this;
  }
  
  public UpdateTableRequest withAttributeDefinitions(Collection<AttributeDefinition> attributeDefinitions)
  {
    setAttributeDefinitions(attributeDefinitions);
    return this;
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public UpdateTableRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setBillingMode(String billingMode)
  {
    this.billingMode = billingMode;
  }
  
  public String getBillingMode()
  {
    return billingMode;
  }
  
  public UpdateTableRequest withBillingMode(String billingMode)
  {
    setBillingMode(billingMode);
    return this;
  }
  
  public UpdateTableRequest withBillingMode(BillingMode billingMode)
  {
    this.billingMode = billingMode.toString();
    return this;
  }
  
  public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    this.provisionedThroughput = provisionedThroughput;
  }
  
  public ProvisionedThroughput getProvisionedThroughput()
  {
    return provisionedThroughput;
  }
  
  public UpdateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
    return this;
  }
  
  public List<GlobalSecondaryIndexUpdate> getGlobalSecondaryIndexUpdates()
  {
    return globalSecondaryIndexUpdates;
  }
  
  public void setGlobalSecondaryIndexUpdates(Collection<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates)
  {
    if (globalSecondaryIndexUpdates == null)
    {
      this.globalSecondaryIndexUpdates = null;
      return;
    }
    this.globalSecondaryIndexUpdates = new ArrayList(globalSecondaryIndexUpdates);
  }
  
  public UpdateTableRequest withGlobalSecondaryIndexUpdates(GlobalSecondaryIndexUpdate... globalSecondaryIndexUpdates)
  {
    if (this.globalSecondaryIndexUpdates == null) {
      setGlobalSecondaryIndexUpdates(new ArrayList(globalSecondaryIndexUpdates.length));
    }
    for (GlobalSecondaryIndexUpdate ele : globalSecondaryIndexUpdates) {
      this.globalSecondaryIndexUpdates.add(ele);
    }
    return this;
  }
  
  public UpdateTableRequest withGlobalSecondaryIndexUpdates(Collection<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates)
  {
    setGlobalSecondaryIndexUpdates(globalSecondaryIndexUpdates);
    return this;
  }
  
  public void setStreamSpecification(StreamSpecification streamSpecification)
  {
    this.streamSpecification = streamSpecification;
  }
  
  public StreamSpecification getStreamSpecification()
  {
    return streamSpecification;
  }
  
  public UpdateTableRequest withStreamSpecification(StreamSpecification streamSpecification)
  {
    setStreamSpecification(streamSpecification);
    return this;
  }
  
  public void setSSESpecification(SSESpecification sSESpecification)
  {
    this.sSESpecification = sSESpecification;
  }
  
  public SSESpecification getSSESpecification()
  {
    return sSESpecification;
  }
  
  public UpdateTableRequest withSSESpecification(SSESpecification sSESpecification)
  {
    setSSESpecification(sSESpecification);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributeDefinitions() != null) {
      sb.append("AttributeDefinitions: ").append(getAttributeDefinitions()).append(",");
    }
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getBillingMode() != null) {
      sb.append("BillingMode: ").append(getBillingMode()).append(",");
    }
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput()).append(",");
    }
    if (getGlobalSecondaryIndexUpdates() != null) {
      sb.append("GlobalSecondaryIndexUpdates: ").append(getGlobalSecondaryIndexUpdates()).append(",");
    }
    if (getStreamSpecification() != null) {
      sb.append("StreamSpecification: ").append(getStreamSpecification()).append(",");
    }
    if (getSSESpecification() != null) {
      sb.append("SSESpecification: ").append(getSSESpecification());
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
    if (!(obj instanceof UpdateTableRequest)) {
      return false;
    }
    UpdateTableRequest other = (UpdateTableRequest)obj;
    if (((other.getAttributeDefinitions() == null ? 1 : 0) ^ (getAttributeDefinitions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeDefinitions() != null) && (!other.getAttributeDefinitions().equals(getAttributeDefinitions()))) {
      return false;
    }
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getBillingMode() == null ? 1 : 0) ^ (getBillingMode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBillingMode() != null) && (!other.getBillingMode().equals(getBillingMode()))) {
      return false;
    }
    if (((other.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedThroughput() != null) && (!other.getProvisionedThroughput().equals(getProvisionedThroughput()))) {
      return false;
    }
    if (((other.getGlobalSecondaryIndexUpdates() == null ? 1 : 0) ^ (getGlobalSecondaryIndexUpdates() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalSecondaryIndexUpdates() != null) && (!other.getGlobalSecondaryIndexUpdates().equals(getGlobalSecondaryIndexUpdates()))) {
      return false;
    }
    if (((other.getStreamSpecification() == null ? 1 : 0) ^ (getStreamSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamSpecification() != null) && (!other.getStreamSpecification().equals(getStreamSpecification()))) {
      return false;
    }
    if (((other.getSSESpecification() == null ? 1 : 0) ^ (getSSESpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSESpecification() != null) && (!other.getSSESpecification().equals(getSSESpecification()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttributeDefinitions() == null ? 0 : getAttributeDefinitions().hashCode());
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getBillingMode() == null ? 0 : getBillingMode().hashCode());
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    hashCode = 31 * hashCode + (getGlobalSecondaryIndexUpdates() == null ? 0 : getGlobalSecondaryIndexUpdates().hashCode());
    hashCode = 31 * hashCode + (getStreamSpecification() == null ? 0 : getStreamSpecification().hashCode());
    hashCode = 31 * hashCode + (getSSESpecification() == null ? 0 : getSSESpecification().hashCode());
    return hashCode;
  }
  
  public UpdateTableRequest clone()
  {
    return (UpdateTableRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */