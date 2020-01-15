package com.amazon.ws.emr.hadoop.fs.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;

public class RuntimeIOException
  extends RuntimeException
{
  public RuntimeIOException(IOException cause)
  {
    super((Throwable)Preconditions.checkNotNull(cause));
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.exception.RuntimeIOException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */