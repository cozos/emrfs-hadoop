package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

import java.io.IOException;

public abstract interface ConnFactory<T, C>
{
  public abstract C create(T paramT)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */