package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.net.URI;

@Deprecated
public abstract interface RedirectHandler
{
  public abstract boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws ProtocolException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */