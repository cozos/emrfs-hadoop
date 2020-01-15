package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TableDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private List<AttributeDefinition> attributeDefinitions;
  private String tableName;
  private List<KeySchemaElement> keySchema;
  private String tableStatus;
  private Date creationDateTime;
  private ProvisionedThroughputDescription provisionedThroughput;
  private Long tableSizeBytes;
  private Long itemCount;
  private String tableArn;
  private String tableId;
  private BillingModeSummary billingModeSummary;
  private List<LocalSecondaryIndexDescription> localSecondaryIndexes;
  private List<GlobalSecondaryIndexDescription> globalSecondaryIndexes;
  private StreamSpecification streamSpecification;
  private String latestStreamLabel;
  private String latestStreamArn;
  private RestoreSummary restoreSummary;
  private SSEDescription sSEDescription;
  
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
  
  public TableDescription withAttributeDefinitions(AttributeDefinition... attributeDefinitions)
  {
    if (this.attributeDefinitions == null) {
      setAttributeDefinitions(new ArrayList(attributeDefinitions.length));
    }
    for (AttributeDefinition ele : attributeDefinitions) {
      this.attributeDefinitions.add(ele);
    }
    return this;
  }
  
  public TableDescription withAttributeDefinitions(Collection<AttributeDefinition> attributeDefinitions)
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
  
  public TableDescription withTableName(String tableName)
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
  
  public TableDescription withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public TableDescription withKeySchema(Collection<KeySchemaElement> keySchema)
  {
    setKeySchema(keySchema);
    return this;
  }
  
  public void setTableStatus(String tableStatus)
  {
    this.tableStatus = tableStatus;
  }
  
  public String getTableStatus()
  {
    return tableStatus;
  }
  
  public TableDescription withTableStatus(String tableStatus)
  {
    setTableStatus(tableStatus);
    return this;
  }
  
  public void setTableStatus(TableStatus tableStatus)
  {
    withTableStatus(tableStatus);
  }
  
  public TableDescription withTableStatus(TableStatus tableStatus)
  {
    this.tableStatus = tableStatus.toString();
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
  
  public TableDescription withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput)
  {
    this.provisionedThroughput = provisionedThroughput;
  }
  
  public ProvisionedThroughputDescription getProvisionedThroughput()
  {
    return provisionedThroughput;
  }
  
  public TableDescription withProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
    return this;
  }
  
  public void setTableSizeBytes(Long tableSizeBytes)
  {
    this.tableSizeBytes = tableSizeBytes;
  }
  
  public Long getTableSizeBytes()
  {
    return tableSizeBytes;
  }
  
  public TableDescription withTableSizeBytes(Long tableSizeBytes)
  {
    setTableSizeBytes(tableSizeBytes);
    return this;
  }
  
  public void setItemCount(Long itemCount)
  {
    this.itemCount = itemCount;
  }
  
  public Long getItemCount()
  {
    return itemCount;
  }
  
  public TableDescription withItemCount(Long itemCount)
  {
    setItemCount(itemCount);
    return this;
  }
  
  public void setTableArn(String tableArn)
  {
    this.tableArn = tableArn;
  }
  
  public String getTableArn()
  {
    return tableArn;
  }
  
  public TableDescription withTableArn(String tableArn)
  {
    setTableArn(tableArn);
    return this;
  }
  
  public void setTableId(String tableId)
  {
    this.tableId = tableId;
  }
  
  public String getTableId()
  {
    return tableId;
  }
  
  public TableDescription withTableId(String tableId)
  {
    setTableId(tableId);
    return this;
  }
  
  public void setBillingModeSummary(BillingModeSummary billingModeSummary)
  {
    this.billingModeSummary = billingModeSummary;
  }
  
  public BillingModeSummary getBillingModeSummary()
  {
    return billingModeSummary;
  }
  
  public TableDescription withBillingModeSummary(BillingModeSummary billingModeSummary)
  {
    setBillingModeSummary(billingModeSummary);
    return this;
  }
  
  public List<LocalSecondaryIndexDescription> getLocalSecondaryIndexes()
  {
    return localSecondaryIndexes;
  }
  
  public void setLocalSecondaryIndexes(Collection<LocalSecondaryIndexDescription> localSecondaryIndexes)
  {
    if (localSecondaryIndexes == null)
    {
      this.localSecondaryIndexes = null;
      return;
    }
    this.localSecondaryIndexes = new ArrayList(localSecondaryIndexes);
  }
  
  public TableDescription withLocalSecondaryIndexes(LocalSecondaryIndexDescription... localSecondaryIndexes)
  {
    if (this.localSecondaryIndexes == null) {
      setLocalSecondaryIndexes(new ArrayList(localSecondaryIndexes.length));
    }
    for (LocalSecondaryIndexDescription ele : localSecondaryIndexes) {
      this.localSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public TableDescription withLocalSecondaryIndexes(Collection<LocalSecondaryIndexDescription> localSecondaryIndexes)
  {
    setLocalSecondaryIndexes(localSecondaryIndexes);
    return this;
  }
  
  public List<GlobalSecondaryIndexDescription> getGlobalSecondaryIndexes()
  {
    return globalSecondaryIndexes;
  }
  
  public void setGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexDescription> globalSecondaryIndexes)
  {
    if (globalSecondaryIndexes == null)
    {
      this.globalSecondaryIndexes = null;
      return;
    }
    this.globalSecondaryIndexes = new ArrayList(globalSecondaryIndexes);
  }
  
  public TableDescription withGlobalSecondaryIndexes(GlobalSecondaryIndexDescription... globalSecondaryIndexes)
  {
    if (this.globalSecondaryIndexes == null) {
      setGlobalSecondaryIndexes(new ArrayList(globalSecondaryIndexes.length));
    }
    for (GlobalSecondaryIndexDescription ele : globalSecondaryIndexes) {
      this.globalSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public TableDescription withGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexDescription> globalSecondaryIndexes)
  {
    setGlobalSecondaryIndexes(globalSecondaryIndexes);
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
  
  public TableDescription withStreamSpecification(StreamSpecification streamSpecification)
  {
    setStreamSpecification(streamSpecification);
    return this;
  }
  
  public void setLatestStreamLabel(String latestStreamLabel)
  {
    this.latestStreamLabel = latestStreamLabel;
  }
  
  public String getLatestStreamLabel()
  {
    return latestStreamLabel;
  }
  
  public TableDescription withLatestStreamLabel(String latestStreamLabel)
  {
    setLatestStreamLabel(latestStreamLabel);
    return this;
  }
  
  public void setLatestStreamArn(String latestStreamArn)
  {
    this.latestStreamArn = latestStreamArn;
  }
  
  public String getLatestStreamArn()
  {
    return latestStreamArn;
  }
  
  public TableDescription withLatestStreamArn(String latestStreamArn)
  {
    setLatestStreamArn(latestStreamArn);
    return this;
  }
  
  public void setRestoreSummary(RestoreSummary restoreSummary)
  {
    this.restoreSummary = restoreSummary;
  }
  
  public RestoreSummary getRestoreSummary()
  {
    return restoreSummary;
  }
  
  public TableDescription withRestoreSummary(RestoreSummary restoreSummary)
  {
    setRestoreSummary(restoreSummary);
    return this;
  }
  
  public void setSSEDescription(SSEDescription sSEDescription)
  {
    this.sSEDescription = sSEDescription;
  }
  
  public SSEDescription getSSEDescription()
  {
    return sSEDescription;
  }
  
  public TableDescription withSSEDescription(SSEDescription sSEDescription)
  {
    setSSEDescription(sSEDescription);
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
    if (getTableStatus() != null) {
      sb.append("TableStatus: ").append(getTableStatus()).append(",");
    }
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput()).append(",");
    }
    if (getTableSizeBytes() != null) {
      sb.append("TableSizeBytes: ").append(getTableSizeBytes()).append(",");
    }
    if (getItemCount() != null) {
      sb.append("ItemCount: ").append(getItemCount()).append(",");
    }
    if (getTableArn() != null) {
      sb.append("TableArn: ").append(getTableArn()).append(",");
    }
    if (getTableId() != null) {
      sb.append("TableId: ").append(getTableId()).append(",");
    }
    if (getBillingModeSummary() != null) {
      sb.append("BillingModeSummary: ").append(getBillingModeSummary()).append(",");
    }
    if (getLocalSecondaryIndexes() != null) {
      sb.append("LocalSecondaryIndexes: ").append(getLocalSecondaryIndexes()).append(",");
    }
    if (getGlobalSecondaryIndexes() != null) {
      sb.append("GlobalSecondaryIndexes: ").append(getGlobalSecondaryIndexes()).append(",");
    }
    if (getStreamSpecification() != null) {
      sb.append("StreamSpecification: ").append(getStreamSpecification()).append(",");
    }
    if (getLatestStreamLabel() != null) {
      sb.append("LatestStreamLabel: ").append(getLatestStreamLabel()).append(",");
    }
    if (getLatestStreamArn() != null) {
      sb.append("LatestStreamArn: ").append(getLatestStreamArn()).append(",");
    }
    if (getRestoreSummary() != null) {
      sb.append("RestoreSummary: ").append(getRestoreSummary()).append(",");
    }
    if (getSSEDescription() != null) {
      sb.append("SSEDescription: ").append(getSSEDescription());
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
    if (!(obj instanceof TableDescription)) {
      return false;
    }
    TableDescription other = (TableDescription)obj;
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
    if (((other.getTableStatus() == null ? 1 : 0) ^ (getTableStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableStatus() != null) && (!other.getTableStatus().equals(getTableStatus()))) {
      return false;
    }
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedThroughput() != null) && (!other.getProvisionedThroughput().equals(getProvisionedThroughput()))) {
      return false;
    }
    if (((other.getTableSizeBytes() == null ? 1 : 0) ^ (getTableSizeBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableSizeBytes() != null) && (!other.getTableSizeBytes().equals(getTableSizeBytes()))) {
      return false;
    }
    if (((other.getItemCount() == null ? 1 : 0) ^ (getItemCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCount() != null) && (!other.getItemCount().equals(getItemCount()))) {
      return false;
    }
    if (((other.getTableArn() == null ? 1 : 0) ^ (getTableArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableArn() != null) && (!other.getTableArn().equals(getTableArn()))) {
      return false;
    }
    if (((other.getTableId() == null ? 1 : 0) ^ (getTableId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableId() != null) && (!other.getTableId().equals(getTableId()))) {
      return false;
    }
    if (((other.getBillingModeSummary() == null ? 1 : 0) ^ (getBillingModeSummary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBillingModeSummary() != null) && (!other.getBillingModeSummary().equals(getBillingModeSummary()))) {
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
    if (((other.getStreamSpecification() == null ? 1 : 0) ^ (getStreamSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamSpecification() != null) && (!other.getStreamSpecification().equals(getStreamSpecification()))) {
      return false;
    }
    if (((other.getLatestStreamLabel() == null ? 1 : 0) ^ (getLatestStreamLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLatestStreamLabel() != null) && (!other.getLatestStreamLabel().equals(getLatestStreamLabel()))) {
      return false;
    }
    if (((other.getLatestStreamArn() == null ? 1 : 0) ^ (getLatestStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLatestStreamArn() != null) && (!other.getLatestStreamArn().equals(getLatestStreamArn()))) {
      return false;
    }
    if (((other.getRestoreSummary() == null ? 1 : 0) ^ (getRestoreSummary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRestoreSummary() != null) && (!other.getRestoreSummary().equals(getRestoreSummary()))) {
      return false;
    }
    if (((other.getSSEDescription() == null ? 1 : 0) ^ (getSSEDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSEDescription() != null) && (!other.getSSEDescription().equals(getSSEDescription()))) {
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
    hashCode = 31 * hashCode + (getTableStatus() == null ? 0 : getTableStatus().hashCode());
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    hashCode = 31 * hashCode + (getTableSizeBytes() == null ? 0 : getTableSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getItemCount() == null ? 0 : getItemCount().hashCode());
    hashCode = 31 * hashCode + (getTableArn() == null ? 0 : getTableArn().hashCode());
    hashCode = 31 * hashCode + (getTableId() == null ? 0 : getTableId().hashCode());
    hashCode = 31 * hashCode + (getBillingModeSummary() == null ? 0 : getBillingModeSummary().hashCode());
    hashCode = 31 * hashCode + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getStreamSpecification() == null ? 0 : getStreamSpecification().hashCode());
    hashCode = 31 * hashCode + (getLatestStreamLabel() == null ? 0 : getLatestStreamLabel().hashCode());
    hashCode = 31 * hashCode + (getLatestStreamArn() == null ? 0 : getLatestStreamArn().hashCode());
    hashCode = 31 * hashCode + (getRestoreSummary() == null ? 0 : getRestoreSummary().hashCode());
    hashCode = 31 * hashCode + (getSSEDescription() == null ? 0 : getSSEDescription().hashCode());
    return hashCode;
  }
  
  public TableDescription clone()
  {
    try
    {
      return (TableDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TableDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */