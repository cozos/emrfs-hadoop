package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

public class AbortMultipartUploadEvent$AbortMultipartUploadEventBuilder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent.AbortMultipartUploadEventBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */