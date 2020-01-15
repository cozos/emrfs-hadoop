package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

public class AmazonClientException
  extends SdkBaseException
{
  private static final long serialVersionUID = 1L;
  
  public AmazonClientException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public AmazonClientException(String message)
  {
    super(message);
  }
  
  public AmazonClientException(Throwable t)
  {
    super(t);
  }
  
  @SdkInternalApi
  public boolean isRetryable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */