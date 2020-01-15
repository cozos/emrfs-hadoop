package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.util.Collection;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NetscapeDraftSpecFactory
  implements CookieSpecFactory, CookieSpecProvider
{
  private final CookieSpec cookieSpec;
  
  public NetscapeDraftSpecFactory(String[] datepatterns)
  {
    cookieSpec = new NetscapeDraftSpec(datepatterns);
  }
  
  public NetscapeDraftSpecFactory()
  {
    this(null);
  }
  
  public CookieSpec newInstance(HttpParams params)
  {
    if (params != null)
    {
      String[] patterns = null;
      Collection<?> param = (Collection)params.getParameter("http.protocol.cookie-datepatterns");
      if (param != null)
      {
        patterns = new String[param.size()];
        patterns = (String[])param.toArray(patterns);
      }
      return new NetscapeDraftSpec(patterns);
    }
    return new NetscapeDraftSpec();
  }
  
  public CookieSpec create(HttpContext context)
  {
    return cookieSpec;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.NetscapeDraftSpecFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */