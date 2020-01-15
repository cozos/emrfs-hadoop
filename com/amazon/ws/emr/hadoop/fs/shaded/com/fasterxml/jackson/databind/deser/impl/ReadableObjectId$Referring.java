package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;

public abstract class ReadableObjectId$Referring
{
  private final UnresolvedForwardReference _reference;
  private final Class<?> _beanType;
  
  public ReadableObjectId$Referring(UnresolvedForwardReference ref, Class<?> beanType)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */