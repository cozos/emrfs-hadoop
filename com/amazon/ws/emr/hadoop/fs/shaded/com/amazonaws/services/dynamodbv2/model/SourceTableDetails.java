package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableDetailsMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SourceTableDetails
  implements Serializable, Cloneable, StructuredPojo
{
  private String tableName;
  private String tableId;
  private String tableArn;
  private Long tableSizeBytes;
  private List<KeySchemaElement> keySchema;
  private Date tableCreationDateTime;
  private ProvisionedThroughput provisionedThroughput;
  private Long itemCount;
  private String billingMode;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public SourceTableDetails withTableName(String tableName)
  {
    setTableName(tableName);
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
  
  public SourceTableDetails withTableId(String tableId)
  {
    setTableId(tableId);
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
  
  public SourceTableDetails withTableArn(String tableArn)
  {
    setTableArn(tableArn);
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
  
  public SourceTableDetails withTableSizeBytes(Long tableSizeBytes)
  {
    setTableSizeBytes(tableSizeBytes);
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
  
  public SourceTableDetails withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public SourceTableDetails withKeySchema(Collection<KeySchemaElement> keySchema)
  {
    setKeySchema(keySchema);
    return this;
  }
  
  public void setTableCreationDateTime(Date tableCreationDateTime)
  {
    this.tableCreationDateTime = tableCreationDateTime;
  }
  
  public Date getTableCreationDateTime()
  {
    return tableCreationDateTime;
  }
  
  public SourceTableDetails withTableCreationDateTime(Date tableCreationDateTime)
  {
    setTableCreationDateTime(tableCreationDateTime);
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
  
  public SourceTableDetails withProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
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
  
  public SourceTableDetails withItemCount(Long itemCount)
  {
    setItemCount(itemCount);
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
  
  public SourceTableDetails withBillingMode(String billingMode)
  {
    setBillingMode(billingMode);
    return this;
  }
  
  public SourceTableDetails withBillingMode(BillingMode billingMode)
  {
    this.billingMode = billingMode.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getTableId() != null) {
      sb.append("TableId: ").append(getTableId()).append(",");
    }
    if (getTableArn() != null) {
      sb.append("TableArn: ").append(getTableArn()).append(",");
    }
    if (getTableSizeBytes() != null) {
      sb.append("TableSizeBytes: ").append(getTableSizeBytes()).append(",");
    }
    if (getKeySchema() != null) {
      sb.append("KeySchema: ").append(getKeySchema()).append(",");
    }
    if (getTableCreationDateTime() != null) {
      sb.append("TableCreationDateTime: ").append(getTableCreationDateTime()).append(",");
    }
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput()).append(",");
    }
    if (getItemCount() != null) {
      sb.append("ItemCount: ").append(getItemCount()).append(",");
    }
    if (getBillingMode() != null) {
      sb.append("BillingMode: ").append(getBillingMode());
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
    if (!(obj instanceof SourceTableDetails)) {
      return false;
    }
    SourceTableDetails other = (SourceTableDetails)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getTableId() == null ? 1 : 0) ^ (getTableId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableId() != null) && (!other.getTableId().equals(getTableId()))) {
      return false;
    }
    if (((other.getTableArn() == null ? 1 : 0) ^ (getTableArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableArn() != null) && (!other.getTableArn().equals(getTableArn()))) {
      return false;
    }
    if (((other.getTableSizeBytes() == null ? 1 : 0) ^ (getTableSizeBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableSizeBytes() != null) && (!other.getTableSizeBytes().equals(getTableSizeBytes()))) {
      return false;
    }
    if (((other.getKeySchema() == null ? 1 : 0) ^ (getKeySchema() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeySchema() != null) && (!other.getKeySchema().equals(getKeySchema()))) {
      return false;
    }
    if (((other.getTableCreationDateTime() == null ? 1 : 0) ^ (getTableCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableCreationDateTime() != null) && (!other.getTableCreationDateTime().equals(getTableCreationDateTime()))) {
      return false;
    }
    if (((other.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedThroughput() != null) && (!other.getProvisionedThroughput().equals(getProvisionedThroughput()))) {
      return false;
    }
    if (((other.getItemCount() == null ? 1 : 0) ^ (getItemCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCount() != null) && (!other.getItemCount().equals(getItemCount()))) {
      return false;
    }
    if (((other.getBillingMode() == null ? 1 : 0) ^ (getBillingMode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBillingMode() != null) && (!other.getBillingMode().equals(getBillingMode()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getTableId() == null ? 0 : getTableId().hashCode());
    hashCode = 31 * hashCode + (getTableArn() == null ? 0 : getTableArn().hashCode());
    hashCode = 31 * hashCode + (getTableSizeBytes() == null ? 0 : getTableSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getKeySchema() == null ? 0 : getKeySchema().hashCode());
    hashCode = 31 * hashCode + (getTableCreationDateTime() == null ? 0 : getTableCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    hashCode = 31 * hashCode + (getItemCount() == null ? 0 : getItemCount().hashCode());
    hashCode = 31 * hashCode + (getBillingMode() == null ? 0 : getBillingMode().hashCode());
    return hashCode;
  }
  
  public SourceTableDetails clone()
  {
    try
    {
      return (SourceTableDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SourceTableDetailsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */