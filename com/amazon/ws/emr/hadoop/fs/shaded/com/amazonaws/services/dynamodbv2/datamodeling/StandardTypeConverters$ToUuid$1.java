package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.ByteBuffer;
import java.util.UUID;

final class StandardTypeConverters$ToUuid$1
  extends StandardTypeConverters.ToUuid<ByteBuffer>
{
  StandardTypeConverters$ToUuid$1()
  {
    super(null);
  }
  
  public final UUID convert(ByteBuffer o)
  {
    return new UUID(o.getLong(), o.getLong());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToUuid.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */