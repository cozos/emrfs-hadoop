package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.ByteBuffer;
import java.util.UUID;

final class StandardTypeConverters$ToByteBuffer$2
  extends StandardTypeConverters.ToByteBuffer<UUID>
{
  StandardTypeConverters$ToByteBuffer$2()
  {
    super(null);
  }
  
  public final ByteBuffer convert(UUID o)
  {
    ByteBuffer value = ByteBuffer.allocate(16);
    value.putLong(o.getMostSignificantBits()).putLong(o.getLeastSignificantBits());
    value.position(0);
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToByteBuffer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */