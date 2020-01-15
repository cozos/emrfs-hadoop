package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface HttpEntity
{
  public abstract boolean isRepeatable();
  
  public abstract boolean isChunked();
  
  public abstract long getContentLength();
  
  public abstract Header getContentType();
  
  public abstract Header getContentEncoding();
  
  public abstract InputStream getContent()
    throws IOException, UnsupportedOperationException;
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract boolean isStreaming();
  
  @Deprecated
  public abstract void consumeContent()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */