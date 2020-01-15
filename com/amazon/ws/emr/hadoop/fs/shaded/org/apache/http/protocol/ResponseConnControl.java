package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ResponseConnControl
  implements HttpResponseInterceptor
{
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    
    HttpCoreContext corecontext = HttpCoreContext.adapt(context);
    
    int status = response.getStatusLine().getStatusCode();
    if ((status == 400) || (status == 408) || (status == 411) || (status == 413) || (status == 414) || (status == 503) || (status == 501))
    {
      response.setHeader("Connection", "Close");
      return;
    }
    Header explicit = response.getFirstHeader("Connection");
    if ((explicit != null) && ("Close".equalsIgnoreCase(explicit.getValue()))) {
      return;
    }
    HttpEntity entity = response.getEntity();
    if (entity != null)
    {
      ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
      if ((entity.getContentLength() < 0L) && ((!entity.isChunked()) || (ver.lessEquals(HttpVersion.HTTP_1_0))))
      {
        response.setHeader("Connection", "Close");
        return;
      }
    }
    HttpRequest request = corecontext.getRequest();
    if (request != null)
    {
      Header header = request.getFirstHeader("Connection");
      if (header != null) {
        response.setHeader("Connection", header.getValue());
      } else if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
        response.setHeader("Connection", "Close");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ResponseConnControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */