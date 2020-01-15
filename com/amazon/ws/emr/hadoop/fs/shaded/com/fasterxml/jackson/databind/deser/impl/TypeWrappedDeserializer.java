package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;

public final class TypeWrappedDeserializer
  extends JsonDeserializer<Object>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final TypeDeserializer _typeDeserializer;
  protected final JsonDeserializer<Object> _deserializer;
  
  public TypeWrappedDeserializer(TypeDeserializer typeDeser, JsonDeserializer<?> deser)
  {
    _typeDeserializer = typeDeser;
    _deserializer = deser;
  }
  
  public Class<?> handledType()
  {
    return _deserializer.handledType();
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserializer.deserializeWithType(jp, ctxt, _typeDeserializer);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt, Object intoValue)
    throws IOException
  {
    return _deserializer.deserialize(jp, ctxt, intoValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */