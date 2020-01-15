package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DateTimeJsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;

public class S3EventNotification$RestoreEventDataEntity
{
  private DateTime lifecycleRestorationExpiryTime;
  private final String lifecycleRestoreStorageClass;
  
  @JsonCreator
  public S3EventNotification$RestoreEventDataEntity(@JsonProperty("lifecycleRestorationExpiryTime") String lifecycleRestorationExpiryTime, @JsonProperty("lifecycleRestoreStorageClass") String lifecycleRestoreStorageClass)
  {
    if (lifecycleRestorationExpiryTime != null) {
      this.lifecycleRestorationExpiryTime = DateTime.parse(lifecycleRestorationExpiryTime);
    }
    this.lifecycleRestoreStorageClass = lifecycleRestoreStorageClass;
  }
  
  @JsonSerialize(using=DateTimeJsonSerializer.class)
  public DateTime getLifecycleRestorationExpiryTime()
  {
    return lifecycleRestorationExpiryTime;
  }
  
  public String getLifecycleRestoreStorageClass()
  {
    return lifecycleRestoreStorageClass;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.RestoreEventDataEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */