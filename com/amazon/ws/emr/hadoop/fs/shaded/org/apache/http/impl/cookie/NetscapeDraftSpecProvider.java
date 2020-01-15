package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Obsolete
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NetscapeDraftSpecProvider
  implements CookieSpecProvider
{
  private final String[] datepatterns;
  private volatile CookieSpec cookieSpec;
  
  public NetscapeDraftSpecProvider(String[] datepatterns)
  {
    this.datepatterns = datepatterns;
  }
  
  public NetscapeDraftSpecProvider()
  {
    this(null);
  }
  
  public CookieSpec create(HttpContext context)
  {
    if (cookieSpec == null) {
      synchronized (this)
      {
        if (cookieSpec == null) {
          cookieSpec = new NetscapeDraftSpec(datepatterns);
        }
      }
    }
    return cookieSpec;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.NetscapeDraftSpecProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */