package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;

public class HttpClientUtils
{
  public static void closeQuietly(HttpResponse response)
  {
    if (response != null)
    {
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        try
        {
          EntityUtils.consume(entity);
        }
        catch (IOException ex) {}
      }
    }
  }
  
  public static void closeQuietly(CloseableHttpResponse response)
  {
    if (response != null) {
      try
      {
        try
        {
          EntityUtils.consume(response.getEntity());
        }
        finally
        {
          response.close();
        }
      }
      catch (IOException ignore) {}
    }
  }
  
  public static void closeQuietly(HttpClient httpClient)
  {
    if ((httpClient != null) && 
      ((httpClient instanceof Closeable))) {
      try
      {
        ((Closeable)httpClient).close();
      }
      catch (IOException ignore) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.HttpClientUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */