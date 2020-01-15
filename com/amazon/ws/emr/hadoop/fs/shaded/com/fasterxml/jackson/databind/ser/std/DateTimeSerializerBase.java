package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DateTimeSerializerBase<T>
  extends StdScalarSerializer<T>
  implements ContextualSerializer
{
  protected final Boolean _useTimestamp;
  protected final DateFormat _customFormat;
  
  protected DateTimeSerializerBase(Class<T> type, Boolean useTimestamp, DateFormat customFormat)
  {
    super(type);
    _useTimestamp = useTimestamp;
    _customFormat = customFormat;
  }
  
  public abstract DateTimeSerializerBase<T> withFormat(Boolean paramBoolean, DateFormat paramDateFormat);
  
  public JsonSerializer<?> createContextual(SerializerProvider serializers, BeanProperty property)
    throws JsonMappingException
  {
    if (property != null)
    {
      JsonFormat.Value format = serializers.getAnnotationIntrospector().findFormat(property.getMember());
      if (format != null)
      {
        if (format.getShape().isNumeric()) {
          return withFormat(Boolean.TRUE, null);
        }
        Boolean asNumber = format.getShape() == JsonFormat.Shape.STRING ? Boolean.FALSE : null;
        
        TimeZone tz = format.getTimeZone();
        if (format.hasPattern())
        {
          String pattern = format.getPattern();
          Locale loc = format.hasLocale() ? format.getLocale() : serializers.getLocale();
          SimpleDateFormat df = new SimpleDateFormat(pattern, loc);
          if (tz == null) {
            tz = serializers.getTimeZone();
          }
          df.setTimeZone(tz);
          return withFormat(asNumber, df);
        }
        if (tz != null)
        {
          DateFormat df = serializers.getConfig().getDateFormat();
          if (df.getClass() == StdDateFormat.class)
          {
            Locale loc = format.hasLocale() ? format.getLocale() : serializers.getLocale();
            df = StdDateFormat.getISO8601Format(tz, loc);
          }
          else
          {
            df = (DateFormat)df.clone();
            df.setTimeZone(tz);
          }
          return withFormat(asNumber, df);
        }
      }
    }
    return this;
  }
  
  @Deprecated
  public boolean isEmpty(T value)
  {
    return (value == null) || (_timestamp(value) == 0L);
  }
  
  public boolean isEmpty(SerializerProvider serializers, T value)
  {
    return (value == null) || (_timestamp(value) == 0L);
  }
  
  protected abstract long _timestamp(T paramT);
  
  public JsonNode getSchema(SerializerProvider serializers, Type typeHint)
  {
    return createSchemaNode(_asTimestamp(serializers) ? "number" : "string", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    _acceptJsonFormatVisitor(visitor, typeHint, _asTimestamp(visitor.getProvider()));
  }
  
  public abstract void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  protected boolean _asTimestamp(SerializerProvider serializers)
  {
    if (_useTimestamp != null) {
      return _useTimestamp.booleanValue();
    }
    if (_customFormat == null)
    {
      if (serializers != null) {
        return serializers.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      }
      throw new IllegalArgumentException("Null SerializerProvider passed for " + handledType().getName());
    }
    return false;
  }
  
  protected void _acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint, boolean asNumber)
    throws JsonMappingException
  {
    if (asNumber)
    {
      JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
      if (v2 != null)
      {
        v2.numberType(JsonParser.NumberType.LONG);
        v2.format(JsonValueFormat.UTC_MILLISEC);
      }
    }
    else
    {
      JsonStringFormatVisitor v2 = visitor.expectStringFormat(typeHint);
      if (v2 != null) {
        v2.format(JsonValueFormat.DATE_TIME);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */