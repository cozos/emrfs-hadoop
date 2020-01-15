package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SdkInternalApi
public class ReflectionMethodInvoker<T, R>
{
  private final Class<T> clazz;
  private final String methodName;
  private final Class<R> returnType;
  private final Class<?>[] parameterTypes;
  private Method targetMethod;
  
  public ReflectionMethodInvoker(Class<T> clazz, Class<R> returnType, String methodName, Class<?>... parameterTypes)
  {
    this.clazz = clazz;
    this.methodName = methodName;
    this.returnType = returnType;
    this.parameterTypes = parameterTypes;
  }
  
  public R invoke(T obj, Object... args)
    throws NoSuchMethodException
  {
    Method targetMethod = getTargetMethod();
    try
    {
      Object rawResult = targetMethod.invoke(obj, args);
      return (R)returnType.cast(rawResult);
    }
    catch (IllegalAccessException e)
    {
      throw new SdkClientException(e);
    }
    catch (InvocationTargetException e)
    {
      throw new SdkClientException(e);
    }
  }
  
  public void initialize()
    throws NoSuchMethodException
  {
    getTargetMethod();
  }
  
  public boolean isInitialized()
  {
    return targetMethod != null;
  }
  
  private Method getTargetMethod()
    throws NoSuchMethodException
  {
    if (targetMethod != null) {
      return targetMethod;
    }
    try
    {
      targetMethod = clazz.getMethod(methodName, parameterTypes);
      return targetMethod;
    }
    catch (NullPointerException e)
    {
      throw new SdkClientException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ReflectionMethodInvoker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */