package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;

@Beta
public abstract interface HttpClientFactory<T>
{
  public abstract T create(HttpClientSettings paramHttpClientSettings);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.client.HttpClientFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */