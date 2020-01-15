package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import javax.annotation.Nullable;

public class UncheckedTimeoutException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public UncheckedTimeoutException() {}
  
  public UncheckedTimeoutException(@Nullable String message)
  {
    super(message);
  }
  
  public UncheckedTimeoutException(@Nullable Throwable cause)
  {
    super(cause);
  }
  
  public UncheckedTimeoutException(@Nullable String message, @Nullable Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */