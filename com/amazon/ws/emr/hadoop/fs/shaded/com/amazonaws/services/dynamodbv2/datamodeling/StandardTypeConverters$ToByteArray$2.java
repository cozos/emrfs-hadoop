package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.nio.charset.Charset;

final class StandardTypeConverters$ToByteArray$2
  extends StandardTypeConverters.ToByteArray<String>
{
  StandardTypeConverters$ToByteArray$2()
  {
    super(null);
  }
  
  public final byte[] convert(String o)
  {
    return o.getBytes(Charset.forName("UTF-8"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToByteArray.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */