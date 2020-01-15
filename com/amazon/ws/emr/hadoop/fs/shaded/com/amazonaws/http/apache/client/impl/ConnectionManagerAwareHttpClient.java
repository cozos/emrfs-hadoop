package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;

public abstract interface ConnectionManagerAwareHttpClient
  extends HttpClient
{
  public abstract HttpClientConnectionManager getHttpClientConnectionManager();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ConnectionManagerAwareHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */