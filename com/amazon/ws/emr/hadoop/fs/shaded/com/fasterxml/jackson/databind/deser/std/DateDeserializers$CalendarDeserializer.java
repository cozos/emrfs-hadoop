package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@JacksonStdImpl
public class DateDeserializers$CalendarDeserializer
  extends DateDeserializers.DateBasedDeserializer<Calendar>
{
  protected final Class<? extends Calendar> _calendarClass;
  
  public DateDeserializers$CalendarDeserializer()
  {
    super(Calendar.class);
    _calendarClass = null;
  }
  
  public DateDeserializers$CalendarDeserializer(Class<? extends Calendar> cc)
  {
    super(cc);
    _calendarClass = cc;
  }
  
  public DateDeserializers$CalendarDeserializer(CalendarDeserializer src, DateFormat df, String formatString)
  {
    super(src, df, formatString);
    _calendarClass = _calendarClass;
  }
  
  protected CalendarDeserializer withDateFormat(DateFormat df, String formatString)
  {
    return new CalendarDeserializer(this, df, formatString);
  }
  
  public Calendar deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    Date d = _parseDate(jp, ctxt);
    if (d == null) {
      return null;
    }
    if (_calendarClass == null) {
      return ctxt.constructCalendar(d);
    }
    try
    {
      Calendar c = (Calendar)_calendarClass.newInstance();
      c.setTimeInMillis(d.getTime());
      TimeZone tz = ctxt.getTimeZone();
      if (tz != null) {
        c.setTimeZone(tz);
      }
      return c;
    }
    catch (Exception e)
    {
      throw ctxt.instantiationException(_calendarClass, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */