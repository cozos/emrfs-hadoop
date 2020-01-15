package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;

@SdkInternalApi
public class HttpRequestAbortTaskImpl
  implements HttpRequestAbortTask
{
  private final HttpRequestBase httpRequest;
  private volatile boolean httpRequestAborted;
  
  public HttpRequestAbortTaskImpl(HttpRequestBase httpRequest)
  {
    this.httpRequest = httpRequest;
  }
  
  public void run()
  {
    if (!httpRequest.isAborted())
    {
      httpRequestAborted = true;
      httpRequest.abort();
    }
  }
  
  public boolean httpRequestAborted()
  {
    return httpRequestAborted;
  }
  
  public boolean isEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.request.HttpRequestAbortTaskImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */