package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
class AuthenticationStrategyAdaptor
  implements AuthenticationStrategy
{
  private final Log log = LogFactory.getLog(getClass());
  private final AuthenticationHandler handler;
  
  public AuthenticationStrategyAdaptor(AuthenticationHandler handler)
  {
    this.handler = handler;
  }
  
  public boolean isAuthenticationRequested(HttpHost authhost, HttpResponse response, HttpContext context)
  {
    return handler.isAuthenticationRequested(response, context);
  }
  
  public Map<String, Header> getChallenges(HttpHost authhost, HttpResponse response, HttpContext context)
    throws MalformedChallengeException
  {
    return handler.getChallenges(response, context);
  }
  
  public Queue<AuthOption> select(Map<String, Header> challenges, HttpHost authhost, HttpResponse response, HttpContext context)
    throws MalformedChallengeException
  {
    Args.notNull(challenges, "Map of auth challenges");
    Args.notNull(authhost, "Host");
    Args.notNull(response, "HTTP response");
    Args.notNull(context, "HTTP context");
    
    Queue<AuthOption> options = new LinkedList();
    CredentialsProvider credsProvider = (CredentialsProvider)context.getAttribute("http.auth.credentials-provider");
    if (credsProvider == null)
    {
      log.debug("Credentials provider not set in the context");
      return options;
    }
    AuthScheme authScheme;
    try
    {
      authScheme = handler.selectScheme(challenges, response, context);
    }
    catch (AuthenticationException ex)
    {
      if (log.isWarnEnabled()) {
        log.warn(ex.getMessage(), ex);
      }
      return options;
    }
    String id = authScheme.getSchemeName();
    Header challenge = (Header)challenges.get(id.toLowerCase(Locale.ROOT));
    authScheme.processChallenge(challenge);
    
    AuthScope authScope = new AuthScope(authhost.getHostName(), authhost.getPort(), authScheme.getRealm(), authScheme.getSchemeName());
    
    Credentials credentials = credsProvider.getCredentials(authScope);
    if (credentials != null) {
      options.add(new AuthOption(authScheme, credentials));
    }
    return options;
  }
  
  public void authSucceeded(HttpHost authhost, AuthScheme authScheme, HttpContext context)
  {
    AuthCache authCache = (AuthCache)context.getAttribute("http.auth.auth-cache");
    if (isCachable(authScheme))
    {
      if (authCache == null)
      {
        authCache = new BasicAuthCache();
        context.setAttribute("http.auth.auth-cache", authCache);
      }
      if (log.isDebugEnabled()) {
        log.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + authhost);
      }
      authCache.put(authhost, authScheme);
    }
  }
  
  public void authFailed(HttpHost authhost, AuthScheme authScheme, HttpContext context)
  {
    AuthCache authCache = (AuthCache)context.getAttribute("http.auth.auth-cache");
    if (authCache == null) {
      return;
    }
    if (log.isDebugEnabled()) {
      log.debug("Removing from cache '" + authScheme.getSchemeName() + "' auth scheme for " + authhost);
    }
    authCache.remove(authhost);
  }
  
  private boolean isCachable(AuthScheme authScheme)
  {
    if ((authScheme == null) || (!authScheme.isComplete())) {
      return false;
    }
    String schemeName = authScheme.getSchemeName();
    return schemeName.equalsIgnoreCase("Basic");
  }
  
  public AuthenticationHandler getHandler()
  {
    return handler;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.AuthenticationStrategyAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */