package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Collections;

public abstract class AnnotatedMember
  extends Annotated
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final transient AnnotatedClass _context;
  protected final transient AnnotationMap _annotations;
  
  protected AnnotatedMember(AnnotatedClass ctxt, AnnotationMap annotations)
  {
    _context = ctxt;
    _annotations = annotations;
  }
  
  protected AnnotatedMember(AnnotatedMember base)
  {
    _context = _context;
    _annotations = _annotations;
  }
  
  public abstract Class<?> getDeclaringClass();
  
  public abstract Member getMember();
  
  public AnnotatedClass getContextClass()
  {
    return _context;
  }
  
  public Iterable<Annotation> annotations()
  {
    if (_annotations == null) {
      return Collections.emptyList();
    }
    return _annotations.annotations();
  }
  
  protected AnnotationMap getAllAnnotations()
  {
    return _annotations;
  }
  
  public final boolean addOrOverride(Annotation a)
  {
    return _annotations.add(a);
  }
  
  public final boolean addIfNotPresent(Annotation a)
  {
    return _annotations.addIfNotPresent(a);
  }
  
  public final void fixAccess()
  {
    ClassUtil.checkAndFixAccess(getMember());
  }
  
  public abstract void setValue(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException, IllegalArgumentException;
  
  public abstract Object getValue(Object paramObject)
    throws UnsupportedOperationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */