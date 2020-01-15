package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DateTimeJsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Event;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonIgnore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.List;

public class S3EventNotification
{
  private final List<S3EventNotificationRecord> records;
  
  @JsonCreator
  public S3EventNotification(@JsonProperty("Records") List<S3EventNotificationRecord> records)
  {
    this.records = records;
  }
  
  public static S3EventNotification parseJson(String json)
  {
    return (S3EventNotification)Jackson.fromJsonString(json, S3EventNotification.class);
  }
  
  @JsonProperty("Records")
  public List<S3EventNotificationRecord> getRecords()
  {
    return records;
  }
  
  public String toJson()
  {
    return Jackson.toJsonString(this);
  }
  
  public static class UserIdentityEntity
  {
    private final String principalId;
    
    @JsonCreator
    public UserIdentityEntity(@JsonProperty("principalId") String principalId)
    {
      this.principalId = principalId;
    }
    
    public String getPrincipalId()
    {
      return principalId;
    }
  }
  
  public static class S3BucketEntity
  {
    private final String name;
    private final S3EventNotification.UserIdentityEntity ownerIdentity;
    private final String arn;
    
    @JsonCreator
    public S3BucketEntity(@JsonProperty("name") String name, @JsonProperty("ownerIdentity") S3EventNotification.UserIdentityEntity ownerIdentity, @JsonProperty("arn") String arn)
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
  
  public static class S3ObjectEntity
  {
    private final String key;
    private final Long size;
    private final String eTag;
    private final String versionId;
    private final String sequencer;
    
    @Deprecated
    public S3ObjectEntity(String key, Integer size, String eTag, String versionId)
    {
      this.key = key;
      this.size = (size == null ? null : Long.valueOf(size.longValue()));
      this.eTag = eTag;
      this.versionId = versionId;
      sequencer = null;
    }
    
    @Deprecated
    public S3ObjectEntity(String key, Long size, String eTag, String versionId)
    {
      this(key, size, eTag, versionId, null);
    }
    
    @JsonCreator
    public S3ObjectEntity(@JsonProperty("key") String key, @JsonProperty("size") Long size, @JsonProperty("eTag") String eTag, @JsonProperty("versionId") String versionId, @JsonProperty("sequencer") String sequencer)
    {
      this.key = key;
      this.size = size;
      this.eTag = eTag;
      this.versionId = versionId;
      this.sequencer = sequencer;
    }
    
    public String getKey()
    {
      return key;
    }
    
    public String getUrlDecodedKey()
    {
      return SdkHttpUtils.urlDecode(getKey());
    }
    
    @Deprecated
    @JsonIgnore
    public Integer getSize()
    {
      return size == null ? null : Integer.valueOf(size.intValue());
    }
    
    @JsonProperty("size")
    public Long getSizeAsLong()
    {
      return size;
    }
    
    public String geteTag()
    {
      return eTag;
    }
    
    public String getVersionId()
    {
      return versionId;
    }
    
    public String getSequencer()
    {
      return sequencer;
    }
  }
  
  public static class S3Entity
  {
    private final String configurationId;
    private final S3EventNotification.S3BucketEntity bucket;
    private final S3EventNotification.S3ObjectEntity object;
    private final String s3SchemaVersion;
    
    @JsonCreator
    public S3Entity(@JsonProperty("configurationId") String configurationId, @JsonProperty("bucket") S3EventNotification.S3BucketEntity bucket, @JsonProperty("object") S3EventNotification.S3ObjectEntity object, @JsonProperty("s3SchemaVersion") String s3SchemaVersion)
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
  
  public static class RequestParametersEntity
  {
    private final String sourceIPAddress;
    
    @JsonCreator
    public RequestParametersEntity(@JsonProperty("sourceIPAddress") String sourceIPAddress)
    {
      this.sourceIPAddress = sourceIPAddress;
    }
    
    public String getSourceIPAddress()
    {
      return sourceIPAddress;
    }
  }
  
  public static class ResponseElementsEntity
  {
    private final String xAmzId2;
    private final String xAmzRequestId;
    
    @JsonCreator
    public ResponseElementsEntity(@JsonProperty("x-amz-id-2") String xAmzId2, @JsonProperty("x-amz-request-id") String xAmzRequestId)
    {
      this.xAmzId2 = xAmzId2;
      this.xAmzRequestId = xAmzRequestId;
    }
    
    @JsonProperty("x-amz-id-2")
    public String getxAmzId2()
    {
      return xAmzId2;
    }
    
    @JsonProperty("x-amz-request-id")
    public String getxAmzRequestId()
    {
      return xAmzRequestId;
    }
  }
  
  public static class GlacierEventDataEntity
  {
    private final S3EventNotification.RestoreEventDataEntity restoreEventData;
    
    @JsonCreator
    public GlacierEventDataEntity(@JsonProperty("restoreEventData") S3EventNotification.RestoreEventDataEntity restoreEventData)
    {
      this.restoreEventData = restoreEventData;
    }
    
    public S3EventNotification.RestoreEventDataEntity getRestoreEventData()
    {
      return restoreEventData;
    }
  }
  
  public static class RestoreEventDataEntity
  {
    private DateTime lifecycleRestorationExpiryTime;
    private final String lifecycleRestoreStorageClass;
    
    @JsonCreator
    public RestoreEventDataEntity(@JsonProperty("lifecycleRestorationExpiryTime") String lifecycleRestorationExpiryTime, @JsonProperty("lifecycleRestoreStorageClass") String lifecycleRestoreStorageClass)
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
  
  public static class S3EventNotificationRecord
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
    public S3EventNotificationRecord(String awsRegion, String eventName, String eventSource, String eventTime, String eventVersion, S3EventNotification.RequestParametersEntity requestParameters, S3EventNotification.ResponseElementsEntity responseElements, S3EventNotification.S3Entity s3, S3EventNotification.UserIdentityEntity userIdentity)
    {
      this(awsRegion, eventName, eventSource, eventTime, eventVersion, requestParameters, responseElements, s3, userIdentity, null);
    }
    
    @JsonCreator
    public S3EventNotificationRecord(@JsonProperty("awsRegion") String awsRegion, @JsonProperty("eventName") String eventName, @JsonProperty("eventSource") String eventSource, @JsonProperty("eventTime") String eventTime, @JsonProperty("eventVersion") String eventVersion, @JsonProperty("requestParameters") S3EventNotification.RequestParametersEntity requestParameters, @JsonProperty("responseElements") S3EventNotification.ResponseElementsEntity responseElements, @JsonProperty("s3") S3EventNotification.S3Entity s3, @JsonProperty("userIdentity") S3EventNotification.UserIdentityEntity userIdentity, @JsonProperty("glacierEventData") S3EventNotification.GlacierEventDataEntity glacierEventData)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */