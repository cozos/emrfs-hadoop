package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public abstract interface JmxInfoProvider
{
  public abstract long[] getFileDecriptorInfo();
  
  public abstract int getThreadCount();
  
  public abstract int getDaemonThreadCount();
  
  public abstract int getPeakThreadCount();
  
  public abstract long getTotalStartedThreadCount();
  
  public abstract long[] findDeadlockedThreads();
  
  public abstract boolean isEnabled();
  
  public static class Factory
  {
    private static final JmxInfoProvider provider;
    
    static
    {
      JmxInfoProvider p;
      try
      {
        Class<?> c = Class.forName("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.JmxInfoProviderSupport");
        p = (JmxInfoProvider)c.newInstance();
      }
      catch (Exception e)
      {
        JmxInfoProvider p;
        LogFactory.getLog(JmxInfoProvider.class).debug("Failed to load the JMX implementation module - JMX is disabled", e);
        p = JmxInfoProvider.NONE;
      }
      provider = p;
    }
    
    public static JmxInfoProvider getJmxInfoProvider()
    {
      return provider;
    }
  }
  
  public static final JmxInfoProvider NONE = new JmxInfoProvider()
  {
    public long[] getFileDecriptorInfo()
    {
      return null;
    }
    
    public int getThreadCount()
    {
      return 0;
    }
    
    public int getDaemonThreadCount()
    {
      return 0;
    }
    
    public int getPeakThreadCount()
    {
      return 0;
    }
    
    public long getTotalStartedThreadCount()
    {
      return 0L;
    }
    
    public long[] findDeadlockedThreads()
    {
      return null;
    }
    
    public boolean isEnabled()
    {
      return false;
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.JmxInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */