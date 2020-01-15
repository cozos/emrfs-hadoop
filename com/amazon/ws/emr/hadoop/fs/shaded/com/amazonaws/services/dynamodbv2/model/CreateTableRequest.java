package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateTableRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private List<AttributeDefinition> attributeDefinitions;
  private String tableName;
  private List<KeySchemaElement> keySchema;
  private List<LocalSecondaryIndex> localSecondaryIndexes;
  private List<GlobalSecondaryIndex> globalSecondaryIndexes;
  private String billingMode;
  private ProvisionedThroughput provisionedThroughput;
  private StreamSpecification streamSpecification;
  private SSESpecification sSESpecification;
  private List<Tag> tags;
  
  public CreateTableRequest() {}
  
  public CreateTableRequest(String tableName, List<KeySchemaElement> keySchema)
  {
    setTableName(tableName);
    setKeySchema(keySchema);
  }
  
  public CreateTableRequest(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput)
  {
    setAttributeDefinitions(attributeDefinitions);
    setTableName(tableName);
    setKeySchema(keySchema);
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
  
  public CreateTableRequest withAttributeDefinitions(AttributeDefinition... attributeDefinitions)
  {
    if (this.attributeDefinitions == null) {
      setAttributeDefinitions(new ArrayList(attributeDefinitions.length));
    }
    for (AttributeDefinition ele : attributeDefinitions) {
      this.attributeDefinitions.add(ele);
    }
    return this;
  }
  
  public CreateTableRequest withAttributeDefinitions(Collection<AttributeDefinition> attributeDefinitions)
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
  
  public CreateTableRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public List<KeySchemaElement> getKeySchema()
  {
    return keySchema;
  }
  
  public void setKeySchema(Collection<KeySchemaElement> keySchema)
  {
    if (keySchema == null)
    {
      this.keySchema = null;
      return;
    }
    this.keySchema = new ArrayList(keySchema);
  }
  
  public CreateTableRequest withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public CreateTableRequest withKeySchema(Collection<KeySchemaElement> keySchema)
  {
    setKeySchema(keySchema);
    return this;
  }
  
  public List<LocalSecondaryIndex> getLocalSecondaryIndexes()
  {
    return localSecondaryIndexes;
  }
  
  public void setLocalSecondaryIndexes(Collection<LocalSecondaryIndex> localSecondaryIndexes)
  {
    if (localSecondaryIndexes == null)
    {
      this.localSecondaryIndexes = null;
      return;
    }
    this.localSecondaryIndexes = new ArrayList(localSecondaryIndexes);
  }
  
  public CreateTableRequest withLocalSecondaryIndexes(LocalSecondaryIndex... localSecondaryIndexes)
  {
    if (this.localSecondaryIndexes == null) {
      setLocalSecondaryIndexes(new ArrayList(localSecondaryIndexes.length));
    }
    for (LocalSecondaryIndex ele : localSecondaryIndexes) {
      this.localSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public CreateTableRequest withLocalSecondaryIndexes(Collection<LocalSecondaryIndex> localSecondaryIndexes)
  {
    setLocalSecondaryIndexes(localSecondaryIndexes);
    return this;
  }
  
  public List<GlobalSecondaryIndex> getGlobalSecondaryIndexes()
  {
    return globalSecondaryIndexes;
  }
  
  public void setGlobalSecondaryIndexes(Collection<GlobalSecondaryIndex> globalSecondaryIndexes)
  {
    if (globalSecondaryIndexes == null)
    {
      this.globalSecondaryIndexes = null;
      return;
    }
    this.globalSecondaryIndexes = new ArrayList(globalSecondaryIndexes);
  }
  
  public CreateTableRequest withGlobalSecondaryIndexes(GlobalSecondaryIndex... globalSecondaryIndexes)
  {
    if (this.globalSecondaryIndexes == null) {
      setGlobalSecondaryIndexes(new ArrayList(globalSecondaryIndexes.length));
    }
    for (GlobalSecondaryIndex ele : globalSecondaryIndexes) {
      this.globalSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public CreateTableRequest withGlobalSecondaryIndexes(Collection<GlobalSecondaryIndex> globalSecondaryIndexes)
  {
    setGlobalSecondaryIndexes(globalSecondaryIndexes);
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
  
  public CreateTableRequest withBillingMode(String billingMode)
  {
    setBillingMode(billingMode);
    return this;
  }
  
  public CreateTableRequest withBillingMode(BillingMode billingMode)
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
  
  public CreateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
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
  
  public CreateTableRequest withStreamSpecification(StreamSpecification streamSpecification)
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
  
  public CreateTableRequest withSSESpecification(SSESpecification sSESpecification)
  {
    setSSESpecification(sSESpecification);
    return this;
  }
  
  public List<Tag> getTags()
  {
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new ArrayList(tags);
  }
  
  public CreateTableRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new ArrayList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public CreateTableRequest withTags(Collection<Tag> tags)
  {
    setTags(tags);
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
    if (getKeySchema() != null) {
      sb.append("KeySchema: ").append(getKeySchema()).append(",");
    }
    if (getLocalSecondaryIndexes() != null) {
      sb.append("LocalSecondaryIndexes: ").append(getLocalSecondaryIndexes()).append(",");
    }
    if (getGlobalSecondaryIndexes() != null) {
      sb.append("GlobalSecondaryIndexes: ").append(getGlobalSecondaryIndexes()).append(",");
    }
    if (getBillingMode() != null) {
      sb.append("BillingMode: ").append(getBillingMode()).append(",");
    }
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput()).append(",");
    }
    if (getStreamSpecification() != null) {
      sb.append("StreamSpecification: ").append(getStreamSpecification()).append(",");
    }
    if (getSSESpecification() != null) {
      sb.append("SSESpecification: ").append(getSSESpecification()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags());
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
    if (!(obj instanceof CreateTableRequest)) {
      return false;
    }
    CreateTableRequest other = (CreateTableRequest)obj;
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
    if (((other.getKeySchema() == null ? 1 : 0) ^ (getKeySchema() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeySchema() != null) && (!other.getKeySchema().equals(getKeySchema()))) {
      return false;
    }
    if (((other.getLocalSecondaryIndexes() == null ? 1 : 0) ^ (getLocalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLocalSecondaryIndexes() != null) && (!other.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes()))) {
      return false;
    }
    if (((other.getGlobalSecondaryIndexes() == null ? 1 : 0) ^ (getGlobalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalSecondaryIndexes() != null) && (!other.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes()))) {
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
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
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
    hashCode = 31 * hashCode + (getKeySchema() == null ? 0 : getKeySchema().hashCode());
    hashCode = 31 * hashCode + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getBillingMode() == null ? 0 : getBillingMode().hashCode());
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    hashCode = 31 * hashCode + (getStreamSpecification() == null ? 0 : getStreamSpecification().hashCode());
    hashCode = 31 * hashCode + (getSSESpecification() == null ? 0 : getSSESpecification().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public CreateTableRequest clone()
  {
    return (CreateTableRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */