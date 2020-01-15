package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.exception;

public class CloneFailedException
  extends RuntimeException
{
  private static final long serialVersionUID = 20091223L;
  
  public CloneFailedException(String message)
  {
    super(message);
  }
  
  public CloneFailedException(Throwable cause)
  {
    super(cause);
  }
  
  public CloneFailedException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.exception.CloneFailedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */