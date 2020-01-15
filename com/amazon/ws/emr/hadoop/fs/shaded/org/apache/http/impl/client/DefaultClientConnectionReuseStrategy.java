package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.TokenIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicTokenIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

public class DefaultClientConnectionReuseStrategy
  extends DefaultConnectionReuseStrategy
{
  public static final DefaultClientConnectionReuseStrategy INSTANCE = new DefaultClientConnectionReuseStrategy();
  
  public boolean keepAlive(HttpResponse response, HttpContext context)
  {
    HttpRequest request = (HttpRequest)context.getAttribute("http.request");
    if (request != null)
    {
      Header[] connHeaders = request.getHeaders("Connection");
      if (connHeaders.length != 0)
      {
        TokenIterator ti = new BasicTokenIterator(new BasicHeaderIterator(connHeaders, null));
        while (ti.hasNext())
        {
          String token = ti.nextToken();
          if ("Close".equalsIgnoreCase(token)) {
            return false;
          }
        }
      }
    }
    return super.keepAlive(response, context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultClientConnectionReuseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */