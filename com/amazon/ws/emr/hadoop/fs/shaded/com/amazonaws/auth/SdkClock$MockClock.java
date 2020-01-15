package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import java.util.Date;

public final class SdkClock$MockClock
  implements SdkClock
{
  private final long mockedTime;
  
  public SdkClock$MockClock(Date mockedTime)
  {
    this(mockedTime.getTime());
  }
  
  public SdkClock$MockClock(long mockedTime)
  {
    this.mockedTime = mockedTime;
  }
  
  public long currentTimeMillis()
  {
    return mockedTime;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock.MockClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */