package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ISO8601DateFormat
  extends DateFormat
{
  private static final long serialVersionUID = 1L;
  private static Calendar CALENDAR = new GregorianCalendar();
  private static NumberFormat NUMBER_FORMAT = new DecimalFormat();
  
  public ISO8601DateFormat()
  {
    numberFormat = NUMBER_FORMAT;
    calendar = CALENDAR;
  }
  
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition)
  {
    String value = ISO8601Utils.format(date);
    toAppendTo.append(value);
    return toAppendTo;
  }
  
  public Date parse(String source, ParsePosition pos)
  {
    try
    {
      return ISO8601Utils.parse(source, pos);
    }
    catch (ParseException e) {}
    return null;
  }
  
  public Date parse(String source)
    throws ParseException
  {
    return ISO8601Utils.parse(source, new ParsePosition(0));
  }
  
  public Object clone()
  {
    return this;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ISO8601DateFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */