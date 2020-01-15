package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Date;

final class StandardTypeConverters$ToString$3
  extends StandardTypeConverters.ToString<Date>
{
  StandardTypeConverters$ToString$3()
  {
    super(null);
  }
  
  public final String convert(Date o)
  {
    return DateUtils.formatISO8601Date(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToString.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */