package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class AbortedException
  extends SdkClientException
{
  private static final long serialVersionUID = 1L;
  
  public AbortedException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public AbortedException(Throwable t)
  {
    super("", t);
  }
  
  public AbortedException(String message)
  {
    super(message);
  }
  
  public AbortedException()
  {
    super("");
  }
  
  public boolean isRetryable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */