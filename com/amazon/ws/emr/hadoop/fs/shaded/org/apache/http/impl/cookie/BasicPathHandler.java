package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicPathHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    cookie.setPath(!TextUtils.isBlank(value) ? value : "/");
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {}
  
  static boolean pathMatch(String uriPath, String cookiePath)
  {
    String normalizedCookiePath = cookiePath;
    if (normalizedCookiePath == null) {
      normalizedCookiePath = "/";
    }
    if ((normalizedCookiePath.length() > 1) && (normalizedCookiePath.endsWith("/"))) {
      normalizedCookiePath = normalizedCookiePath.substring(0, normalizedCookiePath.length() - 1);
    }
    if (uriPath.startsWith(normalizedCookiePath))
    {
      if (normalizedCookiePath.equals("/")) {
        return true;
      }
      if (uriPath.length() == normalizedCookiePath.length()) {
        return true;
      }
      if (uriPath.charAt(normalizedCookiePath.length()) == '/') {
        return true;
      }
    }
    return false;
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    return pathMatch(origin.getPath(), cookie.getPath());
  }
  
  public String getAttributeName()
  {
    return "path";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BasicPathHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */