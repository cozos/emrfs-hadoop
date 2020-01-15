package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpPost
  extends HttpEntityEnclosingRequestBase
{
  public static final String METHOD_NAME = "POST";
  
  public HttpPost() {}
  
  public HttpPost(URI uri)
  {
    setURI(uri);
  }
  
  public HttpPost(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "POST";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */