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
public class BestMatchSpecFactory
  implements CookieSpecFactory, CookieSpecProvider
{
  private final CookieSpec cookieSpec;
  
  public BestMatchSpecFactory(String[] datepatterns, boolean oneHeader)
  {
    cookieSpec = new BestMatchSpec(datepatterns, oneHeader);
  }
  
  public BestMatchSpecFactory()
  {
    this(null, false);
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
      boolean singleHeader = params.getBooleanParameter("http.protocol.single-cookie-header", false);
      
      return new BestMatchSpec(patterns, singleHeader);
    }
    return new BestMatchSpec();
  }
  
  public CookieSpec create(HttpContext context)
  {
    return cookieSpec;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BestMatchSpecFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */