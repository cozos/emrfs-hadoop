package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.FormattedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HTTP;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
abstract class AuthenticationStrategyImpl
  implements AuthenticationStrategy
{
  private final Log log = LogFactory.getLog(getClass());
  private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[] { "Negotiate", "Kerberos", "NTLM", "CredSSP", "Digest", "Basic" }));
  private final int challengeCode;
  private final String headerName;
  
  AuthenticationStrategyImpl(int challengeCode, String headerName)
  {
    this.challengeCode = challengeCode;
    this.headerName = headerName;
  }
  
  public boolean isAuthenticationRequested(HttpHost authhost, HttpResponse response, HttpContext context)
  {
    Args.notNull(response, "HTTP response");
    int status = response.getStatusLine().getStatusCode();
    return status == challengeCode;
  }
  
  public Map<String, Header> getChallenges(HttpHost authhost, HttpResponse response, HttpContext context)
    throws MalformedChallengeException
  {
    Args.notNull(response, "HTTP response");
    Header[] headers = response.getHeaders(headerName);
    Map<String, Header> map = new HashMap(headers.length);
    for (Header header : headers)
    {
      int pos;
      CharArrayBuffer buffer;
      int pos;
      if ((header instanceof FormattedHeader))
      {
        CharArrayBuffer buffer = ((FormattedHeader)header).getBuffer();
        pos = ((FormattedHeader)header).getValuePos();
      }
      else
      {
        String s = header.getValue();
        if (s == null) {
          throw new MalformedChallengeException("Header value is null");
        }
        buffer = new CharArrayBuffer(s.length());
        buffer.append(s);
        pos = 0;
      }
      while ((pos < buffer.length()) && (HTTP.isWhitespace(buffer.charAt(pos)))) {
        pos++;
      }
      int beginIndex = pos;
      while ((pos < buffer.length()) && (!HTTP.isWhitespace(buffer.charAt(pos)))) {
        pos++;
      }
      int endIndex = pos;
      String s = buffer.substring(beginIndex, endIndex);
      map.put(s.toLowerCase(Locale.ROOT), header);
    }
    return map;
  }
  
  abstract Collection<String> getPreferredAuthSchemes(RequestConfig paramRequestConfig);
  
  public Queue<AuthOption> select(Map<String, Header> challenges, HttpHost authhost, HttpResponse response, HttpContext context)
    throws MalformedChallengeException
  {
    Args.notNull(challenges, "Map of auth challenges");
    Args.notNull(authhost, "Host");
    Args.notNull(response, "HTTP response");
    Args.notNull(context, "HTTP context");
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    Queue<AuthOption> options = new LinkedList();
    Lookup<AuthSchemeProvider> registry = clientContext.getAuthSchemeRegistry();
    if (registry == null)
    {
      log.debug("Auth scheme registry not set in the context");
      return options;
    }
    CredentialsProvider credsProvider = clientContext.getCredentialsProvider();
    if (credsProvider == null)
    {
      log.debug("Credentials provider not set in the context");
      return options;
    }
    RequestConfig config = clientContext.getRequestConfig();
    Collection<String> authPrefs = getPreferredAuthSchemes(config);
    if (authPrefs == null) {
      authPrefs = DEFAULT_SCHEME_PRIORITY;
    }
    if (log.isDebugEnabled()) {
      log.debug("Authentication schemes in the order of preference: " + authPrefs);
    }
    for (String id : authPrefs)
    {
      Header challenge = (Header)challenges.get(id.toLowerCase(Locale.ROOT));
      if (challenge != null)
      {
        AuthSchemeProvider authSchemeProvider = (AuthSchemeProvider)registry.lookup(id);
        if (authSchemeProvider == null)
        {
          if (log.isWarnEnabled()) {
            log.warn("Authentication scheme " + id + " not supported");
          }
        }
        else
        {
          AuthScheme authScheme = authSchemeProvider.create(context);
          authScheme.processChallenge(challenge);
          
          AuthScope authScope = new AuthScope(authhost, authScheme.getRealm(), authScheme.getSchemeName());
          
          Credentials credentials = credsProvider.getCredentials(authScope);
          if (credentials != null) {
            options.add(new AuthOption(authScheme, credentials));
          }
        }
      }
      else if (log.isDebugEnabled())
      {
        log.debug("Challenge for " + id + " authentication scheme not available");
      }
    }
    return options;
  }
  
  public void authSucceeded(HttpHost authhost, AuthScheme authScheme, HttpContext context)
  {
    Args.notNull(authhost, "Host");
    Args.notNull(authScheme, "Auth scheme");
    Args.notNull(context, "HTTP context");
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    if (isCachable(authScheme))
    {
      AuthCache authCache = clientContext.getAuthCache();
      if (authCache == null)
      {
        authCache = new BasicAuthCache();
        clientContext.setAuthCache(authCache);
      }
      if (log.isDebugEnabled()) {
        log.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + authhost);
      }
      authCache.put(authhost, authScheme);
    }
  }
  
  protected boolean isCachable(AuthScheme authScheme)
  {
    if ((authScheme == null) || (!authScheme.isComplete())) {
      return false;
    }
    String schemeName = authScheme.getSchemeName();
    return schemeName.equalsIgnoreCase("Basic");
  }
  
  public void authFailed(HttpHost authhost, AuthScheme authScheme, HttpContext context)
  {
    Args.notNull(authhost, "Host");
    Args.notNull(context, "HTTP context");
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    AuthCache authCache = clientContext.getAuthCache();
    if (authCache != null)
    {
      if (log.isDebugEnabled()) {
        log.debug("Clearing cached auth scheme for " + authhost);
      }
      authCache.remove(authhost);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.AuthenticationStrategyImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */