package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.lang.reflect.Type;

public class StdDelegatingSerializer
  extends StdSerializer<Object>
  implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable, SchemaAware
{
  protected final Converter<Object, ?> _converter;
  protected final JavaType _delegateType;
  protected final JsonSerializer<Object> _delegateSerializer;
  
  public StdDelegatingSerializer(Converter<?, ?> converter)
  {
    super(Object.class);
    _converter = converter;
    _delegateType = null;
    _delegateSerializer = null;
  }
  
  public <T> StdDelegatingSerializer(Class<T> cls, Converter<T, ?> converter)
  {
    super(cls, false);
    _converter = converter;
    _delegateType = null;
    _delegateSerializer = null;
  }
  
  public StdDelegatingSerializer(Converter<Object, ?> converter, JavaType delegateType, JsonSerializer<?> delegateSerializer)
  {
    super(delegateType);
    _converter = converter;
    _delegateType = delegateType;
    _delegateSerializer = delegateSerializer;
  }
  
  protected StdDelegatingSerializer withDelegate(Converter<Object, ?> converter, JavaType delegateType, JsonSerializer<?> delegateSerializer)
  {
    if (getClass() != StdDelegatingSerializer.class) {
      throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }
    return new StdDelegatingSerializer(converter, delegateType, delegateSerializer);
  }
  
  public void resolve(SerializerProvider provider)
    throws JsonMappingException
  {
    if ((_delegateSerializer != null) && ((_delegateSerializer instanceof ResolvableSerializer))) {
      ((ResolvableSerializer)_delegateSerializer).resolve(provider);
    }
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> delSer = _delegateSerializer;
    JavaType delegateType = _delegateType;
    if (delSer == null)
    {
      if (delegateType == null) {
        delegateType = _converter.getOutputType(provider.getTypeFactory());
      }
      if (!delegateType.isJavaLangObject()) {
        delSer = provider.findValueSerializer(delegateType);
      }
    }
    if ((delSer instanceof ContextualSerializer)) {
      delSer = provider.handleSecondaryContextualization(delSer, property);
    }
    if ((delSer == _delegateSerializer) && (delegateType == _delegateType)) {
      return this;
    }
    return withDelegate(_converter, delegateType, delSer);
  }
  
  protected Converter<Object, ?> getConverter()
  {
    return _converter;
  }
  
  public JsonSerializer<?> getDelegatee()
  {
    return _delegateSerializer;
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    Object delegateValue = convertValue(value);
    if (delegateValue == null)
    {
      provider.defaultSerializeNull(gen);
      return;
    }
    JsonSerializer<Object> ser = _delegateSerializer;
    if (ser == null) {
      ser = _findSerializer(delegateValue, provider);
    }
    ser.serialize(delegateValue, gen, provider);
  }
  
  public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    Object delegateValue = convertValue(value);
    JsonSerializer<Object> ser = _delegateSerializer;
    if (ser == null) {
      ser = _findSerializer(value, provider);
    }
    ser.serializeWithType(delegateValue, gen, provider, typeSer);
  }
  
  @Deprecated
  public boolean isEmpty(Object value)
  {
    return isEmpty(null, value);
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    Object delegateValue = convertValue(value);
    if (_delegateSerializer == null) {
      return value == null;
    }
    return _delegateSerializer.isEmpty(prov, delegateValue);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    if ((_delegateSerializer instanceof SchemaAware)) {
      return ((SchemaAware)_delegateSerializer).getSchema(provider, typeHint);
    }
    return super.getSchema(provider, typeHint);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint, boolean isOptional)
    throws JsonMappingException
  {
    if ((_delegateSerializer instanceof SchemaAware)) {
      return ((SchemaAware)_delegateSerializer).getSchema(provider, typeHint, isOptional);
    }
    return super.getSchema(provider, typeHint);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (_delegateSerializer != null) {
      _delegateSerializer.acceptJsonFormatVisitor(visitor, typeHint);
    }
  }
  
  protected Object convertValue(Object value)
  {
    return _converter.convert(value);
  }
  
  protected JsonSerializer<Object> _findSerializer(Object value, SerializerProvider serializers)
    throws JsonMappingException
  {
    return serializers.findValueSerializer(value.getClass());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */