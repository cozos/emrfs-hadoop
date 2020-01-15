package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactGetItemMarshaller;
import java.io.Serializable;

public class TransactGetItem
  implements Serializable, Cloneable, StructuredPojo
{
  private Get get;
  
  public void setGet(Get get)
  {
    this.get = get;
  }
  
  public Get getGet()
  {
    return get;
  }
  
  public TransactGetItem withGet(Get get)
  {
    setGet(get);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGet() != null) {
      sb.append("Get: ").append(getGet());
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
    if (!(obj instanceof TransactGetItem)) {
      return false;
    }
    TransactGetItem other = (TransactGetItem)obj;
    if (((other.getGet() == null ? 1 : 0) ^ (getGet() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGet() != null) && (!other.getGet().equals(getGet()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGet() == null ? 0 : getGet().hashCode());
    return hashCode;
  }
  
  public TransactGetItem clone()
  {
    try
    {
      return (TransactGetItem)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    TransactGetItemMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */