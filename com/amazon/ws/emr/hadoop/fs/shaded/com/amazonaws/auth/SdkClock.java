package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import java.util.Date;

@SdkProtectedApi
public abstract interface SdkClock
{
  public static final SdkClock STANDARD = new SdkClock()
  {
    public long currentTimeMillis()
    {
      return System.currentTimeMillis();
    }
  };
  
  public abstract long currentTimeMillis();
  
  public static final class MockClock
    implements SdkClock
  {
    private final long mockedTime;
    
    public MockClock(Date mockedTime)
    {
      this(mockedTime.getTime());
    }
    
    public MockClock(long mockedTime)
    {
      this.mockedTime = mockedTime;
    }
    
    public long currentTimeMillis()
    {
      return mockedTime;
    }
  }
  
  public static final class Instance
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */