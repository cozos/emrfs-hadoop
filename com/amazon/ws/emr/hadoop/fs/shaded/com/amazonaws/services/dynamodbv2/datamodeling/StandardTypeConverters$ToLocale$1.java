package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Locale;

final class StandardTypeConverters$ToLocale$1
  extends StandardTypeConverters.ToLocale<String>
{
  StandardTypeConverters$ToLocale$1()
  {
    super(null);
  }
  
  public final Locale convert(String o)
  {
    String[] value = o.split("-", 3);
    if (value.length == 3) {
      return new Locale(value[0], value[1], value[2]);
    }
    if (value.length == 2) {
      return new Locale(value[0], value[1]);
    }
    return new Locale(value[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToLocale.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */