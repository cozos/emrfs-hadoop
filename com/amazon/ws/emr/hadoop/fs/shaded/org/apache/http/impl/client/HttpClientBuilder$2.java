package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import java.io.Closeable;
import java.io.IOException;

class HttpClientBuilder$2
  implements Closeable
{
  HttpClientBuilder$2(HttpClientBuilder paramHttpClientBuilder, HttpClientConnectionManager paramHttpClientConnectionManager) {}
  
  public void close()
    throws IOException
  {
    val$cm.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClientBuilder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */