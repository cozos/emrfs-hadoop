package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import java.util.Collections;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class IgnoreSpec
  extends CookieSpecBase
{
  public int getVersion()
  {
    return 0;
  }
  
  public List<Cookie> parse(Header header, CookieOrigin origin)
    throws MalformedCookieException
  {
    return Collections.emptyList();
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    return false;
  }
  
  public List<Header> formatCookies(List<Cookie> cookies)
  {
    return Collections.emptyList();
  }
  
  public Header getVersionHeader()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.IgnoreSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */