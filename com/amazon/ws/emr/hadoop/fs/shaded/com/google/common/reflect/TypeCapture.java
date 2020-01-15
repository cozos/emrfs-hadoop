package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class TypeCapture<T>
{
  final Type capture()
  {
    Type superclass = getClass().getGenericSuperclass();
    Preconditions.checkArgument(superclass instanceof ParameterizedType, "%s isn't parameterized", new Object[] { superclass });
    
    return ((ParameterizedType)superclass).getActualTypeArguments()[0];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeCapture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */