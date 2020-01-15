package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonIgnore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

class S3Link$ID
{
  @JsonProperty("s3")
  private S3Link.S3 s3;
  
  S3Link$ID() {}
  
  S3Link$ID(String bucketName, String key)
  {
    s3 = new S3Link.S3(bucketName, key);
  }
  
  S3Link$ID(String region, String bucketName, String key)
  {
    s3 = new S3Link.S3(region, bucketName, key);
  }
  
  S3Link$ID(S3Link.S3 s3)
  {
    this.s3 = s3;
  }
  
  @JsonProperty("s3")
  public S3Link.S3 getS3()
  {
    return s3;
  }
  
  @JsonIgnore
  public String getRegionId()
  {
    return s3.getRegionId();
  }
  
  @JsonIgnore
  public String getBucket()
  {
    return s3.getBucket();
  }
  
  @JsonIgnore
  public String getKey()
  {
    return s3.getKey();
  }
  
  String toJson()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link.ID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */