package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import java.util.List;

public class CompleteMultipartUploadEvent$CompleteMultipartUploadEventBuilder
{
  private String bucket;
  private String key;
  private String uploadId;
  private List<PartETag> partETags;
  private Long totalLength;
  private ExtraUploadMetadata extraUploadMetadata;
  
  public String toString()
  {
    return "CompleteMultipartUploadEvent.CompleteMultipartUploadEventBuilder(bucket=" + bucket + ", key=" + key + ", uploadId=" + uploadId + ", partETags=" + partETags + ", totalLength=" + totalLength + ", extraUploadMetadata=" + extraUploadMetadata + ")";
  }
  
  public CompleteMultipartUploadEvent build()
  {
    return new CompleteMultipartUploadEvent(bucket, key, uploadId, partETags, totalLength, extraUploadMetadata, null);
  }
  
  public CompleteMultipartUploadEventBuilder extraUploadMetadata(ExtraUploadMetadata extraUploadMetadata)
  {
    this.extraUploadMetadata = extraUploadMetadata;return this;
  }
  
  public CompleteMultipartUploadEventBuilder totalLength(Long totalLength)
  {
    this.totalLength = totalLength;return this;
  }
  
  public CompleteMultipartUploadEventBuilder partETags(List<PartETag> partETags)
  {
    this.partETags = partETags;return this;
  }
  
  public CompleteMultipartUploadEventBuilder uploadId(String uploadId)
  {
    this.uploadId = uploadId;return this;
  }
  
  public CompleteMultipartUploadEventBuilder key(String key)
  {
    this.key = key;return this;
  }
  
  public CompleteMultipartUploadEventBuilder bucket(String bucket)
  {
    this.bucket = bucket;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent.CompleteMultipartUploadEventBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */