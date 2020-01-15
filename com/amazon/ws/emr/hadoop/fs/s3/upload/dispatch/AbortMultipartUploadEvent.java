package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import lombok.NonNull;

public final class AbortMultipartUploadEvent
{
  @NonNull
  private final String bucket;
  @NonNull
  private final String key;
  @NonNull
  private final String uploadId;
  
  public static class AbortMultipartUploadEventBuilder
  {
    private String bucket;
    private String key;
    private String uploadId;
    
    public String toString()
    {
      return "AbortMultipartUploadEvent.AbortMultipartUploadEventBuilder(bucket=" + bucket + ", key=" + key + ", uploadId=" + uploadId + ")";
    }
    
    public AbortMultipartUploadEvent build()
    {
      return new AbortMultipartUploadEvent(bucket, key, uploadId);
    }
    
    public AbortMultipartUploadEventBuilder uploadId(String uploadId)
    {
      this.uploadId = uploadId;return this;
    }
    
    public AbortMultipartUploadEventBuilder key(String key)
    {
      this.key = key;return this;
    }
    
    public AbortMultipartUploadEventBuilder bucket(String bucket)
    {
      this.bucket = bucket;return this;
    }
  }
  
  AbortMultipartUploadEvent(@NonNull String bucket, @NonNull String key, @NonNull String uploadId)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (uploadId == null) {
      throw new NullPointerException("uploadId");
    }
    this.bucket = bucket;this.key = key;this.uploadId = uploadId;
  }
  
  public static AbortMultipartUploadEventBuilder builder()
  {
    return new AbortMultipartUploadEventBuilder();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof AbortMultipartUploadEvent)) {
      return false;
    }
    AbortMultipartUploadEvent other = (AbortMultipartUploadEvent)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$key = getKey();Object other$key = other.getKey();
    if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
      return false;
    }
    Object this$uploadId = getUploadId();Object other$uploadId = other.getUploadId();return this$uploadId == null ? other$uploadId == null : this$uploadId.equals(other$uploadId);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $key = getKey();result = result * 59 + ($key == null ? 43 : $key.hashCode());Object $uploadId = getUploadId();result = result * 59 + ($uploadId == null ? 43 : $uploadId.hashCode());return result;
  }
  
  public String toString()
  {
    return "AbortMultipartUploadEvent(bucket=" + getBucket() + ", key=" + getKey() + ", uploadId=" + getUploadId() + ")";
  }
  
  @NonNull
  public String getBucket()
  {
    return bucket;
  }
  
  @NonNull
  public String getKey()
  {
    return key;
  }
  
  @NonNull
  public String getUploadId()
  {
    return uploadId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */