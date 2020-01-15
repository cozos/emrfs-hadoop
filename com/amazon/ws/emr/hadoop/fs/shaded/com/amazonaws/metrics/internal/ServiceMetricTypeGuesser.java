package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ThroughputMetricType;

public enum ServiceMetricTypeGuesser
{
  private ServiceMetricTypeGuesser() {}
  
  public static ThroughputMetricType guessThroughputMetricType(Request<?> req, String metricNameSuffix, String byteCountMetricNameSuffix)
  {
    if (!AwsSdkMetrics.isMetricsEnabled()) {
      return null;
    }
    Object orig = req.getOriginalRequestObject();
    if (orig.getClass().getName().startsWith("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3")) {
      return new SimpleThroughputMetricType("S3" + metricNameSuffix, req
      
        .getServiceName(), "S3" + byteCountMetricNameSuffix);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.internal.ServiceMetricTypeGuesser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */