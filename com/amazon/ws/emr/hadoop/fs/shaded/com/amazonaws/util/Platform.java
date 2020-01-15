package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public class Platform
{
  public static boolean isWindows()
  {
    String osName = System.getProperty("os.name");
    return (osName != null) && (osName.startsWith("Windows"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Platform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */