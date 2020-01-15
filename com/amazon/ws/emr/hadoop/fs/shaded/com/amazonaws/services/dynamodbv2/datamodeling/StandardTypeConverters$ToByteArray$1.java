package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.ByteBuffer;

final class StandardTypeConverters$ToByteArray$1
  extends StandardTypeConverters.ToByteArray<ByteBuffer>
{
  StandardTypeConverters$ToByteArray$1()
  {
    super(null);
  }
  
  public final byte[] convert(ByteBuffer o)
  {
    if (o.hasArray()) {
      return o.array();
    }
    byte[] value = new byte[o.remaining()];
    o.get(value);
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToByteArray.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */