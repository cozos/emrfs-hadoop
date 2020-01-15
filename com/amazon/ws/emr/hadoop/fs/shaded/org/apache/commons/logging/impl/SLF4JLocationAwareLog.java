package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class SLF4JLocationAwareLog
  implements Log, Serializable
{
  private static final long serialVersionUID = -2379157579039314822L;
  protected String name;
  private transient LocationAwareLogger logger;
  private static final String FQCN = SLF4JLocationAwareLog.class.getName();
  
  SLF4JLocationAwareLog(LocationAwareLogger logger)
  {
    this.logger = logger;
    name = logger.getName();
  }
  
  public boolean isTraceEnabled()
  {
    return logger.isTraceEnabled();
  }
  
  public boolean isDebugEnabled()
  {
    return logger.isDebugEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return logger.isInfoEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return logger.isWarnEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return logger.isErrorEnabled();
  }
  
  public boolean isFatalEnabled()
  {
    return logger.isErrorEnabled();
  }
  
  public void trace(Object message)
  {
    logger.log(null, FQCN, 0, String.valueOf(message), null, null);
  }
  
  public void trace(Object message, Throwable t)
  {
    logger.log(null, FQCN, 0, String.valueOf(message), null, t);
  }
  
  public void debug(Object message)
  {
    logger.log(null, FQCN, 10, String.valueOf(message), null, null);
  }
  
  public void debug(Object message, Throwable t)
  {
    logger.log(null, FQCN, 10, String.valueOf(message), null, t);
  }
  
  public void info(Object message)
  {
    logger.log(null, FQCN, 20, String.valueOf(message), null, null);
  }
  
  public void info(Object message, Throwable t)
  {
    logger.log(null, FQCN, 20, String.valueOf(message), null, t);
  }
  
  public void warn(Object message)
  {
    logger.log(null, FQCN, 30, String.valueOf(message), null, null);
  }
  
  public void warn(Object message, Throwable t)
  {
    logger.log(null, FQCN, 30, String.valueOf(message), null, t);
  }
  
  public void error(Object message)
  {
    logger.log(null, FQCN, 40, String.valueOf(message), null, null);
  }
  
  public void error(Object message, Throwable t)
  {
    logger.log(null, FQCN, 40, String.valueOf(message), null, t);
  }
  
  public void fatal(Object message)
  {
    logger.log(null, FQCN, 40, String.valueOf(message), null, null);
  }
  
  public void fatal(Object message, Throwable t)
  {
    logger.log(null, FQCN, 40, String.valueOf(message), null, t);
  }
  
  protected Object readResolve()
    throws ObjectStreamException
  {
    Logger logger = LoggerFactory.getLogger(name);
    return new SLF4JLocationAwareLog((LocationAwareLogger)logger);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl.SLF4JLocationAwareLog
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */