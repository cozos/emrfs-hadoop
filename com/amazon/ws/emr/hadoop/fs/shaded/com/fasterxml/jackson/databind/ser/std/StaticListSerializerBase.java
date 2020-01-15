package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class StaticListSerializerBase<T extends Collection<?>>
  extends StdSerializer<T>
  implements ContextualSerializer
{
  protected final JsonSerializer<String> _serializer;
  protected final Boolean _unwrapSingle;
  
  protected StaticListSerializerBase(Class<?> cls)
  {
    super(cls, false);
    _serializer = null;
    _unwrapSingle = null;
  }
  
  protected StaticListSerializerBase(StaticListSerializerBase<?> src, JsonSerializer<?> ser, Boolean unwrapSingle)
  {
    super(src);
    _serializer = ser;
    _unwrapSingle = unwrapSingle;
  }
  
  public abstract JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer, Boolean paramBoolean);
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = null;
    Boolean unwrapSingle = null;
    if (property != null)
    {
      AnnotationIntrospector intr = provider.getAnnotationIntrospector();
      AnnotatedMember m = property.getMember();
      if (m != null)
      {
        Object serDef = intr.findContentSerializer(m);
        if (serDef != null) {
          ser = provider.serializerInstance(m, serDef);
        }
      }
      JsonFormat.Value format = property.findFormatOverrides(intr);
      if (format != null) {
        unwrapSingle = format.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
      }
    }
    if (ser == null) {
      ser = _serializer;
    }
    ser = findConvertingContentSerializer(provider, property, ser);
    if (ser == null) {
      ser = provider.findValueSerializer(String.class, property);
    } else {
      ser = provider.handleSecondaryContextualization(ser, property);
    }
    if (isDefaultSerializer(ser)) {
      ser = null;
    }
    if ((ser == _serializer) && (unwrapSingle == _unwrapSingle)) {
      return this;
    }
    return _withResolved(property, ser, unwrapSingle);
  }
  
  @Deprecated
  public boolean isEmpty(T value)
  {
    return isEmpty(null, value);
  }
  
  public boolean isEmpty(SerializerProvider provider, T value)
  {
    return (value == null) || (value.size() == 0);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("array", true).set("items", contentSchema());
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    acceptContentVisitor(visitor.expectArrayFormat(typeHint));
  }
  
  protected abstract JsonNode contentSchema();
  
  protected abstract void acceptContentVisitor(JsonArrayFormatVisitor paramJsonArrayFormatVisitor)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */