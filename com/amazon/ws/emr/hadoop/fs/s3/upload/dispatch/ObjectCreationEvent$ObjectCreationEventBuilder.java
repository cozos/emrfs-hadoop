package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import java.io.InputStream;

public class ObjectCreationEvent$ObjectCreationEventBuilder
{
  private String bucket;
  private String key;
  private InputStream contentStream;
  private long contentLength;
  private String contentMD5;
  private String serverSideEncryptionAlgorithm;
  private ProgressListener progressListener;
  private ExtraUploadMetadata extraUploadMetadata;
  
  public String toString()
  {
    return "ObjectCreationEvent.ObjectCreationEventBuilder(bucket=" + bucket + ", key=" + key + ", contentStream=" + contentStream + ", contentLength=" + contentLength + ", contentMD5=" + contentMD5 + ", serverSideEncryptionAlgorithm=" + serverSideEncryptionAlgorithm + ", progressListener=" + progressListener + ", extraUploadMetadata=" + extraUploadMetadata + ")";
  }
  
  public ObjectCreationEvent build()
  {
    return new ObjectCreationEvent(bucket, key, contentStream, contentLength, contentMD5, serverSideEncryptionAlgorithm, progressListener, extraUploadMetadata);
  }
  
  public ObjectCreationEventBuilder extraUploadMetadata(ExtraUploadMetadata extraUploadMetadata)
  {
    this.extraUploadMetadata = extraUploadMetadata;return this;
  }
  
  public ObjectCreationEventBuilder progressListener(ProgressListener progressListener)
  {
    this.progressListener = progressListener;return this;
  }
  
  public ObjectCreationEventBuilder serverSideEncryptionAlgorithm(String serverSideEncryptionAlgorithm)
  {
    this.serverSideEncryptionAlgorithm = serverSideEncryptionAlgorithm;return this;
  }
  
  public ObjectCreationEventBuilder contentMD5(String contentMD5)
  {
    this.contentMD5 = contentMD5;return this;
  }
  
  public ObjectCreationEventBuilder contentLength(long contentLength)
  {
    this.contentLength = contentLength;return this;
  }
  
  public ObjectCreationEventBuilder contentStream(InputStream contentStream)
  {
    this.contentStream = contentStream;return this;
  }
  
  public ObjectCreationEventBuilder key(String key)
  {
    this.key = key;return this;
  }
  
  public ObjectCreationEventBuilder bucket(String bucket)
  {
    this.bucket = bucket;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ObjectCreationEvent.ObjectCreationEventBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */