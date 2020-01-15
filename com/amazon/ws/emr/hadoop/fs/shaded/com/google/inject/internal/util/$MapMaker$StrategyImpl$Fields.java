package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.reflect.Field;

class $MapMaker$StrategyImpl$Fields
{
  static final Field keyStrength = findField("keyStrength");
  static final Field valueStrength = findField("valueStrength");
  static final Field expirationNanos = findField("expirationNanos");
  static final Field internals = findField("internals");
  static final Field map = findField("map");
  
  static Field findField(String name)
  {
    try
    {
      Field f = .MapMaker.StrategyImpl.class.getDeclaredField(name);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.StrategyImpl.Fields
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */