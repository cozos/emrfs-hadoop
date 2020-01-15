package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class LaxMaxAgeHandler
  extends AbstractCookieAttributeHandler
  implements CommonCookieAttributeHandler
{
  private static final Pattern MAX_AGE_PATTERN = Pattern.compile("^\\-?[0-9]+$");
  
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    if (TextUtils.isBlank(value)) {
      return;
    }
    Matcher matcher = MAX_AGE_PATTERN.matcher(value);
    if (matcher.matches())
    {
      int age;
      try
      {
        age = Integer.parseInt(value);
      }
      catch (NumberFormatException e)
      {
        return;
      }
      Date expiryDate = age >= 0 ? new Date(System.currentTimeMillis() + age * 1000L) : new Date(Long.MIN_VALUE);
      
      cookie.setExpiryDate(expiryDate);
    }
  }
  
  public String getAttributeName()
  {
    return "max-age";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.LaxMaxAgeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */