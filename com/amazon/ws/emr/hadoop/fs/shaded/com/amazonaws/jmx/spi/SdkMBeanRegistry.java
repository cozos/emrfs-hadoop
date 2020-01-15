package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public abstract interface SdkMBeanRegistry
{
  public abstract boolean registerMetricAdminMBean(String paramString);
  
  public abstract boolean unregisterMBean(String paramString);
  
  public abstract boolean isMBeanRegistered(String paramString);
  
  public static class Factory
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
  
  public static final SdkMBeanRegistry NONE = new SdkMBeanRegistry()
  {
    public boolean registerMetricAdminMBean(String objectName)
    {
      return false;
    }
    
    public boolean unregisterMBean(String objectName)
    {
      return false;
    }
    
    public boolean isMBeanRegistered(String objectName)
    {
      return false;
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.SdkMBeanRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */