package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.request.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;

public class HttpGetWithBody
  extends HttpEntityEnclosingRequestBase
{
  public HttpGetWithBody(String uri)
  {
    setURI(URI.create(uri));
  }
  
  public String getMethod()
  {
    return "GET";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.request.impl.HttpGetWithBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */