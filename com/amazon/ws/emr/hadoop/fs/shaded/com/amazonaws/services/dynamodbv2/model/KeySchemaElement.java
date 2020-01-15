package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeySchemaElementMarshaller;
import java.io.Serializable;

public class KeySchemaElement
  implements Serializable, Cloneable, StructuredPojo
{
  private String attributeName;
  private String keyType;
  
  public KeySchemaElement() {}
  
  public KeySchemaElement(String attributeName, String keyType)
  {
    setAttributeName(attributeName);
    setKeyType(keyType);
  }
  
  public KeySchemaElement(String attributeName, KeyType keyType)
  {
    setAttributeName(attributeName);
    setKeyType(keyType.toString());
  }
  
  public void setAttributeName(String attributeName)
  {
    this.attributeName = attributeName;
  }
  
  public String getAttributeName()
  {
    return attributeName;
  }
  
  public KeySchemaElement withAttributeName(String attributeName)
  {
    setAttributeName(attributeName);
    return this;
  }
  
  public void setKeyType(String keyType)
  {
    this.keyType = keyType;
  }
  
  public String getKeyType()
  {
    return keyType;
  }
  
  public KeySchemaElement withKeyType(String keyType)
  {
    setKeyType(keyType);
    return this;
  }
  
  public void setKeyType(KeyType keyType)
  {
    withKeyType(keyType);
  }
  
  public KeySchemaElement withKeyType(KeyType keyType)
  {
    this.keyType = keyType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributeName() != null) {
      sb.append("AttributeName: ").append(getAttributeName()).append(",");
    }
    if (getKeyType() != null) {
      sb.append("KeyType: ").append(getKeyType());
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
    if (!(obj instanceof KeySchemaElement)) {
      return false;
    }
    KeySchemaElement other = (KeySchemaElement)obj;
    if (((other.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeName() != null) && (!other.getAttributeName().equals(getAttributeName()))) {
      return false;
    }
    if (((other.getKeyType() == null ? 1 : 0) ^ (getKeyType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyType() != null) && (!other.getKeyType().equals(getKeyType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttributeName() == null ? 0 : getAttributeName().hashCode());
    hashCode = 31 * hashCode + (getKeyType() == null ? 0 : getKeyType().hashCode());
    return hashCode;
  }
  
  public KeySchemaElement clone()
  {
    try
    {
      return (KeySchemaElement)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    KeySchemaElementMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */