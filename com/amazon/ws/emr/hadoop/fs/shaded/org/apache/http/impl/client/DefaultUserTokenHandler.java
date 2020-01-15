package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.UserTokenHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultUserTokenHandler
  implements UserTokenHandler
{
  public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();
  
  public Object getUserToken(HttpContext context)
  {
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    Principal userPrincipal = null;
    
    AuthState targetAuthState = clientContext.getTargetAuthState();
    if (targetAuthState != null)
    {
      userPrincipal = getAuthPrincipal(targetAuthState);
      if (userPrincipal == null)
      {
        AuthState proxyAuthState = clientContext.getProxyAuthState();
        userPrincipal = getAuthPrincipal(proxyAuthState);
      }
    }
    if (userPrincipal == null)
    {
      HttpConnection conn = clientContext.getConnection();
      if ((conn.isOpen()) && ((conn instanceof ManagedHttpClientConnection)))
      {
        SSLSession sslsession = ((ManagedHttpClientConnection)conn).getSSLSession();
        if (sslsession != null) {
          userPrincipal = sslsession.getLocalPrincipal();
        }
      }
    }
    return userPrincipal;
  }
  
  private static Principal getAuthPrincipal(AuthState authState)
  {
    AuthScheme scheme = authState.getAuthScheme();
    if ((scheme != null) && (scheme.isComplete()) && (scheme.isConnectionBased()))
    {
      Credentials creds = authState.getCredentials();
      if (creds != null) {
        return creds.getUserPrincipal();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultUserTokenHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */