package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie2;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RFC2965CommentUrlAttributeHandler
  implements CommonCookieAttributeHandler
{
  public void parse(SetCookie cookie, String commenturl)
    throws MalformedCookieException
  {
    if ((cookie instanceof SetCookie2))
    {
      SetCookie2 cookie2 = (SetCookie2)cookie;
      cookie2.setCommentURL(commenturl);
    }
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {}
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    return true;
  }
  
  public String getAttributeName()
  {
    return "commenturl";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC2965CommentUrlAttributeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */