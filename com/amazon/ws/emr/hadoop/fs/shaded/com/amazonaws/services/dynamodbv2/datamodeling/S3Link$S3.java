package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

class S3Link$S3
{
  @JsonProperty("bucket")
  private String bucket;
  @JsonProperty("key")
  private String key;
  @JsonProperty("region")
  private String regionId;
  
  S3Link$S3() {}
  
  S3Link$S3(String bucket, String key)
  {
    this(null, bucket, key);
  }
  
  S3Link$S3(String region, String bucket, String key)
  {
    regionId = region;
    this.bucket = bucket;
    this.key = key;
  }
  
  @JsonProperty("bucket")
  public String getBucket()
  {
    return bucket;
  }
  
  @JsonProperty("key")
  public String getKey()
  {
    return key;
  }
  
  @JsonProperty("region")
  public String getRegionId()
  {
    return regionId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link.S3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */