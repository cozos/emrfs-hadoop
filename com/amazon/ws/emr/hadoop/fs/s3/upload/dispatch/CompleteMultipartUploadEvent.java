package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.List;
import lombok.NonNull;

public final class CompleteMultipartUploadEvent
{
  private final String bucket;
  private final String key;
  private final String uploadId;
  private final List<PartETag> partETags;
  private final Long totalLength;
  private final ExtraUploadMetadata extraUploadMetadata;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CompleteMultipartUploadEvent)) {
      return false;
    }
    CompleteMultipartUploadEvent other = (CompleteMultipartUploadEvent)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$key = getKey();Object other$key = other.getKey();
    if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
      return false;
    }
    Object this$uploadId = getUploadId();Object other$uploadId = other.getUploadId();
    if (this$uploadId == null ? other$uploadId != null : !this$uploadId.equals(other$uploadId)) {
      return false;
    }
    Object this$partETags = getPartETags();Object other$partETags = other.getPartETags();
    if (this$partETags == null ? other$partETags != null : !this$partETags.equals(other$partETags)) {
      return false;
    }
    Object this$totalLength = getTotalLength();Object other$totalLength = other.getTotalLength();
    if (this$totalLength == null ? other$totalLength != null : !this$totalLength.equals(other$totalLength)) {
      return false;
    }
    Object this$extraUploadMetadata = getExtraUploadMetadata();Object other$extraUploadMetadata = other.getExtraUploadMetadata();return this$extraUploadMetadata == null ? other$extraUploadMetadata == null : this$extraUploadMetadata.equals(other$extraUploadMetadata);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $key = getKey();result = result * 59 + ($key == null ? 43 : $key.hashCode());Object $uploadId = getUploadId();result = result * 59 + ($uploadId == null ? 43 : $uploadId.hashCode());Object $partETags = getPartETags();result = result * 59 + ($partETags == null ? 43 : $partETags.hashCode());Object $totalLength = getTotalLength();result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());Object $extraUploadMetadata = getExtraUploadMetadata();result = result * 59 + ($extraUploadMetadata == null ? 43 : $extraUploadMetadata.hashCode());return result;
  }
  
  public String toString()
  {
    return "CompleteMultipartUploadEvent(bucket=" + getBucket() + ", key=" + getKey() + ", uploadId=" + getUploadId() + ", partETags=" + getPartETags() + ", totalLength=" + getTotalLength() + ", extraUploadMetadata=" + getExtraUploadMetadata() + ")";
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public List<PartETag> getPartETags()
  {
    return partETags;
  }
  
  public Long getTotalLength()
  {
    return totalLength;
  }
  
  public ExtraUploadMetadata getExtraUploadMetadata()
  {
    return extraUploadMetadata;
  }
  
  public static class CompleteMultipartUploadEventBuilder
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
  
  public static CompleteMultipartUploadEventBuilder builder()
  {
    return new CompleteMultipartUploadEventBuilder();
  }
  
  private CompleteMultipartUploadEvent(@NonNull String bucket, @NonNull String key, @NonNull String uploadId, @NonNull List<PartETag> partETags, @NonNull Long totalLength, @NonNull ExtraUploadMetadata extraUploadMetadata)
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
    if (partETags == null) {
      throw new NullPointerException("partETags");
    }
    if (totalLength == null) {
      throw new NullPointerException("totalLength");
    }
    if (extraUploadMetadata == null) {
      throw new NullPointerException("extraUploadMetadata");
    }
    Preconditions.checkArgument(totalLength.longValue() >= 0L, "TotalLength (%s) must not be negative", new Object[] { totalLength });
    this.bucket = bucket;
    this.key = key;
    this.uploadId = uploadId;
    this.partETags = partETags;
    this.totalLength = totalLength;
    this.extraUploadMetadata = extraUploadMetadata;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */