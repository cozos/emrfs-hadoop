package com.amazon.ws.emr.hadoop.fs.staging.metadata;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.List;
import lombok.NonNull;

public final class UploadMetadata
{
  private final String uploadId;
  private final List<PartETag> partETags;
  private final long totalLength;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UploadMetadata)) {
      return false;
    }
    UploadMetadata other = (UploadMetadata)o;Object this$uploadId = getUploadId();Object other$uploadId = other.getUploadId();
    if (this$uploadId == null ? other$uploadId != null : !this$uploadId.equals(other$uploadId)) {
      return false;
    }
    Object this$partETags = getPartETags();Object other$partETags = other.getPartETags();
    if (this$partETags == null ? other$partETags != null : !this$partETags.equals(other$partETags)) {
      return false;
    }
    return getTotalLength() == other.getTotalLength();
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $uploadId = getUploadId();result = result * 59 + ($uploadId == null ? 43 : $uploadId.hashCode());Object $partETags = getPartETags();result = result * 59 + ($partETags == null ? 43 : $partETags.hashCode());long $totalLength = getTotalLength();result = result * 59 + (int)($totalLength >>> 32 ^ $totalLength);return result;
  }
  
  public String toString()
  {
    return "UploadMetadata(uploadId=" + getUploadId() + ", partETags=" + getPartETags() + ", totalLength=" + getTotalLength() + ")";
  }
  
  private UploadMetadata(String uploadId, List<PartETag> partETags, long totalLength)
  {
    this.uploadId = uploadId;this.partETags = partETags;this.totalLength = totalLength;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public List<PartETag> getPartETags()
  {
    return partETags;
  }
  
  public long getTotalLength()
  {
    return totalLength;
  }
  
  public static UploadMetadata of(@NonNull String uploadId, @NonNull List<PartETag> partETags, long totalLength)
  {
    if (uploadId == null) {
      throw new NullPointerException("uploadId");
    }
    if (partETags == null) {
      throw new NullPointerException("partETags");
    }
    Preconditions.checkArgument(totalLength >= 0L, "TotalLength must not be negative");
    return new UploadMetadata(uploadId, partETags, totalLength);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */