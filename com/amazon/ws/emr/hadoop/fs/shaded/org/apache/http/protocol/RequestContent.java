package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestContent
  implements HttpRequestInterceptor
{
  private final boolean overwrite;
  
  public RequestContent()
  {
    this(false);
  }
  
  public RequestContent(boolean overwrite)
  {
    this.overwrite = overwrite;
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    if ((request instanceof HttpEntityEnclosingRequest))
    {
      if (overwrite)
      {
        request.removeHeaders("Transfer-Encoding");
        request.removeHeaders("Content-Length");
      }
      else
      {
        if (request.containsHeader("Transfer-Encoding")) {
          throw new ProtocolException("Transfer-encoding header already present");
        }
        if (request.containsHeader("Content-Length")) {
          throw new ProtocolException("Content-Length header already present");
        }
      }
      ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
      HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
      if (entity == null)
      {
        request.addHeader("Content-Length", "0");
        return;
      }
      if ((entity.isChunked()) || (entity.getContentLength() < 0L))
      {
        if (ver.lessEquals(HttpVersion.HTTP_1_0)) {
          throw new ProtocolException("Chunked transfer encoding not allowed for " + ver);
        }
        request.addHeader("Transfer-Encoding", "chunked");
      }
      else
      {
        request.addHeader("Content-Length", Long.toString(entity.getContentLength()));
      }
      if ((entity.getContentType() != null) && (!request.containsHeader("Content-Type"))) {
        request.addHeader(entity.getContentType());
      }
      if ((entity.getContentEncoding() != null) && (!request.containsHeader("Content-Encoding"))) {
        request.addHeader(entity.getContentEncoding());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */