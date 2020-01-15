package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class AnnotatedMethodMap
  implements Iterable<AnnotatedMethod>
{
  protected LinkedHashMap<MemberKey, AnnotatedMethod> _methods;
  
  public void add(AnnotatedMethod am)
  {
    if (_methods == null) {
      _methods = new LinkedHashMap();
    }
    _methods.put(new MemberKey(am.getAnnotated()), am);
  }
  
  public AnnotatedMethod remove(AnnotatedMethod am)
  {
    return remove(am.getAnnotated());
  }
  
  public AnnotatedMethod remove(Method m)
  {
    if (_methods != null) {
      return (AnnotatedMethod)_methods.remove(new MemberKey(m));
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return (_methods == null) || (_methods.size() == 0);
  }
  
  public int size()
  {
    return _methods == null ? 0 : _methods.size();
  }
  
  public AnnotatedMethod find(String name, Class<?>[] paramTypes)
  {
    if (_methods == null) {
      return null;
    }
    return (AnnotatedMethod)_methods.get(new MemberKey(name, paramTypes));
  }
  
  public AnnotatedMethod find(Method m)
  {
    if (_methods == null) {
      return null;
    }
    return (AnnotatedMethod)_methods.get(new MemberKey(m));
  }
  
  public Iterator<AnnotatedMethod> iterator()
  {
    if (_methods != null) {
      return _methods.values().iterator();
    }
    List<AnnotatedMethod> empty = Collections.emptyList();
    return empty.iterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */