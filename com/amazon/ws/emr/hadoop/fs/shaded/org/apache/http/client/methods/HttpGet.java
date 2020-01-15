package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpGet
  extends HttpRequestBase
{
  public static final String METHOD_NAME = "GET";
  
  public HttpGet() {}
  
  public HttpGet(URI uri)
  {
    setURI(uri);
  }
  
  public HttpGet(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "GET";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpGet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */