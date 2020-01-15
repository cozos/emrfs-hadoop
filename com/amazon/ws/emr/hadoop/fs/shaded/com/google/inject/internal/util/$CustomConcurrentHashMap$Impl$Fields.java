package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.reflect.Field;

class $CustomConcurrentHashMap$Impl$Fields
{
  static final Field loadFactor = findField("loadFactor");
  static final Field segmentShift = findField("segmentShift");
  static final Field segmentMask = findField("segmentMask");
  static final Field segments = findField("segments");
  static final Field strategy = findField("strategy");
  
  static Field findField(String name)
  {
    try
    {
      Field f = .CustomConcurrentHashMap.Impl.class.getDeclaredField(name);
      f.setAccessible(true);
      return f;
    }
    catch (NoSuchFieldException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.Fields
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */