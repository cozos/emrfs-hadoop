package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeDefinitionMarshaller;
import java.io.Serializable;

public class AttributeDefinition
  implements Serializable, Cloneable, StructuredPojo
{
  private String attributeName;
  private String attributeType;
  
  public AttributeDefinition() {}
  
  public AttributeDefinition(String attributeName, String attributeType)
  {
    setAttributeName(attributeName);
    setAttributeType(attributeType);
  }
  
  public AttributeDefinition(String attributeName, ScalarAttributeType attributeType)
  {
    setAttributeName(attributeName);
    setAttributeType(attributeType.toString());
  }
  
  public void setAttributeName(String attributeName)
  {
    this.attributeName = attributeName;
  }
  
  public String getAttributeName()
  {
    return attributeName;
  }
  
  public AttributeDefinition withAttributeName(String attributeName)
  {
    setAttributeName(attributeName);
    return this;
  }
  
  public void setAttributeType(String attributeType)
  {
    this.attributeType = attributeType;
  }
  
  public String getAttributeType()
  {
    return attributeType;
  }
  
  public AttributeDefinition withAttributeType(String attributeType)
  {
    setAttributeType(attributeType);
    return this;
  }
  
  public void setAttributeType(ScalarAttributeType attributeType)
  {
    withAttributeType(attributeType);
  }
  
  public AttributeDefinition withAttributeType(ScalarAttributeType attributeType)
  {
    this.attributeType = attributeType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributeName() != null) {
      sb.append("AttributeName: ").append(getAttributeName()).append(",");
    }
    if (getAttributeType() != null) {
      sb.append("AttributeType: ").append(getAttributeType());
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
    if (!(obj instanceof AttributeDefinition)) {
      return false;
    }
    AttributeDefinition other = (AttributeDefinition)obj;
    if (((other.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeName() != null) && (!other.getAttributeName().equals(getAttributeName()))) {
      return false;
    }
    if (((other.getAttributeType() == null ? 1 : 0) ^ (getAttributeType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeType() != null) && (!other.getAttributeType().equals(getAttributeType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttributeName() == null ? 0 : getAttributeName().hashCode());
    hashCode = 31 * hashCode + (getAttributeType() == null ? 0 : getAttributeType().hashCode());
    return hashCode;
  }
  
  public AttributeDefinition clone()
  {
    try
    {
      return (AttributeDefinition)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AttributeDefinitionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */