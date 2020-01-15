package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.ClientCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie2;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.StringTokenizer;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RFC2965PortAttributeHandler
  implements CommonCookieAttributeHandler
{
  private static int[] parsePortAttribute(String portValue)
    throws MalformedCookieException
  {
    StringTokenizer st = new StringTokenizer(portValue, ",");
    int[] ports = new int[st.countTokens()];
    try
    {
      int i = 0;
      while (st.hasMoreTokens())
      {
        ports[i] = Integer.parseInt(st.nextToken().trim());
        if (ports[i] < 0) {
          throw new MalformedCookieException("Invalid Port attribute.");
        }
        i++;
      }
    }
    catch (NumberFormatException e)
    {
      throw new MalformedCookieException("Invalid Port attribute: " + e.getMessage());
    }
    return ports;
  }
  
  private static boolean portMatch(int port, int[] ports)
  {
    boolean portInList = false;
    for (int port2 : ports) {
      if (port == port2)
      {
        portInList = true;
        break;
      }
    }
    return portInList;
  }
  
  public void parse(SetCookie cookie, String portValue)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if ((cookie instanceof SetCookie2))
    {
      SetCookie2 cookie2 = (SetCookie2)cookie;
      if ((portValue != null) && (!portValue.trim().isEmpty()))
      {
        int[] ports = parsePortAttribute(portValue);
        cookie2.setPorts(ports);
      }
    }
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    int port = origin.getPort();
    if (((cookie instanceof ClientCookie)) && (((ClientCookie)cookie).containsAttribute("port"))) {
      if (!portMatch(port, cookie.getPorts())) {
        throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
      }
    }
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    Args.notNull(cookie, "Cookie");
    Args.notNull(origin, "Cookie origin");
    int port = origin.getPort();
    if (((cookie instanceof ClientCookie)) && (((ClientCookie)cookie).containsAttribute("port")))
    {
      if (cookie.getPorts() == null) {
        return false;
      }
      if (!portMatch(port, cookie.getPorts())) {
        return false;
      }
    }
    return true;
  }
  
  public String getAttributeName()
  {
    return "port";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC2965PortAttributeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */