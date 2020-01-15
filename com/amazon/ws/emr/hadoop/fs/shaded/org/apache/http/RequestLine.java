package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface RequestLine
{
  public abstract String getMethod();
  
  public abstract ProtocolVersion getProtocolVersion();
  
  public abstract String getUri();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */