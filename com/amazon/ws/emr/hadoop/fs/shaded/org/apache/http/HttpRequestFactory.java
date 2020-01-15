package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface HttpRequestFactory
{
  public abstract HttpRequest newHttpRequest(RequestLine paramRequestLine)
    throws MethodNotSupportedException;
  
  public abstract HttpRequest newHttpRequest(String paramString1, String paramString2)
    throws MethodNotSupportedException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */