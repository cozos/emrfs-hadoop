package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.TimeZone;

final class StandardTypeConverters$ToTimeZone$1
  extends StandardTypeConverters.ToTimeZone<String>
{
  StandardTypeConverters$ToTimeZone$1()
  {
    super(null);
  }
  
  public final TimeZone convert(String o)
  {
    return TimeZone.getTimeZone(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToTimeZone.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */