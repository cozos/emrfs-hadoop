package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;
import java.util.List;

public abstract interface CookieSpec
{
  @Obsolete
  public abstract int getVersion();
  
  public abstract List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin)
    throws MalformedCookieException;
  
  public abstract void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
    throws MalformedCookieException;
  
  public abstract boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  public abstract List<Header> formatCookies(List<Cookie> paramList);
  
  @Obsolete
  public abstract Header getVersionHeader();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */