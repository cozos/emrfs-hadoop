package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.lang.reflect.Type;

class ConstructorConstructor$12
  implements ObjectConstructor<T>
{
  private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
  
  ConstructorConstructor$12(ConstructorConstructor paramConstructorConstructor, Class paramClass, Type paramType) {}
  
  public T construct()
  {
    try
    {
      return (T)unsafeAllocator.newInstance(val$rawType);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + val$type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ConstructorConstructor.12
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */