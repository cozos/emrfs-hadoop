package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.io.DataOutputStream;

final class HeaderValue$BooleanValue
  extends HeaderValue
{
  private final boolean value;
  
  private HeaderValue$BooleanValue(boolean value)
  {
    this.value = value;
  }
  
  public HeaderType getType()
  {
    if (value) {
      return HeaderType.TRUE;
    }
    return HeaderType.FALSE;
  }
  
  public boolean getBoolean()
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
    BooleanValue that = (BooleanValue)o;
    
    return value == value;
  }
  
  public int hashCode()
  {
    if (value) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.BooleanValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */