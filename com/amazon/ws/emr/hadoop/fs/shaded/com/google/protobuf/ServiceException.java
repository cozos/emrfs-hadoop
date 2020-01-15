package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public class ServiceException
  extends Exception
{
  private static final long serialVersionUID = -1219262335729891920L;
  
  public ServiceException(String message)
  {
    super(message);
  }
  
  public ServiceException(Throwable cause)
  {
    super(cause);
  }
  
  public ServiceException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ServiceException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */