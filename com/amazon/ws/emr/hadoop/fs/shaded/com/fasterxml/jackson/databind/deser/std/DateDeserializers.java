package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class DateDeserializers
{
  private static final HashSet<String> _classNames = new HashSet();
  
  static
  {
    Class<?>[] numberTypes = { Calendar.class, GregorianCalendar.class, java.sql.Date.class, java.util.Date.class, Timestamp.class };
    for (Class<?> cls : numberTypes) {
      _classNames.add(cls.getName());
    }
  }
  
  public static JsonDeserializer<?> find(Class<?> rawType, String clsName)
  {
    if (_classNames.contains(clsName))
    {
      if (rawType == Calendar.class) {
        return new CalendarDeserializer();
      }
      if (rawType == java.util.Date.class) {
        return DateDeserializer.instance;
      }
      if (rawType == java.sql.Date.class) {
        return new SqlDateDeserializer();
      }
      if (rawType == Timestamp.class) {
        return new TimestampDeserializer();
      }
      if (rawType == GregorianCalendar.class) {
        return new CalendarDeserializer(GregorianCalendar.class);
      }
    }
    return null;
  }
  
  protected static abstract class DateBasedDeserializer<T>
    extends StdScalarDeserializer<T>
    implements ContextualDeserializer
  {
    protected final DateFormat _customFormat;
    protected final String _formatString;
    
    protected DateBasedDeserializer(Class<?> clz)
    {
      super();
      _customFormat = null;
      _formatString = null;
    }
    
    protected DateBasedDeserializer(DateBasedDeserializer<T> base, DateFormat format, String formatStr)
    {
      super();
      _customFormat = format;
      _formatString = formatStr;
    }
    
    protected abstract DateBasedDeserializer<T> withDateFormat(DateFormat paramDateFormat, String paramString);
    
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
      throws JsonMappingException
    {
      if (property != null)
      {
        JsonFormat.Value format = ctxt.getAnnotationIntrospector().findFormat(property.getMember());
        if (format != null)
        {
          TimeZone tz = format.getTimeZone();
          if (format.hasPattern())
          {
            String pattern = format.getPattern();
            Locale loc = format.hasLocale() ? format.getLocale() : ctxt.getLocale();
            SimpleDateFormat df = new SimpleDateFormat(pattern, loc);
            if (tz == null) {
              tz = ctxt.getTimeZone();
            }
            df.setTimeZone(tz);
            return withDateFormat(df, pattern);
          }
          if (tz != null)
          {
            DateFormat df = ctxt.getConfig().getDateFormat();
            if (df.getClass() == StdDateFormat.class)
            {
              Locale loc = format.hasLocale() ? format.getLocale() : ctxt.getLocale();
              StdDateFormat std = (StdDateFormat)df;
              std = std.withTimeZone(tz);
              std = std.withLocale(loc);
              df = std;
            }
            else
            {
              df = (DateFormat)df.clone();
              df.setTimeZone(tz);
            }
            return withDateFormat(df, _formatString);
          }
        }
      }
      return this;
    }
    
    protected java.util.Date _parseDate(JsonParser p, DeserializationContext ctxt)
      throws IOException
    {
      if (_customFormat != null)
      {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.VALUE_STRING)
        {
          String str = p.getText().trim();
          if (str.length() == 0) {
            return (java.util.Date)getEmptyValue(ctxt);
          }
          synchronized (_customFormat)
          {
            try
            {
              return _customFormat.parse(str);
            }
            catch (ParseException e)
            {
              throw new IllegalArgumentException("Failed to parse Date value '" + str + "' (format: \"" + _formatString + "\"): " + e.getMessage());
            }
          }
        }
        if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
        {
          p.nextToken();
          java.util.Date parsed = _parseDate(p, ctxt);
          t = p.nextToken();
          if (t != JsonToken.END_ARRAY) {
            throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.util.Date' value but there was more than a single value in the array");
          }
          return parsed;
        }
      }
      return super._parseDate(p, ctxt);
    }
  }
  
  @JacksonStdImpl
  public static class CalendarDeserializer
    extends DateDeserializers.DateBasedDeserializer<Calendar>
  {
    protected final Class<? extends Calendar> _calendarClass;
    
    public CalendarDeserializer()
    {
      super();
      _calendarClass = null;
    }
    
    public CalendarDeserializer(Class<? extends Calendar> cc)
    {
      super();
      _calendarClass = cc;
    }
    
    public CalendarDeserializer(CalendarDeserializer src, DateFormat df, String formatString)
    {
      super(df, formatString);
      _calendarClass = _calendarClass;
    }
    
    protected CalendarDeserializer withDateFormat(DateFormat df, String formatString)
    {
      return new CalendarDeserializer(this, df, formatString);
    }
    
    public Calendar deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException
    {
      java.util.Date d = _parseDate(jp, ctxt);
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
  
  public static class DateDeserializer
    extends DateDeserializers.DateBasedDeserializer<java.util.Date>
  {
    public static final DateDeserializer instance = new DateDeserializer();
    
    public DateDeserializer()
    {
      super();
    }
    
    public DateDeserializer(DateDeserializer base, DateFormat df, String formatString)
    {
      super(df, formatString);
    }
    
    protected DateDeserializer withDateFormat(DateFormat df, String formatString)
    {
      return new DateDeserializer(this, df, formatString);
    }
    
    public java.util.Date deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException
    {
      return _parseDate(jp, ctxt);
    }
  }
  
  public static class SqlDateDeserializer
    extends DateDeserializers.DateBasedDeserializer<java.sql.Date>
  {
    public SqlDateDeserializer()
    {
      super();
    }
    
    public SqlDateDeserializer(SqlDateDeserializer src, DateFormat df, String formatString)
    {
      super(df, formatString);
    }
    
    protected SqlDateDeserializer withDateFormat(DateFormat df, String formatString)
    {
      return new SqlDateDeserializer(this, df, formatString);
    }
    
    public java.sql.Date deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException
    {
      java.util.Date d = _parseDate(jp, ctxt);
      return d == null ? null : new java.sql.Date(d.getTime());
    }
  }
  
  public static class TimestampDeserializer
    extends DateDeserializers.DateBasedDeserializer<Timestamp>
  {
    public TimestampDeserializer()
    {
      super();
    }
    
    public TimestampDeserializer(TimestampDeserializer src, DateFormat df, String formatString)
    {
      super(df, formatString);
    }
    
    protected TimestampDeserializer withDateFormat(DateFormat df, String formatString)
    {
      return new TimestampDeserializer(this, df, formatString);
    }
    
    public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException
    {
      return new Timestamp(_parseDate(jp, ctxt).getTime());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */