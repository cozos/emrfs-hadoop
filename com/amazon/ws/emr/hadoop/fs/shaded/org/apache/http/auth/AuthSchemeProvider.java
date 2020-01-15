package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

public abstract interface AuthSchemeProvider
{
  public abstract AuthScheme create(HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */