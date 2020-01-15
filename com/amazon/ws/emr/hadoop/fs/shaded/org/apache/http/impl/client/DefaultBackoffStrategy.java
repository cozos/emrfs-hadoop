package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ConnectionBackoffStrategy;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class DefaultBackoffStrategy
  implements ConnectionBackoffStrategy
{
  public boolean shouldBackoff(Throwable t)
  {
    return ((t instanceof SocketTimeoutException)) || ((t instanceof ConnectException));
  }
  
  public boolean shouldBackoff(HttpResponse resp)
  {
    return resp.getStatusLine().getStatusCode() == 503;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */