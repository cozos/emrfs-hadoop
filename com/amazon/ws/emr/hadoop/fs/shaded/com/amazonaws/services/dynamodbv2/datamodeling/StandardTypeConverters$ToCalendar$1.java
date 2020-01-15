package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Calendar;
import java.util.Date;

final class StandardTypeConverters$ToCalendar$1
  extends StandardTypeConverters.ToCalendar<Date>
{
  StandardTypeConverters$ToCalendar$1()
  {
    super(null);
  }
  
  public final Calendar convert(Date o)
  {
    Calendar value = Calendar.getInstance();
    value.setTime(o);
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToCalendar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */