package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import java.io.IOException;

@Beta
public abstract interface HttpRequestFactory<T>
{
  public abstract T create(Request<?> paramRequest, HttpClientSettings paramHttpClientSettings)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.request.HttpRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */