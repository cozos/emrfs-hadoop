package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.logging.Logger;

public final class $Stopwatch
{
  private static final Logger logger = Logger.getLogger(Stopwatch.class.getName());
  private long start = System.currentTimeMillis();
  
  public long reset()
  {
    long now = System.currentTimeMillis();
    try
    {
      return now - start;
    }
    finally
    {
      start = now;
    }
  }
  
  public void resetAndLog(String label)
  {
    logger.fine(label + ": " + reset() + "ms");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Stopwatch
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */