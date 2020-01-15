package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class IgnoreSpecProvider
  implements CookieSpecProvider
{
  private volatile CookieSpec cookieSpec;
  
  public CookieSpec create(HttpContext context)
  {
    if (cookieSpec == null) {
      synchronized (this)
      {
        if (cookieSpec == null) {
          cookieSpec = new IgnoreSpec();
        }
      }
    }
    return cookieSpec;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.IgnoreSpecProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */