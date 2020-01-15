package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public final class CommonsLogFactory
  extends InternalLogFactory
{
  protected InternalLogApi doGetLog(Class<?> clazz)
  {
    return new CommonsLog(
      LogFactory.getLog(clazz));
  }
  
  protected InternalLogApi doGetLog(String name)
  {
    return new CommonsLog(
      LogFactory.getLog(name));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.CommonsLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */