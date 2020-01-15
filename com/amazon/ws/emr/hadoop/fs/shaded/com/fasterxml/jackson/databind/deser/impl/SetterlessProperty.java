package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class SetterlessProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _annotated;
  protected final Method _getter;
  
  public SetterlessProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedMethod method)
  {
    super(propDef, type, typeDeser, contextAnnotations);
    _annotated = method;
    _getter = method.getAnnotated();
  }
  
  protected SetterlessProperty(SetterlessProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _annotated = _annotated;
    _getter = _getter;
  }
  
  protected SetterlessProperty(SetterlessProperty src, PropertyName newName)
  {
    super(src, newName);
    _annotated = _annotated;
    _getter = _getter;
  }
  
  public SetterlessProperty withName(PropertyName newName)
  {
    return new SetterlessProperty(this, newName);
  }
  
  public SetterlessProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new SetterlessProperty(this, deser);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _annotated.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _annotated;
  }
  
  public final void deserializeAndSet(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException, JsonProcessingException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_NULL) {
      return;
    }
    if (_valueTypeDeserializer != null) {
      throw new JsonMappingException("Problem deserializing 'setterless' property (\"" + getName() + "\"): no way to handle typed deser with setterless yet");
    }
    Object toModify;
    try
    {
      toModify = _getter.invoke(instance, new Object[0]);
    }
    catch (Exception e)
    {
      _throwAsIOE(e);
      return;
    }
    if (toModify == null) {
      throw new JsonMappingException("Problem deserializing 'setterless' property '" + getName() + "': get method returned null");
    }
    _valueDeserializer.deserialize(jp, ctxt, toModify);
  }
  
  public Object deserializeSetAndReturn(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException, JsonProcessingException
  {
    deserializeAndSet(jp, ctxt, instance);
    return instance;
  }
  
  public final void set(Object instance, Object value)
    throws IOException
  {
    throw new UnsupportedOperationException("Should never call 'set' on setterless property");
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    set(instance, value);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.SetterlessProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */