package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

@GwtCompatible
final class CollectPreconditions
{
  static void checkEntryNotNull(Object key, Object value)
  {
    String str;
    if (key == null)
    {
      str = String.valueOf(String.valueOf(value));throw new NullPointerException(24 + str.length() + "null key in entry: null=" + str);
    }
    if (value == null)
    {
      str = String.valueOf(String.valueOf(key));throw new NullPointerException(26 + str.length() + "null value in entry: " + str + "=null");
    }
  }
  
  static int checkNonnegative(int value, String name)
  {
    if (value < 0)
    {
      String str = String.valueOf(String.valueOf(name));int i = value;throw new IllegalArgumentException(40 + str.length() + str + " cannot be negative but was: " + i);
    }
    return value;
  }
  
  static void checkRemove(boolean canRemove)
  {
    Preconditions.checkState(canRemove, "no calls to next() since the last call to remove()");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.CollectPreconditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */