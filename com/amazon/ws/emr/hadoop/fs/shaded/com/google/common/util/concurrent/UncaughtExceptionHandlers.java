package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class UncaughtExceptionHandlers
{
  public static Thread.UncaughtExceptionHandler systemExit()
  {
    return new Exiter(Runtime.getRuntime());
  }
  
  @VisibleForTesting
  static final class Exiter
    implements Thread.UncaughtExceptionHandler
  {
    private static final Logger logger = Logger.getLogger(Exiter.class.getName());
    private final Runtime runtime;
    
    Exiter(Runtime runtime)
    {
      this.runtime = runtime;
    }
    
    public void uncaughtException(Thread t, Throwable e)
    {
      try
      {
        logger.log(Level.SEVERE, String.format("Caught an exception in %s.  Shutting down.", new Object[] { t }), e);
      }
      catch (Throwable errorInLogging)
      {
        System.err.println(e.getMessage());
        System.err.println(errorInLogging.getMessage());
      }
      finally
      {
        runtime.exit(1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncaughtExceptionHandlers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */