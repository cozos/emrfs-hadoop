package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$1
  extends UnsafeAllocator
{
  UnsafeAllocator$1(Method paramMethod, Object paramObject) {}
  
  public <T> T newInstance(Class<T> c)
    throws Exception
  {
    return (T)val$allocateInstance.invoke(val$unsafe, new Object[] { c });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.UnsafeAllocator.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */