package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class UncheckedExecutionException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  protected UncheckedExecutionException() {}
  
  protected UncheckedExecutionException(@Nullable String message)
  {
    super(message);
  }
  
  public UncheckedExecutionException(@Nullable String message, @Nullable Throwable cause)
  {
    super(message, cause);
  }
  
  public UncheckedExecutionException(@Nullable Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedExecutionException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */