package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;

@Contract(threading=ThreadingBehavior.SAFE)
public class RFC6265LaxSpec
  extends RFC6265CookieSpecBase
{
  public RFC6265LaxSpec()
  {
    super(new CommonCookieAttributeHandler[] { new BasicPathHandler(), new BasicDomainHandler(), new LaxMaxAgeHandler(), new BasicSecureHandler(), new LaxExpiresHandler() });
  }
  
  RFC6265LaxSpec(CommonCookieAttributeHandler... handlers)
  {
    super(handlers);
  }
  
  public String toString()
  {
    return "rfc6265-lax";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC6265LaxSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */