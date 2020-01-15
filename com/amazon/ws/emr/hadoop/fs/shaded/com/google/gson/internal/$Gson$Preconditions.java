package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

public final class $Gson$Preconditions
{
  public static <T> T checkNotNull(T obj)
  {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }
  
  public static void checkArgument(boolean condition)
  {
    if (!condition) {
      throw new IllegalArgumentException();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Preconditions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */