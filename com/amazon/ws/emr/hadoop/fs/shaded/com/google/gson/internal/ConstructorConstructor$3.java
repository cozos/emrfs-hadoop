package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstructorConstructor$3
  implements ObjectConstructor<T>
{
  ConstructorConstructor$3(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor) {}
  
  public T construct()
  {
    try
    {
      Object[] args = null;
      return (T)val$constructor.newInstance(args);
    }
    catch (InstantiationException e)
    {
      throw new RuntimeException("Failed to invoke " + val$constructor + " with no args", e);
    }
    catch (InvocationTargetException e)
    {
      throw new RuntimeException("Failed to invoke " + val$constructor + " with no args", e.getTargetException());
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ConstructorConstructor.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */