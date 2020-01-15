package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;

public final class Response<T>
{
  private final T response;
  private final HttpResponse httpResponse;
  
  public Response(T response, HttpResponse httpResponse)
  {
    this.response = response;
    this.httpResponse = httpResponse;
  }
  
  public T getAwsResponse()
  {
    return (T)response;
  }
  
  public HttpResponse getHttpResponse()
  {
    return httpResponse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */