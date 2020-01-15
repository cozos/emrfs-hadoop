package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.reflect.Field;

final class Serialization$FieldSetter<T>
{
  private final Field field;
  
  private Serialization$FieldSetter(Field field)
  {
    this.field = field;
    field.setAccessible(true);
  }
  
  void set(T instance, Object value)
  {
    try
    {
      field.set(instance, value);
    }
    catch (IllegalAccessException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  void set(T instance, int value)
  {
    try
    {
      field.set(instance, Integer.valueOf(value));
    }
    catch (IllegalAccessException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Serialization.FieldSetter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */