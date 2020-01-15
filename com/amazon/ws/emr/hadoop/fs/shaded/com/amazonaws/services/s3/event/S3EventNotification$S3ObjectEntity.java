package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonIgnore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$S3ObjectEntity
{
  private final String key;
  private final Long size;
  private final String eTag;
  private final String versionId;
  private final String sequencer;
  
  @Deprecated
  public S3EventNotification$S3ObjectEntity(String key, Integer size, String eTag, String versionId)
  {
    this.key = key;
    this.size = (size == null ? null : Long.valueOf(size.longValue()));
    this.eTag = eTag;
    this.versionId = versionId;
    sequencer = null;
  }
  
  @Deprecated
  public S3EventNotification$S3ObjectEntity(String key, Long size, String eTag, String versionId)
  {
    this(key, size, eTag, versionId, null);
  }
  
  @JsonCreator
  public S3EventNotification$S3ObjectEntity(@JsonProperty("key") String key, @JsonProperty("size") Long size, @JsonProperty("eTag") String eTag, @JsonProperty("versionId") String versionId, @JsonProperty("sequencer") String sequencer)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.S3ObjectEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */