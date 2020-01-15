package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;

public abstract interface InputStreamFactory
{
  public abstract InputStream create(InputStream paramInputStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.InputStreamFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */