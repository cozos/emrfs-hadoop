package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UnencryptedLengthHeaderAdder
  extends AfterUploadCompletionObserver
{
  public UnencryptedLengthHeaderAdder(@NonNull AmazonS3Lite s3, @NonNull Configuration configuration)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (configuration == null) {
      throw new NullPointerException("configuration");
    }
    this.s3 = s3;this.configuration = configuration;
  }
  
  private static final Logger logger = LoggerFactory.getLogger(UnencryptedLengthHeaderAdder.class);
  @NonNull
  private final AmazonS3Lite s3;
  @NonNull
  private final Configuration configuration;
  
  protected void afterUpload(String bucket, String key)
    throws IOException
  {
    if (!ConfigurationUtils.isCSEUnencryptedLengthHeaderMPUEnabled(configuration).booleanValue())
    {
      logger.debug("Not adding the unencrypted length header");
      return;
    }
    try
    {
      logger.info("Going to add unencrypted length header to {}/{}", bucket, key);
      ObjectMetadata copyMetadata = s3.getObjectMetadata(bucket, key);
      long len = CSEUtils.getPlaintextLength(s3, bucket, key, copyMetadata, true);
      logger.debug("Determined unencrypted length for {}/{} as {}", new Object[] { bucket, key, Long.valueOf(len) });
      
      copyMetadata.addUserMetadata("x-amz-unencrypted-content-length", String.valueOf(len));
      
      CopyObjectRequest request = new CopyObjectRequest(bucket, key, bucket, key).withNewObjectMetadata(copyMetadata);
      s3.copyObject(request);
      logger.info("Added the unencrypted length header to {}/{}", bucket, key);
    }
    catch (Exception e)
    {
      if (((e instanceof AmazonServiceException)) && 
        (((AmazonServiceException)e).getStatusCode() == 404)) {
        return;
      }
      logger.error("Error trying to add unencrypted length header to {}/{}", new Object[] { bucket, key, e });
      throw new IOException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UnencryptedLengthHeaderAdder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */