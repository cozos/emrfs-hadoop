package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricType;

public enum AWSServiceMetrics
  implements ServiceMetricType
{
  HttpClientGetConnectionTime("HttpClient");
  
  private final String serviceName;
  
  private AWSServiceMetrics(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSServiceMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */