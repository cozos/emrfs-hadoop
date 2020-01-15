package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

public abstract interface AsyncFunction<I, O>
{
  public abstract ListenableFuture<O> apply(I paramI)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AsyncFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */