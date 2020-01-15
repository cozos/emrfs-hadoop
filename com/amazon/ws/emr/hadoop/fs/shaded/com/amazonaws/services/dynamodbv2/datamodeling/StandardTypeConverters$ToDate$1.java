package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Calendar;
import java.util.Date;

final class StandardTypeConverters$ToDate$1
  extends StandardTypeConverters.ToDate<Calendar>
{
  StandardTypeConverters$ToDate$1()
  {
    super(null);
  }
  
  public final Date convert(Calendar o)
  {
    return o.getTime();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToDate.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */