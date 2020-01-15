package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Contract(threading=ThreadingBehavior.SAFE)
public abstract class CookieSpecBase
  extends AbstractCookieSpec
{
  public CookieSpecBase() {}
  
  protected CookieSpecBase(HashMap<String, CookieAttributeHandler> map)
  {
    super(map);
  }
  
  protected CookieSpecBase(CommonCookieAttributeHandler... handlers)
  {
    super(handlers);
  }
  
  protected static String getDefaultPath(CookieOrigin origin)
  {
    String defaultPath = origin.getPath();
    int lastSlashIndex = defaultPath.lastIndexOf('/');
    if (lastSlashIndex >= 0)
    {
      if (lastSlashIndex == 0) {
        lastSlashIndex = 1;
      }
      defaultPath = defaultPath.substring(0, lastSlashIndex);
    }
    return defaultPath;
  }
  
  protected static String getDefaultDomain(CookieOrigin origin)
  {
    return origin.getHost();
  }
  
  protected List<Cookie> parse(HeaderElement[] elems, CookieOrigin origin)
    throws MalformedCookieException
  {
    List<Cookie> cookies = new ArrayList(elems.length);
    for (HeaderElement headerelement : elems)
    {
      String name = headerelement.getName();
      String value = headerelement.getValue();
      if ((name != null) && (!name.isEmpty()))
      {
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        
        NameValuePair[] attribs = headerelement.getParameters();
        for (int j = attribs.length - 1; j >= 0; j--)
        {
          NameValuePair attrib = attribs[j];
          String s = attrib.getName().toLowerCase(Locale.ROOT);
          
          cookie.setAttribute(s, attrib.getValue());
          
          CookieAttributeHandler handler = findAttribHandler(s);
          if (handler != null) {
            handler.parse(cookie, attrib.getValue());
          }
        }
        cookies.add(cookie);
      }
    }
    return cookies;
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    for (CookieAttributeHandler handler : getAttribHandlers()) {
      handler.validate(cookie, origin);
    }
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    for (CookieAttributeHandler handler : getAttribHandlers()) {
      if (!handler.match(cookie, origin)) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.CookieSpecBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */