package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

public class $Strings
{
  public static String capitalize(String s)
  {
    if (s.length() == 0) {
      return s;
    }
    char first = s.charAt(0);
    char capitalized = Character.toUpperCase(first);
    return capitalized + s.substring(1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Strings
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */