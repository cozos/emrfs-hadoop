package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.math.BigInteger;

final class StandardTypeConverters$ToBigInteger$1
  extends StandardTypeConverters.ToBigInteger<String>
{
  StandardTypeConverters$ToBigInteger$1()
  {
    super(null);
  }
  
  public final BigInteger convert(String o)
  {
    return new BigInteger(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToBigInteger.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */