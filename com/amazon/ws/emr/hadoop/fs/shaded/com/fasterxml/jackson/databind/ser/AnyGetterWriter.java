package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

public class AnyGetterWriter
{
  protected final BeanProperty _property;
  protected final AnnotatedMember _accessor;
  protected JsonSerializer<Object> _serializer;
  protected MapSerializer _mapSerializer;
  
  public AnyGetterWriter(BeanProperty property, AnnotatedMember accessor, JsonSerializer<?> serializer)
  {
    _accessor = accessor;
    _property = property;
    _serializer = serializer;
    if ((serializer instanceof MapSerializer)) {
      _mapSerializer = ((MapSerializer)serializer);
    }
  }
  
  public void getAndSerialize(Object bean, JsonGenerator gen, SerializerProvider provider)
    throws Exception
  {
    Object value = _accessor.getValue(bean);
    if (value == null) {
      return;
    }
    if (!(value instanceof Map)) {
      throw new JsonMappingException("Value returned by 'any-getter' (" + _accessor.getName() + "()) not java.util.Map but " + value.getClass().getName());
    }
    if (_mapSerializer != null)
    {
      _mapSerializer.serializeFields((Map)value, gen, provider);
      return;
    }
    _serializer.serialize(value, gen, provider);
  }
  
  public void getAndFilter(Object bean, JsonGenerator gen, SerializerProvider provider, PropertyFilter filter)
    throws Exception
  {
    Object value = _accessor.getValue(bean);
    if (value == null) {
      return;
    }
    if (!(value instanceof Map)) {
      throw new JsonMappingException("Value returned by 'any-getter' (" + _accessor.getName() + "()) not java.util.Map but " + value.getClass().getName());
    }
    if (_mapSerializer != null)
    {
      _mapSerializer.serializeFilteredFields((Map)value, gen, provider, filter, null);
      return;
    }
    _serializer.serialize(value, gen, provider);
  }
  
  public void resolve(SerializerProvider provider)
    throws JsonMappingException
  {
    if ((_serializer instanceof ContextualSerializer))
    {
      JsonSerializer<?> ser = provider.handlePrimaryContextualization(_serializer, _property);
      _serializer = ser;
      if ((ser instanceof MapSerializer)) {
        _mapSerializer = ((MapSerializer)ser);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.AnyGetterWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */