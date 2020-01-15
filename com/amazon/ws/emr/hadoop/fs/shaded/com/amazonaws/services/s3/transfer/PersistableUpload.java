package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public final class PersistableUpload
  extends PersistableTransfer
{
  static final String TYPE = "upload";
  @JsonProperty
  private final String pauseType = "upload";
  @JsonProperty
  private final String bucketName;
  @JsonProperty
  private final String key;
  @JsonProperty
  private final String file;
  @JsonProperty
  private final String multipartUploadId;
  @JsonProperty
  private final long partSize;
  @JsonProperty
  private final long mutlipartUploadThreshold;
  
  public PersistableUpload()
  {
    this(null, null, null, null, -1L, -1L);
  }
  
  public PersistableUpload(@JsonProperty("bucketName") String bucketName, @JsonProperty("key") String key, @JsonProperty("file") String file, @JsonProperty("multipartUploadId") String multipartUploadId, @JsonProperty("partSize") long partSize, @JsonProperty("mutlipartUploadThreshold") long mutlipartUploadThreshold)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.file = file;
    this.multipartUploadId = multipartUploadId;
    this.partSize = partSize;
    this.mutlipartUploadThreshold = mutlipartUploadThreshold;
  }
  
  String getBucketName()
  {
    return bucketName;
  }
  
  String getKey()
  {
    return key;
  }
  
  String getMultipartUploadId()
  {
    return multipartUploadId;
  }
  
  long getPartSize()
  {
    return partSize;
  }
  
  long getMutlipartUploadThreshold()
  {
    return mutlipartUploadThreshold;
  }
  
  String getFile()
  {
    return file;
  }
  
  String getPauseType()
  {
    return "upload";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */