package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$S3Entity
{
  private final String configurationId;
  private final S3EventNotification.S3BucketEntity bucket;
  private final S3EventNotification.S3ObjectEntity object;
  private final String s3SchemaVersion;
  
  @JsonCreator
  public S3EventNotification$S3Entity(@JsonProperty("configurationId") String configurationId, @JsonProperty("bucket") S3EventNotification.S3BucketEntity bucket, @JsonProperty("object") S3EventNotification.S3ObjectEntity object, @JsonProperty("s3SchemaVersion") String s3SchemaVersion)
  {
    this.configurationId = configurationId;
    this.bucket = bucket;
    this.object = object;
    this.s3SchemaVersion = s3SchemaVersion;
  }
  
  public String getConfigurationId()
  {
    return configurationId;
  }
  
  public S3EventNotification.S3BucketEntity getBucket()
  {
    return bucket;
  }
  
  public S3EventNotification.S3ObjectEntity getObject()
  {
    return object;
  }
  
  public String getS3SchemaVersion()
  {
    return s3SchemaVersion;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.S3Entity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */