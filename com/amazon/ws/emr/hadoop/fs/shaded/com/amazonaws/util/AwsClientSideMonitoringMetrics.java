package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricType;

public enum AwsClientSideMonitoringMetrics
  implements RequestMetricType
{
  ApiCallLatency,  MaxRetriesExceeded;
  
  private AwsClientSideMonitoringMetrics() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsClientSideMonitoringMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */