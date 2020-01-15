package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.Scheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicAuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ResponseAuthCache
  implements HttpResponseInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP request");
    Args.notNull(context, "HTTP context");
    AuthCache authCache = (AuthCache)context.getAttribute("http.auth.auth-cache");
    
    HttpHost target = (HttpHost)context.getAttribute("http.target_host");
    AuthState targetState = (AuthState)context.getAttribute("http.auth.target-scope");
    if ((target != null) && (targetState != null))
    {
      if (log.isDebugEnabled()) {
        log.debug("Target auth state: " + targetState.getState());
      }
      if (isCachable(targetState))
      {
        SchemeRegistry schemeRegistry = (SchemeRegistry)context.getAttribute("http.scheme-registry");
        if (target.getPort() < 0)
        {
          Scheme scheme = schemeRegistry.getScheme(target);
          target = new HttpHost(target.getHostName(), scheme.resolvePort(target.getPort()), target.getSchemeName());
        }
        if (authCache == null)
        {
          authCache = new BasicAuthCache();
          context.setAttribute("http.auth.auth-cache", authCache);
        }
        switch (targetState.getState())
        {
        case CHALLENGED: 
          cache(authCache, target, targetState.getAuthScheme());
          break;
        case FAILURE: 
          uncache(authCache, target, targetState.getAuthScheme());
        }
      }
    }
    HttpHost proxy = (HttpHost)context.getAttribute("http.proxy_host");
    AuthState proxyState = (AuthState)context.getAttribute("http.auth.proxy-scope");
    if ((proxy != null) && (proxyState != null))
    {
      if (log.isDebugEnabled()) {
        log.debug("Proxy auth state: " + proxyState.getState());
      }
      if (isCachable(proxyState))
      {
        if (authCache == null)
        {
          authCache = new BasicAuthCache();
          context.setAttribute("http.auth.auth-cache", authCache);
        }
        switch (proxyState.getState())
        {
        case CHALLENGED: 
          cache(authCache, proxy, proxyState.getAuthScheme());
          break;
        case FAILURE: 
          uncache(authCache, proxy, proxyState.getAuthScheme());
        }
      }
    }
  }
  
  private boolean isCachable(AuthState authState)
  {
    AuthScheme authScheme = authState.getAuthScheme();
    if ((authScheme == null) || (!authScheme.isComplete())) {
      return false;
    }
    String schemeName = authScheme.getSchemeName();
    return (schemeName.equalsIgnoreCase("Basic")) || (schemeName.equalsIgnoreCase("Digest"));
  }
  
  private void cache(AuthCache authCache, HttpHost host, AuthScheme authScheme)
  {
    if (log.isDebugEnabled()) {
      log.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + host);
    }
    authCache.put(host, authScheme);
  }
  
  private void uncache(AuthCache authCache, HttpHost host, AuthScheme authScheme)
  {
    if (log.isDebugEnabled()) {
      log.debug("Removing from cache '" + authScheme.getSchemeName() + "' auth scheme for " + host);
    }
    authCache.remove(host);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ResponseAuthCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */