package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthProtocolState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.ContextAwareAuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class HttpAuthenticator
{
  private final Log log;
  
  public HttpAuthenticator(Log log)
  {
    this.log = (log != null ? log : LogFactory.getLog(getClass()));
  }
  
  public HttpAuthenticator()
  {
    this(null);
  }
  
  public boolean isAuthenticationRequested(HttpHost host, HttpResponse response, AuthenticationStrategy authStrategy, AuthState authState, HttpContext context)
  {
    if (authStrategy.isAuthenticationRequested(host, response, context))
    {
      log.debug("Authentication required");
      if (authState.getState() == AuthProtocolState.SUCCESS) {
        authStrategy.authFailed(host, authState.getAuthScheme(), context);
      }
      return true;
    }
    switch (authState.getState())
    {
    case CHALLENGED: 
    case HANDSHAKE: 
      log.debug("Authentication succeeded");
      authState.setState(AuthProtocolState.SUCCESS);
      authStrategy.authSucceeded(host, authState.getAuthScheme(), context);
      break;
    case SUCCESS: 
      break;
    default: 
      authState.setState(AuthProtocolState.UNCHALLENGED);
    }
    return false;
  }
  
  public boolean handleAuthChallenge(HttpHost host, HttpResponse response, AuthenticationStrategy authStrategy, AuthState authState, HttpContext context)
  {
    try
    {
      if (log.isDebugEnabled()) {
        log.debug(host.toHostString() + " requested authentication");
      }
      Map<String, Header> challenges = authStrategy.getChallenges(host, response, context);
      if (challenges.isEmpty())
      {
        log.debug("Response contains no authentication challenges");
        return false;
      }
      AuthScheme authScheme = authState.getAuthScheme();
      switch (authState.getState())
      {
      case FAILURE: 
        return false;
      case SUCCESS: 
        authState.reset();
        break;
      case CHALLENGED: 
      case HANDSHAKE: 
        if (authScheme == null)
        {
          log.debug("Auth scheme is null");
          authStrategy.authFailed(host, null, context);
          authState.reset();
          authState.setState(AuthProtocolState.FAILURE);
          return false;
        }
      case UNCHALLENGED: 
        if (authScheme != null)
        {
          String id = authScheme.getSchemeName();
          Header challenge = (Header)challenges.get(id.toLowerCase(Locale.ROOT));
          if (challenge != null)
          {
            log.debug("Authorization challenge processed");
            authScheme.processChallenge(challenge);
            if (authScheme.isComplete())
            {
              log.debug("Authentication failed");
              authStrategy.authFailed(host, authState.getAuthScheme(), context);
              authState.reset();
              authState.setState(AuthProtocolState.FAILURE);
              return false;
            }
            authState.setState(AuthProtocolState.HANDSHAKE);
            return true;
          }
          authState.reset();
        }
        break;
      }
      Queue<AuthOption> authOptions = authStrategy.select(challenges, host, response, context);
      if ((authOptions != null) && (!authOptions.isEmpty()))
      {
        if (log.isDebugEnabled()) {
          log.debug("Selected authentication options: " + authOptions);
        }
        authState.setState(AuthProtocolState.CHALLENGED);
        authState.update(authOptions);
        return true;
      }
      return false;
    }
    catch (MalformedChallengeException ex)
    {
      if (log.isWarnEnabled()) {
        log.warn("Malformed challenge: " + ex.getMessage());
      }
      authState.reset();
    }
    return false;
  }
  
  public void generateAuthResponse(HttpRequest request, AuthState authState, HttpContext context)
    throws HttpException, IOException
  {
    AuthScheme authScheme = authState.getAuthScheme();
    Credentials creds = authState.getCredentials();
    switch (authState.getState())
    {
    case FAILURE: 
      return;
    case SUCCESS: 
      ensureAuthScheme(authScheme);
      if (authScheme.isConnectionBased()) {
        return;
      }
      break;
    case CHALLENGED: 
      Queue<AuthOption> authOptions = authState.getAuthOptions();
      if (authOptions != null)
      {
        while (!authOptions.isEmpty())
        {
          AuthOption authOption = (AuthOption)authOptions.remove();
          authScheme = authOption.getAuthScheme();
          creds = authOption.getCredentials();
          authState.update(authScheme, creds);
          if (log.isDebugEnabled()) {
            log.debug("Generating response to an authentication challenge using " + authScheme.getSchemeName() + " scheme");
          }
          try
          {
            Header header = doAuth(authScheme, creds, request, context);
            request.addHeader(header);
          }
          catch (AuthenticationException ex)
          {
            if (log.isWarnEnabled()) {
              log.warn(authScheme + " authentication error: " + ex.getMessage());
            }
          }
        }
        return;
      }
      ensureAuthScheme(authScheme);
    }
    if (authScheme != null) {
      try
      {
        Header header = doAuth(authScheme, creds, request, context);
        request.addHeader(header);
      }
      catch (AuthenticationException ex)
      {
        if (log.isErrorEnabled()) {
          log.error(authScheme + " authentication error: " + ex.getMessage());
        }
      }
    }
  }
  
  private void ensureAuthScheme(AuthScheme authScheme)
  {
    Asserts.notNull(authScheme, "Auth scheme");
  }
  
  private Header doAuth(AuthScheme authScheme, Credentials creds, HttpRequest request, HttpContext context)
    throws AuthenticationException
  {
    if ((authScheme instanceof ContextAwareAuthScheme)) {
      return ((ContextAwareAuthScheme)authScheme).authenticate(creds, request, context);
    }
    return authScheme.authenticate(creds, request);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.HttpAuthenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */