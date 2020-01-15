package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.ByteBuffer;

final class StandardTypeConverters$ToByteBuffer$1
  extends StandardTypeConverters.ToByteBuffer<byte[]>
{
  StandardTypeConverters$ToByteBuffer$1()
  {
    super(null);
  }
  
  public final ByteBuffer convert(byte[] o)
  {
    return ByteBuffer.wrap(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToByteBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */