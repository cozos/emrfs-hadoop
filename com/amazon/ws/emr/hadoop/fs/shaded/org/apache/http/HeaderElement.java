package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface HeaderElement
{
  public abstract String getName();
  
  public abstract String getValue();
  
  public abstract NameValuePair[] getParameters();
  
  public abstract NameValuePair getParameterByName(String paramString);
  
  public abstract int getParameterCount();
  
  public abstract NameValuePair getParameter(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */