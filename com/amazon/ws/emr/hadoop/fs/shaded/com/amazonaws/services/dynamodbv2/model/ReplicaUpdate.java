package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaUpdateMarshaller;
import java.io.Serializable;

public class ReplicaUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private CreateReplicaAction create;
  private DeleteReplicaAction delete;
  
  public void setCreate(CreateReplicaAction create)
  {
    this.create = create;
  }
  
  public CreateReplicaAction getCreate()
  {
    return create;
  }
  
  public ReplicaUpdate withCreate(CreateReplicaAction create)
  {
    setCreate(create);
    return this;
  }
  
  public void setDelete(DeleteReplicaAction delete)
  {
    this.delete = delete;
  }
  
  public DeleteReplicaAction getDelete()
  {
    return delete;
  }
  
  public ReplicaUpdate withDelete(DeleteReplicaAction delete)
  {
    setDelete(delete);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof ReplicaUpdate)) {
      return false;
    }
    ReplicaUpdate other = (ReplicaUpdate)obj;
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
    
    hashCode = 31 * hashCode + (getCreate() == null ? 0 : getCreate().hashCode());
    hashCode = 31 * hashCode + (getDelete() == null ? 0 : getDelete().hashCode());
    return hashCode;
  }
  
  public ReplicaUpdate clone()
  {
    try
    {
      return (ReplicaUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ReplicaUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */