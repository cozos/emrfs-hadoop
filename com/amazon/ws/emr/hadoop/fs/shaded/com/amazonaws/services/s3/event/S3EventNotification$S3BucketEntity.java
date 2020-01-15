package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$S3BucketEntity
{
  private final String name;
  private final S3EventNotification.UserIdentityEntity ownerIdentity;
  private final String arn;
  
  @JsonCreator
  public S3EventNotification$S3BucketEntity(@JsonProperty("name") String name, @JsonProperty("ownerIdentity") S3EventNotification.UserIdentityEntity ownerIdentity, @JsonProperty("arn") String arn)
  {
    this.name = name;
    this.ownerIdentity = ownerIdentity;
    this.arn = arn;
  }
  
  public String getName()
  {
    return name;
  }
  
  public S3EventNotification.UserIdentityEntity getOwnerIdentity()
  {
    return ownerIdentity;
  }
  
  public String getArn()
  {
    return arn;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.S3BucketEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */