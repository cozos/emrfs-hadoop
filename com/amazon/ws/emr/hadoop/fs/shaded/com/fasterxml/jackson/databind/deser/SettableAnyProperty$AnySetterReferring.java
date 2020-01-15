package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;

class SettableAnyProperty$AnySetterReferring
  extends ReadableObjectId.Referring
{
  private final SettableAnyProperty _parent;
  private final Object _pojo;
  private final String _propName;
  
  public SettableAnyProperty$AnySetterReferring(SettableAnyProperty parent, UnresolvedForwardReference reference, Class<?> type, Object instance, String propName)
  {
    super(reference, type);
    _parent = parent;
    _pojo = instance;
    _propName = propName;
  }
  
  public void handleResolvedForwardReference(Object id, Object value)
    throws IOException
  {
    if (!hasId(id)) {
      throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id.toString() + "] that wasn't previously registered.");
    }
    _parent.set(_pojo, _propName, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty.AnySetterReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */