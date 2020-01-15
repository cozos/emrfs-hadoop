package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsS3BucketDestination
  implements Serializable
{
  private String format;
  private String bucketAccountId;
  private String bucketArn;
  private String prefix;
  
  public void setFormat(AnalyticsS3ExportFileFormat format)
  {
    if (format == null) {
      setFormat((String)null);
    } else {
      setFormat(format.toString());
    }
  }
  
  public AnalyticsS3BucketDestination withFormat(AnalyticsS3ExportFileFormat format)
  {
    setFormat(format);
    return this;
  }
  
  public String getFormat()
  {
    return format;
  }
  
  public void setFormat(String format)
  {
    this.format = format;
  }
  
  public AnalyticsS3BucketDestination withFormat(String format)
  {
    setFormat(format);
    return this;
  }
  
  public String getBucketAccountId()
  {
    return bucketAccountId;
  }
  
  public void setBucketAccountId(String bucketAccountId)
  {
    this.bucketAccountId = bucketAccountId;
  }
  
  public AnalyticsS3BucketDestination withBucketAccountId(String bucketAccountId)
  {
    setBucketAccountId(bucketAccountId);
    return this;
  }
  
  public String getBucketArn()
  {
    return bucketArn;
  }
  
  public void setBucketArn(String bucketArn)
  {
    this.bucketArn = bucketArn;
  }
  
  public AnalyticsS3BucketDestination withBucketArn(String bucketArn)
  {
    setBucketArn(bucketArn);
    return this;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public AnalyticsS3BucketDestination withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */