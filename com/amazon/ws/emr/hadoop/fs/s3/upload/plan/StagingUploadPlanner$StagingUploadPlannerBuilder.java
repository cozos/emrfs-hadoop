package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import org.apache.hadoop.conf.Configuration;

public class StagingUploadPlanner$StagingUploadPlannerBuilder
{
  private String bucket;
  private Configuration conf;
  private StagingPathConverter stagingPathConverter;
  private StagingMetadataStore stagingMetadataStore;
  private MultipartUploadDispatcher multipartDispatcher;
  
  public String toString()
  {
    return "StagingUploadPlanner.StagingUploadPlannerBuilder(bucket=" + bucket + ", conf=" + conf + ", stagingPathConverter=" + stagingPathConverter + ", stagingMetadataStore=" + stagingMetadataStore + ", multipartDispatcher=" + multipartDispatcher + ")";
  }
  
  public StagingUploadPlanner build()
  {
    return new StagingUploadPlanner(bucket, conf, stagingPathConverter, stagingMetadataStore, multipartDispatcher);
  }
  
  public StagingUploadPlannerBuilder multipartDispatcher(MultipartUploadDispatcher multipartDispatcher)
  {
    this.multipartDispatcher = multipartDispatcher;return this;
  }
  
  public StagingUploadPlannerBuilder stagingMetadataStore(StagingMetadataStore stagingMetadataStore)
  {
    this.stagingMetadataStore = stagingMetadataStore;return this;
  }
  
  public StagingUploadPlannerBuilder stagingPathConverter(StagingPathConverter stagingPathConverter)
  {
    this.stagingPathConverter = stagingPathConverter;return this;
  }
  
  public StagingUploadPlannerBuilder conf(Configuration conf)
  {
    this.conf = conf;return this;
  }
  
  public StagingUploadPlannerBuilder bucket(String bucket)
  {
    this.bucket = bucket;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.StagingUploadPlanner.StagingUploadPlannerBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */