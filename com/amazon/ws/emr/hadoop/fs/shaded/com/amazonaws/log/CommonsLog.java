package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;

public class CommonsLog
  implements InternalLogApi
{
  private final Log log;
  
  CommonsLog(Log log)
  {
    this.log = log;
  }
  
  public void debug(Object message)
  {
    log.debug(message);
  }
  
  public void debug(Object message, Throwable t)
  {
    log.debug(message, t);
  }
  
  public void error(Object message)
  {
    log.error(message);
  }
  
  public void error(Object message, Throwable t)
  {
    log.error(message, t);
  }
  
  public void fatal(Object message)
  {
    log.fatal(message);
  }
  
  public void fatal(Object message, Throwable t)
  {
    log.fatal(message, t);
  }
  
  public void info(Object message)
  {
    log.info(message);
  }
  
  public void info(Object message, Throwable t)
  {
    log.info(message, t);
  }
  
  public boolean isDebugEnabled()
  {
    return log.isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return log.isErrorEnabled();
  }
  
  public boolean isFatalEnabled()
  {
    return log.isFatalEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return log.isInfoEnabled();
  }
  
  public boolean isTraceEnabled()
  {
    return log.isTraceEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return log.isWarnEnabled();
  }
  
  public void trace(Object message)
  {
    log.trace(message);
  }
  
  public void trace(Object message, Throwable t)
  {
    log.trace(message, t);
  }
  
  public void warn(Object message)
  {
    log.warn(message);
  }
  
  public void warn(Object message, Throwable t)
  {
    log.warn(message, t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.CommonsLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */