package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.TimeZone;

final class StandardTypeConverters$ToString$7
  extends StandardTypeConverters.ToString<TimeZone>
{
  StandardTypeConverters$ToString$7()
  {
    super(null);
  }
  
  public final String convert(TimeZone o)
  {
    return o.getID();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToString.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */