package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpHead
  extends HttpRequestBase
{
  public static final String METHOD_NAME = "HEAD";
  
  public HttpHead() {}
  
  public HttpHead(URI uri)
  {
    setURI(uri);
  }
  
  public HttpHead(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "HEAD";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpHead
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */