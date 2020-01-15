package com.amazon.ws.emr.hadoop.fs.consistency.exception;

public final class MalformedItemKeyException
  extends IllegalArgumentException
{
  public MalformedItemKeyException(String message)
  {
    super(message);
  }
  
  public MalformedItemKeyException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public MalformedItemKeyException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.exception.MalformedItemKeyException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */