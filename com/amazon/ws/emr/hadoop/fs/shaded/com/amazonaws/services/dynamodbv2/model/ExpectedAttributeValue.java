package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ExpectedAttributeValueMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpectedAttributeValue
  implements Serializable, Cloneable, StructuredPojo
{
  private AttributeValue value;
  private Boolean exists;
  private String comparisonOperator;
  private List<AttributeValue> attributeValueList;
  
  public ExpectedAttributeValue() {}
  
  public ExpectedAttributeValue(AttributeValue value)
  {
    setValue(value);
  }
  
  public ExpectedAttributeValue(Boolean exists)
  {
    setExists(exists);
  }
  
  public void setValue(AttributeValue value)
  {
    this.value = value;
  }
  
  public AttributeValue getValue()
  {
    return value;
  }
  
  public ExpectedAttributeValue withValue(AttributeValue value)
  {
    setValue(value);
    return this;
  }
  
  public void setExists(Boolean exists)
  {
    this.exists = exists;
  }
  
  public Boolean getExists()
  {
    return exists;
  }
  
  public ExpectedAttributeValue withExists(Boolean exists)
  {
    setExists(exists);
    return this;
  }
  
  public Boolean isExists()
  {
    return exists;
  }
  
  public void setComparisonOperator(String comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator;
  }
  
  public String getComparisonOperator()
  {
    return comparisonOperator;
  }
  
  public ExpectedAttributeValue withComparisonOperator(String comparisonOperator)
  {
    setComparisonOperator(comparisonOperator);
    return this;
  }
  
  public void setComparisonOperator(ComparisonOperator comparisonOperator)
  {
    withComparisonOperator(comparisonOperator);
  }
  
  public ExpectedAttributeValue withComparisonOperator(ComparisonOperator comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator.toString();
    return this;
  }
  
  public List<AttributeValue> getAttributeValueList()
  {
    return attributeValueList;
  }
  
  public void setAttributeValueList(Collection<AttributeValue> attributeValueList)
  {
    if (attributeValueList == null)
    {
      this.attributeValueList = null;
      return;
    }
    this.attributeValueList = new ArrayList(attributeValueList);
  }
  
  public ExpectedAttributeValue withAttributeValueList(AttributeValue... attributeValueList)
  {
    if (this.attributeValueList == null) {
      setAttributeValueList(new ArrayList(attributeValueList.length));
    }
    for (AttributeValue ele : attributeValueList) {
      this.attributeValueList.add(ele);
    }
    return this;
  }
  
  public ExpectedAttributeValue withAttributeValueList(Collection<AttributeValue> attributeValueList)
  {
    setAttributeValueList(attributeValueList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getValue() != null) {
      sb.append("Value: ").append(getValue()).append(",");
    }
    if (getExists() != null) {
      sb.append("Exists: ").append(getExists()).append(",");
    }
    if (getComparisonOperator() != null) {
      sb.append("ComparisonOperator: ").append(getComparisonOperator()).append(",");
    }
    if (getAttributeValueList() != null) {
      sb.append("AttributeValueList: ").append(getAttributeValueList());
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
    if (!(obj instanceof ExpectedAttributeValue)) {
      return false;
    }
    ExpectedAttributeValue other = (ExpectedAttributeValue)obj;
    if (((other.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValue() != null) && (!other.getValue().equals(getValue()))) {
      return false;
    }
    if (((other.getExists() == null ? 1 : 0) ^ (getExists() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExists() != null) && (!other.getExists().equals(getExists()))) {
      return false;
    }
    if (((other.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getComparisonOperator() != null) && (!other.getComparisonOperator().equals(getComparisonOperator()))) {
      return false;
    }
    if (((other.getAttributeValueList() == null ? 1 : 0) ^ (getAttributeValueList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeValueList() != null) && (!other.getAttributeValueList().equals(getAttributeValueList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getValue() == null ? 0 : getValue().hashCode());
    hashCode = 31 * hashCode + (getExists() == null ? 0 : getExists().hashCode());
    hashCode = 31 * hashCode + (getComparisonOperator() == null ? 0 : getComparisonOperator().hashCode());
    hashCode = 31 * hashCode + (getAttributeValueList() == null ? 0 : getAttributeValueList().hashCode());
    return hashCode;
  }
  
  public ExpectedAttributeValue clone()
  {
    try
    {
      return (ExpectedAttributeValue)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ExpectedAttributeValueMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */