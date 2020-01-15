package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.InetAddressUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.ClientCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.util.Locale;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicDomainHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (TextUtils.isBlank(value)) {
      throw new MalformedCookieException("Blank or null value for domain attribute");
    }
    if (value.endsWith(".")) {
      return;
    }
    String domain = value;
    if (domain.startsWith(".")) {
      domain = domain.substring(1);
    }
    domain = domain.toLowerCase(Locale.ROOT);
    cookie.setDomain(domain);
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    
    String host = origin.getHost();
    String domain = cookie.getDomain();
    if (domain == null) {
      throw new CookieRestrictionViolationException("Cookie 'domain' may not be null");
    }
    if ((!host.equals(domain)) && (!domainMatch(domain, host))) {
      throw new CookieRestrictionViolationException("Illegal 'domain' attribute \"" + domain + "\". Domain of origin: \"" + host + "\"");
    }
  }
  
  static boolean domainMatch(String domain, String host)
  {
    if ((InetAddressUtils.isIPv4Address(host)) || (InetAddressUtils.isIPv6Address(host))) {
      return false;
    }
    String normalizedDomain = domain.startsWith(".") ? domain.substring(1) : domain;
    if (host.endsWith(normalizedDomain))
    {
      int prefix = host.length() - normalizedDomain.length();
      if (prefix == 0) {
        return true;
      }
      if ((prefix > 1) && (host.charAt(prefix - 1) == '.')) {
        return true;
      }
    }
    return false;
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
    if (domain.startsWith(".")) {
      domain = domain.substring(1);
    }
    domain = domain.toLowerCase(Locale.ROOT);
    if (host.equals(domain)) {
      return true;
    }
    if (((cookie instanceof ClientCookie)) && 
      (((ClientCookie)cookie).containsAttribute("domain"))) {
      return domainMatch(domain, host);
    }
    return false;
  }
  
  public String getAttributeName()
  {
    return "domain";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BasicDomainHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */