package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

final class HeaderValue$UuidValue
  extends HeaderValue
{
  private final UUID value;
  
  private HeaderValue$UuidValue(UUID value)
  {
    this.value = ((UUID)ValidationUtils.assertNotNull(value, "value"));
  }
  
  static UuidValue decode(ByteBuffer buf)
  {
    long msb = buf.getLong();
    long lsb = buf.getLong();
    return new UuidValue(new UUID(msb, lsb));
  }
  
  public HeaderType getType()
  {
    return HeaderType.UUID;
  }
  
  public UUID getUuid()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    dos.writeLong(value.getMostSignificantBits());
    dos.writeLong(value.getLeastSignificantBits());
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    UuidValue uuidValue = (UuidValue)o;
    
    return value.equals(value);
  }
  
  public int hashCode()
  {
    return value.hashCode();
  }
  
  public String toString()
  {
    return value.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.UuidValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */