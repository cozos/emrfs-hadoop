package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import java.io.IOException;

public abstract interface ResponseHandler<T>
{
  public abstract T handleResponse(HttpResponse paramHttpResponse)
    throws ClientProtocolException, IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */