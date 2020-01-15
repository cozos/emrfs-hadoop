package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.charset.Charset;

final class StandardTypeConverters$ToString$2
  extends StandardTypeConverters.ToString<byte[]>
{
  StandardTypeConverters$ToString$2()
  {
    super(null);
  }
  
  public final String convert(byte[] o)
  {
    return new String(o, Charset.forName("UTF-8"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToString.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */