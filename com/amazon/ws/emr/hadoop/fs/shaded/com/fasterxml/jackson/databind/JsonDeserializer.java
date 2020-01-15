package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Collection;

public abstract class JsonDeserializer<T>
{
  public abstract T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
  
  public T deserialize(JsonParser p, DeserializationContext ctxt, T intoValue)
    throws IOException, JsonProcessingException
  {
    throw new UnsupportedOperationException("Can not update object of type " + intoValue.getClass().getName() + " (by deserializer of type " + getClass().getName() + ")");
  }
  
  public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromAny(p, ctxt);
  }
  
  public JsonDeserializer<T> unwrappingDeserializer(NameTransformer unwrapper)
  {
    return this;
  }
  
  public JsonDeserializer<?> replaceDelegatee(JsonDeserializer<?> delegatee)
  {
    throw new UnsupportedOperationException();
  }
  
  public Class<?> handledType()
  {
    return null;
  }
  
  public boolean isCachable()
  {
    return false;
  }
  
  public JsonDeserializer<?> getDelegatee()
  {
    return null;
  }
  
  public Collection<Object> getKnownPropertyNames()
  {
    return null;
  }
  
  public T getNullValue(DeserializationContext ctxt)
    throws JsonMappingException
  {
    return (T)getNullValue();
  }
  
  public T getEmptyValue(DeserializationContext ctxt)
    throws JsonMappingException
  {
    return (T)getEmptyValue();
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return null;
  }
  
  public SettableBeanProperty findBackReference(String refName)
  {
    throw new IllegalArgumentException("Can not handle managed/back reference '" + refName + "': type: value deserializer of type " + getClass().getName() + " does not support them");
  }
  
  @Deprecated
  public T getNullValue()
  {
    return null;
  }
  
  @Deprecated
  public T getEmptyValue()
  {
    return (T)getNullValue();
  }
  
  public static abstract class None
    extends JsonDeserializer<Object>
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */