package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class SdkClientException
  extends AmazonClientException
{
  public SdkClientException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public SdkClientException(String message)
  {
    super(message);
  }
  
  public SdkClientException(Throwable t)
  {
    super(t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */