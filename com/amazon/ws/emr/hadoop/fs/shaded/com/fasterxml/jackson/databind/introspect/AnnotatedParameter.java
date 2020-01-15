package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedParameter
  extends AnnotatedMember
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedWithParams _owner;
  protected final Type _type;
  protected final int _index;
  
  public AnnotatedParameter(AnnotatedWithParams owner, Type type, AnnotationMap annotations, int index)
  {
    super(owner == null ? null : owner.getContextClass(), annotations);
    _owner = owner;
    _type = type;
    _index = index;
  }
  
  public AnnotatedParameter withAnnotations(AnnotationMap ann)
  {
    if (ann == _annotations) {
      return this;
    }
    return _owner.replaceParameterAnnotations(_index, ann);
  }
  
  public AnnotatedElement getAnnotated()
  {
    return null;
  }
  
  public int getModifiers()
  {
    return _owner.getModifiers();
  }
  
  public String getName()
  {
    return "";
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _annotations == null ? null : _annotations.get(acls);
  }
  
  public Type getGenericType()
  {
    return _type;
  }
  
  public Class<?> getRawType()
  {
    if ((_type instanceof Class)) {
      return (Class)_type;
    }
    JavaType t = TypeFactory.defaultInstance().constructType(_type);
    return t.getRawClass();
  }
  
  public Class<?> getDeclaringClass()
  {
    return _owner.getDeclaringClass();
  }
  
  public Member getMember()
  {
    return _owner.getMember();
  }
  
  public void setValue(Object pojo, Object value)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + getDeclaringClass().getName());
  }
  
  public Object getValue(Object pojo)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + getDeclaringClass().getName());
  }
  
  public Type getParameterType()
  {
    return _type;
  }
  
  public AnnotatedWithParams getOwner()
  {
    return _owner;
  }
  
  public int getIndex()
  {
    return _index;
  }
  
  public int hashCode()
  {
    return _owner.hashCode() + _index;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (o.getClass() != getClass())) {
      return false;
    }
    AnnotatedParameter other = (AnnotatedParameter)o;
    return (_owner.equals(_owner)) && (_index == _index);
  }
  
  public String toString()
  {
    return "[parameter #" + getIndex() + ", annotations: " + _annotations + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */