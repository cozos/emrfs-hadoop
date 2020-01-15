package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$GlacierEventDataEntity
{
  private final S3EventNotification.RestoreEventDataEntity restoreEventData;
  
  @JsonCreator
  public S3EventNotification$GlacierEventDataEntity(@JsonProperty("restoreEventData") S3EventNotification.RestoreEventDataEntity restoreEventData)
  {
    this.restoreEventData = restoreEventData;
  }
  
  public S3EventNotification.RestoreEventDataEntity getRestoreEventData()
  {
    return restoreEventData;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.GlacierEventDataEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */