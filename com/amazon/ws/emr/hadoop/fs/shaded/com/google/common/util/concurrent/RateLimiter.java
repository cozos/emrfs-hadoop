package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Beta
public abstract class RateLimiter
{
  private final SleepingStopwatch stopwatch;
  private volatile Object mutexDoNotUseDirectly;
  
  public static RateLimiter create(double permitsPerSecond)
  {
    return create(SleepingStopwatch.createFromSystemTimer(), permitsPerSecond);
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch stopwatch, double permitsPerSecond)
  {
    RateLimiter rateLimiter = new SmoothRateLimiter.SmoothBursty(stopwatch, 1.0D);
    rateLimiter.setRate(permitsPerSecond);
    return rateLimiter;
  }
  
  public static RateLimiter create(double permitsPerSecond, long warmupPeriod, TimeUnit unit)
  {
    Preconditions.checkArgument(warmupPeriod >= 0L, "warmupPeriod must not be negative: %s", new Object[] { Long.valueOf(warmupPeriod) });
    return create(SleepingStopwatch.createFromSystemTimer(), permitsPerSecond, warmupPeriod, unit);
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch stopwatch, double permitsPerSecond, long warmupPeriod, TimeUnit unit)
  {
    RateLimiter rateLimiter = new SmoothRateLimiter.SmoothWarmingUp(stopwatch, warmupPeriod, unit);
    rateLimiter.setRate(permitsPerSecond);
    return rateLimiter;
  }
  
  private Object mutex()
  {
    Object mutex = mutexDoNotUseDirectly;
    if (mutex == null) {
      synchronized (this)
      {
        mutex = mutexDoNotUseDirectly;
        if (mutex == null) {
          mutexDoNotUseDirectly = (mutex = new Object());
        }
      }
    }
    return mutex;
  }
  
  RateLimiter(SleepingStopwatch stopwatch)
  {
    this.stopwatch = ((SleepingStopwatch)Preconditions.checkNotNull(stopwatch));
  }
  
  public final void setRate(double permitsPerSecond)
  {
    Preconditions.checkArgument((permitsPerSecond > 0.0D) && (!Double.isNaN(permitsPerSecond)), "rate must be positive");
    synchronized (mutex())
    {
      doSetRate(permitsPerSecond, stopwatch.readMicros());
    }
  }
  
  abstract void doSetRate(double paramDouble, long paramLong);
  
  /* Error */
  public final double getRate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 99	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:mutex	()Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 112	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:doGetRate	()D
    //   11: aload_1
    //   12: monitorexit
    //   13: dreturn
    //   14: astore_2
    //   15: aload_1
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Line number table:
    //   Java source line #243	-> byte code offset #0
    //   Java source line #244	-> byte code offset #7
    //   Java source line #245	-> byte code offset #14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	19	0	this	RateLimiter
    //   5	11	1	Ljava/lang/Object;	Object
    //   14	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	13	14	finally
    //   14	17	14	finally
  }
  
  abstract double doGetRate();
  
  public double acquire()
  {
    return acquire(1);
  }
  
  public double acquire(int permits)
  {
    long microsToWait = reserve(permits);
    stopwatch.sleepMicrosUninterruptibly(microsToWait);
    return 1.0D * microsToWait / TimeUnit.SECONDS.toMicros(1L);
  }
  
  /* Error */
  final long reserve(int permits)
  {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic 140	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:checkPermits	(I)I
    //   4: pop
    //   5: aload_0
    //   6: invokespecial 99	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:mutex	()Ljava/lang/Object;
    //   9: dup
    //   10: astore_2
    //   11: monitorenter
    //   12: aload_0
    //   13: iload_1
    //   14: aload_0
    //   15: getfield 86	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:stopwatch	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter$SleepingStopwatch;
    //   18: invokevirtual 103	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter$SleepingStopwatch:readMicros	()J
    //   21: invokevirtual 144	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/RateLimiter:reserveAndGetWaitLength	(IJ)J
    //   24: aload_2
    //   25: monitorexit
    //   26: lreturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #285	-> byte code offset #0
    //   Java source line #286	-> byte code offset #5
    //   Java source line #287	-> byte code offset #12
    //   Java source line #288	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	RateLimiter
    //   0	32	1	permits	int
    //   10	19	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   12	26	27	finally
    //   27	30	27	finally
  }
  
  public boolean tryAcquire(long timeout, TimeUnit unit)
  {
    return tryAcquire(1, timeout, unit);
  }
  
  public boolean tryAcquire(int permits)
  {
    return tryAcquire(permits, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire()
  {
    return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int permits, long timeout, TimeUnit unit)
  {
    long timeoutMicros = Math.max(unit.toMicros(timeout), 0L);
    checkPermits(permits);
    long microsToWait;
    synchronized (mutex())
    {
      long nowMicros = stopwatch.readMicros();
      if (!canAcquire(nowMicros, timeoutMicros)) {
        return false;
      }
      microsToWait = reserveAndGetWaitLength(permits, nowMicros);
    }
    stopwatch.sleepMicrosUninterruptibly(microsToWait);
    return true;
  }
  
  private boolean canAcquire(long nowMicros, long timeoutMicros)
  {
    return queryEarliestAvailable(nowMicros) - timeoutMicros <= nowMicros;
  }
  
  final long reserveAndGetWaitLength(int permits, long nowMicros)
  {
    long momentAvailable = reserveEarliestAvailable(permits, nowMicros);
    return Math.max(momentAvailable - nowMicros, 0L);
  }
  
  abstract long queryEarliestAvailable(long paramLong);
  
  abstract long reserveEarliestAvailable(int paramInt, long paramLong);
  
  public String toString()
  {
    return String.format("RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(getRate()) });
  }
  
  @VisibleForTesting
  static abstract class SleepingStopwatch
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
  
  private static int checkPermits(int permits)
  {
    Preconditions.checkArgument(permits > 0, "Requested permits (%s) must be positive", new Object[] { Integer.valueOf(permits) });
    return permits;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.RateLimiter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */