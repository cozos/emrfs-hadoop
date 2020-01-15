package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestExpectContinue
  implements HttpRequestInterceptor
{
  private final boolean activeByDefault;
  
  @Deprecated
  public RequestExpectContinue()
  {
    this(false);
  }
  
  public RequestExpectContinue(boolean activeByDefault)
  {
    this.activeByDefault = activeByDefault;
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    if ((!request.containsHeader("Expect")) && 
      ((request instanceof HttpEntityEnclosingRequest)))
    {
      ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
      HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
      if ((entity != null) && (entity.getContentLength() != 0L) && (!ver.lessEquals(HttpVersion.HTTP_1_0)))
      {
        boolean active = request.getParams().getBooleanParameter("http.protocol.expect-continue", activeByDefault);
        if (active) {
          request.addHeader("Expect", "100-continue");
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestExpectContinue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */