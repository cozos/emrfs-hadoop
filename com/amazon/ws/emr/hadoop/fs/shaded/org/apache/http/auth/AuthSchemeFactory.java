package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public abstract interface AuthSchemeFactory
{
  public abstract AuthScheme newInstance(HttpParams paramHttpParams);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */