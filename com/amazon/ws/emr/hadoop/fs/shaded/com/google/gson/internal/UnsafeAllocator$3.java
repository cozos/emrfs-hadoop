package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$3
  extends UnsafeAllocator
{
  UnsafeAllocator$3(Method paramMethod, int paramInt) {}
  
  public <T> T newInstance(Class<T> c)
    throws Exception
  {
    return (T)val$newInstance.invoke(null, new Object[] { c, Integer.valueOf(val$constructorId) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.UnsafeAllocator.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */