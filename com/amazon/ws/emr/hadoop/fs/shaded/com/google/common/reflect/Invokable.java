package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class Invokable<T, R>
  extends Element
  implements GenericDeclaration
{
  <M extends AccessibleObject,  extends Member> Invokable(M member)
  {
    super(member);
  }
  
  public static Invokable<?, Object> from(Method method)
  {
    return new MethodInvokable(method);
  }
  
  public static <T> Invokable<T, T> from(Constructor<T> constructor)
  {
    return new ConstructorInvokable(constructor);
  }
  
  public abstract boolean isOverridable();
  
  public abstract boolean isVarArgs();
  
  public final R invoke(@Nullable T receiver, Object... args)
    throws InvocationTargetException, IllegalAccessException
  {
    return (R)invokeInternal(receiver, (Object[])Preconditions.checkNotNull(args));
  }
  
  public final TypeToken<? extends R> getReturnType()
  {
    return TypeToken.of(getGenericReturnType());
  }
  
  public final ImmutableList<Parameter> getParameters()
  {
    Type[] parameterTypes = getGenericParameterTypes();
    Annotation[][] annotations = getParameterAnnotations();
    ImmutableList.Builder<Parameter> builder = ImmutableList.builder();
    for (int i = 0; i < parameterTypes.length; i++) {
      builder.add(new Parameter(this, i, TypeToken.of(parameterTypes[i]), annotations[i]));
    }
    return builder.build();
  }
  
  public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes()
  {
    ImmutableList.Builder<TypeToken<? extends Throwable>> builder = ImmutableList.builder();
    for (Type type : getGenericExceptionTypes())
    {
      TypeToken<? extends Throwable> exceptionType = TypeToken.of(type);
      
      builder.add(exceptionType);
    }
    return builder.build();
  }
  
  public final <R1 extends R> Invokable<T, R1> returning(Class<R1> returnType)
  {
    return returning(TypeToken.of(returnType));
  }
  
  public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> returnType)
  {
    if (!returnType.isAssignableFrom(getReturnType()))
    {
      String str1 = String.valueOf(String.valueOf(getReturnType()));String str2 = String.valueOf(String.valueOf(returnType));throw new IllegalArgumentException(35 + str1.length() + str2.length() + "Invokable is known to return " + str1 + ", not " + str2);
    }
    Object specialized = this;
    return (Invokable<T, R1>)specialized;
  }
  
  public final Class<? super T> getDeclaringClass()
  {
    return super.getDeclaringClass();
  }
  
  public TypeToken<T> getOwnerType()
  {
    return TypeToken.of(getDeclaringClass());
  }
  
  abstract Object invokeInternal(@Nullable Object paramObject, Object[] paramArrayOfObject)
    throws InvocationTargetException, IllegalAccessException;
  
  abstract Type[] getGenericParameterTypes();
  
  abstract Type[] getGenericExceptionTypes();
  
  abstract Annotation[][] getParameterAnnotations();
  
  abstract Type getGenericReturnType();
  
  static class MethodInvokable<T>
    extends Invokable<T, Object>
  {
    final Method method;
    
    MethodInvokable(Method method)
    {
      super();
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
  
  static class ConstructorInvokable<T>
    extends Invokable<T, T>
  {
    final Constructor<?> constructor;
    
    ConstructorInvokable(Constructor<?> constructor)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Invokable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */