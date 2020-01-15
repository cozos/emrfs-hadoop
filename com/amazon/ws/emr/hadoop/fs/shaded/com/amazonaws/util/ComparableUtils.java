package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public class ComparableUtils
{
  public static <T> int safeCompare(Comparable<T> d1, T d2)
  {
    if ((d1 != null) && (d2 != null)) {
      return d1.compareTo(d2);
    }
    if ((d1 == null) && (d2 != null)) {
      return -1;
    }
    if ((d1 != null) && (d2 == null)) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ComparableUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */