package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher;

public class UploadPlan$UploadPlanBuilder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlan.UploadPlanBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */