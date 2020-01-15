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
public class BrowserCompatSpecFactory
  implements CookieSpecFactory, CookieSpecProvider
{
  private final SecurityLevel securityLevel;
  private final CookieSpec cookieSpec;
  
  public static enum SecurityLevel
  {
    SECURITYLEVEL_DEFAULT,  SECURITYLEVEL_IE_MEDIUM;
    
    private SecurityLevel() {}
  }
  
  public BrowserCompatSpecFactory(String[] datepatterns, SecurityLevel securityLevel)
  {
    this.securityLevel = securityLevel;
    cookieSpec = new BrowserCompatSpec(datepatterns, securityLevel);
  }
  
  public BrowserCompatSpecFactory(String[] datepatterns)
  {
    this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
  }
  
  public BrowserCompatSpecFactory()
  {
    this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
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
      return new BrowserCompatSpec(patterns, securityLevel);
    }
    return new BrowserCompatSpec(null, securityLevel);
  }
  
  public CookieSpec create(HttpContext context)
  {
    return cookieSpec;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BrowserCompatSpecFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */