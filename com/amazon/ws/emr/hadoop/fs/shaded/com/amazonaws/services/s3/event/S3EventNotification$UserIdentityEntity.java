package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$UserIdentityEntity
{
  private final String principalId;
  
  @JsonCreator
  public S3EventNotification$UserIdentityEntity(@JsonProperty("principalId") String principalId)
  {
    this.principalId = principalId;
  }
  
  public String getPrincipalId()
  {
    return principalId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.UserIdentityEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */