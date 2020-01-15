package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LocalSecondaryIndexDescriptionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocalSecondaryIndexDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private List<KeySchemaElement> keySchema;
  private Projection projection;
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
  
  public LocalSecondaryIndexDescription withIndexName(String indexName)
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
  
  public LocalSecondaryIndexDescription withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public LocalSecondaryIndexDescription withKeySchema(Collection<KeySchemaElement> keySchema)
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
  
  public LocalSecondaryIndexDescription withProjection(Projection projection)
  {
    setProjection(projection);
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
  
  public LocalSecondaryIndexDescription withIndexSizeBytes(Long indexSizeBytes)
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
  
  public LocalSecondaryIndexDescription withItemCount(Long itemCount)
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
  
  public LocalSecondaryIndexDescription withIndexArn(String indexArn)
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
    if (!(obj instanceof LocalSecondaryIndexDescription)) {
      return false;
    }
    LocalSecondaryIndexDescription other = (LocalSecondaryIndexDescription)obj;
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
    hashCode = 31 * hashCode + (getIndexSizeBytes() == null ? 0 : getIndexSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getItemCount() == null ? 0 : getItemCount().hashCode());
    hashCode = 31 * hashCode + (getIndexArn() == null ? 0 : getIndexArn().hashCode());
    return hashCode;
  }
  
  public LocalSecondaryIndexDescription clone()
  {
    try
    {
      return (LocalSecondaryIndexDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    LocalSecondaryIndexDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */