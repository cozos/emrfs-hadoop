package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher;
import org.apache.hadoop.conf.Configuration;

public class UploadPlanTemplate$UploadPlanTemplateBuilder
{
  private String bucket;
  private Configuration configuration;
  private SinglePartUploadDispatcher singlePartDispatcher;
  private MultipartUploadDispatcher multipartDispatcher;
  
  public String toString()
  {
    return "UploadPlanTemplate.UploadPlanTemplateBuilder(bucket=" + bucket + ", configuration=" + configuration + ", singlePartDispatcher=" + singlePartDispatcher + ", multipartDispatcher=" + multipartDispatcher + ")";
  }
  
  public UploadPlanTemplate build()
  {
    return new UploadPlanTemplate(bucket, configuration, singlePartDispatcher, multipartDispatcher);
  }
  
  public UploadPlanTemplateBuilder multipartDispatcher(MultipartUploadDispatcher multipartDispatcher)
  {
    this.multipartDispatcher = multipartDispatcher;return this;
  }
  
  public UploadPlanTemplateBuilder singlePartDispatcher(SinglePartUploadDispatcher singlePartDispatcher)
  {
    this.singlePartDispatcher = singlePartDispatcher;return this;
  }
  
  public UploadPlanTemplateBuilder configuration(Configuration configuration)
  {
    this.configuration = configuration;return this;
  }
  
  public UploadPlanTemplateBuilder bucket(String bucket)
  {
    this.bucket = bucket;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanTemplate.UploadPlanTemplateBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */