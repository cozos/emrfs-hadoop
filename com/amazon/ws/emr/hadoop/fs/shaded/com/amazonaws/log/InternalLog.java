package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

class InternalLog
  implements InternalLogApi
{
  private final String name;
  
  InternalLog(String name)
  {
    this.name = name;
  }
  
  private InternalLogApi logger()
  {
    return InternalLogFactory.getFactory().doGetLog(name);
  }
  
  public void debug(Object message)
  {
    logger().debug(message);
  }
  
  public void debug(Object message, Throwable t)
  {
    logger().debug(message, t);
  }
  
  public void error(Object message)
  {
    logger().error(message);
  }
  
  public void error(Object message, Throwable t)
  {
    logger().error(message, t);
  }
  
  public void fatal(Object message)
  {
    logger().fatal(message);
  }
  
  public void fatal(Object message, Throwable t)
  {
    logger().fatal(message, t);
  }
  
  public void info(Object message)
  {
    logger().info(message);
  }
  
  public void info(Object message, Throwable t)
  {
    logger().info(message, t);
  }
  
  public boolean isDebugEnabled()
  {
    return logger().isDebugEnabled();
  }
  
  public boolean isErrorEnabled()
  {
    return logger().isErrorEnabled();
  }
  
  public boolean isFatalEnabled()
  {
    return logger().isFatalEnabled();
  }
  
  public boolean isInfoEnabled()
  {
    return logger().isInfoEnabled();
  }
  
  public boolean isTraceEnabled()
  {
    return logger().isTraceEnabled();
  }
  
  public boolean isWarnEnabled()
  {
    return logger().isWarnEnabled();
  }
  
  public void trace(Object message)
  {
    logger().trace(message);
  }
  
  public void trace(Object message, Throwable t)
  {
    logger().trace(message, t);
  }
  
  public void warn(Object message)
  {
    logger().warn(message);
  }
  
  public void warn(Object message, Throwable t)
  {
    logger().warn(message, t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */