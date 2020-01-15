package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ResponseServer
  implements HttpResponseInterceptor
{
  private final String originServer;
  
  public ResponseServer(String originServer)
  {
    this.originServer = originServer;
  }
  
  public ResponseServer()
  {
    this(null);
  }
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    if ((!response.containsHeader("Server")) && 
      (originServer != null)) {
      response.addHeader("Server", originServer);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ResponseServer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */