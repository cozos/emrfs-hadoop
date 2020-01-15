package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MetricAdmin
  implements MetricAdminMBean
{
  public boolean enableDefaultMetrics()
  {
    return AwsSdkMetrics.enableDefaultMetrics();
  }
  
  public void disableMetrics() {}
  
  public String getRequestMetricCollector()
  {
    MetricCollector mc = AwsSdkMetrics.getInternalMetricCollector();
    RequestMetricCollector rmc = mc == null ? null : mc.getRequestMetricCollector();
    return (mc == null) || (rmc == RequestMetricCollector.NONE) ? "NONE" : rmc
    
      .getClass().getName();
  }
  
  public String getServiceMetricCollector()
  {
    MetricCollector mc = AwsSdkMetrics.getInternalMetricCollector();
    ServiceMetricCollector smc = mc == null ? null : mc.getServiceMetricCollector();
    return (mc == null) || (smc == ServiceMetricCollector.NONE) ? "NONE" : smc
    
      .getClass().getName();
  }
  
  public boolean isMetricsEnabled()
  {
    return AwsSdkMetrics.isMetricsEnabled();
  }
  
  public boolean isMachineMetricsExcluded()
  {
    return AwsSdkMetrics.isMachineMetricExcluded();
  }
  
  public void setMachineMetricsExcluded(boolean excludeJvmMetrics)
  {
    AwsSdkMetrics.setMachineMetricsExcluded(excludeJvmMetrics);
  }
  
  public String getRegion()
  {
    return AwsSdkMetrics.getRegionName();
  }
  
  public void setRegion(String region)
  {
    AwsSdkMetrics.setRegion(region);
  }
  
  public Integer getMetricQueueSize()
  {
    return AwsSdkMetrics.getMetricQueueSize();
  }
  
  public void setMetricQueueSize(Integer metricQueueSize)
  {
    AwsSdkMetrics.setMetricQueueSize(metricQueueSize);
  }
  
  public Integer getQueuePollTimeoutMilli()
  {
    Long queuePollTimeoutMilli = AwsSdkMetrics.getQueuePollTimeoutMilli();
    return queuePollTimeoutMilli == null ? null : Integer.valueOf(queuePollTimeoutMilli.intValue());
  }
  
  public void setQueuePollTimeoutMilli(Integer timeoutMilli)
  {
    AwsSdkMetrics.setQueuePollTimeoutMilli(timeoutMilli == null ? null : Long.valueOf(timeoutMilli.longValue()));
  }
  
  public String getMetricNameSpace()
  {
    return AwsSdkMetrics.getMetricNameSpace();
  }
  
  public void setMetricNameSpace(String metricNameSpace)
  {
    AwsSdkMetrics.setMetricNameSpace(metricNameSpace);
  }
  
  public boolean isPerHostMetricsIncluded()
  {
    return AwsSdkMetrics.isPerHostMetricIncluded();
  }
  
  public void setPerHostMetricsIncluded(boolean includePerHostMetrics)
  {
    AwsSdkMetrics.setPerHostMetricsIncluded(includePerHostMetrics);
  }
  
  public String getJvmMetricName()
  {
    return AwsSdkMetrics.getJvmMetricName();
  }
  
  public void setJvmMetricName(String jvmMetricName)
  {
    AwsSdkMetrics.setJvmMetricName(jvmMetricName);
  }
  
  public String getHostMetricName()
  {
    return AwsSdkMetrics.getHostMetricName();
  }
  
  public void setHostMetricName(String hostMetricName)
  {
    AwsSdkMetrics.setHostMetricName(hostMetricName);
  }
  
  public String getCredentialFile()
  {
    return AwsSdkMetrics.getCredentialFile();
  }
  
  public void setCredentialFile(String filepath)
    throws FileNotFoundException, IOException
  {
    AwsSdkMetrics.setCredentialFile(filepath);
  }
  
  public boolean isSingleMetricNamespace()
  {
    return AwsSdkMetrics.isSingleMetricNamespace();
  }
  
  public void setSingleMetricNamespace(boolean singleMetricNamespace)
  {
    AwsSdkMetrics.setSingleMetricNamespace(singleMetricNamespace);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricAdmin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */