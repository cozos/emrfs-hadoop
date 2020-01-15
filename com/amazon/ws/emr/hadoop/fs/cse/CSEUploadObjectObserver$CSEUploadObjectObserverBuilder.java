package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import java.util.function.LongSupplier;

public class CSEUploadObjectObserver$CSEUploadObjectObserverBuilder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEUploadObjectObserver.CSEUploadObjectObserverBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */