package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class $MethodInfoTransformer
  implements .Transformer
{
  private static final MethodInfoTransformer INSTANCE = new MethodInfoTransformer();
  
  public static MethodInfoTransformer getInstance()
  {
    return INSTANCE;
  }
  
  public Object transform(Object value)
  {
    if ((value instanceof Method)) {
      return .ReflectUtils.getMethodInfo((Method)value);
    }
    if ((value instanceof Constructor)) {
      return .ReflectUtils.getMethodInfo((Constructor)value);
    }
    throw new IllegalArgumentException("cannot get method info for " + value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfoTransformer
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */