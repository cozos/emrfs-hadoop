package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public final class InnerClassProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final SettableBeanProperty _delegate;
  protected final transient Constructor<?> _creator;
  protected AnnotatedConstructor _annotated;
  
  public InnerClassProperty(SettableBeanProperty delegate, Constructor<?> ctor)
  {
    super(delegate);
    _delegate = delegate;
    _creator = ctor;
  }
  
  protected InnerClassProperty(InnerClassProperty src, AnnotatedConstructor ann)
  {
    super(src);
    _delegate = _delegate;
    _annotated = ann;
    _creator = (_annotated == null ? null : _annotated.getAnnotated());
    if (_creator == null) {
      throw new IllegalArgumentException("Missing constructor (broken JDK (de)serialization?)");
    }
  }
  
  protected InnerClassProperty(InnerClassProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _delegate = _delegate.withValueDeserializer(deser);
    _creator = _creator;
  }
  
  protected InnerClassProperty(InnerClassProperty src, PropertyName newName)
  {
    super(src, newName);
    _delegate = _delegate.withName(newName);
    _creator = _creator;
  }
  
  public InnerClassProperty withName(PropertyName newName)
  {
    return new InnerClassProperty(this, newName);
  }
  
  public InnerClassProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new InnerClassProperty(this, deser);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _delegate.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _delegate.getMember();
  }
  
  public void deserializeAndSet(JsonParser jp, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    Object value;
    Object value;
    if (t == JsonToken.VALUE_NULL)
    {
      value = _valueDeserializer.getNullValue(ctxt);
    }
    else
    {
      Object value;
      if (_valueTypeDeserializer != null)
      {
        value = _valueDeserializer.deserializeWithType(jp, ctxt, _valueTypeDeserializer);
      }
      else
      {
        try
        {
          value = _creator.newInstance(new Object[] { bean });
        }
        catch (Exception e)
        {
          ClassUtil.unwrapAndThrowAsIAE(e, "Failed to instantiate class " + _creator.getDeclaringClass().getName() + ", problem: " + e.getMessage());
          value = null;
        }
        _valueDeserializer.deserialize(jp, ctxt, value);
      }
    }
    set(bean, value);
  }
  
  public Object deserializeSetAndReturn(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    return setAndReturn(instance, deserialize(jp, ctxt));
  }
  
  public final void set(Object instance, Object value)
    throws IOException
  {
    _delegate.set(instance, value);
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    return _delegate.setAndReturn(instance, value);
  }
  
  Object readResolve()
  {
    return new InnerClassProperty(this, _annotated);
  }
  
  Object writeReplace()
  {
    if (_annotated != null) {
      return this;
    }
    return new InnerClassProperty(this, new AnnotatedConstructor(null, _creator, null, null));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.InnerClassProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */