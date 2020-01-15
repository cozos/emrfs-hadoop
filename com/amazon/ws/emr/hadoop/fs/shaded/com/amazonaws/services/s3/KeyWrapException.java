package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

public class KeyWrapException
  extends SecurityException
{
  private static final long serialVersionUID = 1L;
  
  public KeyWrapException() {}
  
  public KeyWrapException(String s)
  {
    super(s);
  }
  
  public KeyWrapException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public KeyWrapException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.KeyWrapException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */