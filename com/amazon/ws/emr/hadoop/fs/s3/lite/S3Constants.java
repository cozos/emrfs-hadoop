package com.amazon.ws.emr.hadoop.fs.s3.lite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class S3Constants
{
  private static final Logger logger = LoggerFactory.getLogger(S3Constants.class);
  private static final String STREAM_BUFFER_SIZE_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.s3.defaultStreamBufferSize";
  
  private S3Constants()
  {
    throw new AssertionError();
  }
  
  public static Integer getS3StreamBufferSize()
  {
    String bufferSizeOverride = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.s3.defaultStreamBufferSize");
    if (bufferSizeOverride != null) {
      try
      {
        return Integer.valueOf(Integer.parseInt(bufferSizeOverride));
      }
      catch (NumberFormatException e)
      {
        logger.warn("Unable to parse buffer size override from value: {}", bufferSizeOverride);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.S3Constants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */