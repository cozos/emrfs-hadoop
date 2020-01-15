package com.amazon.ws.emr.hadoop.fs.staging;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import lombok.NonNull;

public final class DeferredUpload
{
  @NonNull
  private final UploadMetadata metadata;
  private final long deferralTime;
  private Long completedTime;
  
  public DeferredUpload(@NonNull UploadMetadata metadata, long deferralTime)
  {
    if (metadata == null) {
      throw new NullPointerException("metadata");
    }
    this.metadata = metadata;this.deferralTime = deferralTime;
  }
  
  @NonNull
  public UploadMetadata getMetadata()
  {
    return metadata;
  }
  
  public long getDeferralTime()
  {
    return deferralTime;
  }
  
  public Long getCompletedTime()
  {
    return completedTime;
  }
  
  public void setCompletedTime(long completedTime)
  {
    Preconditions.checkState(!isCompleted(), "upload is already completed");
    Preconditions.checkArgument(completedTime >= deferralTime, "completedTime must be >= deferralTime");
    
    this.completedTime = Long.valueOf(completedTime);
  }
  
  public boolean isCompleted()
  {
    return completedTime != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.DeferredUpload
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */