package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.util.Map;

@Deprecated
public abstract interface AuthenticationHandler
{
  public abstract boolean isAuthenticationRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract Map<String, Header> getChallenges(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws MalformedChallengeException;
  
  public abstract AuthScheme selectScheme(Map<String, Header> paramMap, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws AuthenticationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthenticationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */