package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

final class HeaderValue$TimestampValue
  extends HeaderValue
{
  private final DateTime value;
  
  private HeaderValue$TimestampValue(DateTime value)
  {
    this.value = ((DateTime)ValidationUtils.assertNotNull(value, "value"));
  }
  
  static TimestampValue decode(ByteBuffer buf)
  {
    long epochMillis = buf.getLong();
    return new TimestampValue(new DateTime(epochMillis));
  }
  
  public HeaderType getType()
  {
    return HeaderType.TIMESTAMP;
  }
  
  public DateTime getTimestamp()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    dos.writeLong(value.getMillis());
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    TimestampValue that = (TimestampValue)o;
    
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.TimestampValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */