package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricType;

final class S3ServiceMetric$1
  extends S3ServiceMetric.S3ThroughputMetric
{
  S3ServiceMetric$1(String name)
  {
    super(name, null);
  }
  
  public ServiceMetricType getByteCountMetricType()
  {
    return S3DownloadByteCount;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics.S3ServiceMetric.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */