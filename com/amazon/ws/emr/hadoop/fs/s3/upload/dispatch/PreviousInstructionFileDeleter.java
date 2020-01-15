package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PreviousInstructionFileDeleter
  extends AfterUploadCompletionObserver
{
  public PreviousInstructionFileDeleter(@NonNull AmazonS3Lite s3, @NonNull Configuration configuration)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (configuration == null) {
      throw new NullPointerException("configuration");
    }
    this.s3 = s3;this.configuration = configuration;
  }
  
  private static final Logger logger = LoggerFactory.getLogger(PreviousInstructionFileDeleter.class);
  @NonNull
  private final AmazonS3Lite s3;
  @NonNull
  private final Configuration configuration;
  
  protected void afterUpload(String bucket, String key)
    throws IOException
  {
    try
    {
      CSEUtils.deletePreviousInstructionFileIfNecessary(configuration, s3, bucket, key);
    }
    catch (AmazonClientException e)
    {
      logger.debug("Unable to delete instruction file for {}/{}", bucket, key);
      throw new IOException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.PreviousInstructionFileDeleter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */