package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public enum SdkRuntime
{
  private SdkRuntime() {}
  
  public static boolean shouldAbort()
  {
    return Thread.interrupted();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkRuntime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */