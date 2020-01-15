package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class SmoothRateLimiter$SmoothBursty
  extends SmoothRateLimiter
{
  final double maxBurstSeconds;
  
  SmoothRateLimiter$SmoothBursty(RateLimiter.SleepingStopwatch stopwatch, double maxBurstSeconds)
  {
    super(stopwatch, null);
    this.maxBurstSeconds = maxBurstSeconds;
  }
  
  void doSetRate(double permitsPerSecond, double stableIntervalMicros)
  {
    double oldMaxPermits = maxPermits;
    maxPermits = (maxBurstSeconds * permitsPerSecond);
    if (oldMaxPermits == Double.POSITIVE_INFINITY) {
      storedPermits = maxPermits;
    } else {
      storedPermits = (oldMaxPermits == 0.0D ? 0.0D : storedPermits * maxPermits / oldMaxPermits);
    }
  }
  
  long storedPermitsToWaitTime(double storedPermits, double permitsToTake)
  {
    return 0L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SmoothRateLimiter.SmoothBursty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */