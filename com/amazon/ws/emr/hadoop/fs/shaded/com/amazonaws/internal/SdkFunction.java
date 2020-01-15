package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

public abstract interface SdkFunction<Input, Output>
{
  public abstract Output apply(Input paramInput);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */