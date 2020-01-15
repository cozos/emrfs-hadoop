package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;

public final class UploadPlanTemplate
{
  @NonNull
  private final String bucket;
  @NonNull
  private final Configuration configuration;
  @NonNull
  private final SinglePartUploadDispatcher singlePartDispatcher;
  @NonNull
  private final MultipartUploadDispatcher multipartDispatcher;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UploadPlanTemplate)) {
      return false;
    }
    UploadPlanTemplate other = (UploadPlanTemplate)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$configuration = getConfiguration();Object other$configuration = other.getConfiguration();
    if (this$configuration == null ? other$configuration != null : !this$configuration.equals(other$configuration)) {
      return false;
    }
    Object this$singlePartDispatcher = getSinglePartDispatcher();Object other$singlePartDispatcher = other.getSinglePartDispatcher();
    if (this$singlePartDispatcher == null ? other$singlePartDispatcher != null : !this$singlePartDispatcher.equals(other$singlePartDispatcher)) {
      return false;
    }
    Object this$multipartDispatcher = getMultipartDispatcher();Object other$multipartDispatcher = other.getMultipartDispatcher();return this$multipartDispatcher == null ? other$multipartDispatcher == null : this$multipartDispatcher.equals(other$multipartDispatcher);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $configuration = getConfiguration();result = result * 59 + ($configuration == null ? 43 : $configuration.hashCode());Object $singlePartDispatcher = getSinglePartDispatcher();result = result * 59 + ($singlePartDispatcher == null ? 43 : $singlePartDispatcher.hashCode());Object $multipartDispatcher = getMultipartDispatcher();result = result * 59 + ($multipartDispatcher == null ? 43 : $multipartDispatcher.hashCode());return result;
  }
  
  public String toString()
  {
    return "UploadPlanTemplate(bucket=" + getBucket() + ", configuration=" + getConfiguration() + ", singlePartDispatcher=" + getSinglePartDispatcher() + ", multipartDispatcher=" + getMultipartDispatcher() + ")";
  }
  
  public static class UploadPlanTemplateBuilder
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
  
  UploadPlanTemplate(@NonNull String bucket, @NonNull Configuration configuration, @NonNull SinglePartUploadDispatcher singlePartDispatcher, @NonNull MultipartUploadDispatcher multipartDispatcher)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (configuration == null) {
      throw new NullPointerException("configuration");
    }
    if (singlePartDispatcher == null) {
      throw new NullPointerException("singlePartDispatcher");
    }
    if (multipartDispatcher == null) {
      throw new NullPointerException("multipartDispatcher");
    }
    this.bucket = bucket;this.configuration = configuration;this.singlePartDispatcher = singlePartDispatcher;this.multipartDispatcher = multipartDispatcher;
  }
  
  public static UploadPlanTemplateBuilder builder()
  {
    return new UploadPlanTemplateBuilder();
  }
  
  @NonNull
  public String getBucket()
  {
    return bucket;
  }
  
  @NonNull
  public Configuration getConfiguration()
  {
    return configuration;
  }
  
  @NonNull
  public SinglePartUploadDispatcher getSinglePartDispatcher()
  {
    return singlePartDispatcher;
  }
  
  @NonNull
  public MultipartUploadDispatcher getMultipartDispatcher()
  {
    return multipartDispatcher;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanTemplate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */