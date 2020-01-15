package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

public abstract interface HttpMessage
{
  public abstract ProtocolVersion getProtocolVersion();
  
  public abstract boolean containsHeader(String paramString);
  
  public abstract Header[] getHeaders(String paramString);
  
  public abstract Header getFirstHeader(String paramString);
  
  public abstract Header getLastHeader(String paramString);
  
  public abstract Header[] getAllHeaders();
  
  public abstract void addHeader(Header paramHeader);
  
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract void setHeader(Header paramHeader);
  
  public abstract void setHeader(String paramString1, String paramString2);
  
  public abstract void setHeaders(Header[] paramArrayOfHeader);
  
  public abstract void removeHeader(Header paramHeader);
  
  public abstract void removeHeaders(String paramString);
  
  public abstract HeaderIterator headerIterator();
  
  public abstract HeaderIterator headerIterator(String paramString);
  
  @Deprecated
  public abstract HttpParams getParams();
  
  @Deprecated
  public abstract void setParams(HttpParams paramHttpParams);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */