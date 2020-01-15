package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthProtocolState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestAuthCache
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    AuthCache authCache = clientContext.getAuthCache();
    if (authCache == null)
    {
      log.debug("Auth cache not set in the context");
      return;
    }
    CredentialsProvider credsProvider = clientContext.getCredentialsProvider();
    if (credsProvider == null)
    {
      log.debug("Credentials provider not set in the context");
      return;
    }
    RouteInfo route = clientContext.getHttpRoute();
    if (route == null)
    {
      log.debug("Route info not set in the context");
      return;
    }
    HttpHost target = clientContext.getTargetHost();
    if (target == null)
    {
      log.debug("Target host not set in the context");
      return;
    }
    if (target.getPort() < 0) {
      target = new HttpHost(target.getHostName(), route.getTargetHost().getPort(), target.getSchemeName());
    }
    AuthState targetState = clientContext.getTargetAuthState();
    if ((targetState != null) && (targetState.getState() == AuthProtocolState.UNCHALLENGED))
    {
      AuthScheme authScheme = authCache.get(target);
      if (authScheme != null) {
        doPreemptiveAuth(target, authScheme, targetState, credsProvider);
      }
    }
    HttpHost proxy = route.getProxyHost();
    AuthState proxyState = clientContext.getProxyAuthState();
    if ((proxy != null) && (proxyState != null) && (proxyState.getState() == AuthProtocolState.UNCHALLENGED))
    {
      AuthScheme authScheme = authCache.get(proxy);
      if (authScheme != null) {
        doPreemptiveAuth(proxy, authScheme, proxyState, credsProvider);
      }
    }
  }
  
  private void doPreemptiveAuth(HttpHost host, AuthScheme authScheme, AuthState authState, CredentialsProvider credsProvider)
  {
    String schemeName = authScheme.getSchemeName();
    if (log.isDebugEnabled()) {
      log.debug("Re-using cached '" + schemeName + "' auth scheme for " + host);
    }
    AuthScope authScope = new AuthScope(host, AuthScope.ANY_REALM, schemeName);
    Credentials creds = credsProvider.getCredentials(authScope);
    if (creds != null) {
      authState.update(authScheme, creds);
    } else {
      log.debug("No credentials for preemptive authentication");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAuthCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */