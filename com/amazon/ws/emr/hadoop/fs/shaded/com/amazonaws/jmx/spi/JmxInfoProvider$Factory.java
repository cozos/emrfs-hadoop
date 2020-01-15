package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public class JmxInfoProvider$Factory
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.JmxInfoProvider.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */