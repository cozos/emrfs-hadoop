package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestUserAgent
  implements HttpRequestInterceptor
{
  private final String userAgent;
  
  public RequestUserAgent(String userAgent)
  {
    this.userAgent = userAgent;
  }
  
  public RequestUserAgent()
  {
    this(null);
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    if (!request.containsHeader("User-Agent"))
    {
      String s = null;
      HttpParams params = request.getParams();
      if (params != null) {
        s = (String)params.getParameter("http.useragent");
      }
      if (s == null) {
        s = userAgent;
      }
      if (s != null) {
        request.addHeader("User-Agent", s);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestUserAgent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */