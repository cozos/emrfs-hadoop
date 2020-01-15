package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseStatus;

public class PauseException
  extends SdkClientException
{
  private static final long serialVersionUID = 1L;
  private final PauseStatus status;
  
  public PauseException(PauseStatus status)
  {
    super("Failed to pause operation; status=" + status);
    if ((status == null) || (status == PauseStatus.SUCCESS)) {
      throw new IllegalArgumentException();
    }
    this.status = status;
  }
  
  public PauseStatus getPauseStatus()
  {
    return status;
  }
  
  public boolean isRetryable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.PauseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */