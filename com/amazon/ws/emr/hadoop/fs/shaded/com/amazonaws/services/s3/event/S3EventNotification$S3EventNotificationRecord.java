package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DateTimeJsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Event;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonIgnore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;

public class S3EventNotification$S3EventNotificationRecord
{
  private final String awsRegion;
  private final String eventName;
  private final String eventSource;
  private DateTime eventTime;
  private final String eventVersion;
  private final S3EventNotification.RequestParametersEntity requestParameters;
  private final S3EventNotification.ResponseElementsEntity responseElements;
  private final S3EventNotification.S3Entity s3;
  private final S3EventNotification.UserIdentityEntity userIdentity;
  private final S3EventNotification.GlacierEventDataEntity glacierEventData;
  
  @Deprecated
  public S3EventNotification$S3EventNotificationRecord(String awsRegion, String eventName, String eventSource, String eventTime, String eventVersion, S3EventNotification.RequestParametersEntity requestParameters, S3EventNotification.ResponseElementsEntity responseElements, S3EventNotification.S3Entity s3, S3EventNotification.UserIdentityEntity userIdentity)
  {
    this(awsRegion, eventName, eventSource, eventTime, eventVersion, requestParameters, responseElements, s3, userIdentity, null);
  }
  
  @JsonCreator
  public S3EventNotification$S3EventNotificationRecord(@JsonProperty("awsRegion") String awsRegion, @JsonProperty("eventName") String eventName, @JsonProperty("eventSource") String eventSource, @JsonProperty("eventTime") String eventTime, @JsonProperty("eventVersion") String eventVersion, @JsonProperty("requestParameters") S3EventNotification.RequestParametersEntity requestParameters, @JsonProperty("responseElements") S3EventNotification.ResponseElementsEntity responseElements, @JsonProperty("s3") S3EventNotification.S3Entity s3, @JsonProperty("userIdentity") S3EventNotification.UserIdentityEntity userIdentity, @JsonProperty("glacierEventData") S3EventNotification.GlacierEventDataEntity glacierEventData)
  {
    this.awsRegion = awsRegion;
    this.eventName = eventName;
    this.eventSource = eventSource;
    if (eventTime != null) {
      this.eventTime = DateTime.parse(eventTime);
    }
    this.eventVersion = eventVersion;
    this.requestParameters = requestParameters;
    this.responseElements = responseElements;
    this.s3 = s3;
    this.userIdentity = userIdentity;
    this.glacierEventData = glacierEventData;
  }
  
  public String getAwsRegion()
  {
    return awsRegion;
  }
  
  public String getEventName()
  {
    return eventName;
  }
  
  @JsonIgnore
  public S3Event getEventNameAsEnum()
  {
    return S3Event.fromValue(eventName);
  }
  
  public String getEventSource()
  {
    return eventSource;
  }
  
  @JsonSerialize(using=DateTimeJsonSerializer.class)
  public DateTime getEventTime()
  {
    return eventTime;
  }
  
  public String getEventVersion()
  {
    return eventVersion;
  }
  
  public S3EventNotification.RequestParametersEntity getRequestParameters()
  {
    return requestParameters;
  }
  
  public S3EventNotification.ResponseElementsEntity getResponseElements()
  {
    return responseElements;
  }
  
  public S3EventNotification.S3Entity getS3()
  {
    return s3;
  }
  
  public S3EventNotification.UserIdentityEntity getUserIdentity()
  {
    return userIdentity;
  }
  
  public S3EventNotification.GlacierEventDataEntity getGlacierEventData()
  {
    return glacierEventData;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */