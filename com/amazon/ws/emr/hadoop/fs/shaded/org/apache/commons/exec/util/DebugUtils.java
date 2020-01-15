package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util;

import java.io.PrintStream;

public class DebugUtils
{
  public static final String COMMONS_EXEC_LENIENT = "com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.lenient";
  public static final String COMMONS_EXEC_DEBUG = "com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.debug";
  
  public static void handleException(String msg, Exception e)
  {
    if (isDebugEnabled())
    {
      System.err.println(msg);
      e.printStackTrace();
    }
    if (!isLenientEnabled())
    {
      if ((e instanceof RuntimeException)) {
        throw ((RuntimeException)e);
      }
      throw new RuntimeException(e.getMessage());
    }
  }
  
  public static boolean isDebugEnabled()
  {
    return "true".equalsIgnoreCase(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.debug", "false"));
  }
  
  public static boolean isLenientEnabled()
  {
    return "true".equalsIgnoreCase(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.lenient", "true"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util.DebugUtils
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */