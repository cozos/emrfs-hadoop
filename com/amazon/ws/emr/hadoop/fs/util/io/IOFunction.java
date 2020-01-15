package com.amazon.ws.emr.hadoop.fs.util.io;

import java.io.IOException;

@FunctionalInterface
public abstract interface IOFunction<T, R>
{
  public abstract R apply(T paramT)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.io.IOFunction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */