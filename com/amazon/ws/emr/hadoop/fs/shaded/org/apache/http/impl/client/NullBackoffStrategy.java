package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ConnectionBackoffStrategy;

public class NullBackoffStrategy
  implements ConnectionBackoffStrategy
{
  public boolean shouldBackoff(Throwable t)
  {
    return false;
  }
  
  public boolean shouldBackoff(HttpResponse resp)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.NullBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */