package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpTrace
  extends HttpRequestBase
{
  public static final String METHOD_NAME = "TRACE";
  
  public HttpTrace() {}
  
  public HttpTrace(URI uri)
  {
    setURI(uri);
  }
  
  public HttpTrace(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "TRACE";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpTrace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */