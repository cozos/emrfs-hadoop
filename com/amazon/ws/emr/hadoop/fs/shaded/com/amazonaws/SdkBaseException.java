package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class SdkBaseException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public SdkBaseException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public SdkBaseException(String message)
  {
    super(message);
  }
  
  public SdkBaseException(Throwable t)
  {
    super(t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */