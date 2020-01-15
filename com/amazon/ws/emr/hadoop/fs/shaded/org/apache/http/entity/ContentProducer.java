package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface ContentProducer
{
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */