package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;

@Deprecated
public abstract interface OutputSupplier<T>
{
  public abstract T getOutput()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.OutputSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */