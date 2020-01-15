package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public abstract class InternalLogFactory
{
  private static volatile InternalLogFactory factory = new JulLogFactory();
  private static volatile boolean factoryConfigured;
  
  public static InternalLogApi getLog(Class<?> clazz)
  {
    return factoryConfigured ? factory
      .doGetLog(clazz) : new InternalLog(clazz
      .getName());
  }
  
  public static InternalLogApi getLog(String name)
  {
    return factoryConfigured ? factory
      .doGetLog(name) : new InternalLog(name);
  }
  
  protected abstract InternalLogApi doGetLog(Class<?> paramClass);
  
  protected abstract InternalLogApi doGetLog(String paramString);
  
  public static InternalLogFactory getFactory()
  {
    return factory;
  }
  
  public static synchronized boolean configureFactory(InternalLogFactory factory)
  {
    if (factory == null) {
      throw new IllegalArgumentException();
    }
    if (factoryConfigured) {
      return false;
    }
    factory = factory;
    factoryConfigured = true;
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */