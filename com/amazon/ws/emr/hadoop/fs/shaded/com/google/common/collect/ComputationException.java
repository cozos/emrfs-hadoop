package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ComputationException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public ComputationException(@Nullable Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */