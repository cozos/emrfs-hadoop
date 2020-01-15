package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpInetConnection;
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
import java.net.InetAddress;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestTargetHost
  implements HttpRequestInterceptor
{
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    
    HttpCoreContext coreContext = HttpCoreContext.adapt(context);
    
    ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
    String method = request.getRequestLine().getMethod();
    if ((method.equalsIgnoreCase("CONNECT")) && (ver.lessEquals(HttpVersion.HTTP_1_0))) {
      return;
    }
    if (!request.containsHeader("Host"))
    {
      HttpHost targetHost = coreContext.getTargetHost();
      if (targetHost == null)
      {
        HttpConnection conn = coreContext.getConnection();
        if ((conn instanceof HttpInetConnection))
        {
          InetAddress address = ((HttpInetConnection)conn).getRemoteAddress();
          int port = ((HttpInetConnection)conn).getRemotePort();
          if (address != null) {
            targetHost = new HttpHost(address.getHostName(), port);
          }
        }
        if (targetHost == null)
        {
          if (ver.lessEquals(HttpVersion.HTTP_1_0)) {
            return;
          }
          throw new ProtocolException("Target host missing");
        }
      }
      request.addHeader("Host", targetHost.toHostString());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestTargetHost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */