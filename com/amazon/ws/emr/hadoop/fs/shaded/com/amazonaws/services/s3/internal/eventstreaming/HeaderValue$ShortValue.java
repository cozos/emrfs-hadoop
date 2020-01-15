package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.io.DataOutputStream;

final class HeaderValue$ShortValue
  extends HeaderValue
{
  private final short value;
  
  private HeaderValue$ShortValue(short value)
  {
    this.value = value;
  }
  
  public HeaderType getType()
  {
    return HeaderType.SHORT;
  }
  
  public short getShort()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos) {}
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    ShortValue that = (ShortValue)o;
    
    return value == value;
  }
  
  public int hashCode()
  {
    return value;
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.ShortValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */