package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.StagingMultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPath;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.staging.UnsupportedStagingDirectoryOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class StagingUploadPlanner
  implements ConditionalUploadPlanner
{
  private static final Logger logger = LoggerFactory.getLogger(StagingUploadPlanner.class);
  private static final String DELIMITER = "/";
  @NonNull
  private final String bucket;
  @NonNull
  private final Configuration conf;
  @NonNull
  private final StagingPathConverter stagingPathConverter;
  @NonNull
  private final StagingMetadataStore stagingMetadataStore;
  @NonNull
  private final MultipartUploadDispatcher multipartDispatcher;
  
  public static class StagingUploadPlannerBuilder
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
  
  StagingUploadPlanner(@NonNull String bucket, @NonNull Configuration conf, @NonNull StagingPathConverter stagingPathConverter, @NonNull StagingMetadataStore stagingMetadataStore, @NonNull MultipartUploadDispatcher multipartDispatcher)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (conf == null) {
      throw new NullPointerException("conf");
    }
    if (stagingPathConverter == null) {
      throw new NullPointerException("stagingPathConverter");
    }
    if (stagingMetadataStore == null) {
      throw new NullPointerException("stagingMetadataStore");
    }
    if (multipartDispatcher == null) {
      throw new NullPointerException("multipartDispatcher");
    }
    this.bucket = bucket;this.conf = conf;this.stagingPathConverter = stagingPathConverter;this.stagingMetadataStore = stagingMetadataStore;this.multipartDispatcher = multipartDispatcher;
  }
  
  public static StagingUploadPlannerBuilder builder()
  {
    return new StagingUploadPlannerBuilder();
  }
  
  public boolean canPlan(Path path)
  {
    return stagingPathConverter.isStagingPath(path);
  }
  
  public UploadPlan plan(Path path, boolean overwrite)
    throws IOException
  {
    checkMultipartUploadsEnabled();
    
    StagingPath stagingPath = stagingPathConverter.toStagingPath(path);
    checkNotStagingRoot(stagingPath);
    
    StagedFileHandle fileHandle = stagingMetadataStore.createFile(stagingPath, overwrite);
    
    String key = getOutputKey(stagingPath);
    logger.info("Creating a new staged file '{}' with destination key '{}'", path, key);
    
    return UploadPlan.builder()
      .bucket(bucket)
      .key(key)
      .constraint(UploadConstraint.MULTIPART_UPLOAD)
      .multipartDispatcher(new StagingMultipartUploadDispatcher(fileHandle, multipartDispatcher))
      
      .extraUploadMetadata(ExtraUploadMetadata.empty())
      .build();
  }
  
  private String getOutputKey(StagingPath stagingPath)
  {
    return EmrFsUtils.pathToKey(new Path(stagingPath.getRoot().getOutputPath(), 
      Joiner.on("/").join(stagingPath.getComponents())));
  }
  
  private void checkMultipartUploadsEnabled()
    throws IOException
  {
    if (!ConfigurationUtils.isMultipartUploadEnabled(conf)) {
      throw new UnsupportedStagingDirectoryOperationException(String.format("Multipart uploads (%s) must be enabled in order to create files under a staging directory", new Object[] { "fs.s3n.multipart.uploads.enabled" }));
    }
  }
  
  private static void checkNotStagingRoot(StagingPath stagingPath)
    throws IOException
  {
    if (stagingPath.isRoot()) {
      throw new UnsupportedStagingDirectoryOperationException(String.format("Cannot create files at paths matching a staging directory root: %s", new Object[] { stagingPath }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.StagingUploadPlanner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */