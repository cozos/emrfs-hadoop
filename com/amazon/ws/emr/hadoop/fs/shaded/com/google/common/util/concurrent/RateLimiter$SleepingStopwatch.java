package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
abstract class RateLimiter$SleepingStopwatch
{
  abstract long readMicros();
  
  abstract void sleepMicrosUninterruptibly(long paramLong);
  
  static final SleepingStopwatch createFromSystemTimer()
  {
    new SleepingStopwatch()
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
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */