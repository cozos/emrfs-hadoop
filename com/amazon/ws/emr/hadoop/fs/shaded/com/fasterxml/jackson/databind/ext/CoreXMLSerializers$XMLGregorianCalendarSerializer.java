package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Calendar;
import javax.xml.datatype.XMLGregorianCalendar;

public class CoreXMLSerializers$XMLGregorianCalendarSerializer
  extends StdSerializer<XMLGregorianCalendar>
  implements ContextualSerializer
{
  static final XMLGregorianCalendarSerializer instance = new XMLGregorianCalendarSerializer();
  final JsonSerializer<Object> _delegate;
  
  public CoreXMLSerializers$XMLGregorianCalendarSerializer()
  {
    this(CalendarSerializer.instance);
  }
  
  protected CoreXMLSerializers$XMLGregorianCalendarSerializer(JsonSerializer<?> del)
  {
    super(XMLGregorianCalendar.class);
    _delegate = del;
  }
  
  public JsonSerializer<?> getDelegatee()
  {
    return _delegate;
  }
  
  public boolean isEmpty(SerializerProvider provider, XMLGregorianCalendar value)
  {
    return _delegate.isEmpty(provider, _convert(value));
  }
  
  public void serialize(XMLGregorianCalendar value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    _delegate.serialize(_convert(value), gen, provider);
  }
  
  public void serializeWithType(XMLGregorianCalendar value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    _delegate.serializeWithType(_convert(value), gen, provider, typeSer);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    _delegate.acceptJsonFormatVisitor(visitor, null);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = prov.handlePrimaryContextualization(_delegate, property);
    if (ser != _delegate) {
      return new XMLGregorianCalendarSerializer(ser);
    }
    return this;
  }
  
  protected Calendar _convert(XMLGregorianCalendar input)
  {
    return input == null ? null : input.toGregorianCalendar();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */