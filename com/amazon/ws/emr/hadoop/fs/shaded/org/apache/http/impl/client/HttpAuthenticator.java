package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Deprecated
public class HttpAuthenticator
  extends com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.HttpAuthenticator
{
  public HttpAuthenticator(Log log)
  {
    super(log);
  }
  
  public HttpAuthenticator() {}
  
  public boolean authenticate(HttpHost host, HttpResponse response, AuthenticationStrategy authStrategy, AuthState authState, HttpContext context)
  {
    return handleAuthChallenge(host, response, authStrategy, authState, context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpAuthenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */