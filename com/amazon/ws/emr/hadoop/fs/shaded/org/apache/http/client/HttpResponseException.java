package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

public class HttpResponseException
  extends ClientProtocolException
{
  private static final long serialVersionUID = -7186627969477257933L;
  private final int statusCode;
  
  public HttpResponseException(int statusCode, String s)
  {
    super(s);
    this.statusCode = statusCode;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpResponseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */