package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public class SdkMBeanRegistry$Factory
{
  private static final SdkMBeanRegistry registry;
  
  static
  {
    SdkMBeanRegistry rego;
    try
    {
      Class<?> c = Class.forName("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.SdkMBeanRegistrySupport");
      rego = (SdkMBeanRegistry)c.newInstance();
    }
    catch (Exception e)
    {
      SdkMBeanRegistry rego;
      LogFactory.getLog(SdkMBeanRegistry.class).debug("Failed to load the JMX implementation module - JMX is disabled", e);
      rego = SdkMBeanRegistry.NONE;
    }
    registry = rego;
  }
  
  public static SdkMBeanRegistry getMBeanRegistry()
  {
    return registry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.SdkMBeanRegistry.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */