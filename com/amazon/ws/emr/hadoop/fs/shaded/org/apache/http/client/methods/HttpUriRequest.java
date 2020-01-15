package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import java.net.URI;

public abstract interface HttpUriRequest
  extends HttpRequest
{
  public abstract String getMethod();
  
  public abstract URI getURI();
  
  public abstract void abort()
    throws UnsupportedOperationException;
  
  public abstract boolean isAborted();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */