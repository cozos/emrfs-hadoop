package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Locale;

final class StandardTypeConverters$ToString$5
  extends StandardTypeConverters.ToString<Locale>
{
  StandardTypeConverters$ToString$5()
  {
    super(null);
  }
  
  public final String convert(Locale o)
  {
    StringBuilder value = new StringBuilder(o.getLanguage());
    if ((!o.getCountry().isEmpty()) || (!o.getVariant().isEmpty())) {
      value.append("-").append(o.getCountry());
    }
    if (!o.getVariant().isEmpty()) {
      value.append("-").append(o.getVariant());
    }
    return value.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToString.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */