package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.math.BigDecimal;

final class StandardTypeConverters$ToBigDecimal$1
  extends StandardTypeConverters.ToBigDecimal<String>
{
  StandardTypeConverters$ToBigDecimal$1()
  {
    super(null);
  }
  
  public final BigDecimal convert(String o)
  {
    return new BigDecimal(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToBigDecimal.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */