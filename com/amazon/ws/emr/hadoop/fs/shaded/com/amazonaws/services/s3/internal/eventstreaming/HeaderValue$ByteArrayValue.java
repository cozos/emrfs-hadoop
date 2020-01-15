package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

final class HeaderValue$ByteArrayValue
  extends HeaderValue
{
  private final byte[] value;
  
  private HeaderValue$ByteArrayValue(byte[] value)
  {
    this.value = ((byte[])ValidationUtils.assertNotNull(value, "value"));
  }
  
  public HeaderType getType()
  {
    return HeaderType.BYTE_ARRAY;
  }
  
  public byte[] getByteArray()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    Utils.writeBytes(dos, value);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    ByteArrayValue that = (ByteArrayValue)o;
    
    return Arrays.equals(value, value);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(value);
  }
  
  public String toString()
  {
    return Base64.encodeAsString(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.ByteArrayValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */