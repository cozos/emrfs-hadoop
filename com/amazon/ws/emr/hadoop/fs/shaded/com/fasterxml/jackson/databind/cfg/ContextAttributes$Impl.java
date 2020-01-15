package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContextAttributes$Impl
  extends ContextAttributes
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final Impl EMPTY = new Impl(Collections.emptyMap());
  protected static final Object NULL_SURROGATE = new Object();
  protected final Map<Object, Object> _shared;
  protected transient Map<Object, Object> _nonShared;
  
  protected ContextAttributes$Impl(Map<Object, Object> shared)
  {
    _shared = shared;
    _nonShared = null;
  }
  
  protected ContextAttributes$Impl(Map<Object, Object> shared, Map<Object, Object> nonShared)
  {
    _shared = shared;
    _nonShared = nonShared;
  }
  
  public static ContextAttributes getEmpty()
  {
    return EMPTY;
  }
  
  public ContextAttributes withSharedAttribute(Object key, Object value)
  {
    Map<Object, Object> m;
    Map<Object, Object> m;
    if (this == EMPTY) {
      m = new HashMap(8);
    } else {
      m = _copy(_shared);
    }
    m.put(key, value);
    return new Impl(m);
  }
  
  public ContextAttributes withSharedAttributes(Map<Object, Object> shared)
  {
    return new Impl(shared);
  }
  
  public ContextAttributes withoutSharedAttribute(Object key)
  {
    if (_shared.isEmpty()) {
      return this;
    }
    if (_shared.containsKey(key))
    {
      if (_shared.size() == 1) {
        return EMPTY;
      }
    }
    else {
      return this;
    }
    Map<Object, Object> m = _copy(_shared);
    m.remove(key);
    return new Impl(m);
  }
  
  public Object getAttribute(Object key)
  {
    if (_nonShared != null)
    {
      Object ob = _nonShared.get(key);
      if (ob != null)
      {
        if (ob == NULL_SURROGATE) {
          return null;
        }
        return ob;
      }
    }
    return _shared.get(key);
  }
  
  public ContextAttributes withPerCallAttribute(Object key, Object value)
  {
    if (value == null) {
      if (_shared.containsKey(key)) {
        value = NULL_SURROGATE;
      } else {
        return this;
      }
    }
    if (_nonShared == null) {
      return nonSharedInstance(key, value);
    }
    _nonShared.put(key, value);
    return this;
  }
  
  protected ContextAttributes nonSharedInstance(Object key, Object value)
  {
    Map<Object, Object> m = new HashMap();
    if (value == null) {
      value = NULL_SURROGATE;
    }
    m.put(key, value);
    return new Impl(_shared, m);
  }
  
  private Map<Object, Object> _copy(Map<Object, Object> src)
  {
    return new HashMap(src);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes.Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */