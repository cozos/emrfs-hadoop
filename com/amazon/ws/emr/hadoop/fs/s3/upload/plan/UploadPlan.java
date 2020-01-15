package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import lombok.NonNull;

public final class UploadPlan
{
  private final String bucket;
  private final String key;
  private final UploadConstraint constraint;
  private final SinglePartUploadDispatcher singlePartDispatcher;
  private final MultipartUploadDispatcher multipartDispatcher;
  private final ExtraUploadMetadata extraUploadMetadata;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UploadPlan)) {
      return false;
    }
    UploadPlan other = (UploadPlan)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$key = getKey();Object other$key = other.getKey();
    if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
      return false;
    }
    Object this$constraint = getConstraint();Object other$constraint = other.getConstraint();
    if (this$constraint == null ? other$constraint != null : !this$constraint.equals(other$constraint)) {
      return false;
    }
    Object this$singlePartDispatcher = getSinglePartDispatcher();Object other$singlePartDispatcher = other.getSinglePartDispatcher();
    if (this$singlePartDispatcher == null ? other$singlePartDispatcher != null : !this$singlePartDispatcher.equals(other$singlePartDispatcher)) {
      return false;
    }
    Object this$multipartDispatcher = getMultipartDispatcher();Object other$multipartDispatcher = other.getMultipartDispatcher();
    if (this$multipartDispatcher == null ? other$multipartDispatcher != null : !this$multipartDispatcher.equals(other$multipartDispatcher)) {
      return false;
    }
    Object this$extraUploadMetadata = getExtraUploadMetadata();Object other$extraUploadMetadata = other.getExtraUploadMetadata();return this$extraUploadMetadata == null ? other$extraUploadMetadata == null : this$extraUploadMetadata.equals(other$extraUploadMetadata);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $key = getKey();result = result * 59 + ($key == null ? 43 : $key.hashCode());Object $constraint = getConstraint();result = result * 59 + ($constraint == null ? 43 : $constraint.hashCode());Object $singlePartDispatcher = getSinglePartDispatcher();result = result * 59 + ($singlePartDispatcher == null ? 43 : $singlePartDispatcher.hashCode());Object $multipartDispatcher = getMultipartDispatcher();result = result * 59 + ($multipartDispatcher == null ? 43 : $multipartDispatcher.hashCode());Object $extraUploadMetadata = getExtraUploadMetadata();result = result * 59 + ($extraUploadMetadata == null ? 43 : $extraUploadMetadata.hashCode());return result;
  }
  
  public String toString()
  {
    return "UploadPlan(bucket=" + getBucket() + ", key=" + getKey() + ", constraint=" + getConstraint() + ", singlePartDispatcher=" + getSinglePartDispatcher() + ", multipartDispatcher=" + getMultipartDispatcher() + ", extraUploadMetadata=" + getExtraUploadMetadata() + ")";
  }
  
  public static class UploadPlanBuilder
  {
    private String bucket;
    private String key;
    private UploadConstraint constraint;
    private SinglePartUploadDispatcher singlePartDispatcher;
    private MultipartUploadDispatcher multipartDispatcher;
    private ExtraUploadMetadata extraUploadMetadata;
    
    public String toString()
    {
      return "UploadPlan.UploadPlanBuilder(bucket=" + bucket + ", key=" + key + ", constraint=" + constraint + ", singlePartDispatcher=" + singlePartDispatcher + ", multipartDispatcher=" + multipartDispatcher + ", extraUploadMetadata=" + extraUploadMetadata + ")";
    }
    
    public UploadPlan build()
    {
      return new UploadPlan(bucket, key, constraint, singlePartDispatcher, multipartDispatcher, extraUploadMetadata, null);
    }
    
    public UploadPlanBuilder extraUploadMetadata(ExtraUploadMetadata extraUploadMetadata)
    {
      this.extraUploadMetadata = extraUploadMetadata;return this;
    }
    
    public UploadPlanBuilder multipartDispatcher(MultipartUploadDispatcher multipartDispatcher)
    {
      this.multipartDispatcher = multipartDispatcher;return this;
    }
    
    public UploadPlanBuilder singlePartDispatcher(SinglePartUploadDispatcher singlePartDispatcher)
    {
      this.singlePartDispatcher = singlePartDispatcher;return this;
    }
    
    public UploadPlanBuilder constraint(UploadConstraint constraint)
    {
      this.constraint = constraint;return this;
    }
    
    public UploadPlanBuilder key(String key)
    {
      this.key = key;return this;
    }
    
    public UploadPlanBuilder bucket(String bucket)
    {
      this.bucket = bucket;return this;
    }
  }
  
  public static UploadPlanBuilder builder()
  {
    return new UploadPlanBuilder();
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public UploadConstraint getConstraint()
  {
    return constraint;
  }
  
  public SinglePartUploadDispatcher getSinglePartDispatcher()
  {
    return singlePartDispatcher;
  }
  
  public MultipartUploadDispatcher getMultipartDispatcher()
  {
    return multipartDispatcher;
  }
  
  public ExtraUploadMetadata getExtraUploadMetadata()
  {
    return extraUploadMetadata;
  }
  
  private UploadPlan(@NonNull String bucket, @NonNull String key, UploadConstraint constraint, SinglePartUploadDispatcher singlePartDispatcher, MultipartUploadDispatcher multipartDispatcher, @NonNull ExtraUploadMetadata extraUploadMetadata)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (extraUploadMetadata == null) {
      throw new NullPointerException("extraUploadMetadata");
    }
    this.bucket = bucket;
    this.key = key;
    this.constraint = constraint;
    this.singlePartDispatcher = singlePartDispatcher;
    this.multipartDispatcher = multipartDispatcher;
    this.extraUploadMetadata = extraUploadMetadata;
    if ((constraint == null) || (constraint == UploadConstraint.SINGLE_PART_UPLOAD))
    {
      Preconditions.checkNotNull(singlePartDispatcher, "single part upload dispatcher is required");
      if (constraint == UploadConstraint.SINGLE_PART_UPLOAD) {
        Preconditions.checkArgument(multipartDispatcher == null, "multipart upload dispatcher must not be specified if constrained to single part uploads");
      }
    }
    if ((constraint == null) || (constraint == UploadConstraint.MULTIPART_UPLOAD))
    {
      Preconditions.checkNotNull(multipartDispatcher, "multipart upload dispatcher is required");
      if (constraint == UploadConstraint.MULTIPART_UPLOAD) {
        Preconditions.checkArgument(singlePartDispatcher == null, "single part upload dispatcher must not be specified if constrained to multipart uploads");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlan
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */