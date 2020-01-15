package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalSecondaryIndexDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GlobalSecondaryIndexDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private List<KeySchemaElement> keySchema;
  private Projection projection;
  private String indexStatus;
  private Boolean backfilling;
  private ProvisionedThroughputDescription provisionedThroughput;
  private Long indexSizeBytes;
  private Long itemCount;
  private String indexArn;
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public GlobalSecondaryIndexDescription withIndexName(String indexName)
  {
    setIndexName(indexName);
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
  
  public GlobalSecondaryIndexDescription withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public GlobalSecondaryIndexDescription withKeySchema(Collection<KeySchemaElement> keySchema)
  {
    setKeySchema(keySchema);
    return this;
  }
  
  public void setProjection(Projection projection)
  {
    this.projection = projection;
  }
  
  public Projection getProjection()
  {
    return projection;
  }
  
  public GlobalSecondaryIndexDescription withProjection(Projection projection)
  {
    setProjection(projection);
    return this;
  }
  
  public void setIndexStatus(String indexStatus)
  {
    this.indexStatus = indexStatus;
  }
  
  public String getIndexStatus()
  {
    return indexStatus;
  }
  
  public GlobalSecondaryIndexDescription withIndexStatus(String indexStatus)
  {
    setIndexStatus(indexStatus);
    return this;
  }
  
  public void setIndexStatus(IndexStatus indexStatus)
  {
    withIndexStatus(indexStatus);
  }
  
  public GlobalSecondaryIndexDescription withIndexStatus(IndexStatus indexStatus)
  {
    this.indexStatus = indexStatus.toString();
    return this;
  }
  
  public void setBackfilling(Boolean backfilling)
  {
    this.backfilling = backfilling;
  }
  
  public Boolean getBackfilling()
  {
    return backfilling;
  }
  
  public GlobalSecondaryIndexDescription withBackfilling(Boolean backfilling)
  {
    setBackfilling(backfilling);
    return this;
  }
  
  public Boolean isBackfilling()
  {
    return backfilling;
  }
  
  public void setProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput)
  {
    this.provisionedThroughput = provisionedThroughput;
  }
  
  public ProvisionedThroughputDescription getProvisionedThroughput()
  {
    return provisionedThroughput;
  }
  
  public GlobalSecondaryIndexDescription withProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
    return this;
  }
  
  public void setIndexSizeBytes(Long indexSizeBytes)
  {
    this.indexSizeBytes = indexSizeBytes;
  }
  
  public Long getIndexSizeBytes()
  {
    return indexSizeBytes;
  }
  
  public GlobalSecondaryIndexDescription withIndexSizeBytes(Long indexSizeBytes)
  {
    setIndexSizeBytes(indexSizeBytes);
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
  
  public GlobalSecondaryIndexDescription withItemCount(Long itemCount)
  {
    setItemCount(itemCount);
    return this;
  }
  
  public void setIndexArn(String indexArn)
  {
    this.indexArn = indexArn;
  }
  
  public String getIndexArn()
  {
    return indexArn;
  }
  
  public GlobalSecondaryIndexDescription withIndexArn(String indexArn)
  {
    setIndexArn(indexArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getIndexName() != null) {
      sb.append("IndexName: ").append(getIndexName()).append(",");
    }
    if (getKeySchema() != null) {
      sb.append("KeySchema: ").append(getKeySchema()).append(",");
    }
    if (getProjection() != null) {
      sb.append("Projection: ").append(getProjection()).append(",");
    }
    if (getIndexStatus() != null) {
      sb.append("IndexStatus: ").append(getIndexStatus()).append(",");
    }
    if (getBackfilling() != null) {
      sb.append("Backfilling: ").append(getBackfilling()).append(",");
    }
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput()).append(",");
    }
    if (getIndexSizeBytes() != null) {
      sb.append("IndexSizeBytes: ").append(getIndexSizeBytes()).append(",");
    }
    if (getItemCount() != null) {
      sb.append("ItemCount: ").append(getItemCount()).append(",");
    }
    if (getIndexArn() != null) {
      sb.append("IndexArn: ").append(getIndexArn());
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
    if (!(obj instanceof GlobalSecondaryIndexDescription)) {
      return false;
    }
    GlobalSecondaryIndexDescription other = (GlobalSecondaryIndexDescription)obj;
    if (((other.getIndexName() == null ? 1 : 0) ^ (getIndexName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexName() != null) && (!other.getIndexName().equals(getIndexName()))) {
      return false;
    }
    if (((other.getKeySchema() == null ? 1 : 0) ^ (getKeySchema() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeySchema() != null) && (!other.getKeySchema().equals(getKeySchema()))) {
      return false;
    }
    if (((other.getProjection() == null ? 1 : 0) ^ (getProjection() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProjection() != null) && (!other.getProjection().equals(getProjection()))) {
      return false;
    }
    if (((other.getIndexStatus() == null ? 1 : 0) ^ (getIndexStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexStatus() != null) && (!other.getIndexStatus().equals(getIndexStatus()))) {
      return false;
    }
    if (((other.getBackfilling() == null ? 1 : 0) ^ (getBackfilling() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackfilling() != null) && (!other.getBackfilling().equals(getBackfilling()))) {
      return false;
    }
    if (((other.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedThroughput() != null) && (!other.getProvisionedThroughput().equals(getProvisionedThroughput()))) {
      return false;
    }
    if (((other.getIndexSizeBytes() == null ? 1 : 0) ^ (getIndexSizeBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexSizeBytes() != null) && (!other.getIndexSizeBytes().equals(getIndexSizeBytes()))) {
      return false;
    }
    if (((other.getItemCount() == null ? 1 : 0) ^ (getItemCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItemCount() != null) && (!other.getItemCount().equals(getItemCount()))) {
      return false;
    }
    if (((other.getIndexArn() == null ? 1 : 0) ^ (getIndexArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIndexArn() != null) && (!other.getIndexArn().equals(getIndexArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getIndexName() == null ? 0 : getIndexName().hashCode());
    hashCode = 31 * hashCode + (getKeySchema() == null ? 0 : getKeySchema().hashCode());
    hashCode = 31 * hashCode + (getProjection() == null ? 0 : getProjection().hashCode());
    hashCode = 31 * hashCode + (getIndexStatus() == null ? 0 : getIndexStatus().hashCode());
    hashCode = 31 * hashCode + (getBackfilling() == null ? 0 : getBackfilling().hashCode());
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    hashCode = 31 * hashCode + (getIndexSizeBytes() == null ? 0 : getIndexSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getItemCount() == null ? 0 : getItemCount().hashCode());
    hashCode = 31 * hashCode + (getIndexArn() == null ? 0 : getIndexArn().hashCode());
    return hashCode;
  }
  
  public GlobalSecondaryIndexDescription clone()
  {
    try
    {
      return (GlobalSecondaryIndexDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GlobalSecondaryIndexDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */