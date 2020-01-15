package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ThroughputMetricType;

abstract class S3ServiceMetric$S3ThroughputMetric
  extends S3ServiceMetric
  implements ThroughputMetricType
{
  private S3ServiceMetric$S3ThroughputMetric(String name)
  {
    super(name, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics.S3ServiceMetric.S3ThroughputMetric
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */