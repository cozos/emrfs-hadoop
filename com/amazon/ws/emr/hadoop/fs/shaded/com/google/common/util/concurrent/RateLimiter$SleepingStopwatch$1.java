package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

final class RateLimiter$SleepingStopwatch$1
  extends RateLimiter.SleepingStopwatch
{
  final Stopwatch stopwatch = Stopwatch.createStarted();
  
  long readMicros()
  {
    return stopwatch.elapsed(TimeUnit.MICROSECONDS);
  }
  
  void sleepMicrosUninterruptibly(long micros)
  {
    if (micros > 0L) {
      Uninterruptibles.sleepUninterruptibly(micros, TimeUnit.MICROSECONDS);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */