package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

final class ArrayBuilders$1
{
  ArrayBuilders$1(Class paramClass, int paramInt, Object paramObject) {}
  
  public boolean equals(Object other)
  {
    if (other == this) {
      return true;
    }
    if ((other == null) || (other.getClass() != val$defaultValueType)) {
      return false;
    }
    if (Array.getLength(other) != val$length) {
      return false;
    }
    for (int i = 0; i < val$length; i++)
    {
      Object value1 = Array.get(val$defaultValue, i);
      Object value2 = Array.get(other, i);
      if ((value1 != value2) && 
        (value1 != null) && 
        (!value1.equals(value2))) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */