package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.IOException;
import java.util.List;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMultipartUploadDispatcher
  implements MultipartUploadDispatcher
{
  private static final Logger logger = LoggerFactory.getLogger(DefaultMultipartUploadDispatcher.class);
  private final AmazonS3Lite s3;
  private final UploadObserver observer;
  
  public DefaultMultipartUploadDispatcher(@NonNull AmazonS3Lite s3, @NonNull UploadObserver observer)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (observer == null) {
      throw new NullPointerException("observer");
    }
    this.s3 = EmrFsUtils.getAmazonS3LiteWithRetryPolicy(s3);
    this.observer = observer;
  }
  
  public void complete(@NonNull CompleteMultipartUploadEvent event)
    throws IOException
  {
    if (event == null) {
      throw new NullPointerException("event");
    }
    UploadObserverContext observerContext = toObserverContext(event);
    observer.beforeUploadCompletion(observerContext);
    completeUpload(event, observerContext);
    observer.afterUploadCompletion(observerContext);
  }
  
  public void abort(AbortMultipartUploadEvent event)
  {
    s3.abortMultipartUpload(toRequest(event));
  }
  
  private UploadObserverContext toObserverContext(CompleteMultipartUploadEvent event)
  {
    return new UploadObserverContext(event.getBucket(), event.getKey(), event
      .getExtraUploadMetadata());
  }
  
  private void completeUpload(CompleteMultipartUploadEvent event, UploadObserverContext context)
  {
    logger.debug("Complete multipart upload {} with bucket '{}' key '{}' and etags '{}'", new Object[] {event
      .getUploadId(), event.getBucket(), event.getKey(), event.getPartETags() });
    CompleteMultipartUploadResult result = s3.completeMultipartUpload(toRequest(event));
    
    context.getStore().put(UploadObserverContext.ETAG_VERIFICATION_KEY, result.getETag());
    
    logger.info("Completed multipart upload of {} parts {} bytes", 
      Integer.valueOf(event.getPartETags().size()), event.getTotalLength());
  }
  
  private CompleteMultipartUploadRequest toRequest(CompleteMultipartUploadEvent event)
  {
    return 
    
      new CompleteMultipartUploadRequest().withBucketName(event.getBucket()).withKey(event.getKey()).withUploadId(event.getUploadId()).withPartETags(event.getPartETags());
  }
  
  private AbortMultipartUploadRequest toRequest(AbortMultipartUploadEvent event)
  {
    return new AbortMultipartUploadRequest(event
      .getBucket(), event
      .getKey(), event
      .getUploadId());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.DefaultMultipartUploadDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */