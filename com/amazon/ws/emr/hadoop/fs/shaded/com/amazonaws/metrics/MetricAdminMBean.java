package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract interface MetricAdminMBean
{
  public abstract boolean isMetricsEnabled();
  
  public abstract String getRequestMetricCollector();
  
  public abstract String getServiceMetricCollector();
  
  public abstract boolean enableDefaultMetrics();
  
  public abstract void disableMetrics();
  
  public abstract boolean isMachineMetricsExcluded();
  
  public abstract void setMachineMetricsExcluded(boolean paramBoolean);
  
  public abstract boolean isPerHostMetricsIncluded();
  
  public abstract void setPerHostMetricsIncluded(boolean paramBoolean);
  
  public abstract String getRegion();
  
  public abstract void setRegion(String paramString);
  
  public abstract String getCredentialFile();
  
  public abstract void setCredentialFile(String paramString)
    throws FileNotFoundException, IOException;
  
  public abstract Integer getMetricQueueSize();
  
  public abstract void setMetricQueueSize(Integer paramInteger);
  
  public abstract Integer getQueuePollTimeoutMilli();
  
  public abstract void setQueuePollTimeoutMilli(Integer paramInteger);
  
  public abstract String getMetricNameSpace();
  
  public abstract void setMetricNameSpace(String paramString);
  
  public abstract String getJvmMetricName();
  
  public abstract void setJvmMetricName(String paramString);
  
  public abstract String getHostMetricName();
  
  public abstract void setHostMetricName(String paramString);
  
  public abstract boolean isSingleMetricNamespace();
  
  public abstract void setSingleMetricNamespace(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricAdminMBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */