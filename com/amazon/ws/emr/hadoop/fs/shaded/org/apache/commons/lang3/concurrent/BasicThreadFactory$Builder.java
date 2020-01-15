package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.Builder;
import java.util.concurrent.ThreadFactory;

public class BasicThreadFactory$Builder
  implements Builder<BasicThreadFactory>
{
  private ThreadFactory wrappedFactory;
  private Thread.UncaughtExceptionHandler exceptionHandler;
  private String namingPattern;
  private Integer priority;
  private Boolean daemonFlag;
  
  public Builder wrappedFactory(ThreadFactory factory)
  {
    if (factory == null) {
      throw new NullPointerException("Wrapped ThreadFactory must not be null!");
    }
    wrappedFactory = factory;
    return this;
  }
  
  public Builder namingPattern(String pattern)
  {
    if (pattern == null) {
      throw new NullPointerException("Naming pattern must not be null!");
    }
    namingPattern = pattern;
    return this;
  }
  
  public Builder daemon(boolean f)
  {
    daemonFlag = Boolean.valueOf(f);
    return this;
  }
  
  public Builder priority(int prio)
  {
    priority = Integer.valueOf(prio);
    return this;
  }
  
  public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler handler)
  {
    if (handler == null) {
      throw new NullPointerException("Uncaught exception handler must not be null!");
    }
    exceptionHandler = handler;
    return this;
  }
  
  public void reset()
  {
    wrappedFactory = null;
    exceptionHandler = null;
    namingPattern = null;
    priority = null;
    daemonFlag = null;
  }
  
  public BasicThreadFactory build()
  {
    BasicThreadFactory factory = new BasicThreadFactory(this, null);
    reset();
    return factory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.BasicThreadFactory.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */