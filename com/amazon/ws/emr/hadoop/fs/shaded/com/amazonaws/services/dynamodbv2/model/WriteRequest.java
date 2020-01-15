package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.WriteRequestMarshaller;
import java.io.Serializable;

public class WriteRequest
  implements Serializable, Cloneable, StructuredPojo
{
  private PutRequest putRequest;
  private DeleteRequest deleteRequest;
  
  public WriteRequest() {}
  
  public WriteRequest(PutRequest putRequest)
  {
    setPutRequest(putRequest);
  }
  
  public WriteRequest(DeleteRequest deleteRequest)
  {
    setDeleteRequest(deleteRequest);
  }
  
  public void setPutRequest(PutRequest putRequest)
  {
    this.putRequest = putRequest;
  }
  
  public PutRequest getPutRequest()
  {
    return putRequest;
  }
  
  public WriteRequest withPutRequest(PutRequest putRequest)
  {
    setPutRequest(putRequest);
    return this;
  }
  
  public void setDeleteRequest(DeleteRequest deleteRequest)
  {
    this.deleteRequest = deleteRequest;
  }
  
  public DeleteRequest getDeleteRequest()
  {
    return deleteRequest;
  }
  
  public WriteRequest withDeleteRequest(DeleteRequest deleteRequest)
  {
    setDeleteRequest(deleteRequest);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPutRequest() != null) {
      sb.append("PutRequest: ").append(getPutRequest()).append(",");
    }
    if (getDeleteRequest() != null) {
      sb.append("DeleteRequest: ").append(getDeleteRequest());
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
    if (!(obj instanceof WriteRequest)) {
      return false;
    }
    WriteRequest other = (WriteRequest)obj;
    if (((other.getPutRequest() == null ? 1 : 0) ^ (getPutRequest() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPutRequest() != null) && (!other.getPutRequest().equals(getPutRequest()))) {
      return false;
    }
    if (((other.getDeleteRequest() == null ? 1 : 0) ^ (getDeleteRequest() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDeleteRequest() != null) && (!other.getDeleteRequest().equals(getDeleteRequest()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPutRequest() == null ? 0 : getPutRequest().hashCode());
    hashCode = 31 * hashCode + (getDeleteRequest() == null ? 0 : getDeleteRequest().hashCode());
    return hashCode;
  }
  
  public WriteRequest clone()
  {
    try
    {
      return (WriteRequest)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    WriteRequestMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */