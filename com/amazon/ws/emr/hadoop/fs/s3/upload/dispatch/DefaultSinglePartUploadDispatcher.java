package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.s3.S3ObjectRequestFactory;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import java.io.IOException;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSinglePartUploadDispatcher
  implements SinglePartUploadDispatcher
{
  public DefaultSinglePartUploadDispatcher(@NonNull AmazonS3Lite s3, @NonNull S3ObjectRequestFactory s3ObjectRequestFactory, @NonNull UploadObserver observer)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (s3ObjectRequestFactory == null) {
      throw new NullPointerException("s3ObjectRequestFactory");
    }
    if (observer == null) {
      throw new NullPointerException("observer");
    }
    this.s3 = s3;this.s3ObjectRequestFactory = s3ObjectRequestFactory;this.observer = observer;
  }
  
  private static final Logger logger = LoggerFactory.getLogger(DefaultSinglePartUploadDispatcher.class);
  private static final String DEFAULT_CONTENT_TYPE = "binary/octet-stream";
  @NonNull
  private final AmazonS3Lite s3;
  @NonNull
  private final S3ObjectRequestFactory s3ObjectRequestFactory;
  @NonNull
  private final UploadObserver observer;
  
  public void create(@NonNull ObjectCreationEvent event)
    throws IOException
  {
    if (event == null) {
      throw new NullPointerException("event");
    }
    UploadObserverContext observerContext = toObserverContext(event);
    observer.beforeUploadCompletion(observerContext);
    PutObjectRequest request = toPutObjectRequest(event);
    
    logger.debug("Putting an object: {}:{} {}", new Object[] { event.getBucket(), event.getKey(), 
      Long.valueOf(event.getContentLength()) });
    PutObjectResult result = s3.putObject(request);
    logger.debug("Upload complete for {}:{}", event.getBucket(), event.getKey());
    
    observerContext.getStore().put(UploadObserverContext.ETAG_VERIFICATION_KEY, result.getETag());
    
    observer.afterUploadCompletion(observerContext);
  }
  
  private UploadObserverContext toObserverContext(ObjectCreationEvent event)
  {
    return new UploadObserverContext(event.getBucket(), event.getKey(), event
      .getExtraUploadMetadata());
  }
  
  private PutObjectRequest toPutObjectRequest(ObjectCreationEvent event)
  {
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentType("binary/octet-stream");
    metadata.setContentLength(event.getContentLength());
    metadata.setContentMD5(event.getContentMD5());
    if (!Strings.isNullOrEmpty(event.getServerSideEncryptionAlgorithm())) {
      metadata.setSSEAlgorithm(event.getServerSideEncryptionAlgorithm());
    }
    return 
    
      (PutObjectRequest)s3ObjectRequestFactory.newPutObjectRequest(event.getBucket(), event.getKey(), event.getContentStream(), metadata).withGeneralProgressListener(event.getProgressListener());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.DefaultSinglePartUploadDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */