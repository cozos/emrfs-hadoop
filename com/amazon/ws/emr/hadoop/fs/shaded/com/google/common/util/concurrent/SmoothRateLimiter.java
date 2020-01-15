package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter
  extends RateLimiter
{
  double storedPermits;
  double maxPermits;
  double stableIntervalMicros;
  
  static final class SmoothWarmingUp
    extends SmoothRateLimiter
  {
    private final long warmupPeriodMicros;
    private double slope;
    private double halfPermits;
    
    SmoothWarmingUp(RateLimiter.SleepingStopwatch stopwatch, long warmupPeriod, TimeUnit timeUnit)
    {
      super(null);
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
  
  static final class SmoothBursty
    extends SmoothRateLimiter
  {
    final double maxBurstSeconds;
    
    SmoothBursty(RateLimiter.SleepingStopwatch stopwatch, double maxBurstSeconds)
    {
      super(null);
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
  
  private long nextFreeTicketMicros = 0L;
  
  private SmoothRateLimiter(RateLimiter.SleepingStopwatch stopwatch)
  {
    super(stopwatch);
  }
  
  final void doSetRate(double permitsPerSecond, long nowMicros)
  {
    resync(nowMicros);
    double stableIntervalMicros = TimeUnit.SECONDS.toMicros(1L) / permitsPerSecond;
    this.stableIntervalMicros = stableIntervalMicros;
    doSetRate(permitsPerSecond, stableIntervalMicros);
  }
  
  abstract void doSetRate(double paramDouble1, double paramDouble2);
  
  final double doGetRate()
  {
    return TimeUnit.SECONDS.toMicros(1L) / stableIntervalMicros;
  }
  
  final long queryEarliestAvailable(long nowMicros)
  {
    return nextFreeTicketMicros;
  }
  
  final long reserveEarliestAvailable(int requiredPermits, long nowMicros)
  {
    resync(nowMicros);
    long returnValue = nextFreeTicketMicros;
    double storedPermitsToSpend = Math.min(requiredPermits, storedPermits);
    double freshPermits = requiredPermits - storedPermitsToSpend;
    
    long waitMicros = storedPermitsToWaitTime(storedPermits, storedPermitsToSpend) + (freshPermits * stableIntervalMicros);
    
    nextFreeTicketMicros += waitMicros;
    storedPermits -= storedPermitsToSpend;
    return returnValue;
  }
  
  abstract long storedPermitsToWaitTime(double paramDouble1, double paramDouble2);
  
  private void resync(long nowMicros)
  {
    if (nowMicros > nextFreeTicketMicros)
    {
      storedPermits = Math.min(maxPermits, storedPermits + (nowMicros - nextFreeTicketMicros) / stableIntervalMicros);
      
      nextFreeTicketMicros = nowMicros;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SmoothRateLimiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */