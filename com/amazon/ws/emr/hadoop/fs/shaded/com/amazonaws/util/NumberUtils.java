package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public final class NumberUtils
{
  public static Integer tryParseInt(String toParse)
  {
    try
    {
      return Integer.valueOf(Integer.parseInt(toParse));
    }
    catch (NumberFormatException e) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NumberUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */