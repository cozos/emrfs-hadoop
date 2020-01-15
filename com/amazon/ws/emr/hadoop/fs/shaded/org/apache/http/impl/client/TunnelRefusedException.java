package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;

@Deprecated
public class TunnelRefusedException
  extends HttpException
{
  private static final long serialVersionUID = -8646722842745617323L;
  private final HttpResponse response;
  
  public TunnelRefusedException(String message, HttpResponse response)
  {
    super(message);
    this.response = response;
  }
  
  public HttpResponse getResponse()
  {
    return response;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.TunnelRefusedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */