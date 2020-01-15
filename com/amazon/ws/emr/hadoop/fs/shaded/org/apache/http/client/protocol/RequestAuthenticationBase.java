package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.ContextAwareAuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.util.Queue;

@Deprecated
abstract class RequestAuthenticationBase
  implements HttpRequestInterceptor
{
  final Log log = LogFactory.getLog(getClass());
  
  void process(AuthState authState, HttpRequest request, HttpContext context)
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
            Header header = authenticate(authScheme, creds, request, context);
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
        Header header = authenticate(authScheme, creds, request, context);
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
  
  private Header authenticate(AuthScheme authScheme, Credentials creds, HttpRequest request, HttpContext context)
    throws AuthenticationException
  {
    Asserts.notNull(authScheme, "Auth scheme");
    if ((authScheme instanceof ContextAwareAuthScheme)) {
      return ((ContextAwareAuthScheme)authScheme).authenticate(creds, request, context);
    }
    return authScheme.authenticate(creds, request);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAuthenticationBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */