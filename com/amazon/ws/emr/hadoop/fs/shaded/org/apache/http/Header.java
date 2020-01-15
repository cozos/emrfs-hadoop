package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface Header
  extends NameValuePair
{
  public abstract HeaderElement[] getElements()
    throws ParseException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */