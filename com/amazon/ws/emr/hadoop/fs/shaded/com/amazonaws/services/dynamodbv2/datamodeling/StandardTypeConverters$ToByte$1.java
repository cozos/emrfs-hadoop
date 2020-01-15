package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardTypeConverters$ToByte$1
  extends StandardTypeConverters.ToByte<Number>
{
  StandardTypeConverters$ToByte$1()
  {
    super(null);
  }
  
  public final Byte convert(Number o)
  {
    return Byte.valueOf(o.byteValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToByte.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */