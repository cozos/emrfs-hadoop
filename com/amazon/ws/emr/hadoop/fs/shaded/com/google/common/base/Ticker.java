package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public abstract class Ticker
{
  public abstract long read();
  
  public static Ticker systemTicker()
  {
    return SYSTEM_TICKER;
  }
  
  private static final Ticker SYSTEM_TICKER = new Ticker()
  {
    public long read()
    {
      return Platform.systemNanoTime();
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */