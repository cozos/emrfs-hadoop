package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Currency;

final class StandardTypeConverters$ToCurrency$1
  extends StandardTypeConverters.ToCurrency<String>
{
  StandardTypeConverters$ToCurrency$1()
  {
    super(null);
  }
  
  public final Currency convert(String o)
  {
    return Currency.getInstance(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToCurrency.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */