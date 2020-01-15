package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;

@Contract(threading=ThreadingBehavior.SAFE)
public class RFC6265StrictSpec
  extends RFC6265CookieSpecBase
{
  static final String[] DATE_PATTERNS = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  
  public RFC6265StrictSpec()
  {
    super(new CommonCookieAttributeHandler[] { new BasicPathHandler(), new BasicDomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicExpiresHandler(DATE_PATTERNS) });
  }
  
  RFC6265StrictSpec(CommonCookieAttributeHandler... handlers)
  {
    super(handlers);
  }
  
  public String toString()
  {
    return "rfc6265-strict";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC6265StrictSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */