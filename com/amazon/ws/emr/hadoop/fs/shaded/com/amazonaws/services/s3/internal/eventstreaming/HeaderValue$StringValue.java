package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.DataOutputStream;
import java.io.IOException;

final class HeaderValue$StringValue
  extends HeaderValue
{
  private final String value;
  
  private HeaderValue$StringValue(String value)
  {
    this.value = ((String)ValidationUtils.assertNotNull(value, "value"));
  }
  
  public HeaderType getType()
  {
    return HeaderType.STRING;
  }
  
  public String getString()
  {
    return value;
  }
  
  void encodeValue(DataOutputStream dos)
    throws IOException
  {
    Utils.writeString(dos, value);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    StringValue that = (StringValue)o;
    
    return value.equals(value);
  }
  
  public int hashCode()
  {
    return value.hashCode();
  }
  
  public String toString()
  {
    return '"' + value + '"';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue.StringValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */