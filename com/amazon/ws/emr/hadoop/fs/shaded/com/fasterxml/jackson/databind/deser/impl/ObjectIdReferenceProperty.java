package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class ObjectIdReferenceProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  private final SettableBeanProperty _forward;
  
  public ObjectIdReferenceProperty(SettableBeanProperty forward, ObjectIdInfo objectIdInfo)
  {
    super(forward);
    _forward = forward;
    _objectIdInfo = objectIdInfo;
  }
  
  public ObjectIdReferenceProperty(ObjectIdReferenceProperty src, JsonDeserializer<?> deser)
  {
    super(src, deser);
    _forward = _forward;
    _objectIdInfo = _objectIdInfo;
  }
  
  public ObjectIdReferenceProperty(ObjectIdReferenceProperty src, PropertyName newName)
  {
    super(src, newName);
    _forward = _forward;
    _objectIdInfo = _objectIdInfo;
  }
  
  public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser)
  {
    return new ObjectIdReferenceProperty(this, deser);
  }
  
  public SettableBeanProperty withName(PropertyName newName)
  {
    return new ObjectIdReferenceProperty(this, newName);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _forward.getAnnotation(acls);
  }
  
  public AnnotatedMember getMember()
  {
    return _forward.getMember();
  }
  
  public int getCreatorIndex()
  {
    return _forward.getCreatorIndex();
  }
  
  public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    deserializeSetAndReturn(p, ctxt, instance);
  }
  
  public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance)
    throws IOException
  {
    try
    {
      return setAndReturn(instance, deserialize(p, ctxt));
    }
    catch (UnresolvedForwardReference reference)
    {
      boolean usingIdentityInfo = (_objectIdInfo != null) || (_valueDeserializer.getObjectIdReader() != null);
      if (!usingIdentityInfo) {
        throw JsonMappingException.from(p, "Unresolved forward reference but no identity info.", reference);
      }
      reference.getRoid().appendReferring(new PropertyReferring(this, reference, _type.getRawClass(), instance));
    }
    return null;
  }
  
  public void set(Object instance, Object value)
    throws IOException
  {
    _forward.set(instance, value);
  }
  
  public Object setAndReturn(Object instance, Object value)
    throws IOException
  {
    return _forward.setAndReturn(instance, value);
  }
  
  public static final class PropertyReferring
    extends ReadableObjectId.Referring
  {
    private final ObjectIdReferenceProperty _parent;
    public final Object _pojo;
    
    public PropertyReferring(ObjectIdReferenceProperty parent, UnresolvedForwardReference ref, Class<?> type, Object ob)
    {
      super(type);
      _parent = parent;
      _pojo = ob;
    }
    
    public void handleResolvedForwardReference(Object id, Object value)
      throws IOException
    {
      if (!hasId(id)) {
        throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
      }
      _parent.set(_pojo, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */