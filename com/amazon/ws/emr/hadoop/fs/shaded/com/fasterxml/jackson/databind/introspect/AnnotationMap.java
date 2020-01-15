package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;

public final class AnnotationMap
  implements Annotations
{
  protected HashMap<Class<? extends Annotation>, Annotation> _annotations;
  
  public AnnotationMap() {}
  
  private AnnotationMap(HashMap<Class<? extends Annotation>, Annotation> a)
  {
    _annotations = a;
  }
  
  public <A extends Annotation> A get(Class<A> cls)
  {
    if (_annotations == null) {
      return null;
    }
    return (Annotation)_annotations.get(cls);
  }
  
  public Iterable<Annotation> annotations()
  {
    if ((_annotations == null) || (_annotations.size() == 0)) {
      return Collections.emptyList();
    }
    return _annotations.values();
  }
  
  public static AnnotationMap merge(AnnotationMap primary, AnnotationMap secondary)
  {
    if ((primary == null) || (_annotations == null) || (_annotations.isEmpty())) {
      return secondary;
    }
    if ((secondary == null) || (_annotations == null) || (_annotations.isEmpty())) {
      return primary;
    }
    HashMap<Class<? extends Annotation>, Annotation> annotations = new HashMap();
    for (Annotation ann : _annotations.values()) {
      annotations.put(ann.annotationType(), ann);
    }
    for (Annotation ann : _annotations.values()) {
      annotations.put(ann.annotationType(), ann);
    }
    return new AnnotationMap(annotations);
  }
  
  public int size()
  {
    return _annotations == null ? 0 : _annotations.size();
  }
  
  public boolean addIfNotPresent(Annotation ann)
  {
    if ((_annotations == null) || (!_annotations.containsKey(ann.annotationType())))
    {
      _add(ann);
      return true;
    }
    return false;
  }
  
  public boolean add(Annotation ann)
  {
    return _add(ann);
  }
  
  public String toString()
  {
    if (_annotations == null) {
      return "[null]";
    }
    return _annotations.toString();
  }
  
  protected final boolean _add(Annotation ann)
  {
    if (_annotations == null) {
      _annotations = new HashMap();
    }
    Annotation previous = (Annotation)_annotations.put(ann.annotationType(), ann);
    return (previous == null) || (!previous.equals(ann));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotationMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */