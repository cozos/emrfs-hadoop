package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class FileLockException
  extends SdkClientException
{
  private static final long serialVersionUID = 1L;
  
  public FileLockException(Throwable t)
  {
    super(t);
  }
  
  public FileLockException(String msg)
  {
    super(msg);
  }
  
  public boolean isRetryable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */