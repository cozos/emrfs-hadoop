package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class SDKGlobalTime
{
  private static volatile int globalTimeOffset;
  
  public static void setGlobalTimeOffset(int timeOffset)
  {
    globalTimeOffset = timeOffset;
  }
  
  public static int getGlobalTimeOffset()
  {
    return globalTimeOffset;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */