package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.UUID;

final class StandardTypeConverters$ToUuid$2
  extends StandardTypeConverters.ToUuid<String>
{
  StandardTypeConverters$ToUuid$2()
  {
    super(null);
  }
  
  public final UUID convert(String o)
  {
    return UUID.fromString(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToUuid.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */