package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemMarshaller;
import java.io.Serializable;

public class TransactWriteItem
  implements Serializable, Cloneable, StructuredPojo
{
  private ConditionCheck conditionCheck;
  private Put put;
  private Delete delete;
  private Update update;
  
  public void setConditionCheck(ConditionCheck conditionCheck)
  {
    this.conditionCheck = conditionCheck;
  }
  
  public ConditionCheck getConditionCheck()
  {
    return conditionCheck;
  }
  
  public TransactWriteItem withConditionCheck(ConditionCheck conditionCheck)
  {
    setConditionCheck(conditionCheck);
    return this;
  }
  
  public void setPut(Put put)
  {
    this.put = put;
  }
  
  public Put getPut()
  {
    return put;
  }
  
  public TransactWriteItem withPut(Put put)
  {
    setPut(put);
    return this;
  }
  
  public void setDelete(Delete delete)
  {
    this.delete = delete;
  }
  
  public Delete getDelete()
  {
    return delete;
  }
  
  public TransactWriteItem withDelete(Delete delete)
  {
    setDelete(delete);
    return this;
  }
  
  public void setUpdate(Update update)
  {
    this.update = update;
  }
  
  public Update getUpdate()
  {
    return update;
  }
  
  public TransactWriteItem withUpdate(Update update)
  {
    setUpdate(update);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getConditionCheck() != null) {
      sb.append("ConditionCheck: ").append(getConditionCheck()).append(",");
    }
    if (getPut() != null) {
      sb.append("Put: ").append(getPut()).append(",");
    }
    if (getDelete() != null) {
      sb.append("Delete: ").append(getDelete()).append(",");
    }
    if (getUpdate() != null) {
      sb.append("Update: ").append(getUpdate());
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
    if (!(obj instanceof TransactWriteItem)) {
      return false;
    }
    TransactWriteItem other = (TransactWriteItem)obj;
    if (((other.getConditionCheck() == null ? 1 : 0) ^ (getConditionCheck() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConditionCheck() != null) && (!other.getConditionCheck().equals(getConditionCheck()))) {
      return false;
    }
    if (((other.getPut() == null ? 1 : 0) ^ (getPut() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPut() != null) && (!other.getPut().equals(getPut()))) {
      return false;
    }
    if (((other.getDelete() == null ? 1 : 0) ^ (getDelete() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDelete() != null) && (!other.getDelete().equals(getDelete()))) {
      return false;
    }
    if (((other.getUpdate() == null ? 1 : 0) ^ (getUpdate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUpdate() != null) && (!other.getUpdate().equals(getUpdate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getConditionCheck() == null ? 0 : getConditionCheck().hashCode());
    hashCode = 31 * hashCode + (getPut() == null ? 0 : getPut().hashCode());
    hashCode = 31 * hashCode + (getDelete() == null ? 0 : getDelete().hashCode());
    hashCode = 31 * hashCode + (getUpdate() == null ? 0 : getUpdate().hashCode());
    return hashCode;
  }
  
  public TransactWriteItem clone()
  {
    try
    {
      return (TransactWriteItem)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TransactWriteItemMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */