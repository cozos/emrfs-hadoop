package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ExecutionError
  extends Error
{
  private static final long serialVersionUID = 0L;
  
  protected ExecutionError() {}
  
  protected ExecutionError(@Nullable String message)
  {
    super(message);
  }
  
  public ExecutionError(@Nullable String message, @Nullable Error cause)
  {
    super(message, cause);
  }
  
  public ExecutionError(@Nullable Error cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ExecutionError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */