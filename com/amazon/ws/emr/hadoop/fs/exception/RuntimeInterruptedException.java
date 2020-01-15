package com.amazon.ws.emr.hadoop.fs.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

public class RuntimeInterruptedException
  extends RuntimeException
{
  public RuntimeInterruptedException(InterruptedException cause)
  {
    super((Throwable)Preconditions.checkNotNull(cause));
  }
  
  public InterruptedException getCause()
  {
    return (InterruptedException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.exception.RuntimeInterruptedException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */