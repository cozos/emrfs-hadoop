package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class CreatorProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedParameter _annotated;
  protected final Object _injectableValueId;
  protected final int _creatorIndex;
  protected SettableBeanProperty _fallbackSetter;
  
  public CreatorProperty(PropertyName name, JavaType type, PropertyName wrapperName, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedParameter param, int index, Object injectableValueId, PropertyMetadata metadata)
  {
    super(name, type, wrapperName, typeDeser, contextAnnotations, metadata);
    _annotated = param;
    _creatorIndex = index;
    _injectableValueId = injectableValueId;
    _fallbackSetter = null;
  }
  
  protected CreatorProperty(CreatorProperty src, PropertyName newName)
  {
    super(src, newName);
    _annotated = _annotated;
    _creatorIndex = _creatorIndex;
    _injectableValueId = _injectableValueId;
    _fallbackSetter = _fallbackSetter;
  }
  
  protected CreatorProperty(CreatorProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _annotated = _annotated;
    _creatorIndex = _creatorIndex;
    _injectableValueId = _injectableValueId;
    _fallbackSetter = _fallbackSetter;
  }
  
  public CreatorProperty withName(PropertyName newName)
  {
    return new CreatorProperty(this, newName);
  }
  
  public CreatorProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new CreatorProperty(this, deser);
  }
  
  public void setFallbackSetter(SettableBeanProperty fallbackSetter)
  {
    _fallbackSetter = fallbackSetter;
  }
  
  public Object findInjectableValue(DeserializationContext context, Object beanInstance)
  {
    if (_injectableValueId == null) {
      throw new IllegalStateException("Property '" + getName() + "' (type " + getClass().getName() + ") has no injectable value id configured");
    }
    return context.findInjectableValue(_injectableValueId, this, beanInstance);
  }
  
  public void inject(DeserializationContext context, Object beanInstance)
    throws IOException
  {
    set(beanInstance, findInjectableValue(context, beanInstance));
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    if (_annotated == null) {
      return null;
    }
    return _annotated.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _annotated;
  }
  
  public int getCreatorIndex()
  {
    return _creatorIndex;
  }
  
  public void deserializeAndSet(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException, JsonProcessingException
  {
    set(instance, deserialize(jp, ctxt));
  }
  
  public Object deserializeSetAndReturn(JsonParser jp, DeserializationContext ctxt, Object instance)
    throws IOException, JsonProcessingException
  {
    return setAndReturn(instance, deserialize(jp, ctxt));
  }
  
  public void set(Object instance, Object value)
    throws IOException
  {
    if (_fallbackSetter == null) {
      throw new IllegalStateException("No fallback setter/field defined: can not use creator property for " + getClass().getName());
    }
    _fallbackSetter.set(instance, value);
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    if (_fallbackSetter == null) {
      throw new IllegalStateException("No fallback setter/field defined: can not use creator property for " + getClass().getName());
    }
    return _fallbackSetter.setAndReturn(instance, value);
  }
  
  public Object getInjectableValueId()
  {
    return _injectableValueId;
  }
  
  public String toString()
  {
    return "[creator property, name '" + getName() + "'; inject id '" + _injectableValueId + "']";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.CreatorProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */