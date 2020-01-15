package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeValueUpdateMarshaller;
import java.io.Serializable;

public class AttributeValueUpdate
  implements Serializable, Cloneable, StructuredPojo
{
  private AttributeValue value;
  private String action;
  
  public AttributeValueUpdate() {}
  
  public AttributeValueUpdate(AttributeValue value, String action)
  {
    setValue(value);
    setAction(action);
  }
  
  public AttributeValueUpdate(AttributeValue value, AttributeAction action)
  {
    setValue(value);
    setAction(action.toString());
  }
  
  public void setValue(AttributeValue value)
  {
    this.value = value;
  }
  
  public AttributeValue getValue()
  {
    return value;
  }
  
  public AttributeValueUpdate withValue(AttributeValue value)
  {
    setValue(value);
    return this;
  }
  
  public void setAction(String action)
  {
    this.action = action;
  }
  
  public String getAction()
  {
    return action;
  }
  
  public AttributeValueUpdate withAction(String action)
  {
    setAction(action);
    return this;
  }
  
  public void setAction(AttributeAction action)
  {
    withAction(action);
  }
  
  public AttributeValueUpdate withAction(AttributeAction action)
  {
    this.action = action.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getValue() != null) {
      sb.append("Value: ").append(getValue()).append(",");
    }
    if (getAction() != null) {
      sb.append("Action: ").append(getAction());
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
    if (!(obj instanceof AttributeValueUpdate)) {
      return false;
    }
    AttributeValueUpdate other = (AttributeValueUpdate)obj;
    if (((other.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValue() != null) && (!other.getValue().equals(getValue()))) {
      return false;
    }
    if (((other.getAction() == null ? 1 : 0) ^ (getAction() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAction() != null) && (!other.getAction().equals(getAction()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    hashCode = 31 * hashCode + (getAction() == null ? 0 : getAction().hashCode());
    return hashCode;
  }
  
  public AttributeValueUpdate clone()
  {
    try
    {
      return (AttributeValueUpdate)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AttributeValueUpdateMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */