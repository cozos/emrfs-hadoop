package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;

public final class SdkClock$Instance
{
  private static SdkClock clock = SdkClock.STANDARD;
  
  public static SdkClock get()
  {
    return clock;
  }
  
  @SdkTestInternalApi
  public static void set(SdkClock newClock)
  {
    clock = newClock;
  }
  
  @SdkTestInternalApi
  public static void reset()
  {
    clock = SdkClock.STANDARD;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock.Instance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */