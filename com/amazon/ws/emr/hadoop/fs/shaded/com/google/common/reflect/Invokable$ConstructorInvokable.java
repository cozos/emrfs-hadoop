package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

class Invokable$ConstructorInvokable<T>
  extends Invokable<T, T>
{
  final Constructor<?> constructor;
  
  Invokable$ConstructorInvokable(Constructor<?> constructor)
  {
    super(constructor);
    this.constructor = constructor;
  }
  
  final Object invokeInternal(@Nullable Object receiver, Object[] args)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      return constructor.newInstance(args);
    }
    catch (InstantiationException e)
    {
      String str = String.valueOf(String.valueOf(constructor));throw new RuntimeException(8 + str.length() + str + " failed.", e);
    }
  }
  
  Type getGenericReturnType()
  {
    Class<?> declaringClass = getDeclaringClass();
    TypeVariable<?>[] typeParams = declaringClass.getTypeParameters();
    if (typeParams.length > 0) {
      return Types.newParameterizedType(declaringClass, typeParams);
    }
    return declaringClass;
  }
  
  Type[] getGenericParameterTypes()
  {
    Type[] types = constructor.getGenericParameterTypes();
    if ((types.length > 0) && (mayNeedHiddenThis()))
    {
      Class<?>[] rawParamTypes = constructor.getParameterTypes();
      if ((types.length == rawParamTypes.length) && (rawParamTypes[0] == getDeclaringClass().getEnclosingClass())) {
        return (Type[])Arrays.copyOfRange(types, 1, types.length);
      }
    }
    return types;
  }
  
  Type[] getGenericExceptionTypes()
  {
    return constructor.getGenericExceptionTypes();
  }
  
  final Annotation[][] getParameterAnnotations()
  {
    return constructor.getParameterAnnotations();
  }
  
  public final TypeVariable<?>[] getTypeParameters()
  {
    TypeVariable<?>[] declaredByClass = getDeclaringClass().getTypeParameters();
    TypeVariable<?>[] declaredByConstructor = constructor.getTypeParameters();
    TypeVariable<?>[] result = new TypeVariable[declaredByClass.length + declaredByConstructor.length];
    
    System.arraycopy(declaredByClass, 0, result, 0, declaredByClass.length);
    System.arraycopy(declaredByConstructor, 0, result, declaredByClass.length, declaredByConstructor.length);
    
    return result;
  }
  
  public final boolean isOverridable()
  {
    return false;
  }
  
  public final boolean isVarArgs()
  {
    return constructor.isVarArgs();
  }
  
  private boolean mayNeedHiddenThis()
  {
    Class<?> declaringClass = constructor.getDeclaringClass();
    if (declaringClass.getEnclosingConstructor() != null) {
      return true;
    }
    Method enclosingMethod = declaringClass.getEnclosingMethod();
    if (enclosingMethod != null) {
      return !Modifier.isStatic(enclosingMethod.getModifiers());
    }
    return (declaringClass.getEnclosingClass() != null) && (!Modifier.isStatic(declaringClass.getModifiers()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Invokable.ConstructorInvokable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */