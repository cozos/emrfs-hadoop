package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public class MessageSystemAttributeValue
  implements Serializable, Cloneable
{
  private String stringValue;
  private ByteBuffer binaryValue;
  private SdkInternalList<String> stringListValues;
  private SdkInternalList<ByteBuffer> binaryListValues;
  private String dataType;
  
  public void setStringValue(String stringValue)
  {
    this.stringValue = stringValue;
  }
  
  public String getStringValue()
  {
    return stringValue;
  }
  
  public MessageSystemAttributeValue withStringValue(String stringValue)
  {
    setStringValue(stringValue);
    return this;
  }
  
  public void setBinaryValue(ByteBuffer binaryValue)
  {
    this.binaryValue = binaryValue;
  }
  
  public ByteBuffer getBinaryValue()
  {
    return binaryValue;
  }
  
  public MessageSystemAttributeValue withBinaryValue(ByteBuffer binaryValue)
  {
    setBinaryValue(binaryValue);
    return this;
  }
  
  public List<String> getStringListValues()
  {
    if (stringListValues == null) {
      stringListValues = new SdkInternalList();
    }
    return stringListValues;
  }
  
  public void setStringListValues(Collection<String> stringListValues)
  {
    if (stringListValues == null)
    {
      this.stringListValues = null;
      return;
    }
    this.stringListValues = new SdkInternalList(stringListValues);
  }
  
  public MessageSystemAttributeValue withStringListValues(String... stringListValues)
  {
    if (this.stringListValues == null) {
      setStringListValues(new SdkInternalList(stringListValues.length));
    }
    for (String ele : stringListValues) {
      this.stringListValues.add(ele);
    }
    return this;
  }
  
  public MessageSystemAttributeValue withStringListValues(Collection<String> stringListValues)
  {
    setStringListValues(stringListValues);
    return this;
  }
  
  public List<ByteBuffer> getBinaryListValues()
  {
    if (binaryListValues == null) {
      binaryListValues = new SdkInternalList();
    }
    return binaryListValues;
  }
  
  public void setBinaryListValues(Collection<ByteBuffer> binaryListValues)
  {
    if (binaryListValues == null)
    {
      this.binaryListValues = null;
      return;
    }
    this.binaryListValues = new SdkInternalList(binaryListValues);
  }
  
  public MessageSystemAttributeValue withBinaryListValues(ByteBuffer... binaryListValues)
  {
    if (this.binaryListValues == null) {
      setBinaryListValues(new SdkInternalList(binaryListValues.length));
    }
    for (ByteBuffer ele : binaryListValues) {
      this.binaryListValues.add(ele);
    }
    return this;
  }
  
  public MessageSystemAttributeValue withBinaryListValues(Collection<ByteBuffer> binaryListValues)
  {
    setBinaryListValues(binaryListValues);
    return this;
  }
  
  public void setDataType(String dataType)
  {
    this.dataType = dataType;
  }
  
  public String getDataType()
  {
    return dataType;
  }
  
  public MessageSystemAttributeValue withDataType(String dataType)
  {
    setDataType(dataType);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStringValue() != null) {
      sb.append("StringValue: ").append(getStringValue()).append(",");
    }
    if (getBinaryValue() != null) {
      sb.append("BinaryValue: ").append(getBinaryValue()).append(",");
    }
    if (getStringListValues() != null) {
      sb.append("StringListValues: ").append(getStringListValues()).append(",");
    }
    if (getBinaryListValues() != null) {
      sb.append("BinaryListValues: ").append(getBinaryListValues()).append(",");
    }
    if (getDataType() != null) {
      sb.append("DataType: ").append(getDataType());
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
    if (!(obj instanceof MessageSystemAttributeValue)) {
      return false;
    }
    MessageSystemAttributeValue other = (MessageSystemAttributeValue)obj;
    if (((other.getStringValue() == null ? 1 : 0) ^ (getStringValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStringValue() != null) && (!other.getStringValue().equals(getStringValue()))) {
      return false;
    }
    if (((other.getBinaryValue() == null ? 1 : 0) ^ (getBinaryValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBinaryValue() != null) && (!other.getBinaryValue().equals(getBinaryValue()))) {
      return false;
    }
    if (((other.getStringListValues() == null ? 1 : 0) ^ (getStringListValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStringListValues() != null) && (!other.getStringListValues().equals(getStringListValues()))) {
      return false;
    }
    if (((other.getBinaryListValues() == null ? 1 : 0) ^ (getBinaryListValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBinaryListValues() != null) && (!other.getBinaryListValues().equals(getBinaryListValues()))) {
      return false;
    }
    if (((other.getDataType() == null ? 1 : 0) ^ (getDataType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDataType() != null) && (!other.getDataType().equals(getDataType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStringValue() == null ? 0 : getStringValue().hashCode());
    hashCode = 31 * hashCode + (getBinaryValue() == null ? 0 : getBinaryValue().hashCode());
    hashCode = 31 * hashCode + (getStringListValues() == null ? 0 : getStringListValues().hashCode());
    hashCode = 31 * hashCode + (getBinaryListValues() == null ? 0 : getBinaryListValues().hashCode());
    hashCode = 31 * hashCode + (getDataType() == null ? 0 : getDataType().hashCode());
    return hashCode;
  }
  
  public MessageSystemAttributeValue clone()
  {
    try
    {
      return (MessageSystemAttributeValue)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.MessageSystemAttributeValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */