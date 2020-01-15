package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Deprecated
public abstract class HttpAbstractParamBean
{
  protected final HttpParams params;
  
  public HttpAbstractParamBean(HttpParams params)
  {
    this.params = ((HttpParams)Args.notNull(params, "HTTP parameters"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */