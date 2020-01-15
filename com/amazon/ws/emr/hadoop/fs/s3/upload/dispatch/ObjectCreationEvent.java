package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import java.io.InputStream;
import lombok.NonNull;

public final class ObjectCreationEvent
{
  @NonNull
  private final String bucket;
  @NonNull
  private final String key;
  @NonNull
  private final InputStream contentStream;
  private final long contentLength;
  private final String contentMD5;
  private final String serverSideEncryptionAlgorithm;
  private final ProgressListener progressListener;
  @NonNull
  private final ExtraUploadMetadata extraUploadMetadata;
  
  public static class ObjectCreationEventBuilder
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
  
  ObjectCreationEvent(@NonNull String bucket, @NonNull String key, @NonNull InputStream contentStream, long contentLength, String contentMD5, String serverSideEncryptionAlgorithm, ProgressListener progressListener, @NonNull ExtraUploadMetadata extraUploadMetadata)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (contentStream == null) {
      throw new NullPointerException("contentStream");
    }
    if (extraUploadMetadata == null) {
      throw new NullPointerException("extraUploadMetadata");
    }
    this.bucket = bucket;this.key = key;this.contentStream = contentStream;this.contentLength = contentLength;this.contentMD5 = contentMD5;this.serverSideEncryptionAlgorithm = serverSideEncryptionAlgorithm;this.progressListener = progressListener;this.extraUploadMetadata = extraUploadMetadata;
  }
  
  public static ObjectCreationEventBuilder builder()
  {
    return new ObjectCreationEventBuilder();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ObjectCreationEvent)) {
      return false;
    }
    ObjectCreationEvent other = (ObjectCreationEvent)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$key = getKey();Object other$key = other.getKey();
    if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
      return false;
    }
    Object this$contentStream = getContentStream();Object other$contentStream = other.getContentStream();
    if (this$contentStream == null ? other$contentStream != null : !this$contentStream.equals(other$contentStream)) {
      return false;
    }
    if (getContentLength() != other.getContentLength()) {
      return false;
    }
    Object this$contentMD5 = getContentMD5();Object other$contentMD5 = other.getContentMD5();
    if (this$contentMD5 == null ? other$contentMD5 != null : !this$contentMD5.equals(other$contentMD5)) {
      return false;
    }
    Object this$serverSideEncryptionAlgorithm = getServerSideEncryptionAlgorithm();Object other$serverSideEncryptionAlgorithm = other.getServerSideEncryptionAlgorithm();
    if (this$serverSideEncryptionAlgorithm == null ? other$serverSideEncryptionAlgorithm != null : !this$serverSideEncryptionAlgorithm.equals(other$serverSideEncryptionAlgorithm)) {
      return false;
    }
    Object this$progressListener = getProgressListener();Object other$progressListener = other.getProgressListener();
    if (this$progressListener == null ? other$progressListener != null : !this$progressListener.equals(other$progressListener)) {
      return false;
    }
    Object this$extraUploadMetadata = getExtraUploadMetadata();Object other$extraUploadMetadata = other.getExtraUploadMetadata();return this$extraUploadMetadata == null ? other$extraUploadMetadata == null : this$extraUploadMetadata.equals(other$extraUploadMetadata);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $key = getKey();result = result * 59 + ($key == null ? 43 : $key.hashCode());Object $contentStream = getContentStream();result = result * 59 + ($contentStream == null ? 43 : $contentStream.hashCode());long $contentLength = getContentLength();result = result * 59 + (int)($contentLength >>> 32 ^ $contentLength);Object $contentMD5 = getContentMD5();result = result * 59 + ($contentMD5 == null ? 43 : $contentMD5.hashCode());Object $serverSideEncryptionAlgorithm = getServerSideEncryptionAlgorithm();result = result * 59 + ($serverSideEncryptionAlgorithm == null ? 43 : $serverSideEncryptionAlgorithm.hashCode());Object $progressListener = getProgressListener();result = result * 59 + ($progressListener == null ? 43 : $progressListener.hashCode());Object $extraUploadMetadata = getExtraUploadMetadata();result = result * 59 + ($extraUploadMetadata == null ? 43 : $extraUploadMetadata.hashCode());return result;
  }
  
  public String toString()
  {
    return "ObjectCreationEvent(bucket=" + getBucket() + ", key=" + getKey() + ", contentStream=" + getContentStream() + ", contentLength=" + getContentLength() + ", contentMD5=" + getContentMD5() + ", serverSideEncryptionAlgorithm=" + getServerSideEncryptionAlgorithm() + ", progressListener=" + getProgressListener() + ", extraUploadMetadata=" + getExtraUploadMetadata() + ")";
  }
  
  @NonNull
  public String getBucket()
  {
    return bucket;
  }
  
  @NonNull
  public String getKey()
  {
    return key;
  }
  
  @NonNull
  public InputStream getContentStream()
  {
    return contentStream;
  }
  
  public long getContentLength()
  {
    return contentLength;
  }
  
  public String getContentMD5()
  {
    return contentMD5;
  }
  
  public String getServerSideEncryptionAlgorithm()
  {
    return serverSideEncryptionAlgorithm;
  }
  
  public ProgressListener getProgressListener()
  {
    return progressListener;
  }
  
  @NonNull
  public ExtraUploadMetadata getExtraUploadMetadata()
  {
    return extraUploadMetadata;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ObjectCreationEvent
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */