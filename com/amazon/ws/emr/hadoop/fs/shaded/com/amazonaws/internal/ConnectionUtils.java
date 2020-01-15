package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

@SdkInternalApi
public class ConnectionUtils
{
  private static ConnectionUtils instance;
  
  public static ConnectionUtils getInstance()
  {
    if (instance == null) {
      instance = new ConnectionUtils();
    }
    return instance;
  }
  
  public HttpURLConnection connectToEndpoint(URI endpoint, Map<String, String> headers)
    throws IOException
  {
    HttpURLConnection connection = (HttpURLConnection)endpoint.toURL().openConnection(Proxy.NO_PROXY);
    connection.setConnectTimeout(2000);
    connection.setReadTimeout(5000);
    connection.setRequestMethod("GET");
    connection.setDoOutput(true);
    for (Map.Entry<String, String> header : headers.entrySet()) {
      connection.addRequestProperty((String)header.getKey(), (String)header.getValue());
    }
    connection.connect();
    
    return connection;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ConnectionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */