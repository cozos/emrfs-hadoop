package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

public abstract interface InternalLogApi
{
  public abstract void debug(Object paramObject);
  
  public abstract void debug(Object paramObject, Throwable paramThrowable);
  
  public abstract void error(Object paramObject);
  
  public abstract void error(Object paramObject, Throwable paramThrowable);
  
  public abstract void fatal(Object paramObject);
  
  public abstract void fatal(Object paramObject, Throwable paramThrowable);
  
  public abstract void info(Object paramObject);
  
  public abstract void info(Object paramObject, Throwable paramThrowable);
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isErrorEnabled();
  
  public abstract boolean isFatalEnabled();
  
  public abstract boolean isInfoEnabled();
  
  public abstract boolean isTraceEnabled();
  
  public abstract boolean isWarnEnabled();
  
  public abstract void trace(Object paramObject);
  
  public abstract void trace(Object paramObject, Throwable paramThrowable);
  
  public abstract void warn(Object paramObject);
  
  public abstract void warn(Object paramObject, Throwable paramThrowable);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */