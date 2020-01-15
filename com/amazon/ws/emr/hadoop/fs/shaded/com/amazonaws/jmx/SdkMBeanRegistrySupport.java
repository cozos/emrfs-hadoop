package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.SdkMBeanRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricAdmin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public class SdkMBeanRegistrySupport
  implements SdkMBeanRegistry
{
  public boolean registerMetricAdminMBean(String objectName)
  {
    try
    {
      return MBeans.registerMBean(objectName, new MetricAdmin());
    }
    catch (Exception ex)
    {
      LogFactory.getLog(SdkMBeanRegistrySupport.class).warn("", ex);
    }
    return false;
  }
  
  public boolean unregisterMBean(String objectName)
  {
    try
    {
      return MBeans.unregisterMBean(objectName);
    }
    catch (Exception ex)
    {
      LogFactory.getLog(SdkMBeanRegistrySupport.class).warn("", ex);
    }
    return false;
  }
  
  public boolean isMBeanRegistered(String objectName)
  {
    return MBeans.isRegistered(objectName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.SdkMBeanRegistrySupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */