package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Date;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicExpiresHandler
  extends AbstractCookieAttributeHandler
  implements CommonCookieAttributeHandler
{
  private final String[] datepatterns;
  
  public BasicExpiresHandler(String[] datepatterns)
  {
    Args.notNull(datepatterns, "Array of date patterns");
    this.datepatterns = datepatterns;
  }
  
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (value == null) {
      throw new MalformedCookieException("Missing value for 'expires' attribute");
    }
    Date expiry = DateUtils.parseDate(value, datepatterns);
    if (expiry == null) {
      throw new MalformedCookieException("Invalid 'expires' attribute: " + value);
    }
    cookie.setExpiryDate(expiry);
  }
  
  public String getAttributeName()
  {
    return "expires";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BasicExpiresHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */