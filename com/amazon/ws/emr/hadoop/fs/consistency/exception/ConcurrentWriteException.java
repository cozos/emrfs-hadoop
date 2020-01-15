package com.amazon.ws.emr.hadoop.fs.consistency.exception;

import java.io.IOException;

public class ConcurrentWriteException
  extends IOException
{
  public ConcurrentWriteException(String message)
  {
    super(message);
  }
  
  public ConcurrentWriteException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public ConcurrentWriteException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.exception.ConcurrentWriteException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */