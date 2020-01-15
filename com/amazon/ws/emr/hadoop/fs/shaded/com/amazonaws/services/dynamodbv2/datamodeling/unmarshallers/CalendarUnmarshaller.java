package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUnmarshaller
  extends SUnmarshaller
{
  private static final CalendarUnmarshaller INSTANCE = new CalendarUnmarshaller();
  
  public static CalendarUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(DateUtils.parseISO8601Date(value.getS()));
    return cal;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CalendarUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */