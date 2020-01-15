package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.select.SelectObjectRequestGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import com.amazon.ws.emr.hadoop.fs.util.MorePreconditions;
import java.io.EOFException;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;

public class S3SelectInputStreamWithInfoFactory
  implements InputStreamWithInfoFactory
{
  @NonNull
  private final AmazonS3Lite s3;
  @NonNull
  private final Configuration selectOptions;
  
  public S3SelectInputStreamWithInfoFactory(@NonNull AmazonS3Lite s3, @NonNull Configuration selectOptions)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (selectOptions == null) {
      throw new NullPointerException("selectOptions");
    }
    this.s3 = s3;this.selectOptions = selectOptions;
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
    InputStreamWithInfo stream = createStream(bucket, key, contentLength);
    skipStreamToPosition(stream, position);
    return stream;
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
  
  private InputStreamWithInfo createStream(String bucket, String key, long contentLength)
  {
    SelectObjectContentRequest request = SelectObjectRequestGenerator.generateRequestFromConfiguration(bucket, key, selectOptions);
    SelectObjectContentResult result = s3.selectObjectContent(request);
    return new InputStreamWithInfo(result.getPayload(), key, selectOptions, contentLength);
  }
  
  private void skipStreamToPosition(InputStreamWithInfo stream, long position)
    throws IOException
  {
    if (position > 0L)
    {
      long skippedBytes = stream.skip(position);
      if (skippedBytes != position)
      {
        String msg = String.format("Unable to start from position %d, actually skipped %d. Might be because the position exceeds the bounds of response stream", new Object[] {
        
          Long.valueOf(position), Long.valueOf(skippedBytes) });
        throw new IOException(msg);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3SelectInputStreamWithInfoFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */