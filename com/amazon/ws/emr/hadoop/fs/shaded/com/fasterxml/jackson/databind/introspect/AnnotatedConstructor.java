package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedConstructor
  extends AnnotatedWithParams
{
  private static final long serialVersionUID = 1L;
  protected final Constructor<?> _constructor;
  protected Serialization _serialization;
  
  public AnnotatedConstructor(AnnotatedClass ctxt, Constructor<?> constructor, AnnotationMap classAnn, AnnotationMap[] paramAnn)
  {
    super(ctxt, classAnn, paramAnn);
    if (constructor == null) {
      throw new IllegalArgumentException("Null constructor not allowed");
    }
    _constructor = constructor;
  }
  
  protected AnnotatedConstructor(Serialization ser)
  {
    super(null, null, null);
    _constructor = null;
    _serialization = ser;
  }
  
  public AnnotatedConstructor withAnnotations(AnnotationMap ann)
  {
    return new AnnotatedConstructor(_context, _constructor, ann, _paramAnnotations);
  }
  
  public Constructor<?> getAnnotated()
  {
    return _constructor;
  }
  
  public int getModifiers()
  {
    return _constructor.getModifiers();
  }
  
  public String getName()
  {
    return _constructor.getName();
  }
  
  public Type getGenericType()
  {
    return getRawType();
  }
  
  public Class<?> getRawType()
  {
    return _constructor.getDeclaringClass();
  }
  
  public JavaType getType(TypeBindings bindings)
  {
    return getType(bindings, _constructor.getTypeParameters());
  }
  
  public int getParameterCount()
  {
    return _constructor.getParameterTypes().length;
  }
  
  public Class<?> getRawParameterType(int index)
  {
    Class<?>[] types = _constructor.getParameterTypes();
    return index >= types.length ? null : types[index];
  }
  
  public Type getGenericParameterType(int index)
  {
    Type[] types = _constructor.getGenericParameterTypes();
    return index >= types.length ? null : types[index];
  }
  
  public final Object call()
    throws Exception
  {
    return _constructor.newInstance(new Object[0]);
  }
  
  public final Object call(Object[] args)
    throws Exception
  {
    return _constructor.newInstance(args);
  }
  
  public final Object call1(Object arg)
    throws Exception
  {
    return _constructor.newInstance(new Object[] { arg });
  }
  
  public Class<?> getDeclaringClass()
  {
    return _constructor.getDeclaringClass();
  }
  
  public Member getMember()
  {
    return _constructor;
  }
  
  public void setValue(Object pojo, Object value)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public Object getValue(Object pojo)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + getDeclaringClass().getName());
  }
  
  public String toString()
  {
    return "[constructor for " + getName() + ", annotations: " + _annotations + "]";
  }
  
  public int hashCode()
  {
    return _constructor.getName().hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (o.getClass() != getClass())) {
      return false;
    }
    return _constructor == _constructor;
  }
  
  Object writeReplace()
  {
    return new AnnotatedConstructor(new Serialization(_constructor));
  }
  
  Object readResolve()
  {
    Class<?> clazz = _serialization.clazz;
    try
    {
      Constructor<?> ctor = clazz.getDeclaredConstructor(_serialization.args);
      if (!ctor.isAccessible()) {
        ClassUtil.checkAndFixAccess(ctor);
      }
      return new AnnotatedConstructor(null, ctor, null, null);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException("Could not find constructor with " + _serialization.args.length + " args from Class '" + clazz.getName());
    }
  }
  
  private static final class Serialization
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected Class<?> clazz;
    protected Class<?>[] args;
    
    public Serialization(Constructor<?> ctor)
    {
      clazz = ctor.getDeclaringClass();
      args = ctor.getParameterTypes();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */