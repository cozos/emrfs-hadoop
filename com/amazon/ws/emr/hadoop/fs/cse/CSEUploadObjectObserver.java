package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AbortMultipartUploadEvent.AbortMultipartUploadEventBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent.CompleteMultipartUploadEventBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.UploadObjectObserver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.function.LongSupplier;
import javax.annotation.Nullable;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CSEUploadObjectObserver
  extends UploadObjectObserver
{
  public static class CSEUploadObjectObserverBuilder
  {
    private LongSupplier totalLengthSupplier;
    private ExtraUploadMetadata extraUploadMetadata;
    private MultipartUploadDispatcher dispatcher;
    private ProgressListener progressListener;
    
    public String toString()
    {
      return "CSEUploadObjectObserver.CSEUploadObjectObserverBuilder(totalLengthSupplier=" + totalLengthSupplier + ", extraUploadMetadata=" + extraUploadMetadata + ", dispatcher=" + dispatcher + ", progressListener=" + progressListener + ")";
    }
    
    public CSEUploadObjectObserver build()
    {
      return new CSEUploadObjectObserver(totalLengthSupplier, extraUploadMetadata, dispatcher, progressListener);
    }
    
    public CSEUploadObjectObserverBuilder progressListener(ProgressListener progressListener)
    {
      this.progressListener = progressListener;return this;
    }
    
    public CSEUploadObjectObserverBuilder dispatcher(MultipartUploadDispatcher dispatcher)
    {
      this.dispatcher = dispatcher;return this;
    }
    
    public CSEUploadObjectObserverBuilder extraUploadMetadata(ExtraUploadMetadata extraUploadMetadata)
    {
      this.extraUploadMetadata = extraUploadMetadata;return this;
    }
    
    public CSEUploadObjectObserverBuilder totalLengthSupplier(LongSupplier totalLengthSupplier)
    {
      this.totalLengthSupplier = totalLengthSupplier;return this;
    }
  }
  
  CSEUploadObjectObserver(@NonNull LongSupplier totalLengthSupplier, @NonNull ExtraUploadMetadata extraUploadMetadata, @NonNull MultipartUploadDispatcher dispatcher, @Nullable ProgressListener progressListener)
  {
    if (totalLengthSupplier == null) {
      throw new NullPointerException("totalLengthSupplier");
    }
    if (extraUploadMetadata == null) {
      throw new NullPointerException("extraUploadMetadata");
    }
    if (dispatcher == null) {
      throw new NullPointerException("dispatcher");
    }
    this.totalLengthSupplier = totalLengthSupplier;this.extraUploadMetadata = extraUploadMetadata;this.dispatcher = dispatcher;this.progressListener = progressListener;
  }
  
  public static CSEUploadObjectObserverBuilder builder()
  {
    return new CSEUploadObjectObserverBuilder();
  }
  
  private static final Logger logger = LoggerFactory.getLogger(CSEUploadObjectObserver.class);
  @NonNull
  private final LongSupplier totalLengthSupplier;
  @NonNull
  private final ExtraUploadMetadata extraUploadMetadata;
  @NonNull
  private final MultipartUploadDispatcher dispatcher;
  @Nullable
  private final ProgressListener progressListener;
  
  protected UploadPartRequest newUploadPartRequest(PartCreationEvent event, File part)
  {
    UploadPartRequest request = super.newUploadPartRequest(event, part);
    if (progressListener != null) {
      request.setGeneralProgressListener(progressListener);
    }
    return request;
  }
  
  public CompleteMultipartUploadResult onCompletion(List<PartETag> partETags)
  {
    try
    {
      completeOrAbortOnFailure(partETags);
    }
    catch (IOException e)
    {
      throw new UncheckedIOException(e);
    }
    return null;
  }
  
  public void onAbort()
  {
    cancelFutures();
    try
    {
      abortUploadIfInitiated();
    }
    catch (IOException e)
    {
      throw new UncheckedIOException(e);
    }
  }
  
  private void cancelFutures()
  {
    for (Future<?> future : getFutures()) {
      future.cancel(true);
    }
  }
  
  private void completeOrAbortOnFailure(List<PartETag> partETags)
    throws IOException
  {
    CompleteMultipartUploadEvent event = CompleteMultipartUploadEvent.builder().bucket(getRequest().getBucketName()).key(getRequest().getKey()).partETags(partETags).uploadId(getUploadId()).totalLength(Long.valueOf(totalLengthSupplier.getAsLong())).extraUploadMetadata(extraUploadMetadata).build();
    try
    {
      dispatcher.complete(event);
    }
    catch (IOException|RuntimeException e)
    {
      abortUploadOrAddSuppressedIfFails(e);
      throw e;
    }
  }
  
  private void abortUploadOrAddSuppressedIfFails(Exception exception)
  {
    try
    {
      abortUpload();
    }
    catch (IOException|RuntimeException abortException)
    {
      exception.addSuppressed(abortException);
    }
  }
  
  private void abortUploadIfInitiated()
    throws IOException
  {
    if (getUploadId() != null) {
      abortUpload();
    }
  }
  
  private void abortUpload()
    throws IOException
  {
    AbortMultipartUploadEvent event = getAbortEvent();
    try
    {
      dispatcher.abort(event);
    }
    catch (IOException|RuntimeException e)
    {
      logger.debug("Failed to dispatch an event to abort a multipart upload: {}", event);
      throw e;
    }
  }
  
  private AbortMultipartUploadEvent getAbortEvent()
  {
    return 
    
      AbortMultipartUploadEvent.builder().bucket(getRequest().getBucketName()).key(getRequest().getKey()).uploadId(getUploadId()).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEUploadObjectObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */