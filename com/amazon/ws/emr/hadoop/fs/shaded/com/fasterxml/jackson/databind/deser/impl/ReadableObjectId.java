package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadableObjectId
{
  @Deprecated
  public Object item;
  @Deprecated
  public final Object id;
  protected final ObjectIdGenerator.IdKey _key;
  protected LinkedList<Referring> _referringProperties;
  protected ObjectIdResolver _resolver;
  
  @Deprecated
  public ReadableObjectId(Object id)
  {
    this.id = id;
    _key = null;
  }
  
  public ReadableObjectId(ObjectIdGenerator.IdKey key)
  {
    _key = key;
    id = key;
  }
  
  public void setResolver(ObjectIdResolver resolver)
  {
    _resolver = resolver;
  }
  
  public ObjectIdGenerator.IdKey getKey()
  {
    return _key;
  }
  
  public void appendReferring(Referring currentReferring)
  {
    if (_referringProperties == null) {
      _referringProperties = new LinkedList();
    }
    _referringProperties.add(currentReferring);
  }
  
  public void bindItem(Object ob)
    throws IOException
  {
    _resolver.bindItem(_key, ob);
    item = ob;
    if (_referringProperties != null)
    {
      Iterator<Referring> it = _referringProperties.iterator();
      _referringProperties = null;
      while (it.hasNext()) {
        ((Referring)it.next()).handleResolvedForwardReference(id, ob);
      }
    }
  }
  
  public Object resolve()
  {
    return item = _resolver.resolveId(_key);
  }
  
  public boolean hasReferringProperties()
  {
    return (_referringProperties != null) && (!_referringProperties.isEmpty());
  }
  
  public Iterator<Referring> referringProperties()
  {
    if (_referringProperties == null) {
      return Collections.emptyList().iterator();
    }
    return _referringProperties.iterator();
  }
  
  public boolean tryToResolveUnresolved(DeserializationContext ctxt)
  {
    return false;
  }
  
  public String toString()
  {
    return String.valueOf(_key);
  }
  
  public static abstract class Referring
  {
    private final UnresolvedForwardReference _reference;
    private final Class<?> _beanType;
    
    public Referring(UnresolvedForwardReference ref, Class<?> beanType)
    {
      _reference = ref;
      _beanType = beanType;
    }
    
    public JsonLocation getLocation()
    {
      return _reference.getLocation();
    }
    
    public Class<?> getBeanType()
    {
      return _beanType;
    }
    
    public abstract void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
      throws IOException;
    
    public boolean hasId(Object id)
    {
      return id.equals(_reference.getUnresolvedId());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */