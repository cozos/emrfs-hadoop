package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

public final class ManagedReferenceProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final String _referenceName;
  protected final boolean _isContainer;
  protected final SettableBeanProperty _managedProperty;
  protected final SettableBeanProperty _backProperty;
  
  public ManagedReferenceProperty(SettableBeanProperty forward, String refName, SettableBeanProperty backward, Annotations contextAnnotations, boolean isContainer)
  {
    super(forward.getFullName(), forward.getType(), forward.getWrapperName(), forward.getValueTypeDeserializer(), contextAnnotations, forward.getMetadata());
    
    _referenceName = refName;
    _managedProperty = forward;
    _backProperty = backward;
    _isContainer = isContainer;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _referenceName = _referenceName;
    _isContainer = _isContainer;
    _managedProperty = _managedProperty;
    _backProperty = _backProperty;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty src, PropertyName newName)
  {
    super(src, newName);
    _referenceName = _referenceName;
    _isContainer = _isContainer;
    _managedProperty = _managedProperty;
    _backProperty = _backProperty;
  }
  
  public ManagedReferenceProperty withName(PropertyName newName)
  {
    return new ManagedReferenceProperty(this, newName);
  }
  
  public ManagedReferenceProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new ManagedReferenceProperty(this, deser);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _managedProperty.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _managedProperty.getMember();
  }
  
  public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    set(instance, _managedProperty.deserialize(p, ctxt));
  }
  
  public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    return setAndReturn(instance, deserialize(p, ctxt));
  }
  
  public final void set(Object instance, Object value)
    throws IOException
  {
    setAndReturn(instance, value);
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    if (value != null) {
      if (_isContainer)
      {
        if ((value instanceof Object[])) {
          for (Object ob : (Object[])value) {
            if (ob != null) {
              _backProperty.set(ob, instance);
            }
          }
        } else if ((value instanceof Collection)) {
          for (Object ob : (Collection)value) {
            if (ob != null) {
              _backProperty.set(ob, instance);
            }
          }
        } else if ((value instanceof Map)) {
          for (Object ob : ((Map)value).values()) {
            if (ob != null) {
              _backProperty.set(ob, instance);
            }
          }
        } else {
          throw new IllegalStateException("Unsupported container type (" + value.getClass().getName() + ") when resolving reference '" + _referenceName + "'");
        }
      }
      else {
        _backProperty.set(value, instance);
      }
    }
    return _managedProperty.setAndReturn(instance, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */