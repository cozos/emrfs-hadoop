package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BrowserCompatVersionAttributeHandler
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
    int version = 0;
    try
    {
      version = Integer.parseInt(value);
    }
    catch (NumberFormatException e) {}
    cookie.setVersion(version);
  }
  
  public String getAttributeName()
  {
    return "version";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BrowserCompatVersionAttributeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */