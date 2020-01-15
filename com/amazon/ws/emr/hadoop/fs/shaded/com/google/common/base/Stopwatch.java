package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.TimeUnit;

@Beta
@GwtCompatible(emulated=true)
public final class Stopwatch
{
  private final Ticker ticker;
  private boolean isRunning;
  private long elapsedNanos;
  private long startTick;
  
  public static Stopwatch createUnstarted()
  {
    return new Stopwatch();
  }
  
  public static Stopwatch createUnstarted(Ticker ticker)
  {
    return new Stopwatch(ticker);
  }
  
  public static Stopwatch createStarted()
  {
    return new Stopwatch().start();
  }
  
  public static Stopwatch createStarted(Ticker ticker)
  {
    return new Stopwatch(ticker).start();
  }
  
  @Deprecated
  Stopwatch()
  {
    this(Ticker.systemTicker());
  }
  
  @Deprecated
  Stopwatch(Ticker ticker)
  {
    this.ticker = ((Ticker)Preconditions.checkNotNull(ticker, "ticker"));
  }
  
  public boolean isRunning()
  {
    return isRunning;
  }
  
  public Stopwatch start()
  {
    Preconditions.checkState(!isRunning, "This stopwatch is already running.");
    isRunning = true;
    startTick = ticker.read();
    return this;
  }
  
  public Stopwatch stop()
  {
    long tick = ticker.read();
    Preconditions.checkState(isRunning, "This stopwatch is already stopped.");
    isRunning = false;
    elapsedNanos += tick - startTick;
    return this;
  }
  
  public Stopwatch reset()
  {
    elapsedNanos = 0L;
    isRunning = false;
    return this;
  }
  
  private long elapsedNanos()
  {
    return isRunning ? ticker.read() - startTick + elapsedNanos : elapsedNanos;
  }
  
  public long elapsed(TimeUnit desiredUnit)
  {
    return desiredUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }
  
  @GwtIncompatible("String.format()")
  public String toString()
  {
    long nanos = elapsedNanos();
    
    TimeUnit unit = chooseUnit(nanos);
    double value = nanos / TimeUnit.NANOSECONDS.convert(1L, unit);
    
    return String.format("%.4g %s", new Object[] { Double.valueOf(value), abbreviate(unit) });
  }
  
  private static TimeUnit chooseUnit(long nanos)
  {
    if (TimeUnit.DAYS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.DAYS;
    }
    if (TimeUnit.HOURS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.HOURS;
    }
    if (TimeUnit.MINUTES.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MINUTES;
    }
    if (TimeUnit.SECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.SECONDS;
    }
    if (TimeUnit.MILLISECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MILLISECONDS;
    }
    if (TimeUnit.MICROSECONDS.convert(nanos, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MICROSECONDS;
    }
    return TimeUnit.NANOSECONDS;
  }
  
  private static String abbreviate(TimeUnit unit)
  {
    switch (unit)
    {
    case NANOSECONDS: 
      return "ns";
    case MICROSECONDS: 
      return "μs";
    case MILLISECONDS: 
      return "ms";
    case SECONDS: 
      return "s";
    case MINUTES: 
      return "min";
    case HOURS: 
      return "h";
    case DAYS: 
      return "d";
    }
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */