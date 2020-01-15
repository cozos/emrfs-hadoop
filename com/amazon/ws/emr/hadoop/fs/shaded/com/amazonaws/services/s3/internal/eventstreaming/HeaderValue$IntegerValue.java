package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.io.DataOutputStream;
import java.io.IOException;

final class HeaderValue$IntegerValue
  extends HeaderValue
{
  private final int value;
  
  private HeaderValue$IntegerValue(int value)
  {
    this.value = value;
  }
  
  public HeaderType getType()
  {
    return HeaderType.INTEGER;
  }
  
  public int getInteger()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    dos.writeInt(value);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    IntegerValue that = (IntegerValue)o;
    
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.IntegerValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */