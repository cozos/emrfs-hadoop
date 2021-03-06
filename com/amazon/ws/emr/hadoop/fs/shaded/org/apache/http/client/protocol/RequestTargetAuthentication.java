package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestTargetAuthentication
  extends RequestAuthenticationBase
{
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT")) {
      return;
    }
    if (request.containsHeader("Authorization")) {
      return;
    }
    AuthState authState = (AuthState)context.getAttribute("http.auth.target-scope");
    if (authState == null)
    {
      log.debug("Target auth state not set in the context");
      return;
    }
    if (log.isDebugEnabled()) {
      log.debug("Target auth state: " + authState.getState());
    }
    process(authState, request, context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestTargetAuthentication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */