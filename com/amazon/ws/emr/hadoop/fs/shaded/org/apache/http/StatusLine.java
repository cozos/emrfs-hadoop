package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface StatusLine
{
  public abstract ProtocolVersion getProtocolVersion();
  
  public abstract int getStatusCode();
  
  public abstract String getReasonPhrase();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */