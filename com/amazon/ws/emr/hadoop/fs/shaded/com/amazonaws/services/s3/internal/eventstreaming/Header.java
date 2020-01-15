package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map.Entry;

class Header
{
  private final String name;
  private final HeaderValue value;
  
  Header(String name, HeaderValue value)
  {
    this.name = ((String)ValidationUtils.assertNotNull(name, "value"));
    this.value = ((HeaderValue)ValidationUtils.assertNotNull(value, "value"));
  }
  
  Header(String name, String value)
  {
    this(name, HeaderValue.fromString(value));
  }
  
  public String getName()
  {
    return name;
  }
  
  public HeaderValue getValue()
  {
    return value;
  }
  
  static Header decode(ByteBuffer buf)
  {
    String name = Utils.readShortString(buf);
    return new Header(name, HeaderValue.decode(buf));
  }
  
  static void encode(Map.Entry<String, HeaderValue> header, DataOutputStream dos)
    throws IOException
  {
    new Header((String)header.getKey(), (HeaderValue)header.getValue()).encode(dos);
  }
  
  void encode(DataOutputStream dos)
    throws IOException
  {
    Utils.writeShortString(dos, name);
    value.encode(dos);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Header header = (Header)o;
    if (!name.equals(name)) {
      return false;
    }
    return value.equals(value);
  }
  
  public int hashCode()
  {
    int result = name.hashCode();
    result = 31 * result + value.hashCode();
    return result;
  }
  
  public String toString()
  {
    return "Header{name='" + name + '\'' + ", value=" + value + '}';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Header
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */