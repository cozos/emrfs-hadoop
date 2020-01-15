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
import java.util.Locale;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RFC2109DomainHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (value == null) {
      throw new MalformedCookieException("Missing value for domain attribute");
    }
    if (value.trim().isEmpty()) {
      throw new MalformedCookieException("Blank value for domain attribute");
    }
    cookie.setDomain(value);
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    String host = origin.getHost();
    String domain = cookie.getDomain();
    if (domain == null) {
      throw new CookieRestrictionViolationException("Cookie domain may not be null");
    }
    if (!domain.equals(host))
    {
      int dotIndex = domain.indexOf('.');
      if (dotIndex == -1) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + domain + "\" does not match the host \"" + host + "\"");
      }
      if (!domain.startsWith(".")) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + domain + "\" violates RFC 2109: domain must start with a dot");
      }
      dotIndex = domain.indexOf('.', 1);
      if ((dotIndex < 0) || (dotIndex == domain.length() - 1)) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + domain + "\" violates RFC 2109: domain must contain an embedded dot");
      }
      host = host.toLowerCase(Locale.ROOT);
      if (!host.endsWith(domain)) {
        throw new CookieRestrictionViolationException("Illegal domain attribute \"" + domain + "\". Domain of origin: \"" + host + "\"");
      }
      String hostWithoutDomain = host.substring(0, host.length() - domain.length());
      if (hostWithoutDomain.indexOf('.') != -1) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + domain + "\" violates RFC 2109: host minus domain may not contain any dots");
      }
    }
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    String host = origin.getHost();
    String domain = cookie.getDomain();
    if (domain == null) {
      return false;
    }
    return (host.equals(domain)) || ((domain.startsWith(".")) && (host.endsWith(domain)));
  }
  
  public String getAttributeName()
  {
    return "domain";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC2109DomainHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */