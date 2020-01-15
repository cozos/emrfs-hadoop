package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.io.DataOutputStream;
import java.io.IOException;

final class HeaderValue$LongValue
  extends HeaderValue
{
  private final long value;
  
  private HeaderValue$LongValue(long value)
  {
    this.value = value;
  }
  
  public HeaderType getType()
  {
    return HeaderType.LONG;
  }
  
  public long getLong()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    dos.writeLong(value);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    LongValue longValue = (LongValue)o;
    
    return value == value;
  }
  
  public int hashCode()
  {
    return (int)(value ^ value >>> 32);
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.LongValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */