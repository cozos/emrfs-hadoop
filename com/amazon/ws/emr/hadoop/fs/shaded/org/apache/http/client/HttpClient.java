package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

public abstract interface HttpClient
{
  @Deprecated
  public abstract HttpParams getParams();
  
  @Deprecated
  public abstract ClientConnectionManager getConnectionManager();
  
  public abstract HttpResponse execute(HttpUriRequest paramHttpUriRequest)
    throws IOException, ClientProtocolException;
  
  public abstract HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException;
  
  public abstract HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws IOException, ClientProtocolException;
  
  public abstract HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException;
  
  public abstract <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException;
  
  public abstract <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException;
  
  public abstract <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException;
  
  public abstract <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */