package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class HttpClientBuilder$1
  implements Closeable
{
  HttpClientBuilder$1(HttpClientBuilder paramHttpClientBuilder, IdleConnectionEvictor paramIdleConnectionEvictor) {}
  
  public void close()
    throws IOException
  {
    val$connectionEvictor.shutdown();
    try
    {
      val$connectionEvictor.awaitTermination(1L, TimeUnit.SECONDS);
    }
    catch (InterruptedException interrupted)
    {
      Thread.currentThread().interrupt();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClientBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */