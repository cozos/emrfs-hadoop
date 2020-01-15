package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthOption;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.util.Map;
import java.util.Queue;

public abstract interface AuthenticationStrategy
{
  public abstract boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract Map<String, Header> getChallenges(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws MalformedChallengeException;
  
  public abstract Queue<AuthOption> select(Map<String, Header> paramMap, HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws MalformedChallengeException;
  
  public abstract void authSucceeded(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext);
  
  public abstract void authFailed(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */