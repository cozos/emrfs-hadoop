package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

import java.util.logging.Logger;

public final class JulLogFactory
  extends InternalLogFactory
{
  protected InternalLogApi doGetLog(Class<?> clazz)
  {
    return new JulLog(Logger.getLogger(clazz.getName()));
  }
  
  protected InternalLogApi doGetLog(String name)
  {
    return new JulLog(Logger.getLogger(name));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.JulLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */