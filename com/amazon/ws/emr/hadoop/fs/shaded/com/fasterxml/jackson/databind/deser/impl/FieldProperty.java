package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class FieldProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedField _annotated;
  protected final transient Field _field;
  
  public FieldProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedField field)
  {
    super(propDef, type, typeDeser, contextAnnotations);
    _annotated = field;
    _field = field.getAnnotated();
  }
  
  protected FieldProperty(FieldProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _annotated = _annotated;
    _field = _field;
  }
  
  protected FieldProperty(FieldProperty src, PropertyName newName)
  {
    super(src, newName);
    _annotated = _annotated;
    _field = _field;
  }
  
  protected FieldProperty(FieldProperty src)
  {
    super(src);
    _annotated = _annotated;
    Field f = _annotated.getAnnotated();
    if (f == null) {
      throw new IllegalArgumentException("Missing field (broken JDK (de)serialization?)");
    }
    _field = f;
  }
  
  public FieldProperty withName(PropertyName newName)
  {
    return new FieldProperty(this, newName);
  }
  
  public FieldProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new FieldProperty(this, deser);
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
      _field.set(instance, value);
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
      _field.set(instance, value);
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
    return instance;
  }
  
  public final void set(Object instance, Object value)
    throws IOException
  {
    try
    {
      _field.set(instance, value);
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
      _field.set(instance, value);
    }
    catch (Exception e)
    {
      _throwAsIOE(e, value);
    }
    return instance;
  }
  
  Object readResolve()
  {
    return new FieldProperty(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.FieldProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */