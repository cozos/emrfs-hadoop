package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class CalendarSetUnmarshaller
  extends SSUnmarshaller
{
  private static final CalendarSetUnmarshaller INSTANCE = new CalendarSetUnmarshaller();
  
  public static CalendarSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<Calendar> result = new HashSet();
    for (String s : value.getSS())
    {
      Calendar cal = GregorianCalendar.getInstance();
      cal.setTime(DateUtils.parseISO8601Date(s));
      result.add(cal);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CalendarSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */