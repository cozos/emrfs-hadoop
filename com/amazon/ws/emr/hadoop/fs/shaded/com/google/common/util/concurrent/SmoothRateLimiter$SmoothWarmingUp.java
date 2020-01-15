package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

final class SmoothRateLimiter$SmoothWarmingUp
  extends SmoothRateLimiter
{
  private final long warmupPeriodMicros;
  private double slope;
  private double halfPermits;
  
  SmoothRateLimiter$SmoothWarmingUp(RateLimiter.SleepingStopwatch stopwatch, long warmupPeriod, TimeUnit timeUnit)
  {
    super(stopwatch, null);
    warmupPeriodMicros = timeUnit.toMicros(warmupPeriod);
  }
  
  void doSetRate(double permitsPerSecond, double stableIntervalMicros)
  {
    double oldMaxPermits = maxPermits;
    maxPermits = (warmupPeriodMicros / stableIntervalMicros);
    halfPermits = (maxPermits / 2.0D);
    
    double coldIntervalMicros = stableIntervalMicros * 3.0D;
    slope = ((coldIntervalMicros - stableIntervalMicros) / halfPermits);
    if (oldMaxPermits == Double.POSITIVE_INFINITY) {
      storedPermits = 0.0D;
    } else {
      storedPermits = (oldMaxPermits == 0.0D ? maxPermits : storedPermits * maxPermits / oldMaxPermits);
    }
  }
  
  long storedPermitsToWaitTime(double storedPermits, double permitsToTake)
  {
    double availablePermitsAboveHalf = storedPermits - halfPermits;
    long micros = 0L;
    if (availablePermitsAboveHalf > 0.0D)
    {
      double permitsAboveHalfToTake = Math.min(availablePermitsAboveHalf, permitsToTake);
      micros = (permitsAboveHalfToTake * (permitsToTime(availablePermitsAboveHalf) + permitsToTime(availablePermitsAboveHalf - permitsAboveHalfToTake)) / 2.0D);
      
      permitsToTake -= permitsAboveHalfToTake;
    }
    micros = (micros + stableIntervalMicros * permitsToTake);
    return micros;
  }
  
  private double permitsToTime(double permits)
  {
    return stableIntervalMicros + permits * slope;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SmoothRateLimiter.SmoothWarmingUp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */