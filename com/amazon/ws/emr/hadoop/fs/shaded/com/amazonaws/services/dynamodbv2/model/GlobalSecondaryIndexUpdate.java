package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalSecondaryIndexUpdateMarshaller;
import java.io.Serializable;

public class GlobalSecondaryIndexUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private UpdateGlobalSecondaryIndexAction update;
  private CreateGlobalSecondaryIndexAction create;
  private DeleteGlobalSecondaryIndexAction delete;
  
  public void setUpdate(UpdateGlobalSecondaryIndexAction update)
  {
    this.update = update;
  }
  
  public UpdateGlobalSecondaryIndexAction getUpdate()
  {
    return update;
  }
  
  public GlobalSecondaryIndexUpdate withUpdate(UpdateGlobalSecondaryIndexAction update)
  {
    setUpdate(update);
    return this;
  }
  
  public void setCreate(CreateGlobalSecondaryIndexAction create)
  {
    this.create = create;
  }
  
  public CreateGlobalSecondaryIndexAction getCreate()
  {
    return create;
  }
  
  public GlobalSecondaryIndexUpdate withCreate(CreateGlobalSecondaryIndexAction create)
  {
    setCreate(create);
    return this;
  }
  
  public void setDelete(DeleteGlobalSecondaryIndexAction delete)
  {
    this.delete = delete;
  }
  
  public DeleteGlobalSecondaryIndexAction getDelete()
  {
    return delete;
  }
  
  public GlobalSecondaryIndexUpdate withDelete(DeleteGlobalSecondaryIndexAction delete)
  {
    setDelete(delete);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUpdate() != null) {
      sb.append("Update: ").append(getUpdate()).append(",");
    }
    if (getCreate() != null) {
      sb.append("Create: ").append(getCreate()).append(",");
    }
    if (getDelete() != null) {
      sb.append("Delete: ").append(getDelete());
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
    if (!(obj instanceof GlobalSecondaryIndexUpdate)) {
      return false;
    }
    GlobalSecondaryIndexUpdate other = (GlobalSecondaryIndexUpdate)obj;
    if (((other.getUpdate() == null ? 1 : 0) ^ (getUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUpdate() != null) && (!other.getUpdate().equals(getUpdate()))) {
      return false;
    }
    if (((other.getCreate() == null ? 1 : 0) ^ (getCreate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreate() != null) && (!other.getCreate().equals(getCreate()))) {
      return false;
    }
    if (((other.getDelete() == null ? 1 : 0) ^ (getDelete() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDelete() != null) && (!other.getDelete().equals(getDelete()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUpdate() == null ? 0 : getUpdate().hashCode());
    hashCode = 31 * hashCode + (getCreate() == null ? 0 : getCreate().hashCode());
    hashCode = 31 * hashCode + (getDelete() == null ? 0 : getDelete().hashCode());
    return hashCode;
  }
  
  public GlobalSecondaryIndexUpdate clone()
  {
    try
    {
      return (GlobalSecondaryIndexUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GlobalSecondaryIndexUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */