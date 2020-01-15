package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ResponseContent
  implements HttpResponseInterceptor
{
  private final boolean overwrite;
  
  public ResponseContent()
  {
    this(false);
  }
  
  public ResponseContent(boolean overwrite)
  {
    this.overwrite = overwrite;
  }
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    if (overwrite)
    {
      response.removeHeaders("Transfer-Encoding");
      response.removeHeaders("Content-Length");
    }
    else
    {
      if (response.containsHeader("Transfer-Encoding")) {
        throw new ProtocolException("Transfer-encoding header already present");
      }
      if (response.containsHeader("Content-Length")) {
        throw new ProtocolException("Content-Length header already present");
      }
    }
    ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
    HttpEntity entity = response.getEntity();
    if (entity != null)
    {
      long len = entity.getContentLength();
      if ((entity.isChunked()) && (!ver.lessEquals(HttpVersion.HTTP_1_0))) {
        response.addHeader("Transfer-Encoding", "chunked");
      } else if (len >= 0L) {
        response.addHeader("Content-Length", Long.toString(entity.getContentLength()));
      }
      if ((entity.getContentType() != null) && (!response.containsHeader("Content-Type"))) {
        response.addHeader(entity.getContentType());
      }
      if ((entity.getContentEncoding() != null) && (!response.containsHeader("Content-Encoding"))) {
        response.addHeader(entity.getContentEncoding());
      }
    }
    else
    {
      int status = response.getStatusLine().getStatusCode();
      if ((status != 204) && (status != 304) && (status != 205)) {
        response.addHeader("Content-Length", "0");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ResponseContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */