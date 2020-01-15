package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public abstract class AbstractCookieAttributeHandler
  implements CookieAttributeHandler
{
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {}
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.AbstractCookieAttributeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */