package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestConnControl
  implements HttpRequestInterceptor
{
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT")) {
      return;
    }
    if (!request.containsHeader("Connection")) {
      request.addHeader("Connection", "Keep-Alive");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestConnControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */