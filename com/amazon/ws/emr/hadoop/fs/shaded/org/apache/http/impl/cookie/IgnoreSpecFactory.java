package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class IgnoreSpecFactory
  implements CookieSpecFactory, CookieSpecProvider
{
  public CookieSpec newInstance(HttpParams params)
  {
    return new IgnoreSpec();
  }
  
  public CookieSpec create(HttpContext context)
  {
    return new IgnoreSpec();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.IgnoreSpecFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */