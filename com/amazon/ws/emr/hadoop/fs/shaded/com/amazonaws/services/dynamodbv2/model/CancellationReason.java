package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CancellationReasonMarshaller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CancellationReason
  implements Serializable, Cloneable, StructuredPojo
{
  private Map<String, AttributeValue> item;
  private String code;
  private String message;
  
  public Map<String, AttributeValue> getItem()
  {
    return item;
  }
  
  public void setItem(Map<String, AttributeValue> item)
  {
    this.item = item;
  }
  
  public CancellationReason withItem(Map<String, AttributeValue> item)
  {
    setItem(item);
    return this;
  }
  
  public CancellationReason addItemEntry(String key, AttributeValue value)
  {
    if (null == item) {
      item = new HashMap();
    }
    if (item.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    item.put(key, value);
    return this;
  }
  
  public CancellationReason clearItemEntries()
  {
    item = null;
    return this;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public CancellationReason withCode(String code)
  {
    setCode(code);
    return this;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public CancellationReason withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getItem() != null) {
      sb.append("Item: ").append(getItem()).append(",");
    }
    if (getCode() != null) {
      sb.append("Code: ").append(getCode()).append(",");
    }
    if (getMessage() != null) {
      sb.append("Message: ").append(getMessage());
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
    if (!(obj instanceof CancellationReason)) {
      return false;
    }
    CancellationReason other = (CancellationReason)obj;
    if (((other.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getItem() != null) && (!other.getItem().equals(getItem()))) {
      return false;
    }
    if (((other.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCode() != null) && (!other.getCode().equals(getCode()))) {
      return false;
    }
    if (((other.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessage() != null) && (!other.getMessage().equals(getMessage()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getItem() == null ? 0 : getItem().hashCode());
    hashCode = 31 * hashCode + (getCode() == null ? 0 : getCode().hashCode());
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    return hashCode;
  }
  
  public CancellationReason clone()
  {
    try
    {
      return (CancellationReason)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CancellationReasonMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CancellationReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */