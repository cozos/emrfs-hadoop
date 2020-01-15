package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;

public abstract interface SchemePortResolver
{
  public abstract int resolve(HttpHost paramHttpHost)
    throws UnsupportedSchemeException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */