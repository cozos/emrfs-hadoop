package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;

public abstract interface ConnectionBackoffStrategy
{
  public abstract boolean shouldBackoff(Throwable paramThrowable);
  
  public abstract boolean shouldBackoff(HttpResponse paramHttpResponse);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ConnectionBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */