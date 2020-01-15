package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.io.IOException;

public class CRC32MismatchException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public CRC32MismatchException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public CRC32MismatchException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CRC32MismatchException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */