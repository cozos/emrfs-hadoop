package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

public abstract interface CookieAttributeHandler
{
  public abstract void parse(SetCookie paramSetCookie, String paramString)
    throws MalformedCookieException;
  
  public abstract void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
    throws MalformedCookieException;
  
  public abstract boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieAttributeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */