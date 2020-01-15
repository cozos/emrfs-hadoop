package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.util.Collection;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class RequestDefaultHeaders
  implements HttpRequestInterceptor
{
  private final Collection<? extends Header> defaultHeaders;
  
  public RequestDefaultHeaders(Collection<? extends Header> defaultHeaders)
  {
    this.defaultHeaders = defaultHeaders;
  }
  
  public RequestDefaultHeaders()
  {
    this(null);
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT")) {
      return;
    }
    Collection<? extends Header> defHeaders = (Collection)request.getParams().getParameter("http.default-headers");
    if (defHeaders == null) {
      defHeaders = defaultHeaders;
    }
    if (defHeaders != null) {
      for (Header defHeader : defHeaders) {
        request.addHeader(defHeader);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestDefaultHeaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */