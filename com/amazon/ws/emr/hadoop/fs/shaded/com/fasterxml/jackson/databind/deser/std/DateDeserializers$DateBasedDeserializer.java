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
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DateDeserializers$DateBasedDeserializer<T>
  extends StdScalarDeserializer<T>
  implements ContextualDeserializer
{
  protected final DateFormat _customFormat;
  protected final String _formatString;
  
  protected DateDeserializers$DateBasedDeserializer(Class<?> clz)
  {
    super(clz);
    _customFormat = null;
    _formatString = null;
  }
  
  protected DateDeserializers$DateBasedDeserializer(DateBasedDeserializer<T> base, DateFormat format, String formatStr)
  {
    super(_valueClass);
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
  
  protected Date _parseDate(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_customFormat != null)
    {
      JsonToken t = p.getCurrentToken();
      if (t == JsonToken.VALUE_STRING)
      {
        String str = p.getText().trim();
        if (str.length() == 0) {
          return (Date)getEmptyValue(ctxt);
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
        Date parsed = _parseDate(p, ctxt);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */