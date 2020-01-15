package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import java.util.Date;
import java.util.List;

public abstract interface CookieStore
{
  public abstract void addCookie(Cookie paramCookie);
  
  public abstract List<Cookie> getCookies();
  
  public abstract boolean clearExpired(Date paramDate);
  
  public abstract void clear();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */