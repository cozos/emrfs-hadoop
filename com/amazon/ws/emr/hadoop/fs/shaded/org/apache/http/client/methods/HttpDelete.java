package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import java.net.URI;

public class HttpDelete
  extends HttpRequestBase
{
  public static final String METHOD_NAME = "DELETE";
  
  public HttpDelete() {}
  
  public HttpDelete(URI uri)
  {
    setURI(uri);
  }
  
  public HttpDelete(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "DELETE";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpDelete
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */