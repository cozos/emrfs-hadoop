package com.amazon.ws.emr.hadoop.fs.consistency.exception;

import java.io.IOException;

public final class UnknownMetadataStateException
  extends IOException
{
  public UnknownMetadataStateException(String message)
  {
    super(message);
  }
  
  public UnknownMetadataStateException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public UnknownMetadataStateException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.exception.UnknownMetadataStateException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */