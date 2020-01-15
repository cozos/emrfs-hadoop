package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;

class RFC2965Spec$1
  extends BasicPathHandler
{
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    if (!match(cookie, origin)) {
      throw new CookieRestrictionViolationException("Illegal 'path' attribute \"" + cookie.getPath() + "\". Path of origin: \"" + origin.getPath() + "\"");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC2965Spec.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */