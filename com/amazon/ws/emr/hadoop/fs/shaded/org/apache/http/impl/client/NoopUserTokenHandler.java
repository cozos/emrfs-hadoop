package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.UserTokenHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NoopUserTokenHandler
  implements UserTokenHandler
{
  public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();
  
  public Object getUserToken(HttpContext context)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.NoopUserTokenHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */