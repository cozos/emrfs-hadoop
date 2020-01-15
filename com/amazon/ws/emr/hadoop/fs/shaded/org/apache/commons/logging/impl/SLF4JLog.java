package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLog
  implements Log, Serializable
{
  private static final long serialVersionUID = 680728617011167209L;
  protected String name;
  private transient Logger logger;
  
  SLF4JLog(Logger logger)
  {
    this.logger = logger;
    name = logger.getName();
  }
  
  public boolean isDebugEnabled()
  {
    return logger.isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return logger.isErrorEnabled();
  }
  
  public boolean isFatalEnabled()
  {
    return logger.isErrorEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return logger.isInfoEnabled();
  }
  
  public boolean isTraceEnabled()
  {
    return logger.isTraceEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return logger.isWarnEnabled();
  }
  
  public void trace(Object message)
  {
    logger.trace(String.valueOf(message));
  }
  
  public void trace(Object message, Throwable t)
  {
    logger.trace(String.valueOf(message), t);
  }
  
  public void debug(Object message)
  {
    logger.debug(String.valueOf(message));
  }
  
  public void debug(Object message, Throwable t)
  {
    logger.debug(String.valueOf(message), t);
  }
  
  public void info(Object message)
  {
    logger.info(String.valueOf(message));
  }
  
  public void info(Object message, Throwable t)
  {
    logger.info(String.valueOf(message), t);
  }
  
  public void warn(Object message)
  {
    logger.warn(String.valueOf(message));
  }
  
  public void warn(Object message, Throwable t)
  {
    logger.warn(String.valueOf(message), t);
  }
  
  public void error(Object message)
  {
    logger.error(String.valueOf(message));
  }
  
  public void error(Object message, Throwable t)
  {
    logger.error(String.valueOf(message), t);
  }
  
  public void fatal(Object message)
  {
    logger.error(String.valueOf(message));
  }
  
  public void fatal(Object message, Throwable t)
  {
    logger.error(String.valueOf(message), t);
  }
  
  protected Object readResolve()
    throws ObjectStreamException
  {
    Logger logger = LoggerFactory.getLogger(name);
    return new SLF4JLog(logger);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl.SLF4JLog
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */