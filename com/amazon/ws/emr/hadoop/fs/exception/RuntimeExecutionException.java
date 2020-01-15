package com.amazon.ws.emr.hadoop.fs.exception;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;

public class RuntimeExecutionException
  extends RuntimeException
{
  public RuntimeExecutionException(ExecutionException cause)
  {
    super((Throwable)Preconditions.checkNotNull(cause));
  }
  
  public ExecutionException getCause()
  {
    return (ExecutionException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.exception.RuntimeExecutionException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */