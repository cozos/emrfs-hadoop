package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.reflect.Array;

public final class $ObjectArrays
{
  public static <T> T[] newArray(T[] reference, int length)
  {
    Class<?> type = reference.getClass().getComponentType();
    
    T[] result = (Object[])Array.newInstance(type, length);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ObjectArrays
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */