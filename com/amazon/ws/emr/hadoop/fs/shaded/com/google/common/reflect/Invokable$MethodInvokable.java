package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

class Invokable$MethodInvokable<T>
  extends Invokable<T, Object>
{
  final Method method;
  
  Invokable$MethodInvokable(Method method)
  {
    super(method);
    this.method = method;
  }
  
  final Object invokeInternal(@Nullable Object receiver, Object[] args)
    throws InvocationTargetException, IllegalAccessException
  {
    return method.invoke(receiver, args);
  }
  
  Type getGenericReturnType()
  {
    return method.getGenericReturnType();
  }
  
  Type[] getGenericParameterTypes()
  {
    return method.getGenericParameterTypes();
  }
  
  Type[] getGenericExceptionTypes()
  {
    return method.getGenericExceptionTypes();
  }
  
  final Annotation[][] getParameterAnnotations()
  {
    return method.getParameterAnnotations();
  }
  
  public final TypeVariable<?>[] getTypeParameters()
  {
    return method.getTypeParameters();
  }
  
  public final boolean isOverridable()
  {
    return (!isFinal()) && (!isPrivate()) && (!isStatic()) && (!Modifier.isFinal(getDeclaringClass().getModifiers()));
  }
  
  public final boolean isVarArgs()
  {
    return method.isVarArgs();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Invokable.MethodInvokable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */