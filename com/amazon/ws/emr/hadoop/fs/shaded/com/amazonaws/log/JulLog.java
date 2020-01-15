package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

import java.util.logging.Level;
import java.util.logging.Logger;

final class JulLog
  implements InternalLogApi
{
  private final Logger log;
  
  JulLog(Logger logger)
  {
    log = logger;
  }
  
  public void debug(Object message)
  {
    log.log(Level.FINE, String.valueOf(message));
  }
  
  public void debug(Object message, Throwable t)
  {
    log.log(Level.FINE, String.valueOf(message), t);
  }
  
  public void error(Object message)
  {
    log.log(Level.SEVERE, String.valueOf(message));
  }
  
  public void error(Object message, Throwable t)
  {
    log.log(Level.SEVERE, String.valueOf(message), t);
  }
  
  public void fatal(Object message)
  {
    log.log(Level.SEVERE, String.valueOf(message));
  }
  
  public void fatal(Object message, Throwable t)
  {
    log.log(Level.SEVERE, String.valueOf(message), t);
  }
  
  public void info(Object message)
  {
    log.log(Level.INFO, String.valueOf(message));
  }
  
  public void info(Object message, Throwable t)
  {
    log.log(Level.INFO, String.valueOf(message), t);
  }
  
  public boolean isDebugEnabled()
  {
    return log.isLoggable(Level.FINE);
  }
  
  public boolean isErrorEnabled()
  {
    return log.isLoggable(Level.SEVERE);
  }
  
  public boolean isFatalEnabled()
  {
    return log.isLoggable(Level.SEVERE);
  }
  
  public boolean isInfoEnabled()
  {
    return log.isLoggable(Level.INFO);
  }
  
  public boolean isTraceEnabled()
  {
    return log.isLoggable(Level.FINER);
  }
  
  public boolean isWarnEnabled()
  {
    return log.isLoggable(Level.WARNING);
  }
  
  public void trace(Object message)
  {
    log.log(Level.FINER, String.valueOf(message));
  }
  
  public void trace(Object message, Throwable t)
  {
    log.log(Level.FINER, String.valueOf(message), t);
  }
  
  public void warn(Object message)
  {
    log.log(Level.WARNING, String.valueOf(message));
  }
  
  public void warn(Object message, Throwable t)
  {
    log.log(Level.WARNING, String.valueOf(message), t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.JulLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */