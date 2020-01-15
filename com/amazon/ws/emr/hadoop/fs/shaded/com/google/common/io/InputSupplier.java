package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;

@Deprecated
public abstract interface InputSupplier<T>
{
  public abstract T getInput()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.InputSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */