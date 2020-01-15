package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class MapProperty
  extends PropertyWriter
{
  protected final TypeSerializer _typeSerializer;
  protected final BeanProperty _property;
  protected Object _key;
  protected JsonSerializer<Object> _keySerializer;
  protected JsonSerializer<Object> _valueSerializer;
  
  @Deprecated
  public MapProperty(TypeSerializer typeSer)
  {
    this(typeSer, null);
  }
  
  public MapProperty(TypeSerializer typeSer, BeanProperty prop)
  {
    _typeSerializer = typeSer;
    _property = prop;
  }
  
  public void reset(Object key, JsonSerializer<Object> keySer, JsonSerializer<Object> valueSer)
  {
    _key = key;
    _keySerializer = keySer;
    _valueSerializer = valueSer;
  }
  
  public String getName()
  {
    if ((_key instanceof String)) {
      return (String)_key;
    }
    return String.valueOf(_key);
  }
  
  public PropertyName getFullName()
  {
    return new PropertyName(getName());
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _property == null ? null : _property.getAnnotation(acls);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> acls)
  {
    return _property == null ? null : _property.getContextAnnotation(acls);
  }
  
  public void serializeAsField(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    _keySerializer.serialize(_key, jgen, provider);
    if (_typeSerializer == null) {
      _valueSerializer.serialize(value, jgen, provider);
    } else {
      _valueSerializer.serializeWithType(value, jgen, provider, _typeSerializer);
    }
  }
  
  public void serializeAsOmittedField(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws Exception
  {
    if (!jgen.canOmitFields()) {
      jgen.writeOmittedField(getName());
    }
  }
  
  public void serializeAsElement(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws Exception
  {
    if (_typeSerializer == null) {
      _valueSerializer.serialize(value, jgen, provider);
    } else {
      _valueSerializer.serializeWithType(value, jgen, provider, _typeSerializer);
    }
  }
  
  public void serializeAsPlaceholder(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws Exception
  {
    jgen.writeNull();
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor objectVisitor)
    throws JsonMappingException
  {}
  
  @Deprecated
  public void depositSchemaProperty(ObjectNode propertiesNode, SerializerProvider provider)
    throws JsonMappingException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.MapProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */