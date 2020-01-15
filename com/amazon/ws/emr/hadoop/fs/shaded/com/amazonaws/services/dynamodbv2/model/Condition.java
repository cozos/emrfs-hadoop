package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConditionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Condition
  implements Serializable, Cloneable, StructuredPojo
{
  private List<AttributeValue> attributeValueList;
  private String comparisonOperator;
  
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
  
  public Condition withAttributeValueList(AttributeValue... attributeValueList)
  {
    if (this.attributeValueList == null) {
      setAttributeValueList(new ArrayList(attributeValueList.length));
    }
    for (AttributeValue ele : attributeValueList) {
      this.attributeValueList.add(ele);
    }
    return this;
  }
  
  public Condition withAttributeValueList(Collection<AttributeValue> attributeValueList)
  {
    setAttributeValueList(attributeValueList);
    return this;
  }
  
  public void setComparisonOperator(String comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator;
  }
  
  public String getComparisonOperator()
  {
    return comparisonOperator;
  }
  
  public Condition withComparisonOperator(String comparisonOperator)
  {
    setComparisonOperator(comparisonOperator);
    return this;
  }
  
  public void setComparisonOperator(ComparisonOperator comparisonOperator)
  {
    withComparisonOperator(comparisonOperator);
  }
  
  public Condition withComparisonOperator(ComparisonOperator comparisonOperator)
  {
    this.comparisonOperator = comparisonOperator.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAttributeValueList() != null) {
      sb.append("AttributeValueList: ").append(getAttributeValueList()).append(",");
    }
    if (getComparisonOperator() != null) {
      sb.append("ComparisonOperator: ").append(getComparisonOperator());
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
    if (!(obj instanceof Condition)) {
      return false;
    }
    Condition other = (Condition)obj;
    if (((other.getAttributeValueList() == null ? 1 : 0) ^ (getAttributeValueList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAttributeValueList() != null) && (!other.getAttributeValueList().equals(getAttributeValueList()))) {
      return false;
    }
    if (((other.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getComparisonOperator() != null) && (!other.getComparisonOperator().equals(getComparisonOperator()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAttributeValueList() == null ? 0 : getAttributeValueList().hashCode());
    hashCode = 31 * hashCode + (getComparisonOperator() == null ? 0 : getComparisonOperator().hashCode());
    return hashCode;
  }
  
  public Condition clone()
  {
    try
    {
      return (Condition)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ConditionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */