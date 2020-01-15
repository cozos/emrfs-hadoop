package com.amazon.ws.emr.hadoop.fs.s3.lite.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;

public final class RepeatS3CallException
  extends AmazonClientException
{
  public RepeatS3CallException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public RepeatS3CallException(String message)
  {
    super(message);
  }
  
  public RepeatS3CallException(Throwable t)
  {
    super(t);
  }
  
  public boolean isRetryable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.exception.RepeatS3CallException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */