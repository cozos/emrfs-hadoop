package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpPatch
  extends HttpEntityEnclosingRequestBase
{
  public static final String METHOD_NAME = "PATCH";
  
  public HttpPatch() {}
  
  public HttpPatch(URI uri)
  {
    setURI(uri);
  }
  
  public HttpPatch(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */