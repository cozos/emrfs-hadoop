package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.List;
import java.util.Map;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultProxyAuthenticationHandler
  extends AbstractAuthenticationHandler
{
  public boolean isAuthenticationRequested(HttpResponse response, HttpContext context)
  {
    Args.notNull(response, "HTTP response");
    int status = response.getStatusLine().getStatusCode();
    return status == 407;
  }
  
  public Map<String, Header> getChallenges(HttpResponse response, HttpContext context)
    throws MalformedChallengeException
  {
    Args.notNull(response, "HTTP response");
    Header[] headers = response.getHeaders("Proxy-Authenticate");
    return parseChallenges(headers);
  }
  
  protected List<String> getAuthPreferences(HttpResponse response, HttpContext context)
  {
    List<String> authpref = (List)response.getParams().getParameter("http.auth.proxy-scheme-pref");
    if (authpref != null) {
      return authpref;
    }
    return super.getAuthPreferences(response, context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultProxyAuthenticationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */