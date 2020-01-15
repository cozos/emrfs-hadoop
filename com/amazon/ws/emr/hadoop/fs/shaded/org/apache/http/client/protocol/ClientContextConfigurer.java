package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Deprecated
public class ClientContextConfigurer
  implements ClientContext
{
  private final HttpContext context;
  
  public ClientContextConfigurer(HttpContext context)
  {
    Args.notNull(context, "HTTP context");
    this.context = context;
  }
  
  public void setCookieSpecRegistry(CookieSpecRegistry registry)
  {
    context.setAttribute("http.cookiespec-registry", registry);
  }
  
  public void setAuthSchemeRegistry(AuthSchemeRegistry registry)
  {
    context.setAttribute("http.authscheme-registry", registry);
  }
  
  public void setCookieStore(CookieStore store)
  {
    context.setAttribute("http.cookie-store", store);
  }
  
  public void setCredentialsProvider(CredentialsProvider provider)
  {
    context.setAttribute("http.auth.credentials-provider", provider);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ClientContextConfigurer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */