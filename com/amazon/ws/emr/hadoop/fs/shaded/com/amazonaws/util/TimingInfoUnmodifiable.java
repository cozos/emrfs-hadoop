package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
final class TimingInfoUnmodifiable
  extends TimingInfo
{
  TimingInfoUnmodifiable(Long startEpochTimeMilli, long startTimeNano, Long endTimeNano)
  {
    super(startEpochTimeMilli, startTimeNano, endTimeNano);
  }
  
  public void setEndTime(long _)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setEndTimeNano(long _)
  {
    throw new UnsupportedOperationException();
  }
  
  public TimingInfo endTiming()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfoUnmodifiable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */