package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClients
{
  public static HttpClientBuilder custom()
  {
    return HttpClientBuilder.create();
  }
  
  public static CloseableHttpClient createDefault()
  {
    return HttpClientBuilder.create().build();
  }
  
  public static CloseableHttpClient createSystem()
  {
    return HttpClientBuilder.create().useSystemProperties().build();
  }
  
  public static CloseableHttpClient createMinimal()
  {
    return new MinimalHttpClient(new PoolingHttpClientConnectionManager());
  }
  
  public static CloseableHttpClient createMinimal(HttpClientConnectionManager connManager)
  {
    return new MinimalHttpClient(connManager);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClients
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */