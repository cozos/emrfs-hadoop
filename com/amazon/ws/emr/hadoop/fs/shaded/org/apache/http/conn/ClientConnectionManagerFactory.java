package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public abstract interface ClientConnectionManagerFactory
{
  public abstract ClientConnectionManager newInstance(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */