package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;

public abstract interface AuthCache
{
  public abstract void put(HttpHost paramHttpHost, AuthScheme paramAuthScheme);
  
  public abstract AuthScheme get(HttpHost paramHttpHost);
  
  public abstract void remove(HttpHost paramHttpHost);
  
  public abstract void clear();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */