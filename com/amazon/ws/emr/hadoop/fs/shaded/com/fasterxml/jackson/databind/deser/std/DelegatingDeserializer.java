package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

public abstract class DelegatingDeserializer
  extends StdDeserializer<Object>
  implements ContextualDeserializer, ResolvableDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JsonDeserializer<?> _delegatee;
  
  public DelegatingDeserializer(JsonDeserializer<?> delegatee)
  {
    super(_figureType(delegatee));
    _delegatee = delegatee;
  }
  
  protected abstract JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> paramJsonDeserializer);
  
  private static Class<?> _figureType(JsonDeserializer<?> deser)
  {
    Class<?> cls = deser.handledType();
    if (cls != null) {
      return cls;
    }
    return Object.class;
  }
  
  public void resolve(DeserializationContext ctxt)
    throws JsonMappingException
  {
    if ((_delegatee instanceof ResolvableDeserializer)) {
      ((ResolvableDeserializer)_delegatee).resolve(ctxt);
    }
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JavaType vt = ctxt.constructType(_delegatee.handledType());
    JsonDeserializer<?> del = ctxt.handleSecondaryContextualization(_delegatee, property, vt);
    if (del == _delegatee) {
      return this;
    }
    return newDelegatingInstance(del);
  }
  
  @Deprecated
  protected JsonDeserializer<?> _createContextual(DeserializationContext ctxt, BeanProperty property, JsonDeserializer<?> newDelegatee)
  {
    if (newDelegatee == _delegatee) {
      return this;
    }
    return newDelegatingInstance(newDelegatee);
  }
  
  public SettableBeanProperty findBackReference(String logicalName)
  {
    return _delegatee.findBackReference(logicalName);
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    return _delegatee.deserialize(jp, ctxt);
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt, Object intoValue)
    throws IOException, JsonProcessingException
  {
    return _delegatee.deserialize(jp, ctxt, intoValue);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return _delegatee.deserializeWithType(jp, ctxt, typeDeserializer);
  }
  
  public JsonDeserializer<?> replaceDelegatee(JsonDeserializer<?> delegatee)
  {
    if (delegatee == _delegatee) {
      return this;
    }
    return newDelegatingInstance(delegatee);
  }
  
  public Object getNullValue(DeserializationContext ctxt)
    throws JsonMappingException
  {
    return _delegatee.getNullValue(ctxt);
  }
  
  public Object getEmptyValue(DeserializationContext ctxt)
    throws JsonMappingException
  {
    return _delegatee.getEmptyValue(ctxt);
  }
  
  @Deprecated
  public Object getNullValue()
  {
    return _delegatee.getNullValue();
  }
  
  @Deprecated
  public Object getEmptyValue()
  {
    return _delegatee.getEmptyValue();
  }
  
  public Collection<Object> getKnownPropertyNames()
  {
    return _delegatee.getKnownPropertyNames();
  }
  
  public boolean isCachable()
  {
    return _delegatee.isCachable();
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _delegatee.getObjectIdReader();
  }
  
  public JsonDeserializer<?> getDelegatee()
  {
    return _delegatee;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */