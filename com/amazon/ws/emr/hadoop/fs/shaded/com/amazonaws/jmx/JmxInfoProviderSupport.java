package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.spi.JmxInfoProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.List;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class JmxInfoProviderSupport
  implements JmxInfoProvider
{
  public long[] getFileDecriptorInfo()
  {
    MBeanServer mbsc = MBeans.getMBeanServer();
    try
    {
      AttributeList attributes = mbsc.getAttributes(new ObjectName("java.lang:type=OperatingSystem"), new String[] { "OpenFileDescriptorCount", "MaxFileDescriptorCount" });
      
      List<Attribute> attrList = attributes.asList();
      long openFdCount = ((Long)((Attribute)attrList.get(0)).getValue()).longValue();
      long maxFdCount = ((Long)((Attribute)attrList.get(1)).getValue()).longValue();
      return new long[] { openFdCount, maxFdCount };
    }
    catch (Exception e)
    {
      LogFactory.getLog(SdkMBeanRegistrySupport.class).debug("Failed to retrieve file descriptor info", e);
    }
    return null;
  }
  
  public int getThreadCount()
  {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    return threadMXBean.getThreadCount();
  }
  
  public int getDaemonThreadCount()
  {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    return threadMXBean.getDaemonThreadCount();
  }
  
  public int getPeakThreadCount()
  {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    return threadMXBean.getPeakThreadCount();
  }
  
  public long getTotalStartedThreadCount()
  {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    return threadMXBean.getTotalStartedThreadCount();
  }
  
  public long[] findDeadlockedThreads()
  {
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    return threadMXBean.findDeadlockedThreads();
  }
  
  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.JmxInfoProviderSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */