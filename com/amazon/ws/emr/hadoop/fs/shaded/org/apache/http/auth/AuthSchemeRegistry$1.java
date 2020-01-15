package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

class AuthSchemeRegistry$1
  implements AuthSchemeProvider
{
  AuthSchemeRegistry$1(AuthSchemeRegistry paramAuthSchemeRegistry, String paramString) {}
  
  public AuthScheme create(HttpContext context)
  {
    HttpRequest request = (HttpRequest)context.getAttribute("http.request");
    
    return this$0.getAuthScheme(val$name, request.getParams());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeRegistry.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */