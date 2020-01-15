package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalSecondaryIndexActionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateGlobalSecondaryIndexAction
  implements Serializable, Cloneable, StructuredPojo
{
  private String indexName;
  private List<KeySchemaElement> keySchema;
  private Projection projection;
  private ProvisionedThroughput provisionedThroughput;
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexName()
  {
    return indexName;
  }
  
  public CreateGlobalSecondaryIndexAction withIndexName(String indexName)
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
  
  public CreateGlobalSecondaryIndexAction withKeySchema(KeySchemaElement... keySchema)
  {
    if (this.keySchema == null) {
      setKeySchema(new ArrayList(keySchema.length));
    }
    for (KeySchemaElement ele : keySchema) {
      this.keySchema.add(ele);
    }
    return this;
  }
  
  public CreateGlobalSecondaryIndexAction withKeySchema(Collection<KeySchemaElement> keySchema)
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
  
  public CreateGlobalSecondaryIndexAction withProjection(Projection projection)
  {
    setProjection(projection);
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
  
  public CreateGlobalSecondaryIndexAction withProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    setProvisionedThroughput(provisionedThroughput);
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
    if (getProvisionedThroughput() != null) {
      sb.append("ProvisionedThroughput: ").append(getProvisionedThroughput());
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
    if (!(obj instanceof CreateGlobalSecondaryIndexAction)) {
      return false;
    }
    CreateGlobalSecondaryIndexAction other = (CreateGlobalSecondaryIndexAction)obj;
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
    if (((other.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvisionedThroughput() != null) && (!other.getProvisionedThroughput().equals(getProvisionedThroughput()))) {
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
    hashCode = 31 * hashCode + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode());
    return hashCode;
  }
  
  public CreateGlobalSecondaryIndexAction clone()
  {
    try
    {
      return (CreateGlobalSecondaryIndexAction)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CreateGlobalSecondaryIndexActionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalSecondaryIndexAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */