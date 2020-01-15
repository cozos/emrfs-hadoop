package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;

public final class ObjectIdReferenceProperty$PropertyReferring
  extends ReadableObjectId.Referring
{
  private final ObjectIdReferenceProperty _parent;
  public final Object _pojo;
  
  public ObjectIdReferenceProperty$PropertyReferring(ObjectIdReferenceProperty parent, UnresolvedForwardReference ref, Class<?> type, Object ob)
  {
    super(ref, type);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty.PropertyReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */