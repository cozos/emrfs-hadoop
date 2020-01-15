package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Date;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicMaxAgeHandler
  extends AbstractCookieAttributeHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (value == null) {
      throw new MalformedCookieException("Missing value for 'max-age' attribute");
    }
    int age;
    try
    {
      age = Integer.parseInt(value);
    }
    catch (NumberFormatException e)
    {
      throw new MalformedCookieException("Invalid 'max-age' attribute: " + value);
    }
    if (age < 0) {
      throw new MalformedCookieException("Negative 'max-age' attribute: " + value);
    }
    cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
  }
  
  public String getAttributeName()
  {
    return "max-age";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BasicMaxAgeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */