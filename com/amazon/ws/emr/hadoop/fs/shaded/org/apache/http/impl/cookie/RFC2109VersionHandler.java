package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RFC2109VersionHandler
  extends AbstractCookieAttributeHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (value == null) {
      throw new MalformedCookieException("Missing value for version attribute");
    }
    if (value.trim().isEmpty()) {
      throw new MalformedCookieException("Blank value for version attribute");
    }
    try
    {
      cookie.setVersion(Integer.parseInt(value));
    }
    catch (NumberFormatException e)
    {
      throw new MalformedCookieException("Invalid version: " + e.getMessage());
    }
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (cookie.getVersion() < 0) {
      throw new CookieRestrictionViolationException("Cookie version may not be negative");
    }
  }
  
  public String getAttributeName()
  {
    return "version";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC2109VersionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */