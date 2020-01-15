package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
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

public final class MethodProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _annotated;
  protected final transient Method _setter;
  
  public MethodProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedMethod method)
  {
    super(propDef, type, typeDeser, contextAnnotations);
    _annotated = method;
    _setter = method.getAnnotated();
  }
  
  protected MethodProperty(MethodProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _annotated = _annotated;
    _setter = _setter;
  }
  
  protected MethodProperty(MethodProperty src, PropertyName newName)
  {
    super(src, newName);
    _annotated = _annotated;
    _setter = _setter;
  }
  
  protected MethodProperty(MethodProperty src, Method m)
  {
    super(src);
    _annotated = _annotated;
    _setter = m;
  }
  
  public MethodProperty withName(PropertyName newName)
  {
    return new MethodProperty(this, newName);
  }
  
  public MethodProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new MethodProperty(this, deser);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _annotated == null ? null : _annotated.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _annotated;
  }
  
  public void deserializeAndSet(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    Object value = deserialize(jp, ctxt);
    try
    {
      _setter.invoke(instance, new Object[] { value });
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
  }
  
  public Object deserializeSetAndReturn(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    Object value = deserialize(jp, ctxt);
    try
    {
      Object result = _setter.invoke(instance, new Object[] { value });
      return result == null ? instance : result;
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
    return null;
  }
  
  public final void set(Object instance, Object value)
    throws IOException
  {
    try
    {
      _setter.invoke(instance, new Object[] { value });
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    try
    {
      Object result = _setter.invoke(instance, new Object[] { value });
      return result == null ? instance : result;
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
    return null;
  }
  
  Object readResolve()
  {
    return new MethodProperty(this, _annotated.getAnnotated());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.MethodProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */