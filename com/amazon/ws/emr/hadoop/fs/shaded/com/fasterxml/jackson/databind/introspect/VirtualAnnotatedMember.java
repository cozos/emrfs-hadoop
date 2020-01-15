package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public class VirtualAnnotatedMember
  extends AnnotatedMember
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _declaringClass;
  protected final Class<?> _rawType;
  protected final String _name;
  
  public VirtualAnnotatedMember(AnnotatedClass contextClass, Class<?> declaringClass, String name, Class<?> rawType)
  {
    super(contextClass, null);
    _declaringClass = declaringClass;
    _rawType = rawType;
    _name = name;
  }
  
  public Annotated withAnnotations(AnnotationMap fallback)
  {
    return this;
  }
  
  public Field getAnnotated()
  {
    return null;
  }
  
  public int getModifiers()
  {
    return 0;
  }
  
  public String getName()
  {
    return _name;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return null;
  }
  
  public Type getGenericType()
  {
    return _rawType;
  }
  
  public Class<?> getRawType()
  {
    return _rawType;
  }
  
  public Class<?> getDeclaringClass()
  {
    return _declaringClass;
  }
  
  public Member getMember()
  {
    return null;
  }
  
  public void setValue(Object pojo, Object value)
    throws IllegalArgumentException
  {
    throw new IllegalArgumentException("Can not set virtual property '" + _name + "'");
  }
  
  public Object getValue(Object pojo)
    throws IllegalArgumentException
  {
    throw new IllegalArgumentException("Can not get virtual property '" + _name + "'");
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName();
  }
  
  public int getAnnotationCount()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return _name.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (o.getClass() != getClass())) {
      return false;
    }
    VirtualAnnotatedMember other = (VirtualAnnotatedMember)o;
    return (_declaringClass == _declaringClass) && (_name.equals(_name));
  }
  
  public String toString()
  {
    return "[field " + getFullName() + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */