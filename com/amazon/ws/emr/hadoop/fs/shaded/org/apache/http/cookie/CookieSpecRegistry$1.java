package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

class CookieSpecRegistry$1
  implements CookieSpecProvider
{
  CookieSpecRegistry$1(CookieSpecRegistry paramCookieSpecRegistry, String paramString) {}
  
  public CookieSpec create(HttpContext context)
  {
    HttpRequest request = (HttpRequest)context.getAttribute("http.request");
    
    return this$0.getCookieSpec(val$name, request.getParams());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecRegistry.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */