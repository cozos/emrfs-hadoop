package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsExportDestination
  implements Serializable
{
  private AnalyticsS3BucketDestination s3BucketDestination;
  
  public AnalyticsS3BucketDestination getS3BucketDestination()
  {
    return s3BucketDestination;
  }
  
  public void setS3BucketDestination(AnalyticsS3BucketDestination s3BucketDestination)
  {
    this.s3BucketDestination = s3BucketDestination;
  }
  
  public AnalyticsExportDestination withS3BucketDestination(AnalyticsS3BucketDestination s3BucketDestination)
  {
    setS3BucketDestination(s3BucketDestination);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */