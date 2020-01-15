package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.IOException;

public class IOExceptionWithCause
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public IOExceptionWithCause(String message, Throwable cause)
  {
    super(message);
    initCause(cause);
  }
  
  public IOExceptionWithCause(Throwable cause)
  {
    super(cause == null ? null : cause.toString());
    initCause(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.IOExceptionWithCause
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */