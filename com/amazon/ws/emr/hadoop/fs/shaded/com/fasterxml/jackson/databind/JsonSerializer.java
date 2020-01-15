package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EmptyIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Iterator;

public abstract class JsonSerializer<T>
  implements JsonFormatVisitable
{
  public JsonSerializer<T> unwrappingSerializer(NameTransformer unwrapper)
  {
    return this;
  }
  
  public JsonSerializer<T> replaceDelegatee(JsonSerializer<?> delegatee)
  {
    throw new UnsupportedOperationException();
  }
  
  public JsonSerializer<?> withFilterId(Object filterId)
  {
    return this;
  }
  
  public abstract void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException;
  
  public void serializeWithType(T value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer)
    throws IOException
  {
    Class<?> clz = handledType();
    if (clz == null) {
      clz = value.getClass();
    }
    throw serializers.mappingException("Type id handling not implemented for type %s (by serializer of type %s)", new Object[] { clz.getName(), getClass().getName() });
  }
  
  public Class<T> handledType()
  {
    return null;
  }
  
  @Deprecated
  public boolean isEmpty(T value)
  {
    return isEmpty(null, value);
  }
  
  public boolean isEmpty(SerializerProvider provider, T value)
  {
    return value == null;
  }
  
  public boolean usesObjectId()
  {
    return false;
  }
  
  public boolean isUnwrappingSerializer()
  {
    return false;
  }
  
  public JsonSerializer<?> getDelegatee()
  {
    return null;
  }
  
  public Iterator<PropertyWriter> properties()
  {
    return EmptyIterator.instance();
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType type)
    throws JsonMappingException
  {
    if (visitor != null) {
      visitor.expectAnyFormat(type);
    }
  }
  
  public static abstract class None
    extends JsonSerializer<Object>
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */