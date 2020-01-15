package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import com.amazon.ws.emr.hadoop.fs.util.MorePreconditions;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import lombok.NonNull;

public class GetObjectInputStreamWithInfoFactory
  implements InputStreamWithInfoFactory
{
  @NonNull
  private final AmazonS3Lite s3;
  private final String etagVerification;
  
  public static class GetObjectInputStreamWithInfoFactoryBuilder
  {
    private AmazonS3Lite s3;
    private String etagVerification;
    
    public String toString()
    {
      return "GetObjectInputStreamWithInfoFactory.GetObjectInputStreamWithInfoFactoryBuilder(s3=" + s3 + ", etagVerification=" + etagVerification + ")";
    }
    
    public GetObjectInputStreamWithInfoFactory build()
    {
      return new GetObjectInputStreamWithInfoFactory(s3, etagVerification);
    }
    
    public GetObjectInputStreamWithInfoFactoryBuilder etagVerification(String etagVerification)
    {
      this.etagVerification = etagVerification;return this;
    }
    
    public GetObjectInputStreamWithInfoFactoryBuilder s3(AmazonS3Lite s3)
    {
      this.s3 = s3;return this;
    }
  }
  
  GetObjectInputStreamWithInfoFactory(@NonNull AmazonS3Lite s3, String etagVerification)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    this.s3 = s3;this.etagVerification = etagVerification;
  }
  
  public static GetObjectInputStreamWithInfoFactoryBuilder builder()
  {
    return new GetObjectInputStreamWithInfoFactoryBuilder();
  }
  
  public InputStreamWithInfo create(@NonNull String bucket, @NonNull String key, long position, long contentLength, boolean shouldTryInitialTimeout)
    throws IOException
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    checkContentLength(contentLength);
    checkPosition(position, contentLength);
    if (position == contentLength) {
      return new InputStreamWithInfo(new ByteArrayInputStream(new byte[0]), key, contentLength);
    }
    GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, key);
    if (position > 0L) {
      getObjectRequest.setRange(position, contentLength);
    }
    if (etagVerification != null) {
      getObjectRequest.withMatchingETagConstraint(etagVerification);
    }
    S3Object object = s3.getObject(getObjectRequest, shouldTryInitialTimeout);
    if (object == null)
    {
      String errorMessage = String.format("eTag in metadata for File '%s/%s' does not match eTag from S3!", new Object[] { bucket, key });
      
      throw new ConsistencyException(errorMessage, Collections.singletonList(EmrFsUtils.getPathForS3Object(bucket, key)));
    }
    return new InputStreamWithInfo(object.getObjectContent(), key, contentLength);
  }
  
  private void checkContentLength(long contentLength)
  {
    MorePreconditions.checkNotNegative(contentLength, "content length");
  }
  
  private void checkPosition(long position, long contentLength)
    throws EOFException
  {
    MorePreconditions.checkNotNegative(position, "position");
    if (position > contentLength) {
      throw new EOFException(String.format("Invalid position: %d, exceeds the bounds of the stream: [0, %d]", new Object[] {
        Long.valueOf(position), Long.valueOf(contentLength) }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.GetObjectInputStreamWithInfoFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */