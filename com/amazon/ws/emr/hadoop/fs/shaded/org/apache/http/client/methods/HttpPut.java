package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpPut
  extends HttpEntityEnclosingRequestBase
{
  public static final String METHOD_NAME = "PUT";
  
  public HttpPut() {}
  
  public HttpPut(URI uri)
  {
    setURI(uri);
  }
  
  public HttpPut(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "PUT";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */