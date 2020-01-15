package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.IOException;
import java.lang.annotation.Annotation;

public final class ObjectIdValueProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final ObjectIdReader _objectIdReader;
  
  public ObjectIdValueProperty(ObjectIdReader objectIdReader, PropertyMetadata metadata)
  {
    super(propertyName, objectIdReader.getIdType(), metadata, objectIdReader.getDeserializer());
    
    _objectIdReader = objectIdReader;
  }
  
  protected ObjectIdValueProperty(ObjectIdValueProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _objectIdReader = _objectIdReader;
  }
  
  protected ObjectIdValueProperty(ObjectIdValueProperty src, PropertyName newName)
  {
    super(src, newName);
    _objectIdReader = _objectIdReader;
  }
  
  public ObjectIdValueProperty withName(PropertyName newName)
  {
    return new ObjectIdValueProperty(this, newName);
  }
  
  public ObjectIdValueProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new ObjectIdValueProperty(this, deser);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return null;
  }
  
  public AnnotatedMember getMember()
  {
    return null;
  }
  
  public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    deserializeSetAndReturn(p, ctxt, instance);
  }
  
  public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    Object id = _valueDeserializer.deserialize(p, ctxt);
    if (id == null) {
      return null;
    }
    ReadableObjectId roid = ctxt.findObjectId(id, _objectIdReader.generator, _objectIdReader.resolver);
    roid.bindItem(instance);
    
    SettableBeanProperty idProp = _objectIdReader.idProperty;
    if (idProp != null) {
      return idProp.setAndReturn(instance, id);
    }
    return instance;
  }
  
  public void set(Object instance, Object value)
    throws IOException
  {
    setAndReturn(instance, value);
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    SettableBeanProperty idProp = _objectIdReader.idProperty;
    if (idProp == null) {
      throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }
    return idProp.setAndReturn(instance, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */